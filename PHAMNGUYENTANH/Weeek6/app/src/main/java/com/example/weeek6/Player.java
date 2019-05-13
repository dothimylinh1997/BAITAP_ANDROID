package com.example.weeek6;

public class Player {
    private int Img;
    private String Name;
    private String Club;
    private String Number;

    public Player(int img, String name, String club, String number) {
        Img = img;
        Name = name;
        Club = club;
        Number = number;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getClub() {
        return Club;
    }

    public void setClub(String club) {
        Club = club;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}

