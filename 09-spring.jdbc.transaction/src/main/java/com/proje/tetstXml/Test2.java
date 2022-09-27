package com.proje.tetstXml;
import java.util.Calendar;
import java.util.Date;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.UserDetail;
import com.proje.service.UserDetailService;

import com.proje.service.impl.UserDetailServiceIpl;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ConfigurableApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
	
		UserDetailService userService =applicationContext.getBean("userDetailServiceIpl",UserDetailServiceIpl.class);
		
		UserDetail user= new UserDetail(16,"besir", "123456",createCustomDate(1,9,2022));

		
		userService.Save(5,user);
		applicationContext.close();


	
	
	
	}
	
public static Date createCustomDate(int gun, int ay,  int yil) {
		
		Calendar calender=Calendar.getInstance();
		 calender.set(Calendar.DAY_OF_MONTH,gun);
		 calender.set(Calendar.MONTH,ay);
		 calender.set(Calendar.YEAR,yil);
				 return calender.getTime();
		
		
	}
	
}
