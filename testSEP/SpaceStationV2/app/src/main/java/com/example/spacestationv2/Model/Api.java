package com.example.spacestationv2.Model;



import com.example.spacestationv2.Database.AllStatsEntity;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {


    @GET("Rooms/1")
    Call<Rooms> getLivingRoom();
    @GET("Rooms/2")
    Call<Rooms> getToilet();
    @GET("Rooms/3")
    Call<Rooms> getKitchen();

    @POST("data/SetServo")
    Call<Servo> createPost(
            @Query("room") String room,
            @Query("servo") String servo
    );
}