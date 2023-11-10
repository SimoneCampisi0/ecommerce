package com.ecommerce.OrderService.dto.request;

import com.ecommerce.OrderService.dto.request.abstraction.AbstractOrderRequest;
import com.ecommerce.OrderService.dto.common.PaymentRequest;
import com.ecommerce.OrderService.dto.common.ShippingRequest;
import lombok.Data;

import java.util.Set;

@Data
public class SendOrderRequest extends AbstractOrderRequest {
    private Set<OrdersDetailsRequest> ordersDetailsRequests;

    private ShippingRequest shippingRequest;

    private PaymentRequest paymentRequest;
}
