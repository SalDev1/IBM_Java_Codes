package com.myapp.spring.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myapp.spring.domain.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceUnit;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	// Aim --> Interacting with the db.
	
	@PersistenceUnit // It gives an object + manage our entities.
	// Inject the dependencies + allow to inject Entity Managers only.
	private EntityManager jpa;
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		
		// Java Persistence Query Language 
		// --> translates from SELECT * from 
		// It helps you to convert rows into objects.
		return jpa.createQuery("from Product").getResultList();
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		jpa.persist(product);
		return product;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
