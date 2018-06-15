package com.americano.foundation.init;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.americano.foundation.login.service.Impl.CustomUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	private CustomUserDetailsServiceImpl customUserDetailsService;
	
	protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.userDetailsService(customUserDetailsService)
			.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/home").hasRole("SYSTEM")
			.antMatchers("/**").permitAll()
			.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/success-login")
			.failureUrl("/error-login")
			.permitAll()
			.and()
			.logout()
			.logoutSuccessUrl("/home");
	}
}
