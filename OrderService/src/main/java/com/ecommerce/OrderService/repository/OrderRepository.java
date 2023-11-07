package com.ecommerce.OrderService.repository;

import com.ecommerce.OrderService.model.Orders;
import com.ecommerce.OrderService.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends GenericRepository<Orders, Long> {
}
