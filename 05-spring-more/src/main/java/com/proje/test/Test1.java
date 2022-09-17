package com.proje.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory1;
import com.proje.repostory.impl.ProductRepositoryImpl1;



public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContetxt.xml");
		//dikkat implement clasını ilk harfi küçükolmak zorunda
		ProductRepostory1 productRepository1=applicationContext.getBean("productRepositoryImpl1",ProductRepositoryImpl1.class);
      
	  Product product=productRepository1.finProductById(8);
	
	}

}
