package com.ecommerce.UserService.config.auth;

import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = repository.findUserByEmail(username);
            CustomUserDetails customUserDetails = new CustomUserDetails(user);
            return customUserDetails;
        } catch (UsernameNotFoundException exception) {
            throw new UsernameNotFoundException("Email non trovata.");
        }
    }
}
