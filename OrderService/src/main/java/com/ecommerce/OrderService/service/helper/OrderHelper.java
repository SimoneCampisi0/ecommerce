package com.ecommerce.OrderService.service.helper;

import com.ecommerce.OrderService.dto.request.abstraction.AbstractOrderRequest;
import com.ecommerce.OrderService.dto.response.OrderResponse;
import com.ecommerce.OrderService.model.Orders;
import com.ecommerce.OrderService.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

@Component
public class OrderHelper implements IHelper<Orders, AbstractOrderRequest> {
    @Override
    public Orders buildEntityFromRequest(AbstractOrderRequest request) {
        return Orders.builder()
                .codCliente(request.getCodCliente())
                .prezzo(request.getPrezzo())
                .quantita(request.getQuantita())
                .build();
    }

    public OrderResponse buildResponse(Orders orders) {
        return OrderResponse.builder()
                .idOrdine(orders.getIdOrdine())
                .codCliente(orders.getCodCliente())
                .prezzo(orders.getPrezzo())
                .quantita(orders.getQuantita())
                .build();
    }
}
