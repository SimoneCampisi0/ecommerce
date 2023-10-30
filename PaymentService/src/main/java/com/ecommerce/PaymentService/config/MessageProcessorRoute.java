package com.ecommerce.PaymentService.config;

import com.ecommerce.PaymentService.dto.response.OrdineResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessorRoute extends RouteBuilder { //riceve il messaggio da activemq
    @Override
    public void configure() throws Exception {
        from("activemq:ordini")
                .process(exchange -> {
                    ObjectMapper objectMapper = new ObjectMapper();

                    String json = exchange.getIn().getBody(String.class);

                    OrdineResponse ordineResponse = objectMapper.readValue(json, OrdineResponse.class);
                    System.out.println("Messaggio ricevuto: " + ordineResponse);
                });
    }
}
