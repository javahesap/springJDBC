package com.proje.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Personel;
import com.proje.repostory.PersonelRepostory;
import com.proje.repostory.impl.PersonelRepostoryImpl;


public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigurableApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationConntext.xml");
		//dikkat implement clasÄ±nÄ± ilk harfi kÃ¼Ã§Ã¼kolmak zorunda
		PersonelRepostory personelrepostory=applicationContext.getBean("personelRepostoryImpl",PersonelRepostoryImpl.class);
		
		/*//personelrepostory.createPersonelTable();
		///personelrepostory.findById(2);
	//List<Personel> personel	=personelrepostory.findPersonelsByName("ali");
		//System.out.println(personelrepostory.findById(2));
		//personelrepostory.deleteById(3);
//	System.out.println(personel); 
		personelrepostory.findPersonels();*/
	  Personel personel	=new Personel("hasan","yıldız",createCustomDate(9,10,2002),"456456");
	  personelrepostory.Save(personel);
		//System.out.println(personelrepostory.findPersonels());
		
	}
	
	public static Date createCustomDate(int gun, int ay,  int yil) {
		
		Calendar calender=Calendar.getInstance();
		 calender.set(Calendar.DAY_OF_MONTH,gun);
		 calender.set(Calendar.MONTH,ay);
		 calender.set(Calendar.YEAR,yil);
				 return calender.getTime();
		
		
	}
	

}
