package com.john.mystore.controllers.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;

import com.john.mystore.services.ProductsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	ProductsService productsService;
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http.authorizeHttpRequests(request->request.anyRequest().authenticated());
    	http.formLogin(Customizer.withDefaults());
    	/*http.httpBasic(Customizer.withDefaults());*/
    	return http.build();
    }
}










