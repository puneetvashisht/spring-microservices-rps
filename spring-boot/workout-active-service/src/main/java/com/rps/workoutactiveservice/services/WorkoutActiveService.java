package com.rps.workoutactiveservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.rps.workoutactiveservice.controllers.WorkoutServiceProxy;
import com.rps.workoutactiveservice.dto.Workout;

@Service
public class WorkoutActiveService {
	@Autowired
    WorkoutServiceProxy workoutServiceProxy;
	
	@HystrixCommand(fallbackMethod = "defaultWorkout")
	public Workout fetchWorkout(int workoutId) throws Exception {
		try {
			Workout workout = workoutServiceProxy.fetchWorkout(workoutId);
			if(workout==null) {
				throw new RuntimeException("workout not found!");
			}
			return workout;
		}
		catch(Exception e) {
			System.out.println("Exception ***********");
			throw new RuntimeException("workout not found!");
		}
		
	}
	
	public Object defaultWorkout() {
        return new Workout(1, "Running", "Good for health");
    }
}
