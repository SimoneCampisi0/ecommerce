package com.ecommerce.PaymentService.dto.common;

import lombok.Data;

@Data
public class PaymentRequest {
    private MetodoPagamentoEnum metodoPagamentoEnum;

    private String titolareCarta;

    private String emittente;

    private String numeroCarta;

    private String scadenzaCarta;

    private String CVV;
}

