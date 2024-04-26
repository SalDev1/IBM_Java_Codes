package com.myapp.core;

public class TestLoanRequestHandler {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
	
		double balance = 2500.0;
		// var is used for local variables.
		var loanRequestHandler = new LoanRequestHandler(balance);
		
		boolean result = loanRequestHandler.approveLoan(new BusinessLoanValidator(balance));
		
		if(result) {
			System.out.println("Loan Approved");
		}
		else 
			System.out.println("Loan Rejected");
	}

}
