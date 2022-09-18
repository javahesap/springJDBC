package com.proje.repostory;

import java.util.List;

import com.proje.model.Product;

public interface ProductRepostory {

	List<Product> findProducts();
	Product finProductById(int id);
}
