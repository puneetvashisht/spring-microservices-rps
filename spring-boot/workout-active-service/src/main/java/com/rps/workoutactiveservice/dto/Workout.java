package com.rps.workoutactiveservice.dto;

public class Workout {

    private int id;
    private String title;
    private String description;
    private int cbpm;
    private String port;
    private Category category;

    

    public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

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

