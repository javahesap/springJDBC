package com.proje.repostory;

import com.proje.model.Product;

public interface ProductRepostory {
	
	boolean createProductTable();
	boolean save(Product product);
}
