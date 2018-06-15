package com.americano.foundation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource("classpath:application.properties")
public class testMain {
	@Resource
	private Environment env;
	
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	
	@Autowired 
	DefaultListableBeanFactory df;
	
	//@Test
	public void doTest() throws SQLException {
		
		 
		Connection connection = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		System.out.println("PROPERTY_NAME_DATABASE_URL : "+env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		System.out.println("PROPERTY_NAME_DATABASE_URL : "+env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		System.out.println("PROPERTY_NAME_DATABASE_URL : "+env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		connection = DriverManager.getConnection("jdbc:mysql://americano.cikjtrzv1lg8.ap-northeast-2.rds.amazonaws.com:3306/americano", "americano", "americano");
		String query = "SELECT * FROM T_USER";
		pstmt = connection.prepareStatement(query);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}

		
	}
	
	@Test
	public void bean() {
		for(String name : df.getBeanDefinitionNames()) { 
			System.out.println(name + " \t " + df.getBean(name).getClass().getName());
		}
		
	}
	

}
