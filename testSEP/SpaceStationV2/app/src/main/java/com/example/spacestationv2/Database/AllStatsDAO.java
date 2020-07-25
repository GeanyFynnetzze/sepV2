package com.example.spacestationv2.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface AllStatsDAO {

    @Insert
    void insert(AllStatsEntity allStatsEntity);

    @Query("SELECT * FROM AllStats_table")
    LiveData<List<AllStatsEntity>> getAllStats();
}
