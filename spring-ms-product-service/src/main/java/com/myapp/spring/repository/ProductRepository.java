package com.myapp.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myapp.spring.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
	
	Optional<List<Product>> findByPriceGreaterThanEqual(Double price);
}
