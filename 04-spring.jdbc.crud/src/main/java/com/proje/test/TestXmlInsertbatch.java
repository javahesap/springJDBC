package com.proje.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory;
import com.proje.repostory.impl.ProductRepositoryImpl;

public class TestXmlInsertbatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContetxt.xml");

		ProductRepostory productRepository = applicationContext.getBean("productRepositoryImpl", ProductRepositoryImpl.class);
		
		Product product1=new Product(6,"sansung a32",2345,6,new Date());
		Product product2=new Product(7,"sansung a32",2345,6,new Date());
		Product product3=new Product(8,"sansung a32",2345,6,new Date());
		Product product4=new Product(9,"sansung a32",2345,6,new Date());
		Product product5=new Product(10,"sansung a32",2345,6,new Date());
		
		/*Product product1=new Product("sansung a32",2345,6,new Date());
		Product product2=new Product("sansung a32",2345,6,new Date());
		Product product3=new Product("sansung a32",2345,6,new Date());
		Product product4=new Product("sansung a32",2345,6,new Date());
		Product product5=new Product("sansung a32",2345,6,new Date());*/
	
		
		List<Product> products=Arrays.asList(product1,product2,product3,product4,product5);
		
		productRepository.saveBeatch(products);
		applicationContext.close();
	}

}
