package com.example.demo;

public class NewBookRequest {

    private String title;

    public NewBookRequest() {
    }

    public NewBookRequest(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
