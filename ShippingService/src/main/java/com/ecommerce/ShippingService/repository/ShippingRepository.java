package com.ecommerce.ShippingService.repository;

import com.ecommerce.ShippingService.model.Shipping;
import com.ecommerce.ShippingService.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends GenericRepository<Shipping, Long> {
}
