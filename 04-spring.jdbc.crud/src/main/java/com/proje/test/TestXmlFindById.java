package com.proje.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory;
import com.proje.repostory.impl.ProductRepositoryImpl;

public class TestXmlFindById {
	public static void main(String[] args) {
	
	ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContetxt.xml");

	ProductRepostory productRepository = applicationContext.getBean("productRepositoryImpl", ProductRepositoryImpl.class);
	Product pr=productRepository.finById(6);
	System.out.println(pr);
	}

}
