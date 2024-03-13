package com.rps.workoutactiveservice.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rps.workoutactiveservice.dto.Workout;

@FeignClient(name="workout-service")
//@FeignClient(name="test", url = "http://localhost:8080")
public interface WorkoutServiceProxy {

	@GetMapping("/api/v1/workouts/{id}")
	public Workout fetchWorkout(@PathVariable("id") int id);
}
