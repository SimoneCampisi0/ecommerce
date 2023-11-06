package com.ecommerce.UserService.controller;

import com.ecommerce.UserService.controller.abstraction.AbstractController;
import com.ecommerce.UserService.dto.request.CreateUserRequest;
import com.ecommerce.UserService.dto.request.LoginUserRequest;
import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController extends AbstractController<User, Long> {

    @PostMapping("/register")
    public ResponseEntity<?> register(CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((UserService)service).createUser(request));
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(LoginUserRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((UserService)service).login(request));
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validate(@RequestParam("token") String token) {
        return ResponseEntity.status(HttpStatus.OK).body(((UserService)service).validateToken(token));
    }

}
