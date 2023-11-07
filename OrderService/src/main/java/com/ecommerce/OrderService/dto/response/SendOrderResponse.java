package com.ecommerce.OrderService.dto.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import java.io.Serializable;

@Data
@SuperBuilder
public class SendOrderResponse implements Serializable {
    private Double importo;

    private Long codOrdine;
}
