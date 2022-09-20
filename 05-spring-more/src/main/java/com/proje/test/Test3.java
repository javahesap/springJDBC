package com.proje.test;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory;
import com.proje.repostory.impl.ProductRepositoryImpl2;
import com.proje.repostory.impl.ProductRepositoryImpl3;




public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContetxt.xml");
		//dikkat implement clasÄ±nÄ± ilk harfi kÃ¼Ã§Ã¼kolmak zorunda
		ProductRepositoryImpl3 productRepository3=applicationContext.getBean("productRepositoryImpl3",ProductRepositoryImpl3.class);
      
	  Product product=productRepository3.finProductById(8);
	    System.out.println(product);
	    //liste ile kullanım
	    
      List<Product> products=productRepository3.findProducts();
	    
	    products.forEach(System.out::println);
	    
	}

}
