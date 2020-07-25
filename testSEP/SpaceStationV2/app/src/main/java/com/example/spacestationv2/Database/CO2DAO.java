package com.example.spacestationv2.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface CO2DAO {


    @Insert
    void insert(CO2Entity co2Entity);

    @Query("SELECT * FROM CO2_table")
    LiveData<List<CO2Entity>> getAllCO2();
}
