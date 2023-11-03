package com.ecommerce.UserService.controller;

import com.ecommerce.UserService.controller.abstraction.AbstractController;
import com.ecommerce.UserService.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("auth")
public class AuthController extends AbstractController<User, Long> {

    @GetMapping("/loginSuccess")
    public ResponseEntity<?> loginSuccess(Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2User user = (OAuth2User) authentication.getPrincipal();

        OAuth2AccessToken accessToken = user.getAttribute("access_token");

        return ResponseEntity.ok("Hello "+user.getAttributes().toString());
    }
}
