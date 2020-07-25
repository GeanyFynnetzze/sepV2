package com.example.spacestationv2.Database;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "HUM_table")
public class HumidityEntity {

    public HumidityEntity(int HUM_ID, float HUM_value) {
        this.HUM_ID = HUM_ID;
        this.HUM_value = HUM_value;
    }
    @PrimaryKey(autoGenerate = true)
    public int HUM_ID;

    public float HUM_value;

    public String HUM_date;

    public int getHUM_ID() {
        return HUM_ID;
    }

    public float getHUM_value() {
        return HUM_value;
    }

    public String getHUM_date() {
        return HUM_date;
    }
}
