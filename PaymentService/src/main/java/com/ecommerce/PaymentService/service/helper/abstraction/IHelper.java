package com.ecommerce.PaymentService.service.helper.abstraction;


import org.springframework.stereotype.Component;

@Component
public interface IHelper<T, A> {
    public T buildEntityFromResponse(A response);

}
