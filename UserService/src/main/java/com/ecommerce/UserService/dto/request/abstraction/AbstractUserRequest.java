package com.ecommerce.UserService.dto.request.abstraction;

import com.ecommerce.UserService.utils.enums.AuthServer;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class AbstractUserRequest {
    private String email;

    private String password;

    private AuthServer authServer;

}
