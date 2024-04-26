package com.myapp.core;

import java.util.Objects;

public class Product implements Comparable<Product>{

	private int productId;
	private String productName;
	private Double price;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
		
	}

	public Product(int productId, String productName, Double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	@Override
	public int hashCode() {
		return Objects.hash(price, productId, productName);
	}


	@Override
	
	// To compare between two objects , using the equal sign over here.
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(price, other.price) && productId == other.productId
				&& Objects.equals(productName, other.productName);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=");
		builder.append(productId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return price.compareTo(o.price);
		// return -1 , first value < second value.
		// return 1 , first value > second value. 
		// return 0 , first_val == second_val;
	}
}
