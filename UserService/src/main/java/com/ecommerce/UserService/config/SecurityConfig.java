package com.ecommerce.UserService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //Aggiungere chiamata di callback a un'API nel controller in seguito al login.
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                        .defaultSuccessUrl("http://localhost:8080/users/auth/loginSuccess", true);

        return http.build();
    }
}
