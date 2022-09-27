package com.proje.tetstXml;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.User;
import com.proje.service.UserService;
import com.proje.service.impl.UserServiceIpl;



public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ConfigurableApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
	
		UserService userService =applicationContext.getBean("userServiceIpl",UserServiceIpl.class);
		
		User user= new User(5 ,"besir", "123456",new Date());

		
		userService.Save(user);
		applicationContext.close();

}
	
}
