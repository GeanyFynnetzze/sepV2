package com.example.spacestationv2.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AllStats_table")
public class AllStatsEntity {
    @PrimaryKey(autoGenerate = true)
    public int huM_ID;
    public int cO2_ID;
    public int temP_ID;
    public String date;
    public float huM_value;
    public float cO2_value;
    public float temP_value;

    public AllStatsEntity(int huM_ID, int cO2_ID, int temP_ID, String date, float huM_value, float cO2_value, float temP_value) {
        this.huM_ID = huM_ID;
        this.cO2_ID = cO2_ID;
        this.temP_ID = temP_ID;
        this.date = date;
        this.huM_value = huM_value;
        this.cO2_value = cO2_value;
        this.temP_value = temP_value;
    }

    public int getHuM_ID() {
        return huM_ID;
    }

    public int getcO2_ID() {
        return cO2_ID;
    }

    public int getTemP_ID() {
        return temP_ID;
    }

    public String getDate1() {
        return date;
    }

    public float getHuM_value() {
        return huM_value;
    }

    public float getCO2_value() {
        return cO2_value;
    }

    public float getTemP_value() {
        return temP_value;
    }
}
