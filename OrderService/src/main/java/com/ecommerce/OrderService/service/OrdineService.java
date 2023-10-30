package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.dto.request.CreateOrdineRequest;
import com.ecommerce.OrderService.dto.response.OrdineResponse;
import com.ecommerce.OrderService.model.Ordine;
import com.ecommerce.OrderService.service.abstraction.GenericService;
import com.ecommerce.OrderService.service.helper.OrdineHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdineService extends GenericService<Ordine, Long> {
    @Autowired
    private OrdineHelper helper;

    @Autowired
    private ProducerTemplate producerTemplate;

    public OrdineResponse riceviOrdine(CreateOrdineRequest request) throws JsonProcessingException {
        OrdineResponse response = helper.buildResponse(repository.save(helper.buildEntityFromRequest(request)));

        ObjectMapper objectMapper = new ObjectMapper();
        //invio dell'ordine ad Apache Camel
        producerTemplate.sendBody("activemq:ordini", objectMapper.writeValueAsString(response));

        return response;
    }
}
