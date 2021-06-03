package com.finalproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.finalproject.service.impl.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecuriryConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserService userService;
	
	@Autowired
	private AuthEntryPointJwt unauthorizedHandle;
	
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandle).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests()
		.antMatchers("/api/auth/**").permitAll()
		.antMatchers("/api/test/**").permitAll()
		.antMatchers(HttpMethod.GET, "/movie/**").permitAll()
		.antMatchers(HttpMethod.GET, "/actor/**").permitAll()
		.antMatchers(HttpMethod.GET, "/trailer/**").permitAll()
		.antMatchers(HttpMethod.GET, "/genre/**").permitAll()
		.antMatchers(HttpMethod.POST, "/movie").hasAuthority("ROLE_ADMIN")
		.antMatchers(HttpMethod.PUT, "/movie/**").hasAuthority("ROLE_ADMIN")
		.antMatchers(HttpMethod.DELETE, "/movie/**").hasAuthority("ROLE_ADMIN")
		.antMatchers(HttpMethod.POST, "/actor").hasAuthority("ROLE_ADMIN")
		.antMatchers(HttpMethod.PUT, "/actor/**").hasAuthority("ROLE_ADMIN")
		.antMatchers(HttpMethod.DELETE, "/actor/**").hasAuthority("ROLE_ADMIN")
		.antMatchers(HttpMethod.POST, "/trailer").hasAuthority("ROLE_ADMIN")
		.antMatchers(HttpMethod.PUT, "/trailer/**").hasAuthority("ROLE_ADMIN")
		.antMatchers(HttpMethod.DELETE, "/trailer/**").hasAuthority("ROLE_ADMIN")
		.anyRequest().authenticated();
		
		
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
}
