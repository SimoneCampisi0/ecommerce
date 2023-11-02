package com.ecommerce.PaymentService.service;

import com.ecommerce.PaymentService.dto.response.InvioOrdineResponse;
import com.ecommerce.PaymentService.dto.response.PaymentResponse;
import com.ecommerce.PaymentService.exceptions.DatiMancantiException;
import com.ecommerce.PaymentService.model.Payment;
import com.ecommerce.PaymentService.service.abstraction.GenericService;
import com.ecommerce.PaymentService.service.helper.PaymentHelper;
import com.ecommerce.PaymentService.utils.ObjectMapperImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.netflix.discovery.converters.Auto;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends GenericService<Payment, Long> {

    @Autowired
    private PaymentHelper helper;

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private ObjectMapperImpl objectMapperImpl;
    public String readAndSendOrder(InvioOrdineResponse response) throws DatiMancantiException, JsonProcessingException {
        if(response.getImporto() == null || response.getCodOrdine() == null) {
            throw new DatiMancantiException("Manca importo o codice ordine nell'input");
        }

        PaymentResponse paymentResponse = helper.buildResponse(super.create(helper.buildEntityFromResponse(response)));

//        producerTemplate.sendBody("activemq:payments", objectMapperImpl.writeValueAsString(paymentResponse));
        return objectMapperImpl.writeValueAsString(paymentResponse);
    }

}
