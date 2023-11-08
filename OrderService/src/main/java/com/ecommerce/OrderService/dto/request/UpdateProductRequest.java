package com.ecommerce.OrderService.dto.request;

import com.ecommerce.OrderService.dto.request.abstraction.AbstractProductRequest;
import lombok.Data;

@Data
public class UpdateProductRequest extends AbstractProductRequest {
    private Long idProduct;
}
