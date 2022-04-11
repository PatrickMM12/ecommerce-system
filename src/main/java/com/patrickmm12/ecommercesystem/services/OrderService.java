package com.patrickmm12.ecommercesystem.services;

import java.util.List;
import java.util.Optional;

import com.patrickmm12.ecommercesystem.entities.Order;
import com.patrickmm12.ecommercesystem.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired //Spring realiza a injeção de dependência de forma transparente ao programador
    private OrderRepository repository;
    
    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
