package com.ecommerce.OrderService.dto.request.abstraction;

import lombok.Data;

@Data
public class AbstractProductRequest {
    private String productName;

    private String productDesq;

    private Double productCost;

    private Boolean available;

    private Long codSeller;

}
