package com.rps.workoutactiveservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rps.workoutactiveservice.entities.WorkoutActive;

public interface WorkoutActiveRepository extends JpaRepository<WorkoutActive, Integer>{
    
}
