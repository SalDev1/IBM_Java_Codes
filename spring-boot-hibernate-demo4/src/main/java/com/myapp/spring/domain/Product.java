package com.myapp.spring.domain;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


// This is a Java Spring Schema , Doing ORM. 
@Entity  // Persistence Class.
@Table(name="products")
public class Product {
	
	@Id // Helps you map the primary key column in the table. 
	@GeneratedValue(strategy=GenerationType.AUTO) // Id will be auto-generated. 
	@Column(name = "PRODUCT_ID", nullable = false) // Define the attributes of the relational table.
	private Integer productId;
	
	@Column(name = "PRODUCT_NAME", nullable = false)
	private String productName;
	
	@Column(name = "PRODUCT_PRICE", nullable = false)
	private Double price;
	
	@Column(name = "PRODUCT_IMAGE_URL", nullable = false)
	private String imageUrl;
	
	@Column(name = "PRODUCT_DESCRIPTION", nullable = false)
	private String description;
	
	@Column(name = "PRODUCT_AVAILABLE", nullable = false)
	private LocalDate productAvailable;
	
	@Column(name = "PRODUCT_RATING", nullable = false)
	private Double starRating;
	
	public Product() {
		
	}
	public Product(String productName, Double price, String imageUrl, String description, LocalDate productAvailable,
			Double starRating) {
		super();
		this.productName = productName;
		this.price = price;
		this.imageUrl = imageUrl;
		this.description = description;
		this.productAvailable = productAvailable;
		this.starRating = starRating;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getProductAvailable() {
		return productAvailable;
	}
	public void setProductAvailable(LocalDate productAvailable) {
		this.productAvailable = productAvailable;
	}
	public Double getStarRating() {
		return starRating;
	}
	public void setStarRating(Double starRating) {
		this.starRating = starRating;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, imageUrl, price, productAvailable, productId, productName, starRating);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		return Objects.equals(description, other.description) && Objects.equals(imageUrl, other.imageUrl)
				&& Objects.equals(price, other.price) && Objects.equals(productAvailable, other.productAvailable)
				&& Objects.equals(productId, other.productId) && Objects.equals(productName, other.productName)
				&& Objects.equals(starRating, other.starRating);
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
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", description=");
		builder.append(description);
		builder.append(", productAvailable=");
		builder.append(productAvailable);
		builder.append(", starRating=");
		builder.append(starRating);
		builder.append("]");
		return builder.toString();
	}
	
	
}
