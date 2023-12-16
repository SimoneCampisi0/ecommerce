//package com.ecommerce.gateway.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Component
//public class CorsFilter implements GlobalFilter, Ordered {
//
//    @Override
//    public int getOrder() {
//        return Ordered.HIGHEST_PRECEDENCE;
//    }
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        // Configurazione CORS
//        exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "*");
//        exchange.getResponse().getHeaders().add("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
//        exchange.getResponse().getHeaders().add("Access-Control-Allow-Headers", "*");
//
//        return chain.filter(exchange);
//    }
//}
