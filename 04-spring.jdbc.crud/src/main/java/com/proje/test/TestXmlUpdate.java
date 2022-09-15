package com.proje.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory;
import com.proje.repostory.impl.ProductRepositoryImpl;

public class TestXmlUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigurableApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContetxt.xml");
		//dikkat implement clasını ilk harfi küçükolmak zorunda
		ProductRepostory productRepository=applicationContext.getBean("productRepositoryImpl",ProductRepositoryImpl.class);

	Product product=	productRepository.finById(5);
	System.out.print(product);
	product.setAvalible(45);
	product.setPrice(896532);
	
	boolean sonuc=productRepository.update(product);
	if(sonuc) {
		
		System.out.print("başarılı");
		
	}else {
		
		System.out.print("hatalı");
		
	}
	
	                                                                                               
	
		
		
	}

}
