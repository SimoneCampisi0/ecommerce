package com.ecommerce.UserService.service.helper;

import com.ecommerce.UserService.dto.request.abstraction.AbstractUserRequest;
import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

@Component
public class UserHelper implements IHelper<User, AbstractUserRequest> {
    @Override
    public User buildEntityFromRequest(AbstractUserRequest request) {
        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .authServer(request.getAuthServer())
                .build();
    }
}
