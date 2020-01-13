package com.mikele.microservices.gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class WebSecurityConfig {



	@Bean
	public SecurityWebFilterChain securityWebFilterChain(
			ServerHttpSecurity http) {
		http.authorizeExchange().anyExchange().authenticated();
		http.oauth2Login()
		.and().formLogin().disable();
		http.oauth2ResourceServer()
				.jwt();
		return http.build();
	}


}
