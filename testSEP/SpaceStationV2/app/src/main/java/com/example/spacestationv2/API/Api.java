package com.example.spacestationv2.API;

import com.example.spacestationv2.Model.Rooms;
import com.example.spacestationv2.Model.Servo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {


    @GET("Rooms/4")
    Call<Rooms> getLivingRoom();
    @GET("Rooms/2")
    Call<Rooms> getToilet();
    @GET("Rooms/1")
    Call<Rooms> getKitchen();

    @POST("data/SetServo")
    Call<Servo> createPost(
            @Query("room") String room,
            @Query("servo") String servo
    );
}