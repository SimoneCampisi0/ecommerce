package com.ecommerce.OrderService.dto.request.abstraction;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public abstract class AbstractOrderRequest {

    @NotNull(message = "Costo totale obbligatorio.")
    private Double costoTotale;

    @NotNull(message = "Cliente obbligatorio.")
    private Long codCliente;
}
