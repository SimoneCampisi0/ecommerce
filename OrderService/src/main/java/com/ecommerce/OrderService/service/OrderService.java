package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.dto.request.OrdersDetailsRequest;
import com.ecommerce.OrderService.dto.request.SendOrderRequest;
import com.ecommerce.OrderService.dto.response.SendOrderResponse;
import com.ecommerce.OrderService.dto.response.OrderResponse;
import com.ecommerce.OrderService.model.Orders;
import com.ecommerce.OrderService.model.OrdersDetails;
import com.ecommerce.OrderService.model.Product;
import com.ecommerce.OrderService.repository.OrderDetailsRepository;
import com.ecommerce.OrderService.service.abstraction.GenericService;
import com.ecommerce.OrderService.service.helper.OrderHelper;
import com.ecommerce.OrderService.utils.ObjectMapperImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService extends GenericService<Orders, Long> {
    @Autowired
    private OrderHelper helper;

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private ObjectMapperImpl objectMapperImpl;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public List<OrdersDetails> parseOrdersDetails(Set<OrdersDetailsRequest> ordersDetailsRequests) {
        return ordersDetailsRequests.stream()
                .map(request -> OrdersDetails.builder()
                        .quantita(request.getQuantita())
                        .costoParziale(request.getCostoParziale())
                        .soldProduct(productService.read(request.getSoldProduct()))
                        .build())
                .collect(Collectors.toList());
    }

    public Orders assignProduct(SendOrderRequest request) {
        Orders orders = super.create(Orders.builder()
                .codCliente(request.getCodCliente())
                .costoTotale(request.getCostoTotale())
                .build());

        List<OrdersDetails> ordersDetailsSet = parseOrdersDetails(request.getOrdersDetailsRequests());


        ordersDetailsSet.forEach(orderDetail -> orderDetail.setAssociateOrders(orders));
        orderDetailsRepository.saveAll(ordersDetailsSet);


        orders.setOrdersDetails(new HashSet<>(ordersDetailsSet));
        return super.update(orders);
    }


    public OrderResponse riceviOrdine(SendOrderRequest request) throws JsonProcessingException {
        Orders orders = assignProduct(request);
        return helper.buildResponse(orders);

//        OrderResponse response = helper.buildResponse(repository.save(helper.buildEntityFromRequest(request)));
//
//        SendOrderResponse customResponse = SendOrderResponse.builder()
//                .importo(request.getPrezzo())
//                .codOrdine(response.getIdOrdine())
//                .build();
//
//        //invio dell'ordine ad Apache Camel
//        producerTemplate.sendBody("activemq:ordini", objectMapperImpl.writeValueAsString(customResponse));
//        return response;
    }
//
//    public OrderResponse leggiOrdine(Long idOrdine) {
//        return helper.buildResponse(super.read(idOrdine));
//    }
//
//    public List<OrderResponse> listaOrdini() {
//        return helper.buildListResponse(super.findAll());
//    }
//
//    public List<OrderResponse> listaOrdiniPerCliente(Long idCliente) {
//        return helper.buildListResponse(super.findAll())
//                .stream()
//                .filter(orderResponse -> Objects.equals(orderResponse.getCodCliente(), idCliente))
//                .collect(Collectors.toList());
//    }
}
