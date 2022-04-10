package com.patrickmm12.ecommercesystem.repositories;

import com.patrickmm12.ecommercesystem.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Opcional devido a essa classe já extender um JPA repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
