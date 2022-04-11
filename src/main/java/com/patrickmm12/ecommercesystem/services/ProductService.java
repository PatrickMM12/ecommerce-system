package com.patrickmm12.ecommercesystem.services;

import java.util.List;
import java.util.Optional;

import com.patrickmm12.ecommercesystem.entities.Product;
import com.patrickmm12.ecommercesystem.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired //Spring realiza a injeção de dependência de forma transparente ao programador
    private ProductRepository repository;
    
    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
