package com.ecommerce.OrderService.dto.common;

import lombok.Data;

@Data
public class PaymentRequest {
    private MetodoPagamento metodoPagamento;

    private String titolareCarta;

    private String emittente;

    private String numeroCarta;

    private String scadenzaCarta;

    private String CVV;
}

