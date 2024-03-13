package com.rps.workoutactiveservice.entities;

import java.time.LocalTime;

import com.rps.workoutactiveservice.dto.Workout;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class WorkoutActive {
    //create workout entity with id, username, startTime, endTime, workout mapping
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    private String username;
    private LocalTime startTime;
    private LocalTime endTime;
    int workoutId;
    
    @Transient
    private Workout workout;
    


    public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public int getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }


    

}
