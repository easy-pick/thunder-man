package com.easypick.thunderMan.config;

import com.easypick.thunderMan.dto.DlUserDto;
import com.easypick.thunderMan.dto.security.UserPrincipal;
import com.easypick.thunderMan.repository.DlUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.cors().and();
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/", "/user/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.anyRequest()
			.permitAll()
			.and()
			.formLogin() // form 로그인 인증기능 작동
			.loginPage("/auth/signin") // 로그인페이지 지정
			.loginProcessingUrl("/auth/login")  // 로그인 Form Action Url 지정
			.usernameParameter("userId")	// 아이디 파라미터를 커스텀함
			.defaultSuccessUrl("/") // 로그인 성공후 이동할 url
			.failureUrl("/auth/failed"); // 로그인 실패시 이동할 url
	}

	@Bean
	public UserDetailsService userDetailsService(DlUserRepository dlUserRepository){

		return username -> dlUserRepository
				.findByUserId(username)
				.map(DlUserDto::from)
				.map(UserPrincipal::from)
				.orElseThrow(() -> new UsernameNotFoundException("유저를 찾을수 없습니다. - userId : "+username));

	}
		@Bean
	public PasswordEncoder passwordEncoder(){
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
