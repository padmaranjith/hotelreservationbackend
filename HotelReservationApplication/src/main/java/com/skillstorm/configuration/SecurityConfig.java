package com.skillstorm.configuration;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
//		httpSecurity
//        .authorizeRequests()
//        .mvcMatchers("/users").permitAll()
//        .mvcMatchers("/users").authenticated();
//      .anyRequest().permitAll();
//		
//		httpSecurity.httpBasic();
//		httpSecurity.csrf().disable();
//		return httpSecurity.build();
		httpSecurity
        .authorizeRequests()
        .mvcMatchers("/users", "/register").permitAll()
        .mvcMatchers("/users").authenticated()
		.anyRequest().permitAll() 
        .and()
        .formLogin()
        .and()
        .httpBasic()
        .and()
        .csrf().disable();

    return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
}
