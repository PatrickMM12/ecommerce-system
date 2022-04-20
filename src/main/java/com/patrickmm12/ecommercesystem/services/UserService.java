package com.patrickmm12.ecommercesystem.services;

import java.util.List;
import java.util.Optional;

import com.patrickmm12.ecommercesystem.entities.User;
import com.patrickmm12.ecommercesystem.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired //Spring realiza a injeção de dependência de forma transparente ao programador
    private UserRepository repository;
    
    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User insert(User obj) {
		return repository.save(obj);
	}
}
