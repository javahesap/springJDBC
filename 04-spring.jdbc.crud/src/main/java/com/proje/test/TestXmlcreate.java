package com.proje.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.repostory.ProductRepostory;
import com.proje.repostory.impl.ProductRepositoryImpl;

public class TestXmlcreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ConfigurableApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContetxt.xml");
		//dikkat implement clasını ilk harfi küçükolmak zorunda
		ProductRepostory productRepository=applicationContext.getBean("productRepositoryImpl",ProductRepositoryImpl.class);
		productRepository.createProductTable();
		

	}

}
