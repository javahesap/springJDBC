package com.proje.repostory;

import java.util.List;

import com.proje.model.Product;

public interface ProductRepostory1 {

	List<Product> findProducts();
	Product finProductById(int id);
}
