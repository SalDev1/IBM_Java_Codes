package com.myapp.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect // Contains common logic
// This is the Aspect Program.
public class SecurityAspect {
	
	@Autowired
	private LoginManagerBean loginManagerBean;
	
	// Example of PointCut Expression Langugage.
	@Before("execution (* com.myapp.spring.repository.ProductRepository.*(..))")
	public void verify() {
		LoginBean loginBean = loginManagerBean.getLoggedInUser();
		
		if(loginBean == null) {
			throw new SecurityException("U Must login to access the methods");
		}
		else {
			if(loginBean.getUsername().equals("admin") && loginBean.getPassword().equals("admin")) {
				System.out.println("Welcome User"+ loginBean.getUsername());
			}
			else {
				throw new SecurityException("Invalid username or password");
			}
		}
	}
}
