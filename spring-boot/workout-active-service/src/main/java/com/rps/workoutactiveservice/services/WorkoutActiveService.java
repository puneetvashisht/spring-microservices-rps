package com.rps.workoutactiveservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.rps.workoutactiveservice.controllers.WorkoutServiceProxy;
import com.rps.workoutactiveservice.dto.Workout;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

@Service
public class WorkoutActiveService {
	@Autowired
    WorkoutServiceProxy workoutServiceProxy;

	@Autowired
	CircuitBreakerFactory circuitBreakerFactory;

	private CircuitBreaker circuitBreaker = CircuitBreaker.of("workoutService", 
			CircuitBreakerConfig.custom()
			.failureRateThreshold(50)
			.waitDurationInOpenState(java.time.Duration.ofMillis(1000))
			.slidingWindowSize(2)
			.build());

	
	@io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "workoutService", fallbackMethod = "defaultWorkout")
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
	
	public Workout defaultWorkout(int workoutId, Exception e) {
		System.out.println("Fallback method called***********	");
        return new Workout(1, "Running", "Good for health");
    }
}
