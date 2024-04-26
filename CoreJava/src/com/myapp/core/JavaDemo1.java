package com.myapp.core;

public class JavaDemo1 {
	
	public static void display(Shape shape) {
		System.out.println("Area of Shape " + shape.getClass().getSimpleName() + shape.calculateArea());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		
		// display(new Shape(23.4,34.5));
		
		display(new Rectangle(23.4,34.5));
		display(new Triangle(23.4,34.5));
		// display("")
	}

}
