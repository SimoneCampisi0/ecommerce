package com.ecommerce.PaymentService.dto.response;

import com.ecommerce.PaymentService.utils.enums.StatoPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse implements Serializable {
    private Long idPagamento;

    private Double importo;

    private StatoPagamento statoPagamento;

    private Long codOrdine;
}
