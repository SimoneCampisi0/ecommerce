package com.ecommerce.OrderService.repository;

import com.ecommerce.OrderService.model.OrdersDetails;
import com.ecommerce.OrderService.repository.abstraction.GenericRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
@Repository
@Transactional
public interface OrderDetailsRepository extends GenericRepository<OrdersDetails, Long> {
}
