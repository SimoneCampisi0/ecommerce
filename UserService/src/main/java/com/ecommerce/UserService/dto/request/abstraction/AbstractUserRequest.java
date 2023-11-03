package com.ecommerce.UserService.dto.request.abstraction;

import lombok.Data;

@Data
public abstract class AbstractUserRequest {
    private String email;

    private String password;

}
