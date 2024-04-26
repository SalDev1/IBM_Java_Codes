package com.myapp.spring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Product;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;

@Repository
//@Scope("prototype")
@Scope("singleton")
public class ProductRepositoryImpl implements ProductRepository , BeanNameAware, BeanPostProcessor, ApplicationContextAware{
	
	// Map which is not initialized --> NullPointerException.
	// @Autowired 
	private Map<Integer,Product>products; // Autowiring by type.
	
	// Auto-wiring by constructor.
	public ProductRepositoryImpl(Map<Integer, Product> products) {
		this.products = products;
	}
	
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

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Inside application context");
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Inside setBeanName");
	}
	
	// Doing Initialization. 
	@PostConstruct
	public void init() {
		System.out.println("Inside setBeanName");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Inside destroy method");
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("Inside the POST Process BEFORE");
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean,beanName);
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("After the POST Process AFTER");
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean,beanName);
	}

}
