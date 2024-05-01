package com.myapp.spring.rest.api;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.domain.Product;
import com.myapp.spring.repository.ProductRepository;

@RestController
@RequestMapping("api/products")
public class ProductAPI {
	private ProductRepository repository;
	
	public ProductAPI(ProductRepository repository) {
		this.repository = repository;
	}
	
	// ResponseEntity --> Wraps the body content + status.
	// List<Product> --> gives us the result. 
	
	
	// Fetching all the products in the GET Method.
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		return new ResponseEntity<List<Product>>(repository.findAll(), HttpStatus.OK);
	}
	
	// Fetching the products greater than a given price.
	@GetMapping("/find/{price}")
	public ResponseEntity<List<Product>> findByPrice(@PathVariable("price") Double price) {
		return new ResponseEntity<List<Product>>(repository.findByPriceGreaterThanEqual(price).get(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return new ResponseEntity<Product>(repository.save(product),HttpStatus.CREATED);
	}
	// @PathVaraible --> Dependency Injection Annotation to inject the parameters.
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody Product product) {
		
		// Showing appropriate response based on the error.
		Product existingproduct = repository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Product with code " + id + " not found"));
		
		product.setId(id);
		BeanUtils.copyProperties(product,existingproduct);
		
		return new ResponseEntity<Product>(repository.save(existingproduct),HttpStatus.OK);
	}
	
	// Deleting a product. 
	@DeleteMapping("/{id}")   // Resource , we map to the delete action.
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		Product existingproduct = repository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Product with code " + id + " not found"));
		
		repository.delete(existingproduct);
		return new ResponseEntity<String> ("Product Deleted ", HttpStatus.NO_CONTENT);
		
	}
}
