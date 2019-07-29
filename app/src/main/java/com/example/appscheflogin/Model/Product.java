package com.example.appscheflogin.Model;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private String image;
    @SerializedName("image_thumb")
    private String image_thumb;

    public Product() {
    }

    public Product(String id, String name, String image, String image_thumb) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.image_thumb = image_thumb;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getImage_thumb() {
        return image_thumb;
    }
}
