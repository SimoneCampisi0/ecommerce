
package com.ecommerce.PaymentService.dto.response;

import com.ecommerce.PaymentService.dto.common.PaymentRequest;
import com.ecommerce.PaymentService.dto.common.ShippingRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CommonOrdersResponse implements Serializable {
    private Long idOrdine;

    private Double costoTotale;

    private Long codCliente;

    private PaymentRequest paymentRequest;

    private ShippingRequest shippingRequest;
}

