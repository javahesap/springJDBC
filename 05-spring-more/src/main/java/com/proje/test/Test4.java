package com.proje.test;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory;
import com.proje.repostory.impl.ProductRepositoryImpl2;
import com.proje.repostory.impl.ProductRepositoryImpl3;
import com.proje.repostory.impl.ProductRepositoryImpl4;




public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContetxt.xml");
		//dikkat implement clasÄ±nÄ± ilk harfi kÃ¼Ã§Ã¼kolmak zorunda
		ProductRepositoryImpl4 productRepository4=applicationContext.getBean("productRepositoryImpl4",ProductRepositoryImpl4.class);
      
	  Product product=productRepository4.finProductById(8);
	    System.out.println(product);
	    //liste ile kullanım
	    
     List<Product> products=productRepository4.findProducts();
	    
	    products.forEach(System.out::println);
	    
	}

}
