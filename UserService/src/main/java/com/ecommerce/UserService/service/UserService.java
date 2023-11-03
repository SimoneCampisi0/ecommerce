package com.ecommerce.UserService.service;

import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.service.abstraction.GenericService;
import com.ecommerce.UserService.service.helper.UserHelper;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User, Long> {

    @Autowired
    private UserHelper helper;
}
