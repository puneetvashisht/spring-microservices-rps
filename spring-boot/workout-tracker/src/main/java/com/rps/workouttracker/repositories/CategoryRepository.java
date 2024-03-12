package com.rps.workouttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rps.workouttracker.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}
