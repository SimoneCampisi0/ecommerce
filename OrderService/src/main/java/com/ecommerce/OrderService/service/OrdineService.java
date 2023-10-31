package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.dto.request.InvioOrdineRequest;
import com.ecommerce.OrderService.dto.response.InvioOrdineResponse;
import com.ecommerce.OrderService.dto.response.OrdineResponse;
import com.ecommerce.OrderService.model.Ordine;
import com.ecommerce.OrderService.service.abstraction.GenericService;
import com.ecommerce.OrderService.service.helper.OrdineHelper;
import com.ecommerce.OrderService.utils.ObjectMapperImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdineService extends GenericService<Ordine, Long> {
    @Autowired
    private OrdineHelper helper;

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private ObjectMapperImpl objectMapperImpl;

    public OrdineResponse riceviOrdine(InvioOrdineRequest request) throws JsonProcessingException {
        OrdineResponse response = helper.buildResponse(repository.save(helper.buildEntityFromRequest(request)));

        InvioOrdineResponse customResponse = InvioOrdineResponse.builder()
                .importo(request.getImporto())
                .codOrdine(response.getIdOrdine())
                .build();

        //invio dell'ordine ad Apache Camel
        producerTemplate.sendBody("activemq:ordini", objectMapperImpl.writeValueAsString(customResponse));
        return response;
    }
}
