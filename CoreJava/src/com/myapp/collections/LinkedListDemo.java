package com.myapp.collections;

import java.util.LinkedList;
import java.util.List;

import com.myapp.core.Product;

public class LinkedListDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// This is Generic ArrayList of type Product and provides type-safety in nature.
		LinkedList<Product> list = new LinkedList<>();
		
		list.add(new Product(1,"Iphone15",75456.5));
		list.add(new Product(3,"OnePlus11R",65456.5));
		list.add(new Product(2,"Samsung", 114556.5));
		
		list.addFirst(new Product(4,"Vivo",35465.5));
		list.addLast(new Product(5,"Oppo",38456.5));
		
		list.removeFirst();
		list.removeLast();
		
		// list.add(n);
		
		System.out.println("Size "+ list.size());
		System.out.println("Get at zero"+ list.get(0));
		
		list.forEach(System.out::println);
		
		// System.out.println("Remove" + list.remove(0));
		// System.out.println("Get " + list.get(4)); --> we get indexOutOfBounds Exception.
		//System.out.println("Get at zero"+ list.get(0));
	}
}
