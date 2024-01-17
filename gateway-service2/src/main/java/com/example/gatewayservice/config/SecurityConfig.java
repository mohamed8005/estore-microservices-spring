package com.example.gatewayservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity security) throws Exception {
        security.csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/eureka/**").permitAll()
                        .anyExchange().permitAll()
                        //.authenticated()
                );
        security.oauth2ResourceServer((oauth)-> oauth.jwt(Customizer.withDefaults())
                //oauth -> oauth
                  //      .jwt(jwt -> jwt.jwtDecoder(jwtDecoder()))
                );

        security.oauth2Login(Customizer.withDefaults());
        security.oauth2Client(Customizer.withDefaults());

        return security.build();
    }

    @Bean
    public ReactiveJwtDecoder jwtDecoder() {

        return ReactiveJwtDecoders.fromIssuerLocation("http://localhost:8080/realms/estore");
    }
}
