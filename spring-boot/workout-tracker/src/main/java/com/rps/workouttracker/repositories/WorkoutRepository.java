package com.rps.workouttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rps.workouttracker.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer>{
    
}
