package com.proje.repostory.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proje.model.Product;
import com.proje.repostory.ProductRepostory;
@Repository
public class ProductRepositoryImpl2 implements ProductRepostory {
    @SuppressWarnings("unused")
	@Autowired
	private DataSource datasurce;
    
    private JdbcTemplate jdbcTemplate;
	public boolean save(Product product) {
		// TODO Auto-generated method stub
		
		this.jdbcTemplate=new JdbcTemplate(datasurce);
		return false;
	}

	public boolean update(Product product) {
		
		this.jdbcTemplate=new JdbcTemplate(datasurce);
		// TODO Auto-generated method stub
		return false;
	}

	

	/*@Autowired // bu şekildede kullanılabilir
	public void setDatasurce(DataSource datasurce) {
		this.datasurce = datasurce;
	}
*/
}
