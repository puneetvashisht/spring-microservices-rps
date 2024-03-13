package com.rps.workoutservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rps.workoutservice.entities.Category;
import com.rps.workoutservice.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer>{


    @Query("SELECT w FROM Workout w WHERE w.cbpm > :cbpm")
    List<Workout> findWorkoutGreaterThanCbpm(Integer cbpm);

    List<Workout> findByCategory(Category category);
    List<Workout> findByTitle(String title);
    
}
