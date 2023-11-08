package com.ecommerce.OrderService.dto.request;

import lombok.Data;

@Data
public class OrdersDetailsRequest {
    private Double costoParziale;

    private Integer quantita;

    private Long soldProduct;
}
