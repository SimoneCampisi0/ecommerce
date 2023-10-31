package com.ecommerce.ShippingService.repository;

import com.ecommerce.ShippingService.model.ShippingDetails;
import com.ecommerce.ShippingService.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingDetailsRepository extends GenericRepository<ShippingDetails, Long> {
}
