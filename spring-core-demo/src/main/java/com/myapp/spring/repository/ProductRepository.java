package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.model.Product;

public interface ProductRepository {
	List<Product> findAll();
	
	Product add(Product product);
	
	Product findByKey(String key);
}
