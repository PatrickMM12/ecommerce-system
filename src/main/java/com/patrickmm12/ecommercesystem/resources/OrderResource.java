package com.patrickmm12.ecommercesystem.resources;

import java.util.List;

import com.patrickmm12.ecommercesystem.entities.Order;
import com.patrickmm12.ecommercesystem.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    
    @Autowired //Spring realiza a injeção de dependência de forma transparente ao programador
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){ //@PathVariable = Spring aceitar Id como caminho na URL
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
