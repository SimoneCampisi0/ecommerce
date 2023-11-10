package com.ecommerce.PaymentService.service;

import com.ecommerce.PaymentService.dto.response.CommonOrdersResponse;
import com.ecommerce.PaymentService.exceptions.DatiMancantiException;
import com.ecommerce.PaymentService.model.Payment;
import com.ecommerce.PaymentService.model.PaymentMethod;
import com.ecommerce.PaymentService.repository.PaymentMethodRepository;
import com.ecommerce.PaymentService.service.abstraction.GenericService;
import com.ecommerce.PaymentService.service.helper.PaymentHelper;
import com.ecommerce.PaymentService.utils.ObjectMapperImpl;
import com.ecommerce.PaymentService.utils.enums.StatoPagamento;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends GenericService<Payment, Long> {

    @Autowired
    private PaymentHelper helper;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

//    @Autowired
//    private ProducerTemplate producerTemplate;

    @Autowired
    private ObjectMapperImpl objectMapperImpl;

    public PaymentMethod buildPaymentMethod(CommonOrdersResponse response) {
        return PaymentMethod.builder()
                .emittente(response.getPaymentRequest().getEmittente())
                .CVV(response.getPaymentRequest().getCVV())
                .numeroCarta(response.getPaymentRequest().getNumeroCarta())
                .titolareCarta(response.getPaymentRequest().getTitolareCarta())
                .scadenzaCarta(response.getPaymentRequest().getScadenzaCarta())
                .metodoPagamentoEnum(response.getPaymentRequest().getMetodoPagamentoEnum())
                .build();
    }

    public Payment buildPayment(CommonOrdersResponse response, PaymentMethod paymentMethod) {
        return repository.save(
                Payment.builder()
                        .importo(response.getCostoTotale())
                        .codOrdine(response.getIdOrdine())
                        .statoPagamento(StatoPagamento.AUTORIZZATO)
                        .paymentMethod(paymentMethod)
                        .build()
        );
    }

    public String readAndSendOrder(CommonOrdersResponse response) throws DatiMancantiException, JsonProcessingException {
        if(response.getIdOrdine() == null && response.getCostoTotale() == null) {
            throw new DatiMancantiException("Manca importo o codice ordine nell'input");
        }

        PaymentMethod paymentMethod = buildPaymentMethod(response);
        Payment payment = buildPayment(response, paymentMethod); //TODO: must test


//
//        PaymentResponse paymentResponse = helper.buildResponse(super.create(helper.buildEntityFromResponse(response)));
//
////        producerTemplate.sendBody("activemq:payments", objectMapperImpl.writeValueAsString(paymentResponse));
//        return objectMapperImpl.writeValueAsString(paymentResponse);
        return "HELLO";
    }

}
