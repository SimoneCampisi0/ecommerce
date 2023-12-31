package com.ecommerce.PaymentService.controller.abstraction;


import com.ecommerce.PaymentService.service.abstraction.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
@RestController
public abstract class AbstractController<T, ID> {
    @Autowired
    public GenericService<T, ID> service;
}
