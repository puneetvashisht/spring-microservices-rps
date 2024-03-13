package com.rps.workoutservice.controllers;

// create workout controller with get, post, put, delete methods using WorkoutRepository
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rps.workoutservice.entities.Category;
import com.rps.workoutservice.entities.Workout;
import com.rps.workoutservice.exceptions.ResourceNotFoundException;
import com.rps.workoutservice.repositories.CategoryRepository;
import com.rps.workoutservice.repositories.WorkoutRepository;


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

    @GetMapping("/workouts/title/{title}")
    public List<Workout> getWorkoutsByTitle(@PathVariable String title) {
        // return workouts by title or throw exception if not found
        List<Workout> workouts = workoutRepository.findByTitle(title);
        if(workouts.isEmpty()){
            throw new ResourceNotFoundException("Workout not found");
        }
        else{
            return workouts;
        }
    }

    @GetMapping("/workouts/cbpm/{cbpm}")
    public List<Workout> getWorkoutsByCbpm(@PathVariable int cbpm) {
        // return workouts by cbpm or throw exception if not found
        List<Workout> workouts = workoutRepository.findWorkoutGreaterThanCbpm(cbpm);
        if(workouts.isEmpty()){
            throw new ResourceNotFoundException("Workout not found");
        }
        else{
            return workouts;
        }
    }

    @GetMapping("/workouts/category/{id}")
    public List<Workout> getWorkoutsByCategory(@PathVariable int id) {
        // return workouts by category id or throw exception if not found
        Optional<Category> categoryFound = categoryRepository.findById(id);
        if(categoryFound.isEmpty()){
            throw new ResourceNotFoundException("Category not found");
        }
        else{
            return workoutRepository.findByCategory(categoryFound.get());
        }
    }


    @GetMapping("/workouts/{id}")
    public Workout getWorkout(@PathVariable int id) {
        // return workout by id or throw exception if not found
        Optional<Workout> workoutFound =  workoutRepository.findById(id);
        if(workoutFound.isEmpty()){
            throw new ResourceNotFoundException("Workout not found");
        }
        else{
            return workoutFound.get();
        }
        // return workoutRepository.findById(id).orElseThrow(()->new RuntimeException("Workout not found"));
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

