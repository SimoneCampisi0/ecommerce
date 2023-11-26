package com.ecommerce.UserService.service.helper;

import com.ecommerce.UserService.dto.request.abstraction.AbstractAnagraficaRequest;
import com.ecommerce.UserService.model.Anagrafica;
import com.ecommerce.UserService.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

@Component
public class AnagraficaHelper implements IHelper<Anagrafica, AbstractAnagraficaRequest> {
    @Override
    public Anagrafica buildEntityFromRequest(AbstractAnagraficaRequest request) {
        return Anagrafica.builder()
                .dataNascita(request.getDataNascita())
                .nome(request.getNome())
                .cognome(request.getCognome())
                .build();
    }
}
