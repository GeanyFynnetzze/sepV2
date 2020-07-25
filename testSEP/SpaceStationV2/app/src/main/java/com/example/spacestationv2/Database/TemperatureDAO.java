package com.example.spacestationv2.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TemperatureDAO {

    @Insert
    void insert(TemperatureEntity temperatureEntity);

    @Query("SELECT * FROM TEMP_table")
    LiveData<List<TemperatureEntity>> getAllTEMP();
}
