package com.ecommerce.UserService.controller;

import com.ecommerce.UserService.controller.abstraction.AbstractController;
import com.ecommerce.UserService.dto.request.CreateUserRequest;
import com.ecommerce.UserService.model.User;

import com.ecommerce.UserService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController extends AbstractController<User, Long> {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DATI_NON_VALIDI");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody CreateUserRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((UserService) service).createUser(request));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(((UserService)service).login(request));
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validate(@RequestParam("token") String token) {
        return ResponseEntity.status(HttpStatus.OK).body(((UserService)service).validateToken(token));
    }

    @GetMapping("/getUsernameByUserId")
    public ResponseEntity<?> getUsernameByUserId(@RequestParam("idUser") Long idUser) {
        return ResponseEntity.status(HttpStatus.OK).body(((UserService)service).getUsernameByUserId(idUser));
    }
}
