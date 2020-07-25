package com.example.spacestationv2.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface HumidityDAO {

    @Insert
    void insert(HumidityEntity humidityEntity);

    @Query("SELECT * FROM HUM_table")
    LiveData<List<HumidityEntity>> getAllHUM();
}
