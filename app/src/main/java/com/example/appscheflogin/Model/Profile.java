package com.example.appscheflogin.Model;

import com.google.gson.annotations.SerializedName;

public class Profile {
    @SerializedName("comment")
    private String comment;
    @SerializedName("email")
    private String email;
    @SerializedName("birthdate")
    private String birthdate;
    @SerializedName("gender")
    private String gender;
    @SerializedName("height")
    private String height;
    @SerializedName("weight")
    private String weight;

    public Profile() {
    }

    public Profile(String comment, String email, String birthdate, String gender, String height, String weight) {
        this.comment = comment;
        this.email = email;
        this.birthdate = birthdate;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public String getComment() {
        return comment;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getGender() {
        return gender;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }
}
