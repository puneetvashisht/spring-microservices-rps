package com.rps.workouttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rps.workouttracker.entities.WorkoutActive;

public interface WorkoutActiveRepository extends JpaRepository<WorkoutActive, Integer>{
    
}
