package com.ecommerce.OrderService.dto.request;

import com.ecommerce.OrderService.dto.request.abstraction.AbstractOrderRequest;
import lombok.Data;

import java.util.Set;

@Data
public class SendOrderRequest extends AbstractOrderRequest {
    private Set<OrdersDetailsRequest> ordersDetailsRequests;
}
