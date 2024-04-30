package com.myapp.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.spring.domain.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;


@Repository
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
public class ProductRepositoryImpl implements ProductRepository {
	// Aim --> Interacting with the db.
	
	// @PersistenceUnit 
	// It gives an object + manage our entities.
	// Inject the dependencies + allow to inject Entity Managers only.
	
	// This is an example of dependency injection.
	@PersistenceContext
	@Qualifier(value="entityManagerFactory")
	private EntityManager jpa;
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		
		// Java Persistence Query Language 
		// --> translates SELECT * from 
		// It helps you to convert rows into objects.
		return jpa.createQuery("from Product").getResultList();
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		jpa.persist(product);
		return product;
	}

}
