package com.ecommerce.UserService.service.helper;

import com.ecommerce.UserService.dto.request.abstraction.AbstractAnagraficaRequest;
import com.ecommerce.UserService.model.Anagrafica;
import com.ecommerce.UserService.service.helper.abstraction.IHelper;
import com.ecommerce.UserService.utils.enums.SessoEnum;
import org.springframework.stereotype.Component;

@Component
public class AnagraficaHelper implements IHelper<Anagrafica, AbstractAnagraficaRequest> {
    @Override
    public Anagrafica buildEntityFromRequest(AbstractAnagraficaRequest request) {
        return Anagrafica.builder()
                .nome(request.getNome())
                .cognome(request.getCognome())
                .dataNascita(request.getDataNascita())
                .sesso(stringToSessoEnum(request.getSesso()))
                .build();
    }

    public SessoEnum stringToSessoEnum(String value) {
        return switch (value) {
            case "Uomo" -> SessoEnum.UOMO;
            case "Donna" -> SessoEnum.DONNA;
            default -> SessoEnum.ALTRO;
        };
    }
}
