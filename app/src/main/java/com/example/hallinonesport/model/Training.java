package com.example.hallinonesport.model;

public class Training {

    private  int id;
    private String type;
    private String imageIcon;
    private String name;
    private String description;
    private double duration;
    private String image;
    private String video;

    public int getId() {
        return id;
    }

    public Training setId(int id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Training setType(String type) {
        this.type = type;
        return this;
    }

    public String getImageIcon() {
        return imageIcon;
    }

    public Training setImageIcon(String imageIcon) {
        this.imageIcon = imageIcon;
        return this;
    }

    public String getName() {
        return name;
    }

    public Training setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Training setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getDuration() {
        return duration;
    }

    public Training setDuration(double duration) {
        this.duration = duration;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Training setImage(String image) {
        this.image = image;
        return this;
    }

    public String getVideo() {
        return video;
    }

    public Training setVideo(String video) {
        this.video = video;
        return this;
    }

}
