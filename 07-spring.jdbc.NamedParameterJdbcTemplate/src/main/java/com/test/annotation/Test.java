package com.test.annotation;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.proje.config.AppConfig;
import com.proje.model.Personel;
import com.proje.repostory.impl.PersonelRepostoryImpl;
import com.proje.repostory.*;

public class Test {

	public static void main(String[] args) {  
		
		
		ConfigurableApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
		PersonelRepostory personelrepostory=applicationContext.getBean(PersonelRepostoryImpl.class);
		Personel personel	=new Personel("hasan","yıldız",createCustomDate(9,10,2002),"456456");
		
		personelrepostory.Save(personel);
		
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
