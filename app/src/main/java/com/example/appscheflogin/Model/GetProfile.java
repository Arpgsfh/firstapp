package com.example.appscheflogin.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetProfile {
    @SerializedName("profile_data")
    Profile profile;

    public GetProfile(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }
}
