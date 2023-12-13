package com.ecommerce.OrderService.dto.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ProductResponse {
    private Long idProduct;

    private String productName;

    private String productDesq;

    private Double productCost;

    private Boolean available;

    private Long codSeller;
}
