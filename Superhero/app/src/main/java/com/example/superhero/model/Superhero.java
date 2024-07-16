package com.example.superhero.model;

public class Superhero {
    int imgId;
    String name;
    String description;

    public Superhero(int imgId, String name, String description) {
        this.imgId = imgId;
        this.name = name;
        this.description = description;
    }

    public int getImgId() {
        return imgId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
