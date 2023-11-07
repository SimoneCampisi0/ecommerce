package com.ecommerce.OrderService.dto.response.abstraction;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class AbstractOrderResponse implements Serializable {
    private Long idOrdine;

    private Integer quantita;

    private Double prezzo;

    private Long codCliente;
}
