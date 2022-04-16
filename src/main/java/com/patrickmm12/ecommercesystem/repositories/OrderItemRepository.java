package com.patrickmm12.ecommercesystem.repositories;

import com.patrickmm12.ecommercesystem.entities.OrderItem;
import com.patrickmm12.ecommercesystem.entities.pk.OrderItemPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
    
}
