package com.example.myapplication;

public class Exercise {

    private int id;
    private String time;
    private String comment;
    private byte[] image;

    public Exercise(int id, String time, String comment, byte[] image) {
        this.id = id;
        this.time = time;
        this.comment = comment;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
