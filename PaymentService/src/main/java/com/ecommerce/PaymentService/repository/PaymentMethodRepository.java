package com.ecommerce.PaymentService.repository;

import com.ecommerce.PaymentService.model.PaymentMethod;
import com.ecommerce.PaymentService.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends GenericRepository<PaymentMethod, Long> {
}
