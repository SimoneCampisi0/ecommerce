package com.ecommerce.PaymentService.repository;

import com.ecommerce.PaymentService.model.Payment;
import com.ecommerce.PaymentService.repository.abstraction.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends GenericRepository<Payment, Long> {
}
