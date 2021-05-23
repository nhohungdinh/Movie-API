package com.finalproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.finalproject.service.impl.UserService;

@Configuration
@EnableWebSecurity
public class WebSecuriryConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setPasswordEncoder(passwordEncoder());
		authProvider.setUserDetailsService(userDetailsService());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/movie/**").permitAll()
		.antMatchers(HttpMethod.GET, "/actor/**").permitAll()
		.antMatchers(HttpMethod.GET, "/trailer/**").permitAll()
		.antMatchers(HttpMethod.GET, "/genre/**").permitAll()
		.antMatchers(HttpMethod.POST, "/movie").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.PUT, "/movie/**").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/movie/**").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.POST, "/actor").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.PUT, "/actor/**").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/actor/**").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.POST, "/trailer").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.PUT, "/trailer/**").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/trailer/**").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll();
	}
	
}
