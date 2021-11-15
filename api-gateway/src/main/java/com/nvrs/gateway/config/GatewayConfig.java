package com.nvrs.gateway.config;

import com.nvrs.gateway.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class GatewayConfig {

    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes().route("auth", r -> r.path("/auth/**").filters(f -> f.filter(filter)).uri("lb://authentication-service"))
                .route("customer", r -> r.path("/customer/**").filters(f -> f.filter(filter)).uri("lb://customer-service"))
                .route("product", r -> r.path("/product/**").filters(f -> f.filter(filter)).uri("lb://product-service"))
                .route("transaction", r -> r.path("/transaction/**").filters(f -> f.filter(filter)).uri("lb://transaction-service"))
                .route("merchant", r -> r.path("/merchant/**").filters(f -> f.filter(filter)).uri("lb://merchant-service"))
                .build();
    }

}