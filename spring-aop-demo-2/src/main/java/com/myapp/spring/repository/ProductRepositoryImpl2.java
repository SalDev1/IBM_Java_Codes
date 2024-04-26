package com.myapp.spring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Product;

import jakarta.annotation.Resource;

public class ProductRepositoryImpl2 implements ProductRepository {
	
	// Map which is not initialized --> NullPointerException.
	//@Autowired 
	private Map<Integer,Product>products = new HashMap<>();
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		
		// Returns you a list of products.
		// .values() --> It will give collection. 
		// .stream() --> Put the data into a pipe and return it as list.
		return products.values().stream().toList();
	}

	@Override
	public Product add(Product product) {
		// TODO Auto-generated method stub
		return products.put(product.getProductId(), product);
	}

	@Override
	public Product findByKey(String key) {
		// TODO Auto-generated method stub
		return products.getOrDefault(key, new Product(0,"",0.0));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
