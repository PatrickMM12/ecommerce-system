package com.patrickmm12.ecommercesystem.repositories;

import com.patrickmm12.ecommercesystem.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
