package com.example.ecommercesdemoperry.ui.dashboard;

public class Item {
    String name, description, price;
    int imageId;

    public Item(String name, String description, String price, int imageId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageId = imageId;
    }
}
