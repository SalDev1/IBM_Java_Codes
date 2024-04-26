package com.myapp.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.myapp.core.nio.Product;

public class TestDeque {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
		
		list.add(new Product(1,"Iphone15",75456.5));
		list.add(new Product(3,"OnePlus11R",65456.5));
		list.add(new Product(2,"SamsungFlip", 114556.5));
		
		
		// LinkedList is a better option than ArrayDeque.
		Deque<Product> deque = new ArrayDeque<>(list);
		
		deque.addFirst(new Product(5,"MotorolaGPlus", 55456.5));
		
		System.out.println(deque.size());
		System.out.println(deque.getFirst());
		
		System.out.println(deque.peek());
		System.out.println(deque.poll());
	}
}
