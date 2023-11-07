package com.ecommerce.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {
//    @Autowired
//    private JwtUtil jwtUtil;

    @Autowired
    private RouteValidator validator;

    @Autowired
    private RestTemplate template;

    public AuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            if(validator.isSecured.test(exchange.getRequest())) {
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("JWT mancante nell'header.");
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if(authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }

                try {
//                    jwtUtil.validateToken(authHeader);
                    template.getForObject("http://localhost:8084/users/auth/validate?token=" + authHeader, String.class);
                } catch (Exception e) {
                    throw new RuntimeException("JWT non valida.");
                }
            }

            return chain.filter(exchange);
        }));
    }

    public static class Config {

    }
}
