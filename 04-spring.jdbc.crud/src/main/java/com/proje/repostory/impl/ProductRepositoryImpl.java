package com.proje.repostory.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory;
import com.proje.rowMapper.ProductRowMapper;
@Repository
public class ProductRepositoryImpl implements ProductRepostory {
    @SuppressWarnings("unused")
	
	private DataSource datasurce;
    
    private JdbcTemplate jdbcTemplate;

	@Override 
	public boolean createProductTable() {
		// TODO Auto-generated method stub
		
	final	String query="Create Table product(productId INT NOT NULL AUTO_INCREMENT, name VARCHAR(20) ,price DOUBLE,avaliable INT ,"
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


@Override
public Product finById(int id) {
	final String sorgu ="SELECT * FROM product WHERE productId =?";
	
	
	Product product=null;
	
	
	try {
		
		/*
		product=this.jdbcTemplate.queryForObject(sorgu, new Object[] {id}, new RowMapper<Product>(){
			
			
			public Product mapRow(ResultSet rs,int i) throws SQLException{
				
				int productId=rs.getInt(1);
				String name=rs.getString("name");
				double price=rs.getDouble("price");
				int avaliable=rs.getInt("avaliable");
				Date addDate=rs.getDate("addDate");
				Product  p=new Product(productId,name,price,avaliable,addDate);
				return p;
				
			}
		});
	
		*/
		product=this.jdbcTemplate.queryForObject(sorgu, new Object[] {id}, new ProductRowMapper());
	
	} catch (Exception e) {
		// TODO: handle exception 
		System.out.println("Hata"+e);
		
	}
	


	
	return product;
}

@Override
public List<Product> findProducts() {
	String sorgu="select * from product";
	List<Product> products=null;
	
	
	try {
		
		
		products=this.jdbcTemplate.query(sorgu, new ProductRowMapper());
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Hata"+e);
	}
	
	
	// TODO Auto-generated method stub
	return 		products;
}



@Override
public boolean update(Product product) {
	// TODO Auto-generated method stub
	
	
	String sorgu="UPDATE product SET name=?, price=? , avaliable =? where productId=?";
	
	try {
		
		/*this.jdbcTemplate.update(sorgu, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, product.getName());
				ps.setDouble(2, product.getPrice());
				ps.setInt(3, product.getAvalible());
				ps.setInt(4, product.getProductId());
				
				
			}
			
			
			
		});
		
		*/
		this.jdbcTemplate.update(sorgu, new Object[] {product.getName(),product.getPrice(), product.getAvalible(),product.getProductId()});
		
	} catch (Exception e) {
		// TODO: handle exception
		
		System.out.println("Hata"+e);
		
		return false;
	}	
	
	
	return true;
}

	
	
	
}
