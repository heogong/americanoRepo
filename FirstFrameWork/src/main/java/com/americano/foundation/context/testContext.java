package com.americano.foundation.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class testContext {
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://americano.cikjtrzv1lg8.ap-northeast-2.rds.amazonaws.com:3306/americano");
		ds.setUsername("americano");
		ds.setPassword("americano");
		
		return ds;
	}
}
