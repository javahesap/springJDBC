package com.proje.repostory;

import java.util.List;

import com.proje.model.Product;

public interface ProductRepostory {
	
	boolean createProductTable();
	boolean save(Product product);
	
	boolean saveBeatch(List<Product> products);
	Product finById(int id);
	List<Product> findProducts();
	boolean update(Product product);
	boolean deleteById(int id);
}
