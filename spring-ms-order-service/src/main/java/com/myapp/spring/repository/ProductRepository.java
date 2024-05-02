package com.myapp.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.spring.domain.Order;

public interface ProductRepository extends JpaRepository<Order, Integer>{

}
