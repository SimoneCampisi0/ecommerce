package com.ecommerce.PaymentService.dto.response;

import com.ecommerce.PaymentService.dto.response.abstraction.AbstractOrderResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SendOrderResponse extends AbstractOrderResponse {
}
