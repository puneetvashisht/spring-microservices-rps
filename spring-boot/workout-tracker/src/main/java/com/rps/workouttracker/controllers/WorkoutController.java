package com.rps.workouttracker.controllers;

// create workout controller with get, post, put, delete methods using WorkoutRepository
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rps.workouttracker.entities.Workout;
import com.rps.workouttracker.repositories.WorkoutRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1")
public class WorkoutController {
    @Autowired
    private WorkoutRepository workoutRepository;

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

