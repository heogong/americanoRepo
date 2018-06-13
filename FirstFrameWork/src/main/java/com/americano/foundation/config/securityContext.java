package com.americano.foundation.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class securityContext extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	
	
	@Value("SELECT USER_ID, USER_NM from TB_USER WHERE USER_ID = ?")
	private String usersQuery;
	
	@Value("SELECT ROLE.USER_ROLE_AUTH FROM TB_USER USER JOIN TB_USER_ROLE ROLE ON USER.USER_PK = USER_ROLE_FK WHERE USER.USER_ID = ?")
	private String rolesQuery;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.usersByUsernameQuery(usersQuery)
			.authoritiesByUsernameQuery(rolesQuery)
			.dataSource(dataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/login").permitAll()
			.anyRequest().authenticated().and()
			.formLogin().loginPage("/login")
			.defaultSuccessUrl("/home")
			.usernameParameter("userId")
			.passwordParameter("password")
			.and().logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/home")
			.and().csrf().disable().httpBasic();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resourcess/**", "/static/**", "/css/**", "/js/**","/images/**");
		
	}

}