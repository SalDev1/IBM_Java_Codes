package com.myapp.core;

public interface LoanValidator {
	
	// By default, it is public + abstract. 
	boolean validate(double amount);
	
}
