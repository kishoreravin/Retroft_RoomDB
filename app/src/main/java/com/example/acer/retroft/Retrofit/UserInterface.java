package com.example.acer.retroft.Retrofit;

import com.example.acer.retroft.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserInterface {

    @GET("/login")
    public Call<List<User>> getAllUsers();

    @POST("/newuser")
    Call<List<User>> addNewUser(@Body User body);
}
