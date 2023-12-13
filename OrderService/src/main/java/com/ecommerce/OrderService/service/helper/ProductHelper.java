package com.ecommerce.OrderService.service.helper;

import com.ecommerce.OrderService.dto.request.abstraction.AbstractProductRequest;
import com.ecommerce.OrderService.dto.response.ProductResponse;
import com.ecommerce.OrderService.model.Product;
import com.ecommerce.OrderService.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

@Component
public class ProductHelper implements IHelper<Product, AbstractProductRequest> {
    @Override
    public Product buildEntityFromRequest(AbstractProductRequest request) {
        return Product.builder()
                .productName(request.getProductName())
                .productDesq(request.getProductDesq())
                .productCost(request.getProductCost())
                .available(request.getAvailable())
                .codSeller(request.getCodSeller())
                .build();
    }

    public ProductResponse buildResponse(Product product) {
        return ProductResponse.builder()
                .idProduct(product.getIdProduct())
                .productName(product.getProductName())
                .productDesq(product.getProductDesq())
                .productCost(product.getProductCost())
                .available(product.getAvailable())
                .codSeller(product.getCodSeller())
                .build();
    }
}
