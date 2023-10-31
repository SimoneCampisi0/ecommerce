package com.ecommerce.ShippingService.config;

import com.ecommerce.ShippingService.dto.response.PaymentResponse;
import com.ecommerce.ShippingService.utils.ObjectMapperImpl;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessorRoute extends RouteBuilder { //riceve il messaggio da activemq

    @Autowired
    private ObjectMapperImpl objectMapperImpl;



    @Override
    public void configure() throws Exception {
        from("activemq:payments")
                .process(exchange -> {
                    objectMapperImpl.readValue(exchange.getIn().getBody(String.class), PaymentResponse.class);
                });
    }
}