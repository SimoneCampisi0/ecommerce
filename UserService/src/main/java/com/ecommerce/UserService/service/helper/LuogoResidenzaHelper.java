package com.ecommerce.UserService.service.helper;

import com.ecommerce.UserService.dto.request.abstraction.AbstractLuogoResidenzaRequest;
import com.ecommerce.UserService.model.LuogoResidenza;
import com.ecommerce.UserService.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

@Component
public class LuogoResidenzaHelper implements IHelper<LuogoResidenza, AbstractLuogoResidenzaRequest> {
    @Override
    public LuogoResidenza buildEntityFromRequest(AbstractLuogoResidenzaRequest request) {
        return LuogoResidenza.builder()
                .stato(request.getStato())
                .provincia(request.getProvincia())
                .comune(request.getComune())
                .indirizzo(request.getIndirizzo())
                .civico(request.getCivico())
                .CAP(request.getCap())
                .build();
    }
}
