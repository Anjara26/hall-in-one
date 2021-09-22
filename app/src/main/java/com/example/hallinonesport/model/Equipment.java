package com.example.hallinonesport.model;

public class Equipment {

    private int id;
    private String image;
    private String name;
    private boolean isSelected = false;

    public int getId() {
        return id;
    }

    public Equipment setId(int id) {
        this.id = id;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Equipment setImage(String image) {
        this.image = image;
        return this;
    }

    public String getname() {
        return name;
    }

    public Equipment setname(String name) {
        this.name = name;
        return this;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public Equipment setSelected(boolean selected) {
        isSelected = selected;
        return this;
    }

    public Equipment setSelected(int selected) {
        isSelected = selected == 1 ;
        return this;
    }
}
