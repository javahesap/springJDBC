package com.proje.repostory.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory;

@Repository
public  class ProductRepositoryImpl3  implements ProductRepostory{
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
			
			
			
this.jdbcTemplate.query(new PreparedStatementCreator() {
@Override
public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
// TODO Auto-generated method stub

PreparedStatement prepareStatement	=con.prepareStatement(sorgu);


return prepareStatement;
}

										

},new  RowCallbackHandler() {

@Override
public void processRow(ResultSet rs) throws SQLException {
	
	do {
	
	
	
// TODO Auto-generated method stub
int productId=rs.getInt("productId");
String name=rs.getString("name");
double price=rs.getDouble("price");
int avaliable=rs.getInt("avaliable");
Date addDate=rs.getDate("addDate");


Product product=new Product();
product.setProductId(productId);
product.setName(name);
product.setPrice(price);
product.setAvaliable(avaliable);
product.setAddDate(addDate);
products.add(product);
}while(rs.next());



}
});






			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Hata"+e);
		}
		
		
		// TODO Auto-generated method stub
		return 		products;
	}

	public Product finProductById(int id) {
		final String sorgu ="SELECT * FROM product WHERE productId =?";
				
		Product product=new Product();
		try {
												
			this.jdbcTemplate.query(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					// TODO Auto-generated method stub
					
					PreparedStatement prepareStatement	=con.prepareStatement(sorgu);
					
					prepareStatement.setInt(1, id);
					return prepareStatement;
				}
				
																
				
			},new  RowCallbackHandler() {
				
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					int productId=rs.getInt("productId");
					String name=rs.getString("name");
					double price=rs.getDouble("price");
					int avaliable=rs.getInt("avaliable");
					Date addDate=rs.getDate("addDate");
					product.setProductId(productId);
					product.setName(name);
					product.setPrice(price);
					product.setAvaliable(avaliable);
					product.setAddDate(addDate);
				}
			});
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("Hata:  "+e);
			// TODO: handle exception		}				
	}		
		return product;
	
	}
}
