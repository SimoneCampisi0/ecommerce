//package com.ecommerce.ShippingService.config;
//
//import com.ecommerce.ShippingService.dto.response.PaymentResponse;
//import com.ecommerce.ShippingService.service.ShippingService;
//import com.ecommerce.ShippingService.utils.ObjectMapperImpl;
//import org.apache.camel.builder.RouteBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MessageProcessorRoute extends RouteBuilder { //riceve il messaggio da activemq
//
//    @Autowired
//    private ObjectMapperImpl objectMapperImpl;
//
//    @Autowired
//    private ShippingService service;
//
//
//    @Override
//    public void configure() {
//        from("activemq:payments")
//                .process(exchange -> {
//                    service.builShippingFromPayment(objectMapperImpl.readValue(exchange.getIn().getBody(String.class), PaymentResponse.class));
//                });
//    }
//}