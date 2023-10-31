package com.ecommerce.PaymentService.config;

import com.ecommerce.PaymentService.dto.response.InvioOrdineResponse;
import com.ecommerce.PaymentService.utils.ObjectMapperImpl;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessorRoute extends RouteBuilder { //riceve il messaggio da activemq

    @Autowired
    private ObjectMapperImpl objectMapperImpl;

    @Override
    public void configure() throws Exception {
        from("activemq:ordini")
                .process(exchange -> {
                    String json = exchange.getIn().getBody(String.class);
                    InvioOrdineResponse ordineResponse = objectMapperImpl.readValue(json, InvioOrdineResponse.class);
                    System.out.println("Messaggio ricevuto: " + ordineResponse);
                });
    }
}
