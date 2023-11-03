package com.ecommerce.UserService.service.helper;

import com.ecommerce.UserService.dto.request.CreateUserRequest;
import com.ecommerce.UserService.dto.request.abstraction.AbstractUserRequest;
import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.service.helper.abstraction.IHelper;
import com.ecommerce.UserService.utils.enums.AuthServer;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class UserHelper implements IHelper<User, AbstractUserRequest> {

    public AuthServer buildAuthServer(String email) {
        String [] emailSub = email.split("@");

        return emailSub[1].equals("gmail.com") ? AuthServer.GOOGLE : AuthServer.OTHER;
    }

    public CreateUserRequest buildRequest(OAuth2User authUser) {
        return CreateUserRequest.builder()
                .email(authUser.getAttribute("email"))
                .password(authUser.getAttribute("passwordHash"))
                .authServer(buildAuthServer(authUser.getAttribute("email")))
                .build();
    }

    @Override
    public User buildEntityFromRequest(AbstractUserRequest request) {
        return User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .authServer(request.getAuthServer())
                .build();
    }
}
