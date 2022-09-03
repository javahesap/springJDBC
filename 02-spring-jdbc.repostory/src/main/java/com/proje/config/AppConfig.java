package com.proje.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class AppConfig {
	
	@Bean
	public DataSource dataSource() {
	
	  DriverManagerDataSource databasesurce=new DriverManagerDataSource();
	  databasesurce.setDriverClassName("com.mysql.jdbc.Driver");
	  databasesurce.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
	  databasesurce.setUsername("root");
	  databasesurce.setPassword("");
	  
	  
	  return databasesurce;
	}
}
