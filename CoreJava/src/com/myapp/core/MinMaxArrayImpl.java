package com.myapp.core;

public class MinMaxArrayImpl<T extends Comparable<T>> implements MinMaxArray<T> {
	
	private T values[];
	
	// constructor is taking the array of type generic.
	// ... --> variable argument count.
	public MinMaxArrayImpl(T ... values) {
		this.values = values;
	}
	
	@Override
	public T min() {
		T val = values[0];
		for(T v : values) { // For Each loop.
			if(v.compareTo(val) < 0) {
				val = v;
			}
		}
		return val;
	}
	
	@Override 
	public T max() {
		T val = values[0];
		for(T v : values) { // For Each loop.
			if(v.compareTo(val) > 0) {
				val = v;
			}
		}
		return val;
	}
	
	public static void main(String[] args) {
		MinMaxArray<Integer> intArray = new MinMaxArrayImpl<>(12,34,56,78,99);
		
		System.out.println("Min Value "+intArray.min());
		System.out.println("Max Value "+intArray.max());
		
		MinMaxArray<Double> doubleArray = new MinMaxArrayImpl<>(12.0,3.4,5.6,78.6,9.59);
		System.out.println("Min Value "+doubleArray.min());
		System.out.println("Max Value "+doubleArray.max());
		
		// Since the Product is not of Type Comparable , that's why it is giving you an error.
		MinMaxArray<Product> productArray = new MinMaxArrayImpl<>(
		  new Product(1,"Iphone15",65675.5),
		  new Product(4,"OnePlus12",35675.5),
		  new Product(3,"SamsungFlip",85675.5)
		);
		
		System.out.println("Min Value "+productArray.min());
		System.out.println("Max Value "+productArray.max());
		
	}
}
