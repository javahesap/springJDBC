package com.proje.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.proje.repostory.PersonelRepostory;
import com.proje.repostory.impl.PersonelRepostoryImpl;

@Configuration
@ComponentScan("com.proje")
public class AppConfig {
	
	
	 
	@Bean
	public DataSource dataSource() {
	
	  DriverManagerDataSource databasesurce=new DriverManagerDataSource();
	  databasesurce.setDriverClassName("com.mysql.jdbc.Driver");
	  databasesurce.setUrl("jdbc:mysql://localhost:3306/spring_jbc");
	  databasesurce.setUsername("root");
	  databasesurce.setPassword("");
	  
	  
	  return databasesurce;
	}
	@Bean
	public PersonelRepostory personelrepostory() {
		PersonelRepostoryImpl personelrepostoryimpl=new  PersonelRepostoryImpl();
		personelrepostoryimpl.setDataSource(this.dataSource());
		return personelrepostoryimpl;
		
	}

}
