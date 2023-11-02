package com.ecommerce.ShippingService.service.helper;

import com.ecommerce.ShippingService.dto.response.abstraction.AbstractPaymentResponse;
import com.ecommerce.ShippingService.model.Shipping;
import com.ecommerce.ShippingService.model.ShippingDetails;
import com.ecommerce.ShippingService.service.helper.abstraction.IHelper;
import com.ecommerce.ShippingService.utils.enums.ShippingStatus;
import org.springframework.stereotype.Component;

@Component
public class ShippingHelper implements IHelper<Shipping, AbstractPaymentResponse> {

    @Override
    public Shipping buildEntityFromResponse(AbstractPaymentResponse response) {
        return Shipping.builder()
                .codOrdine(response.getCodOrdine())
                .shippingStatus(ShippingStatus.PREPARAZIONE)
                .build();
    }

    public ShippingDetails buildShippingDetails(Shipping shipping) {
        return ShippingDetails.builder()
                .shipping(shipping)
                .corriere("corriere")
                .numeroTracking("123")
                .indirizzoConsegna("Via del Corso 1")
            .build();
    }
}
