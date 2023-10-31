package com.ecommerce.PaymentService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class InvioOrdineResponse implements Serializable {
    private Double importo;

    private Long codOrdine;
}
