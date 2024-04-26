package com.myapp.collections;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.myapp.core.nio.Product;

public class TestSet {
	public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
		
		list.add(new Product(1,"Iphone15",75456.5));
		list.add(new Product(3,"OnePlus11R",65456.5));
		list.add(new Product(2,"SamsungFlip", 114556.5));
		list.add(new Product(2,"SamsungFlip", 114556.5));
		
		Set<Product> set = new HashSet<>();
		
		set.addAll(list);
		
		System.out.println("List Size"+list.size());
		System.out.println("Set Size"+set.size());
		
		// Sets are unordered in nature.
		//System.out.println("Set"+set.get(0));
		// Using the predicate over here to get all the products greater than 5000.0
		
		set.removeIf(p -> p.price()>=75000.0);
		System.out.println("Set Size After Removal "+set.size());
		
		DoubleSummaryStatistics stats =  set.stream().mapToDouble(Product::price)
		.summaryStatistics();
		
		System.out.println(stats.getCount());
	}
}
