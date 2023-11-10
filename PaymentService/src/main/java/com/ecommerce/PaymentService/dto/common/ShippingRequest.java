package com.ecommerce.PaymentService.dto.common;

import lombok.Data;

@Data
public class ShippingRequest {
    private String indirizzo;

    private String citta;

    private String CAP;
}
