package com.patrickmm12.ecommercesystem.resources;

import java.util.List;

import com.patrickmm12.ecommercesystem.entities.User;
import com.patrickmm12.ecommercesystem.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @Autowired //Spring realiza a injeção de dependência de forma transparente ao programador
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){ //@PathVariable = Spring aceitar Id como caminho na URL
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
