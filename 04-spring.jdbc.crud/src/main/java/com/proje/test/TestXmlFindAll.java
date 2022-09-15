package com.proje.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory;
import com.proje.repostory.impl.ProductRepositoryImpl;

public class TestXmlFindAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContetxt.xml");

		ProductRepostory productRepository = applicationContext.getBean("productRepositoryImpl", ProductRepositoryImpl.class);
		List<Product> products=productRepository.findProducts();
		
		for (Product product:products) {
			//System.out.println(product);
			
			System.out.println(product.getAvalible());
		}
		//ikinci yontem
		products.forEach(System.out::println);
		
		
		
	}

}
