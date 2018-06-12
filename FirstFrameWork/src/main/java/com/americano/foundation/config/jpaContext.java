package com.americano.foundation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class jpaContext {
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://americano.cikjtrzv1lg8.ap-northeast-2.rds.amazonaws.com:3306/americano");
		ds.setUsername("americano");
		ds.setPassword("americano");
		
		return ds;
	}
	
	@Bean
	public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		
		va.setShowSql(true);
		
		return va;
	}
    
}
