package cpm.proje.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.proje.db.Database;

@Configuration
public class AppConfig {
	
	@Bean
  public Database database() {
	  
	  Database database=new Database();
	  database.setDriverClassNmame("MYSQL");
	  database.setUrl("mysqljdbc");
	  database.setUsernmae("root");
	  database.setPassword("1234");
	  
	  return null;
  }
  
  
	@Bean
 public DataSource dataSource() {
	  
	  DriverManagerDataSource databasesurce=new DriverManagerDataSource();
	  databasesurce.setDriverClassName("com.mysql.jdbc.Driver");
	  databasesurce.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
	  databasesurce.setUsername("root");
	  databasesurce.setPassword("");
	  
	  return null;
  }
}
