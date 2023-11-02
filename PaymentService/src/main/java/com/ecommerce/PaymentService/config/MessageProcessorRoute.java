package com.ecommerce.PaymentService.config;

import com.ecommerce.PaymentService.dto.response.InvioOrdineResponse;
import com.ecommerce.PaymentService.service.PaymentService;
import com.ecommerce.PaymentService.utils.ObjectMapperImpl;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessorRoute extends RouteBuilder { //riceve il messaggio da activemq

    @Autowired
    private ObjectMapperImpl objectMapperImpl;

    @Autowired
    private PaymentService service;

    @Override
    public void configure() throws Exception {
        from("activemq:ordini")
                .process(exchange -> {
                    String jsonResponse = service.readAndSendOrder(objectMapperImpl.readValue(exchange.getIn().getBody(String.class), InvioOrdineResponse.class));
                    exchange.getMessage().setBody(jsonResponse);
                })
                .to("activemq:payments");
    }
}
