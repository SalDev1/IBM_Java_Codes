package com.myapp.core;

public class MarkerImpl {
	
	public void checkInterface() throws InterfaceNotFoundException {
		// Check whether the class is implementating the interface or not.
		
		// type of + instance of
		MarkerImpl a = new MarkerImpl();
		if(a instanceof Marker) {
			System.out.println("It is an interface");
		}
		else 
			throw new InterfaceNotFoundException("Interface Not Implemented");
		
		// Another example. 
//		if(this instanceof Marker) {
//			System.out.println("It is an interface");
//		}
//		else {
//			System.out.println("It is not an interface");
//		}
	}
 
	public static void main(String[] args) {
	   var marker = new MarkerImpl();
	   try {
		marker.checkInterface();
	} catch (InterfaceNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		System.out.println("Inside Final");
	}
	}
}
