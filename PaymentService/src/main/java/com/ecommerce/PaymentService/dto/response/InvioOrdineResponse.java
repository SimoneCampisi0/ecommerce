package com.ecommerce.PaymentService.dto.response;

import com.ecommerce.PaymentService.dto.response.abstraction.AbstractOrderResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class InvioOrdineResponse extends AbstractOrderResponse {
}
