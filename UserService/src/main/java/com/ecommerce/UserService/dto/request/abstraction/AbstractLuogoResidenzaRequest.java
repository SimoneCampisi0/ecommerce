package com.ecommerce.UserService.dto.request.abstraction;

import lombok.Data;

@Data
public abstract class AbstractLuogoResidenzaRequest {
    private String stato;

    private String provincia;

    private String comune;

    private String indirizzo;

    private String civico;

    private String CAP;
}
