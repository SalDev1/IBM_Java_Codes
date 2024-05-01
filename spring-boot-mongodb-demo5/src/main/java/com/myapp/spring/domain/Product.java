package com.myapp.spring.domain;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "products")

public class Product {

   
   @Id
   private String id;
   
   
   private Integer productId;
   
   
   private String productName;
   
   
   private Double price;
   
   
   private String imageUrl;
   
   
   private String description;
   
   
   private LocalDate productAvailable;
   
   
   private Double starRating;
   
   
   
   public Product() {
       // TODO Auto-generated constructor stub
   }


   
   

   public Product(Integer productId, String productName, Double price, String imageUrl, String description,
           LocalDate productAvailable, Double starRating) {
       this.productId = productId;
       this.productName = productName;
       this.price = price;
       this.imageUrl = imageUrl;
       this.description = description;
       this.productAvailable = productAvailable;
       this.starRating = starRating;
   }





   public Product(String productName, Double price, String imageUrl, String description, LocalDate productAvailable,
           Double starRating) {
       this.productName = productName;
       this.price = price;
       this.imageUrl = imageUrl;
       this.description = description;
       this.productAvailable = productAvailable;
       this.starRating = starRating;
   }


   
   

   public String getId() {
       return id;
   }



   public void setId(String id) {
       this.id = id;
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