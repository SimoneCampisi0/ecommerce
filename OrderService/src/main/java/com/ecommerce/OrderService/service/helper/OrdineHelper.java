package com.ecommerce.OrderService.service.helper;

import com.ecommerce.OrderService.dto.request.abstraction.AbstractOrdineRequest;
import com.ecommerce.OrderService.dto.response.OrdineResponse;
import com.ecommerce.OrderService.model.Ordine;
import com.ecommerce.OrderService.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

@Component
public class OrdineHelper implements IHelper<Ordine, AbstractOrdineRequest> {
    @Override
    public Ordine buildEntityFromRequest(AbstractOrdineRequest request) {
        return Ordine.builder()
                .codCliente(request.getCodCliente())
                .prezzo(request.getPrezzo())
                .quantita(request.getQuantita())
                .build();
    }

    public OrdineResponse buildResponse(Ordine ordine) {
        return OrdineResponse.builder()
                .idOrdine(ordine.getIdOrdine())
                .codCliente(ordine.getCodCliente())
                .prezzo(ordine.getPrezzo())
                .quantita(ordine.getQuantita())
                .build();
    }
}
