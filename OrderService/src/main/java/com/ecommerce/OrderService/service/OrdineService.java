package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.dto.request.CreateOrdineRequest;
import com.ecommerce.OrderService.dto.response.OrdineResponse;
import com.ecommerce.OrderService.model.Ordine;
import com.ecommerce.OrderService.service.abstraction.GenericService;
import com.ecommerce.OrderService.service.helper.OrdineHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdineService extends GenericService<Ordine, Long> {
    @Autowired
    private OrdineHelper helper;

    public OrdineResponse riceviOrdine(CreateOrdineRequest request) {
        Ordine ordine = repository.save(helper.buildEntityFromRequest(request));

        //invio dell'ordine ad Apache Camel

        return helper.buildResponse(ordine);
    }
}
