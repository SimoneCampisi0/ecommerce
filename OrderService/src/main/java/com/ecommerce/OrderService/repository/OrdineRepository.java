package com.ecommerce.OrderService.repository;

import com.ecommerce.OrderService.model.Ordine;
import com.ecommerce.OrderService.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineRepository extends GenericRepository<Ordine, Long> {
}
