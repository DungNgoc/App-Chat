package com.example.dungngoc.appchat.model;

import java.io.Serializable;

public class Course implements Serializable {
    private String title;
    private String description;
    private int image;
    public Course(String title, String description, int image){
        this.title = title;
        this.description = description;
        this.image=image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}
