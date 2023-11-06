package com.ecommerce.UserService.service;

import com.ecommerce.UserService.dto.request.CreateUserRequest;
import com.ecommerce.UserService.dto.request.LoginUserRequest;
import com.ecommerce.UserService.dto.response.UserResponse;
import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.service.abstraction.GenericService;
import com.ecommerce.UserService.service.helper.UserHelper;
import com.ecommerce.UserService.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User, Long> {

    @Autowired
    private UserHelper helper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtils jwtUtils;

    public UserResponse createUser(CreateUserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        UserResponse response = helper.buildResponse(super.create(helper.buildEntityFromRequest(request)));
        response.setToken(generateToken(response.getEmail()));

        return response;
    }

    public String login(LoginUserRequest request) { //TODO: implementare Login, controllare se Swagger è raggiungibile e continuare video
        return "TODO";
    }


    public String generateToken(String email) {
        return jwtUtils.generateToken(email);
    }

    public String validateToken(String token) {
        return jwtUtils.validateToken(token);
    }
}
