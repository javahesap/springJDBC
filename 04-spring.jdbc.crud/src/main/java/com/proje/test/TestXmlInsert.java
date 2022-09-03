package com.proje.test;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory;
import com.proje.repostory.impl.ProductRepositoryImpl;

public class TestXmlInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContetxt.xml");

		ProductRepostory productRepository = applicationContext.getBean("productRepositoryImpl",
				ProductRepositoryImpl.class);
		Product product=new Product("sansung a32",2345,6,new Date());
		
		productRepository.save(product);

	}

}
