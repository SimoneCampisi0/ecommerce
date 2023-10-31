package com.ecommerce.OrderService.dto.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import java.io.Serializable;

@Data
@SuperBuilder
public class InvioOrdineResponse implements Serializable {
    private Double importo;

    private Long codOrdine;
}
