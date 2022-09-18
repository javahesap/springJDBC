package com.proje.repostory.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory;

@Repository
public  class ProductRepositoryImpl2  implements ProductRepostory{
	private JdbcTemplate jdbcTemplate;	
	
	
	public void ProductRepositoryImpl1() {}
	@Autowired
	public void setDataSource(DataSource dataSurce) {
		
		this.jdbcTemplate=new JdbcTemplate(dataSurce);
		
	}

	public List<Product> findProducts() {
		String sorgu="select * from product";
		List<Product> products=new ArrayList<>();
		
		
		try {
			
			
			List<Map<String,Object>> list=this.jdbcTemplate.queryForList(sorgu );	
			
			for(Map<String,Object> map:list) {
				
				int ProductId=(int) map.get("productId");
			     String name=(String) map.get("name");
			     double price=(double) map.get("price");
			     int avaliable=(int) map.get("avaliable");
			     Date addDate=(Date) map.get("addDate");
			  Product   product=new Product(ProductId,name,price,avaliable,addDate);
			     products.add(product);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Hata"+e);
		}
		
		
		// TODO Auto-generated method stub
		return 		products;
	}

	public Product finProductById(int id) {
		final String sorgu ="SELECT * FROM product WHERE productId =?";
				
		Product product=null;
		try {
						
			Map<String,Object>map=this.jdbcTemplate.queryForMap(sorgu,  new Object[] {id} );	
		     int ProductId=(int) map.get("productId");
		     String name=(String) map.get("name");
		     double price=(double) map.get("price");
		     int avaliable=(int) map.get("avaliable");
		     Date addDate=(Date) map.get("addDate");
			
			product=new Product(ProductId,name,price,avaliable,addDate);
			
		} catch (Exception e) {
			System.out.println("Hata:  "+e);
			// TODO: handle exception		}				
	}		
		return product;
	
	}
}
