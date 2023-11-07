package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.dto.request.CreateProductRequest;
import com.ecommerce.OrderService.dto.response.ProductResponse;
import com.ecommerce.OrderService.model.Product;
import com.ecommerce.OrderService.service.abstraction.GenericService;
import com.ecommerce.OrderService.service.helper.ProductHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericService<Product, Long> {

    @Autowired
    private ProductHelper helper;

    public ProductResponse creaProdotto(CreateProductRequest request) {
        return helper.buildResponse(repository.save(helper.buildEntityFromRequest(request)));
    }
}
