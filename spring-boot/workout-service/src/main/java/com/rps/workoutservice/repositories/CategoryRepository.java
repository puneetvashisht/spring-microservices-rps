package com.rps.workoutservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rps.workoutservice.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}
