package com.example.gamedanhbai.model;

public class Card {
    private int id;
    private String name;
    private int score;
    private int image;

    public Card() {
    }

    public Card(int id, String name, int score, int image) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}