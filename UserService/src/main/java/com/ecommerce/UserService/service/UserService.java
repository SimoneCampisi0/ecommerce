package com.ecommerce.UserService.service;

import com.ecommerce.UserService.dto.request.CreateUserRequest;
import com.ecommerce.UserService.dto.response.UserResponse;
import com.ecommerce.UserService.model.Anagrafica;
import com.ecommerce.UserService.model.LuogoResidenza;
import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.repository.UserRepository;
import com.ecommerce.UserService.service.abstraction.GenericService;
import com.ecommerce.UserService.service.helper.UserHelper;
import com.ecommerce.UserService.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class UserService extends GenericService<User, Long> {

    @Autowired
    private UserHelper helper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AnagraficaService anagraficaService;

    @Autowired
    private LuogoResidenzaService luogoResidenzaService;

    public String getUsernameByUserId(Long idUser) {
        return anagraficaService.readUsernameByIdUser(idUser);
    }

    public boolean checkUser(String email) {
        if(Objects.isNull(((UserRepository)repository).findUserByEmail(email))) {
            return true;
        }
        return false;
    }

    @Transactional
    public UserResponse saveUser(CreateUserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));

        Anagrafica anagrafica = anagraficaService.createAnagraficaEntity(request.getAnagraficaRequest());
        LuogoResidenza luogoResidenza = luogoResidenzaService.createLuogoResidenzaEntity(request.getAnagraficaRequest().getLuogoResidenzaRequest());

        User user = helper.buildEntityFromRequest(request);
        anagrafica.setLuogoResidenza(luogoResidenza);
        user.setAnagrafica(anagrafica);

        anagraficaService.update(anagrafica);
        UserResponse response = helper.buildResponse(super.create(user));
        response.setToken(generateToken(response.getEmail()));

        return response;
    }

    public UserResponse createUser(CreateUserRequest request) {
        if(checkUser(request.getEmail())) {
            return saveUser(request);
        }

        throw new RuntimeException("Utente già presente");
    }

    public UserResponse login(CreateUserRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        if (authentication.isAuthenticated()) {
            UserResponse userResponse = helper.buildResponse(((UserRepository)repository).findUserByEmail(request.getEmail()));
            userResponse.setToken(generateToken(userResponse.getEmail()));
            return userResponse;
        } else {
            throw new RuntimeException("Dati non validi");
        }
    }


    public String generateToken(String email) {
        return jwtUtils.generateToken(email);
    }

    public String validateToken(String token) {
        return jwtUtils.validateToken(token);
    }
}
