package com.myapp.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class LoginManagerBean {
	
	// 1 MARK Question.
	// ThreadLocal is a scope which helps you share data from class among other class.
	// To pass the data from one class to another class , we use ThreadLocal 
	// Every Class has thread local scope.
	private static ThreadLocal<LoginBean> threadLocal = new ThreadLocal<>();
	
	public void login(String username, String password) {
		LoginBean loginBean = threadLocal.get();
		
		if(loginBean == null) {
			threadLocal.set(new LoginBean(username, password));
		}
	}
	
	public void logout() {
		LoginBean loginBean = threadLocal.get();
		
		if(loginBean == null) {
			threadLocal.remove();
		}
	}
	
	public LoginBean getLoggedInUser() {
		return threadLocal.get();
	}
}
