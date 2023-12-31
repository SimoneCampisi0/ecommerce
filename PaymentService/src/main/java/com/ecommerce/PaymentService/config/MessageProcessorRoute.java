package com.ecommerce.PaymentService.config;

import com.ecommerce.PaymentService.dto.response.CommonOrdersResponse;
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
    public void configure() {
        from("activemq:topayments")
                .process(exchange -> {
                    String jsonResponse = service.readAndSendOrder(objectMapperImpl.readValue(exchange.getIn().getBody(String.class), CommonOrdersResponse.class));

                    System.out.println("\n\n\n"+jsonResponse+"\n\n\n");

                    exchange.getMessage().setBody(jsonResponse);
                })
                .to("activemq:payments");
    }
}
