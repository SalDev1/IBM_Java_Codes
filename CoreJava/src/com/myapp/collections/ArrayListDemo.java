package com.myapp.collections;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

import com.myapp.core.nio.Product;

public class ArrayListDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// This is Generic ArrayList of type Product and provides type-safe in nature.
		List<Product> list = new ArrayList<>();
		
		list.add(new Product(1,"Iphone15",75456.5));
		list.add(new Product(3,"OnePlus11R",65456.5));
		list.add(new Product(2,"Samsung", 114556.5));
		
		// list.add(n);
		
		// You are not allowed to cast a product to string. 
		// You will get an error at compile time if you don't use (String).
		//String str = (String)list.get(0);
		
		// One is a ArrayList of type Product , while the below list is flexible in type.
        // List list1 = new ArrayList();
		
		System.out.println("Size "+ list.size());
		
		System.out.println("Remove" + list.remove(0));
		System.out.println("Get " + list.get(0));
		
		// Filtering products whose price is greater than >= 5000.00
		Stream<Product> stream =  list.stream();
		
//		stream.filter(p -> p.price()>= 50000.0)
//		.forEach(System.out::println);
//		
//		double minPrice = list.stream()
//                .mapToDouble(Product::price)
//                .min()
//                .orElse(0.0);
//		
//		double maxPrice = list.stream()
//                .mapToDouble(Product::price)
//                .max()
//                .orElse(0.0);
		
//		System.out.println("Minimum price: " + minPrice);
//		System.out.println("Maximum price: " + maxPrice);
//		
//		DoubleSummaryStatistics stats = 
//				stream.filter(p -> p.price()>=5000.0)
//				.mapToDouble(Product::price).summaryStatistics();
//		
//		System.out.println("Min "+ stats.getMin());
//		System.out.println("Max "+ stats.getMax());
//		System.out.println("Sum " + stats.getSum());
//		System.out.println("Average " + stats.getAverage());
		
		
		stream.filter(p -> p.price()>=50000.0)
		.map(Product::price)
		.reduce((preVal,nextVal)-> preVal += nextVal);
		
	}
}
