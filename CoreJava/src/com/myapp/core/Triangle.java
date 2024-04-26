package com.myapp.core;

// Extends --> Inheritance Purposes. 
public class Triangle extends Shape {

	public Triangle(double width, double height) {
		super(width, height); // calling the constructors and methods of the parent class.
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return .5*getWidth()*getHeight();
	}

}
