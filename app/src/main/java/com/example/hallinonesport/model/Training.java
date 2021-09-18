package com.example.hallinonesport.model;

public class Training {

    private String type;
    private String imageIcon;
    private String name;
    private String description;
    private float duration;
    private String image;
    private String video;

    public Training(String type, String imageIcon, String name, String description, float duration, String image, String video) {
        this.type = type;
        this.imageIcon = imageIcon;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.image = image;
        this.video = video;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(String imageIcon) {
        this.imageIcon = imageIcon;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

}
