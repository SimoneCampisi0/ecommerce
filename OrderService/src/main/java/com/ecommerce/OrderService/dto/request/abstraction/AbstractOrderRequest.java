package com.ecommerce.OrderService.dto.request.abstraction;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public abstract class AbstractOrderRequest {

    @NotNull(message = "Quantita obbligatoria.")
    private Integer quantita;

    @NotNull(message = "Prezzo obbligatorio.")
    private Double prezzo;

    @NotNull(message = "Cliente obbligatorio.")
    private Long codCliente;
}
