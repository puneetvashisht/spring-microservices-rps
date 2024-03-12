package com.rps.workouttracker.controllers;

// create workout controller with get, post, put, delete methods using WorkoutRepository
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rps.workouttracker.entities.Category;
import com.rps.workouttracker.entities.Workout;
import com.rps.workouttracker.repositories.CategoryRepository;
import com.rps.workouttracker.repositories.WorkoutRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1")
public class WorkoutController {
    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/workouts")
    public List<Workout> getWorkouts() {
        return workoutRepository.findAll();
    }

    @GetMapping("/workouts/{id}")
    public Workout getWorkout(@PathVariable int id) {
        return workoutRepository.findById(id).orElse(null);
    }

    @PostMapping("/workouts")
    public Workout addWorkout(@RequestBody Workout workout) {

        //  if category id is greater than 0, find category by id and set category
        if(workout.getCategory().getId() > 0){
            Optional<Category> categoryFound = categoryRepository.findById(workout.getCategory().getId());
            if(categoryFound.isPresent()){
                Category category = categoryFound.get();
                System.out.println("Category found: " + category.getTitle());
                workout.setCategory(category);
            }
        }

        return workoutRepository.save(workout);
    }

    @PutMapping("/workouts")
    public Workout updateWorkout(@RequestBody Workout workout) {

        
        return workoutRepository.save(workout);
    }

    @DeleteMapping("/workouts/{id}")
    public void deleteWorkout(@PathVariable int id) {
        workoutRepository.deleteById(id);
    }
}

