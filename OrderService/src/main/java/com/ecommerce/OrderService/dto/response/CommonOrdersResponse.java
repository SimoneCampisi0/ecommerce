package com.ecommerce.OrderService.dto.response;

import com.ecommerce.OrderService.dto.common.MetodoPagamento;
import com.ecommerce.OrderService.dto.common.PaymentRequest;
import com.ecommerce.OrderService.dto.common.ShippingRequest;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class CommonOrdersResponse implements Serializable {
    private Long idOrdine;

    private Double costoTotale;

    private Long codCliente;

    private PaymentRequest paymentRequest;

    private ShippingRequest shippingRequest;
}
