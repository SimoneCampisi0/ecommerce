package com.ecommerce.OrderService.repository;

import com.ecommerce.OrderService.model.Product;
import com.ecommerce.OrderService.repository.abstraction.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductRepository extends GenericRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);
}
