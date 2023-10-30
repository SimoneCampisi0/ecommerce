package com.ecommerce.PaymentService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdineResponse implements Serializable {
    private Long idOrdine;

    private Integer quantita;

    private Double prezzo;

    private Long codCliente;
}
