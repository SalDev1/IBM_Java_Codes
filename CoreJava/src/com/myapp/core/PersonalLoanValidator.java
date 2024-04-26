package com.myapp.core;

public class PersonalLoanValidator implements LoanValidator {
	
	private double balance;

	// There is no default constructor.
	public PersonalLoanValidator(double balance) {
		// TODO Auto-generated constructor stub
		this.balance = balance;
	}

	@Override
	public boolean validate(double amount) {
		// TODO Auto-generated method stub
		if(balance >= 5000.0)
			return true;
		else
		    return false;
	}

}
