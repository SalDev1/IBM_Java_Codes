package com.myapp.spring;  // Considers this base package.

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.myapp.spring.domain.Product;
import com.myapp.spring.repository.ProductRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class SpringBootHibernateDemo4Application /*implements CommandLineRunner*/{
	
	@Autowired
//	public ProductRepository repository;

	public static void main(String[] args) {
		// Entry point for SpringBoot Application.
		SpringApplication.run(SpringBootHibernateDemo4Application.class, args);
	}
	
	
	// Old way - 1.
	// Runtime , whatever the argument we are passing to the function will be considered. 
//	@Override
//	public void run(String ...args) throws Exception {
//		repository.save(new Product("OnePlus11",75456.5,"http://oneplus.com","OnePlus11R",LocalDate.now(), 4.5));
//		D
//      repository.findAll().forEach(System.out::println);
//	}
	
	
	@Bean // A spring manage bean --> auto-managed by spring.
	// Lambda Functions.
	// runner() --> To test + supply values at the runtime + helps you interact with the container.
	@Transactional
	CommandLineRunner runner(ProductRepository repository)  {
		return args -> {
			
			// save --> insert a product into the repository.
//			repository.save(new Product("OnePlus11",75456.5,"http://oneplus.com","OnePlus11R",LocalDate.now(), 4.5));
//			repository.findAll().forEach(System.out::println);
			
//			// update --> update the existing details of the product.
			Product product = repository.findById(2).get();
			
			product.setDescription("SamsungGalaxyNote");
			product.setImageUrl("http://samsung.com");
			product.setStarRating(4.9);
			product.setPrice(96456.5);
			
    		repository.save(product);  
			// Check whether id exists + if yes make the update.
			
//		    repository.findAll().forEach(System.out::println);
		    
		    // Delete --> delete the existing product.
		    repository.delete(product);
		};
	};

}
