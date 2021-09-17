package com.example.hallinonesport.model;

public class Training {

    private String image;
    private String name;
    private String description;
    private float duration;

    public Training(String image, String name, String description, float duration) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}
