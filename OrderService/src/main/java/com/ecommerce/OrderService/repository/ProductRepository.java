package com.ecommerce.OrderService.repository;

import com.ecommerce.OrderService.model.Product;
import com.ecommerce.OrderService.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends GenericRepository<Product, Long> {
}
