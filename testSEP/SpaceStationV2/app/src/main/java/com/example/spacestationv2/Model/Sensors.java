package com.example.spacestationv2.Model;

import java.util.ArrayList;

public class Sensors {

        private int sensorID;
        private ArrayList<AllStats> data;
        private String servosetting;

    public Sensors(int sensorID, ArrayList<AllStats> data, String servosetting) {
        this.sensorID = sensorID;
        this.data = data;
        this.servosetting = servosetting;
    }

    public int getSensorID() {
        return sensorID;
    }

    public ArrayList<AllStats> getData() {
        return data;
    }

    public String getServosetting() {
        return servosetting;
    }
}
