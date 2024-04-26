package com.myapp.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myapp.spring.config.AppConfig;
import com.myapp.spring.model.Product;
import com.myapp.spring.repository.ProductRepository;

//@SpringBootApplication
public class SpringCoreDemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringCoreDemoApplication.class, args);
		
		ApplicationContext ioContainer = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		// ProductRepository repository = ioContainer.getBean("productRepositoryImpl",ProductRepository.class);
		
		
		// This shows that we have a singleton bean. 
		// Singleton Bean --> 
		// provides a single instance of a specific entity , every time you request from Bean you
		// get the same reference.
		ProductRepository repository = ioContainer.getBean(ProductRepository.class);
		ProductRepository repository1 = ioContainer.getBean(ProductRepository.class);
		
		System.out.print(repository == repository1);
		
		repository.add(new Product(6,"Vivo17",34565.15));
		repository.findAll().forEach(System.out::println);
	}

}
