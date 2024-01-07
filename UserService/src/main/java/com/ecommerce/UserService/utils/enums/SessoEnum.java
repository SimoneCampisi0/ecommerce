package com.ecommerce.UserService.utils.enums;

public enum SessoEnum {
    UOMO("Uomo"),
    DONNA("Donna"),
    ALTRO("Altro");

    private String valore;

    private SessoEnum(String valore) {
        this.valore = valore;
    }

    public String getValore() {
        return this.valore;
    }
}
