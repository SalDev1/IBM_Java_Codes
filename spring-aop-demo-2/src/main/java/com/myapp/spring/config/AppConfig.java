package com.myapp.spring.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.myapp.spring.model.Product;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Configuration
@ComponentScan(basePackages="com.myapp.spring")
@EnableAspectJAutoProxy  // Weaver class.
public class AppConfig {
	
	// Another way of defining a map.
	
//	@Bean
//	Map<Integer,Product> map() {
//		
//	    Map<Integer,Product> map = new HashMap<>();
//		
//	    map.put(1, new Product(1,"IPhone15",74545.6));
//	    map.put(2, new Product(3,"OnePlus12R",65456.7));
//	    map.put(3,new Product(3,"SamsungFlip",105458.9));
//	    
//		return map;
//	}
	
	   @Bean("products1")
	   Map<Integer, Product> map1(){
	       
	       Map<Integer, Product> map = new HashMap<>();
	       map.put(1, new Product(1,"Iphone15",75456.5));
	       map.put(2, new Product(3,"Oneplus12R",65456.5));
	       map.put(3, new Product(3,"SamsungFlip",105456.5));
	               
	       return map;
	   }
	
	// Alternate way of reading the products from csv file.
	@Bean("products")
	   Map<Integer, Product> map2() throws IllegalStateException, FileNotFoundException{
	       
	       List<Product> products = new CsvToBeanBuilder(new FileReader("products.csv"))
	        .withType(Product.class)
	        .build()
	        .parse();
	       
	
	       // Converting a list into a Map.
	       return products.stream().collect(Collectors.toMap(Product::getProductId, item->item));
	   }
}
