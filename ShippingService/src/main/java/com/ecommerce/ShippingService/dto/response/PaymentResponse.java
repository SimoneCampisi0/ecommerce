package com.ecommerce.ShippingService.dto.response;

import com.ecommerce.ShippingService.dto.response.abstraction.AbstractPaymentResponse;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PaymentResponse extends AbstractPaymentResponse {

}