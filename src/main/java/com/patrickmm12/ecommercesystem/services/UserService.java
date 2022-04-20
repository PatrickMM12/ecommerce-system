package com.patrickmm12.ecommercesystem.services;

import java.util.List;
import java.util.Optional;

import com.patrickmm12.ecommercesystem.entities.User;
import com.patrickmm12.ecommercesystem.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired // Spring realiza a injeção de dependência de forma transparente ao programador
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User obj) {
        User entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
