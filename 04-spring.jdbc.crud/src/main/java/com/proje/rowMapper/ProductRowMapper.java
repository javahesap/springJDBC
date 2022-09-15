package com.proje.rowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.proje.model.Product;

public class ProductRowMapper  implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		int productId=rs.getInt(1);
		String name=rs.getString("name");
		double price=rs.getDouble("price");
		int avaliable=rs.getInt("avaliable");
		Date addDate=rs.getDate("addDate");
		Product  p=new Product(productId,name,price,avaliable,addDate);
		return p;
		
		
		
		// TODO Auto-generated method stub
		
	}

}
