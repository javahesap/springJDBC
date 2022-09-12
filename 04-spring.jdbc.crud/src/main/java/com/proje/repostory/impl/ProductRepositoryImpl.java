package com.proje.repostory.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
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
	
	
	
	@Override
	public boolean save(Product product) {
		
		final String sorgu ="INSERT INTO product (productId, name, price, avaliable, addDate) VALUES (?,?,?,?,?)";
		
		
          try {
			
			Object[] objects=new Object[] {product.getProductId(),product.getName(),product.getPrice(),product.getAvalible(),product.getAddDate()};
			
			this.jdbcTemplate.update(sorgu,objects);
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



	@Override
	public boolean saveBeatch(List<Product> products) {


		final String sorgu ="INSERT INTO product (productId, name, price, avaliable, addDate) VALUES (?,?,?,?,?)";
		
		
        try {
			
			
			this.jdbcTemplate.batchUpdate(sorgu, new BatchPreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					// TODO Auto-generated method stub
					Product product=products.get(i);
					ps.setInt(1,product.getProductId());
					ps.setString(2, product.getName());
					ps.setDouble(3, product.getPrice());
					ps.setInt(4,product.getAvalible());
			         ps.setTimestamp(5,Timestamp.from(product.getAddDate().toInstant()));
			   
					
				}
				
				@Override
				public int getBatchSize() {
					// TODO Auto-generated method stub
					
					products.size();
					return 0;
				}
			});
			
		}catch(RuntimeException e) {
			System.out.println("Hata"+e);
			return false;
		}
		
		return false;
	}






	
	
	
}
