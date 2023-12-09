package com.ecommerce.UserService.service;

import com.ecommerce.UserService.dto.request.CreateAnagraficaRequest;
import com.ecommerce.UserService.model.Anagrafica;
import com.ecommerce.UserService.model.LuogoResidenza;
import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.repository.AnagraficaRepository;
import com.ecommerce.UserService.service.abstraction.GenericService;
import com.ecommerce.UserService.service.helper.AnagraficaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaService extends GenericService<Anagrafica, Long> {

    @Autowired
    private AnagraficaHelper helper;

    public String readUsernameByIdUser(Long idUser) {
        Anagrafica anagrafica = ((AnagraficaRepository)repository).findAnagraficaByUserIdUser(idUser);
        return anagrafica.getNome() + " " + anagrafica.getCognome();
    }

    public void createAnagraficaEntity(CreateAnagraficaRequest request, User user, LuogoResidenza luogoResidenza) {
        Anagrafica anagrafica = helper.buildEntityFromRequest(request);
        anagrafica.setUser(user);
        anagrafica.setLuogoResidenza(luogoResidenza);
        super.create(anagrafica);
    }

}
