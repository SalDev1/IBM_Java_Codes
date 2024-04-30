package com.myapp.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.spring.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
