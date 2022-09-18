package com.proje.test;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory;
import com.proje.repostory.impl.ProductRepositoryImpl2;




public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContetxt.xml");
		//dikkat implement clasını ilk harfi küçükolmak zorunda
		ProductRepostory productRepository2=applicationContext.getBean("productRepositoryImpl2",ProductRepositoryImpl2.class);
      
	  Product product=productRepository2.finProductById(8);
	    System.out.println(product);
	    
	    List<Product> products=productRepository2.findProducts();
	    
	    products.forEach(System.out::println);
	}

}
