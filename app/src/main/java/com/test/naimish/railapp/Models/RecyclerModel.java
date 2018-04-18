package com.test.naimish.railapp.Models;

public class RecyclerModel {
    private String title;
    private int imageUrl;

    public RecyclerModel(String title, int imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public int getImageUrl() {
        return this.imageUrl;
    }
}
