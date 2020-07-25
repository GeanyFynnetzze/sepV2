package com.example.spacestationv2.Database;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TEMP_table")
public class TemperatureEntity {
    public TemperatureEntity(int TEMP_ID, float TEMP_value, String TEMP_date) {
        this.TEMP_ID = TEMP_ID;
        this.TEMP_value = TEMP_value;
        this.TEMP_date= TEMP_date;
    }
    @PrimaryKey(autoGenerate = true)
    public int TEMP_ID;

    public float TEMP_value;

    public String TEMP_date;

    public int getTEMP_ID() {
        return TEMP_ID;
    }

    public float getTEMP_value() {
        return TEMP_value;
    }

    public String getTEMP_date() {
        return TEMP_date;
    }
}
