package com.patrickmm12.ecommercesystem.services;

import java.util.List;
import java.util.Optional;

import com.patrickmm12.ecommercesystem.entities.Category;
import com.patrickmm12.ecommercesystem.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired //Spring realiza a injeção de dependência de forma transparente ao programador
    private CategoryRepository repository;
    
    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
