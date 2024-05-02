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
@Table(name="ms_orders")
public class Order {
	
	@Id // Helps you map the primary key column in the table. 
	@GeneratedValue(strategy=GenerationType.AUTO) // Id will be auto-generated. 
	@Column(name = "ORDER_ID", nullable = false) // Define the attributes of the relational table.
	private Integer orderId;
	
	@Column(name = "ORDER_NAME", nullable = false)
	private String orderName;
	
	@Column(name = "ORDER_TOTAL", nullable = false)
	private Double total;
	
	public Order() {
		
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId, orderName, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderId, other.orderId) && Objects.equals(orderName, other.orderName)
				&& Objects.equals(total, other.total);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderId=");
		builder.append(orderId);
		builder.append(", orderName=");
		builder.append(orderName);
		builder.append(", total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}
}
