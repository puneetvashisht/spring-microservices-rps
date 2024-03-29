package com.rps.workouttracker.controllers;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rps.workouttracker.entities.WorkoutActive;
import com.rps.workouttracker.exceptions.ResourceNotFoundException;
import com.rps.workouttracker.repositories.WorkoutActiveRepository;

@RestController
@RequestMapping("/api/v1")
public class WorkoutActiveController {
    
    @Autowired
    private WorkoutActiveRepository workoutActiveRepository;
    //create workout active controller with post and patch methods
    //post method to create a new workout active
    @PostMapping("/workoutactive")
    public void startWorkoutActive(@RequestBody WorkoutActive workoutActive) {
        //create a new workout active
        workoutActive.setStartTime(LocalTime.now());
        workoutActiveRepository.save(workoutActive);

    }

    @GetMapping("/workoutactive")
    public List<WorkoutActive> getWorkoutActive() {
        //get all workout actives
        return workoutActiveRepository.findAll();
    }

    @PatchMapping("/workoutactive/{id}")
    public ResponseEntity<Void> endWorkoutActive( @PathVariable("id") int id) {
        //update a workout active
        Optional<WorkoutActive> workoutActiveFound = workoutActiveRepository.findById(id);

        if(workoutActiveFound.isPresent()){
            WorkoutActive workoutActive = workoutActiveFound.get();
            workoutActive.setEndTime(LocalTime.now());
            workoutActiveRepository.save(workoutActive);
            return new ResponseEntity<>(HttpStatus.OK);
            
        }

        else {
            throw new ResourceNotFoundException("Workout Active not found: " + id);
        }


        
    }
    //patch method to update a workout active
}
