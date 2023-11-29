package com.ecommerce.UserService.dto.request.abstraction;

import com.ecommerce.UserService.utils.enums.Provincia;
import com.ecommerce.UserService.utils.enums.Stato;
import lombok.Data;

@Data
public abstract class AbstractLuogoResidenzaRequest {
    private Stato stato;

    private Provincia provincia;

    private String comune;

    private String indirizzo;

    private String civico;

    private String CAP;
}
