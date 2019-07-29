package com.example.appscheflogin.Rest;

import com.example.appscheflogin.Model.GetProduct;
import com.example.appscheflogin.Model.GetProfile;
import com.example.appscheflogin.Model.Profile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("products?")
    Call<GetProduct> getProduct(@Query("page") String page, @Query("page") String page2 ,@Query("page") String page3);

    @GET("profile")
    Call<GetProfile> getProfile();
}
