package com.ecommerce.ShippingService.service.helper.abstraction;

import com.ecommerce.ShippingService.dto.response.abstraction.AbstractShippingResponse;
import com.ecommerce.ShippingService.model.Shipping;
import org.springframework.stereotype.Component;

@Component
public class ShippingHelper implements IHelper<Shipping, AbstractShippingResponse> {

    @Override
    public Shipping buildEntityFromResponse(AbstractShippingResponse response) {
        return null;
    }
}
