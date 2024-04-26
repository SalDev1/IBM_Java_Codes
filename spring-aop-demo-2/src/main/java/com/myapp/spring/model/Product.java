package com.myapp.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Product {
   
   private Integer productId;
   private String productName;
   private Double price;
   
   
   public Product() {
       // TODO Auto-generated constructor stub
   }


   public Product(Integer productId, String productName, Double price) {
       this.productId = productId;
       this.productName = productName;
       this.price = price;
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
   

}