package com.myapp.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.myapp.core.nio.Product;

public class TestSortedSet {
	public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
		
		list.add(new Product(1,"Iphone15",75456.5));
		list.add(new Product(3,"OnePlus11R",65456.5));
		list.add(new Product(2,"SamsungFlip", 114556.5));
		list.add(new Product(4,"SamsungFlip", 114556.5));
		
		
		// The reason why we are getting the ClassCastException 
		// is because SortedSet is Parent of TreeSet Child , and we were using the Set.
		
		// This will show you the result based on the productId.
		SortedSet<Product> set = new TreeSet<>(Comparator.comparing(Product::productId));
		
		set.addAll(list);
		System.out.println("List Size"+list.size());
		System.out.println("Set Size"+set.size());
		
		// Sets are unordered in nature.
		//System.out.println("Set"+set.get(0));
		// Using the predicate over here to get all the products greater than 5000.0
		
//		set.removeIf(p -> p.price()>=75000.0);
//		System.out.println("Set Size After Removal "+set.size());
		
		DoubleSummaryStatistics stats =  set.stream().mapToDouble(Product::price)
		.summaryStatistics();
		
		System.out.println(stats.getCount());
	}
}
