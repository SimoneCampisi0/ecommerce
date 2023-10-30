package com.ecommerce.OrderService.dto.response.abstraction;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class AbstractOrdineResponse {
    private Long idOrdine;

    private Integer quantita;

    private Double prezzo;

    private Long codCliente;
}
