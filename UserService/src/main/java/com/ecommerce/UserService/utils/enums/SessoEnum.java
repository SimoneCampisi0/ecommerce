package com.ecommerce.UserService.utils.enums;

import lombok.Getter;

@Getter
public enum SessoEnum {
    UOMO("Uomo"),
    DONNA("Donna"),
    ALTRO("Altro");

    private String valore;

    SessoEnum(String valore) {
        this.valore = valore;
    }
}
