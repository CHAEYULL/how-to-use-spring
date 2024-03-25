package com.leo.springmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf)->csrf.disable()); //개발시 끄기
		http.authorizeHttpRequests((authorize) ->
           authorize.requestMatchers("/**").permitAll() //어디 url에 회원 기능 넣을래?
		);
		http.formLogin((formLogin) -> 
	      formLogin.loginPage("/login")
	      .defaultSuccessUrl("/")
	    );
		http.logout(logout -> logout.logoutUrl("/logout"));
	    return http.build();
	  }
 }
