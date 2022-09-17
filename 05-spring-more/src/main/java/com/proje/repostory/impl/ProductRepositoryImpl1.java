package com.proje.repostory.impl;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory1;

@Repository
public  class ProductRepositoryImpl1  implements ProductRepostory1{
	private JdbcTemplate jdbcTemplate;	
	@Autowired
	public void setDataSource(DataSource dataSurce) {
		
		this.jdbcTemplate=new JdbcTemplate(dataSurce);
		
	}

	public List<Product> findProducts() {
		String sorgu="select * from product";
		List<Product> products=null;
		
		
		try {
			
			
			products=this.jdbcTemplate.query(sorgu, new BeanPropertyRowMapper<>(Product.class));
			
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
						
			product=this.jdbcTemplate.queryForObject(sorgu,  new Object[] {id}, new BeanPropertyRowMapper<>(Product.class));			
			
		} catch (Exception e) {
			System.out.println("Hata"+e);
			// TODO: handle exception		}				
	}		
		return product;
	
	}
}
