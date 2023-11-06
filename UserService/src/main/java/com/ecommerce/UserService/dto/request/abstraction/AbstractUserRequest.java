package com.ecommerce.UserService.dto.request.abstraction;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public abstract class AbstractUserRequest {
    @Email(message = "Email non valida.", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email obbligatoria.")
    private String email;

    @NotEmpty(message = "Password obbligatoria.")
    private String password;

}
