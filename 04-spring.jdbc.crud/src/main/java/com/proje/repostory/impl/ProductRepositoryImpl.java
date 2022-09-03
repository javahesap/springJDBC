package com.proje.repostory.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory;
@Repository
public class ProductRepositoryImpl implements ProductRepostory {
    @SuppressWarnings("unused")
	
	private DataSource datasurce;
    
    private JdbcTemplate jdbcTemplate;

	@Override
	public boolean createProductTable() {
		// TODO Auto-generated method stub
		
		String query="Create Table product(productId INT NOT NULL, name VARCHAR(20) ,price DOUBLE,avaliable INT ,"
				+ "addDate DATETIME,PRIMARY KEY(productId))";
		this.jdbcTemplate.execute(query);
		
		try {
			
			
		}catch(RuntimeException e) {
			System.out.println("Hata"+e);
			return false;
		}
		
		
		return false;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSurce) {
		
		this.jdbcTemplate=new JdbcTemplate(dataSurce);
		
	}
	
}
