package com.ecommerce.UserService.service.helper;

import com.ecommerce.UserService.dto.request.abstraction.AbstractUserRequest;
import com.ecommerce.UserService.dto.response.UserResponse;
import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.service.helper.abstraction.IHelper;
import org.springframework.stereotype.Component;

@Component
public class UserHelper implements IHelper<User, AbstractUserRequest> {

    @Override
    public User buildEntityFromRequest(AbstractUserRequest request) {
        return User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public UserResponse buildResponse(User user) {
        return UserResponse.builder()
                .idUser(user.getIdUser())
                .email(user.getEmail())
                .build();
    }
}
