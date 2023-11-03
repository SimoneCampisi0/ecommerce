package com.ecommerce.UserService.service;

import com.ecommerce.UserService.dto.request.CreateUserRequest;
import com.ecommerce.UserService.dto.response.UserResponse;
import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.service.abstraction.GenericService;
import com.ecommerce.UserService.service.helper.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User, Long> {

    @Autowired
    private UserHelper helper;

    public UserResponse createUser(CreateUserRequest request) {
        return helper.buildResponse(super.create(helper.buildEntityFromRequest(request)));
    }
}
