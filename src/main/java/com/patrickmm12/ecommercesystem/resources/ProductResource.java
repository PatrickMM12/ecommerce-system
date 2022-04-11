package com.patrickmm12.ecommercesystem.resources;

import java.util.List;

import com.patrickmm12.ecommercesystem.entities.Product;
import com.patrickmm12.ecommercesystem.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producties")
public class ProductResource {
    
    @Autowired //Spring realiza a injeção de dependência de forma transparente ao programador
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){ //@PathVariable = Spring aceitar Id como caminho na URL
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
