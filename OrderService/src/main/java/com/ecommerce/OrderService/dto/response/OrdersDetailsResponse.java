package com.ecommerce.OrderService.dto.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class OrdersDetailsResponse implements Serializable {
    private Long idOrderDetails;

    private Double costoParziale;

    private Integer quantita;

    private Long idProdotto;
}
