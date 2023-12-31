package com.ecommerce.OrderService.repository;

import com.ecommerce.OrderService.model.Orders;
import com.ecommerce.OrderService.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrderRepository extends GenericRepository<Orders, Long> {
}
