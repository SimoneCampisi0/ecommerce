package com.ecommerce.UserService.dto.request.abstraction;

import com.ecommerce.UserService.utils.enums.AuthServer;
import lombok.Data;

@Data
public abstract class AbstractUserRequest {
    private String username;

    private String password;

    private AuthServer authServer;

}
