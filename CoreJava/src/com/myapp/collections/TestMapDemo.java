package com.myapp.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.myapp.core.nio.Product;

public class TestMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Product> map = new HashMap<>();
		
		map.put("apple", new Product(1, "IPhone15", 75456.5));	//put is used for adding the key and value
		map.put("oneplus", new Product(4, "OnePlus12", 65456.5));
		map.put("samsung", new Product(2, "SamsungFlip", 95456.5));
		
		System.out.println("Size "+map.size());
		
		System.out.println("Get "+map.get("samsung"));
		
		System.out.println("Get "+map.get("sams"));
		
		System.out.println("Get "+map.getOrDefault("sams",new Product(0, "", 0.0)));
		
		map.keySet().forEach(System.out::println);
		map.values().forEach(System.out::println);
		map.entrySet().forEach(System.out::println);
		
		Set<Map.Entry<String, Product>>entry = map.entrySet();	
		//both the key and value will be represented as 1 entry
		
		entry.forEach(keyValue -> System.out.println(keyValue.getKey()+" "+keyValue.getValue()));
	}
}