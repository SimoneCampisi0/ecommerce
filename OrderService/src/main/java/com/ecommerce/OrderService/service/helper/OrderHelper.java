package com.ecommerce.OrderService.service.helper;

import com.ecommerce.OrderService.dto.request.abstraction.AbstractOrderRequest;
import com.ecommerce.OrderService.dto.response.OrderResponse;
import com.ecommerce.OrderService.dto.response.OrdersDetailsResponse;
import com.ecommerce.OrderService.model.Orders;
import com.ecommerce.OrderService.model.OrdersDetails;
import com.ecommerce.OrderService.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderHelper implements IHelper<Orders, AbstractOrderRequest> {
//    public Set<OrdersDetailsResponse> buildOrdersDetailsResponses(Set<OrdersDetails> ordersDetailsSet) {
//        Set<OrdersDetailsResponse> ordersDetailsResponses = new HashSet<>();
//        for (OrdersDetails ordersDetails : ordersDetailsSet) {
//            OrdersDetailsResponse tempResponse = OrdersDetailsResponse.builder()
//                    .idProdotto(ordersDetails.getSoldProduct().getIdProduct())
//                    .idOrderDetails(ordersDetails.getIdOrderDetails())
//                    .quantita(ordersDetails.getQuantita())
//                    .costoParziale(ordersDetails.getCostoParziale())
//                    .build();
//
//            ordersDetailsResponses.add(tempResponse);
//        }
//
//        return ordersDetailsResponses;
//    }

    public Set<OrdersDetailsResponse> buildOrdersDetailsResponses(Set<OrdersDetails> ordersDetailsSet) {
        return ordersDetailsSet.stream()
                .map(ordersDetails -> OrdersDetailsResponse.builder()
                        .idOrderDetails(ordersDetails.getIdOrderDetails())
                        .idProdotto(ordersDetails.getSoldProduct().getIdProduct())
                        .quantita(ordersDetails.getQuantita())
                        .costoParziale(ordersDetails.getCostoParziale())
                        .build())
                .collect(Collectors.toSet());
    }


    public OrderResponse buildResponse(Orders orders) {
        return OrderResponse.builder()
                .costoTotale(orders.getCostoTotale())
                .codCliente(orders.getCodCliente())
                .idOrdine(orders.getIdOrders())
                .orderDetailsResponses(buildOrdersDetailsResponses(orders.getOrdersDetails()))
                .build();
    }

    @Override
    public Orders buildEntityFromRequest(AbstractOrderRequest request) {
        return Orders.builder()
                .costoTotale(request.getCostoTotale())
                .codCliente(request.getCodCliente())
                .build();
    }

//    public List<OrderResponse> buildListResponse(List<Orders> ordersList) {
//        return ordersList.stream()
//                .map(this::buildResponse)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Orders buildEntityFromRequest(AbstractOrderRequest request) {
//        return Orders.builder()
//                .codCliente(request.getCodCliente())
//                .ordersDetails(request.getPrezzo())
//                .quantita(request.getQuantita())
//                .build();
//    }
//

}
