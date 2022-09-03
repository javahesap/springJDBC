package com.proje.repostory;

import com.proje.model.Product;

public interface ProductRepostory {
	boolean save(Product product );
	boolean update(Product product );
}
