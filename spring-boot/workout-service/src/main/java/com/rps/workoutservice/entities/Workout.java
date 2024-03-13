package com.rps.workoutservice.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// create workout entity with id, title, description
@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    private String title;
    private String description;
    private int cbpm;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Category category;

    

    public Workout() {
    }

    public Workout(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCbpm() {
        return cbpm;
    }

    public void setCbpm(int cbpm) {
        this.cbpm = cbpm;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

