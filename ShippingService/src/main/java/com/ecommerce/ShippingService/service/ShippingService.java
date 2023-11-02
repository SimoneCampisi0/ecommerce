package com.ecommerce.ShippingService.service;

import com.ecommerce.ShippingService.dto.response.PaymentResponse;
import com.ecommerce.ShippingService.model.Shipping;
import com.ecommerce.ShippingService.repository.ShippingDetailsRepository;
import com.ecommerce.ShippingService.service.abstraction.GenericService;
import com.ecommerce.ShippingService.service.helper.ShippingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService extends GenericService<Shipping, Long> {
    @Autowired
    private ShippingHelper helper;

    @Autowired
    private ShippingDetailsRepository shippingDetailsRepository;

    public void builShippingFromPayment(PaymentResponse response) {

    }
}
