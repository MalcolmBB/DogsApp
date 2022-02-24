package com.example.dogsapp.model;

public class SmsInfo {
    public String to;
    public String text;
    public String imageUrl;

    public SmsInfo(String to, String text, String imageUrl) {
        this.to = to;
        this.text = text;
        this.imageUrl = imageUrl;
    }
}
