package com.ecommerce.OrderService.dto.response;

import com.ecommerce.OrderService.dto.response.abstraction.AbstractOrdineResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class OrdineResponse implements Serializable {
    private Long idOrdine;

    private Integer quantita;

    private Double prezzo;

    private Long codCliente;
}
