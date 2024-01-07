package com.ecommerce.UserService.dto.request.abstraction;

import com.ecommerce.UserService.utils.enums.SessoEnum;
import lombok.Data;

import java.util.Date;

@Data
public abstract class AbstractAnagraficaRequest {
    private String nome;

    private String cognome;

    private Date dataNascita;

    private String sesso;
}
