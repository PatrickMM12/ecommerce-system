package com.patrickmm12.ecommercesystem.repositories;

import com.patrickmm12.ecommercesystem.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
