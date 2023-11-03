package com.ecommerce.UserService.service;

import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.service.abstraction.GenericService;
import com.ecommerce.UserService.service.helper.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User, Long> {

    @Autowired
    private UserHelper helper;

    public String saveUser(OAuth2User authUser) {
        return super.create(helper.buildEntityFromRequest(helper.buildRequest(authUser))).toString();
    }
}
