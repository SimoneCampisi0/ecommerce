package com.ecommerce.UserService.dto.request;

import com.ecommerce.UserService.dto.request.abstraction.AbstractUserRequest;
import lombok.Data;

@Data
public class CreateUserRequest extends AbstractUserRequest {

    private CreateAnagraficaRequest anagraficaRequest;

}
