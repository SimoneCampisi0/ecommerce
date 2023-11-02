package com.ecommerce.ShippingService.dto.response.abstraction;

import com.ecommerce.ShippingService.utils.enums.StatoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractPaymentResponse {
    private Long idPagamento;

    private Double importo;

    private StatoPagamento statoPagamento;

    private Long codOrdine;
}
