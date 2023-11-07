package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.dto.request.SendOrderRequest;
import com.ecommerce.OrderService.dto.response.SendOrderResponse;
import com.ecommerce.OrderService.dto.response.OrderResponse;
import com.ecommerce.OrderService.model.Orders;
import com.ecommerce.OrderService.service.abstraction.GenericService;
import com.ecommerce.OrderService.service.helper.OrderHelper;
import com.ecommerce.OrderService.utils.ObjectMapperImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends GenericService<Orders, Long> {
    @Autowired
    private OrderHelper helper;

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private ObjectMapperImpl objectMapperImpl;

    public OrderResponse riceviOrdine(SendOrderRequest request) throws JsonProcessingException {
        OrderResponse response = helper.buildResponse(repository.save(helper.buildEntityFromRequest(request)));

        SendOrderResponse customResponse = SendOrderResponse.builder()
                .importo(request.getPrezzo())
                .codOrdine(response.getIdOrdine())
                .build();

        //invio dell'ordine ad Apache Camel
        producerTemplate.sendBody("activemq:ordini", objectMapperImpl.writeValueAsString(customResponse));
        return response;
    }
}