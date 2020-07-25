package com.example.spacestationv2.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CO2_table")
public class CO2Entity {



    @PrimaryKey(autoGenerate = true)
        private int CO2_ID;

        private float CO2_value;

        private String CO2_date;

    public CO2Entity(int CO2_ID, float CO2_value, String CO2_date) {
        this.CO2_ID = CO2_ID;
        this.CO2_value = CO2_value;
        this.CO2_date = CO2_date;
    }


        public int getCO2_ID() {
            return CO2_ID;
        }


    public float getCO2_value() {
        return CO2_value;
    }

    public String getCO2_date() {
            return CO2_date;
        }
    }

