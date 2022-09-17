package com.proje.anatation;


import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.proje.config.AppConfig;
import com.proje.model.Product;
import com.proje.repostory.ProductRepostory;
import com.proje.repostory.impl.ProductRepositoryImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigurableApplicationContext applicationcontext=new AnnotationConfigApplicationContext(AppConfig.class);
		ProductRepostory productRepository = applicationcontext.getBean("productRepositoryImpl", ProductRepositoryImpl.class);
		Product products=productRepository.finById(6);

	}

}
