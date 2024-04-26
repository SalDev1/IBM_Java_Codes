package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.domain.Product;

public interface ProductRepository {
	
	List<Product> findAll();
	
	Product save(Product product);
}
