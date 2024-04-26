package com.myapp.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myapp.spring.aop.LoginManagerBean;
import com.myapp.spring.config.AppConfig;
import com.myapp.spring.model.Product;
import com.myapp.spring.repository.ProductRepository;

//@SpringBootApplication
public class SpringAopDemo2Application {

	public static void main(String[] args) {
		// SpringApplication.run(SpringAopDemo2Application.class, args);
		
		AbstractApplicationContext iocContainer = 
				new AnnotationConfigApplicationContext(AppConfig.class);
	
	
		ProductRepository repository = iocContainer.getBean(ProductRepository.class);
		ProductRepository repository1 = iocContainer.getBean(ProductRepository.class);
		
		System.out.print(repository == repository1);
		
		// Login in the user.
		LoginManagerBean login = iocContainer.getBean(LoginManagerBean.class);
		login.login("admin", "admin");
		
		System.out.println(login.getLoggedInUser());
		
		repository.add(new Product(6,"Vivo17",34565.15));
		repository.findAll().forEach(System.out::println);
		
		iocContainer.close();
	}

}
