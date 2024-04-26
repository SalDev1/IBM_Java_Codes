package com.myapp.core;

public class LoanRequestHandler {
	
	private double balance;

	public LoanRequestHandler(double balance) {
		// TODO Auto-generated constructor stub
		this.balance = balance;
	}
	// Passing the loan validator as parameter.
	public boolean approveLoan(LoanValidator loanValidator) {
		return loanValidator.validate(balance);
	}
}
