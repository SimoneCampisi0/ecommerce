package com.ecommerce.UserService.dto.request;

import com.ecommerce.UserService.dto.request.abstraction.AbstractUserRequest;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CreateUserRequest extends AbstractUserRequest {
}
