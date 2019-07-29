package com.example.appscheflogin.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetProduct {
    @SerializedName("status")
    String status;
    @SerializedName("data")
    List<Product> productList;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getMessage() {
        return message;
    }
}
