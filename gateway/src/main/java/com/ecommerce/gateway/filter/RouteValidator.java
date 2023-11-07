package com.ecommerce.gateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/users/auth/register",
            "/users/auth/login",
            "/users/auth/validate",
            "/eureka",

            //Swagger
            "/swagger-ui/index.html",
            "/v3/api-docs",
            "/swagger-ui/",
            "/swagger-resources/",
            "/webjars/"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}