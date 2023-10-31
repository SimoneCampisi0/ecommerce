package com.ecommerce.PaymentService.dto.response.abstraction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractOrderResponse implements Serializable {
        private Double importo;

        private Long codOrdine;
}
