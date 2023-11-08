package com.ecommerce.OrderService.dto.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Set;

@Data
@SuperBuilder
public class OrderResponse implements Serializable {
    private Long idOrdine;

    private Double costoTotale;

    private Long codCliente;

    Set<OrdersDetailsResponse> orderDetailsResponses;
}
