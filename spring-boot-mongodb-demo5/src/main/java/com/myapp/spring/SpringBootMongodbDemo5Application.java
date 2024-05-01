package com.myapp.spring;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.spring.domain.Product;
import com.myapp.spring.repository.ProductRepository;

@SpringBootApplication
public class SpringBootMongodbDemo5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbDemo5Application.class, args);
	}

	@Bean 
	@Transactional
	CommandLineRunner runner(ProductRepository repository)  {
		return args -> {
			
			// save --> insert a product into the repository.
//			repository.save(new Product("OnePlus11",75456.5,"http://oneplus.com","OnePlus11R",LocalDate.now(), 4.5));
//			repository.findAll().forEach(System.out::println);
			
//			// update --> update the existing details of the product.
 		    Product product = repository.findById("6630837d84f08c6ccd199417").get();
//			
//			product.setDescription("SamsungGalaxyNote");
//			product.setImageUrl("http://samsung.com");
//			product.setProductAvailable(LocalDate.of(2024, 05, 03));
//			product.setStarRating(4.9);
//			product.setPrice(96456.5);
//			
//    		repository.save(product);  
			// Check whether id exists + if yes make the update.
			
		    
		    // Delete --> delete the existing product.
		    repository.delete(product);
			
		    repository.findAll().forEach(System.out::println);
		};
	};
}
