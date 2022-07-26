package com.easypick.thunderMan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/", "/user/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.anyRequest()
			.permitAll()
			.and()
			.formLogin()
			.loginPage("/auth/signin")
			.loginProcessingUrl("/auth/signin") 
			.defaultSuccessUrl("/")
			.failureUrl("/auth/failed");
	}
	
}