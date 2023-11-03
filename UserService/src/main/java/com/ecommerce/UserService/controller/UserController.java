package com.ecommerce.UserService.controller;

import com.ecommerce.UserService.controller.abstraction.AbstractController;
import com.ecommerce.UserService.dto.request.CreateUserRequest;
import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController extends AbstractController<User, Long> {

    @PostMapping
    public ResponseEntity<?> createUser (CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((UserService)service).createUser(request));
    }
}
