package com.myapp.core.nio;

import java.io.Serializable;

public record Product(Integer productId, String productName, Double price) implements Serializable/* Comparable<Product> */{

//	@Override
//	public int compareTo(Product o) {
//		// TODO Auto-generated method stub
//		return price.compareTo(o.price);
//	}
}