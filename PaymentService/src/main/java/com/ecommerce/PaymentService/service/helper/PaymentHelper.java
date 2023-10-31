package com.ecommerce.PaymentService.service.helper;

import com.ecommerce.PaymentService.dto.response.PaymentResponse;
import com.ecommerce.PaymentService.dto.response.abstraction.AbstractOrderResponse;
import com.ecommerce.PaymentService.model.Payment;
import com.ecommerce.PaymentService.service.helper.abstraction.IHelper;
import com.ecommerce.PaymentService.utils.enums.StatoPagamento;
import org.springframework.stereotype.Component;

@Component
public class PaymentHelper implements IHelper<Payment, AbstractOrderResponse> {

    @Override
    public Payment buildEntityFromResponse(AbstractOrderResponse response) {
        return Payment.builder()
                .importo(response.getImporto())
                .codOrdine(response.getCodOrdine())
                .statoPagamento(StatoPagamento.AUTORIZZATO)
                .build();
    }

    public PaymentResponse buildResponse(Payment payment) {
        return PaymentResponse.builder()
                .idPagamento(payment.getIdPagamento())
                .codOrdine(payment.getCodOrdine())
                .statoPagamento(payment.getStatoPagamento())
                .importo(payment.getImporto())
                .build();
    }
}
