package com.patrickmm12.ecommercesystem.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.patrickmm12.ecommercesystem.entities.User;
import com.patrickmm12.ecommercesystem.repositories.UserRepository;
import com.patrickmm12.ecommercesystem.services.exceptions.DatabaseException;
import com.patrickmm12.ecommercesystem.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } 
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } 
        catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
    }

    public User update(Long id, User obj) {
		try {
			User entity = repository.getById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} 
        catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
