package com.example.spacestationv2.Model;

import java.util.ArrayList;

public class Rooms {
    private int roomID;
    private String name;
    private ArrayList<Sensors> sensors;

    public Rooms(int roomID, String name, ArrayList<Sensors> sensors) {
        this.roomID = roomID;
        this.name = name;
        this.sensors = sensors;
    }

    public int getRoomID() {
        return roomID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Sensors> getSensors() {
        return sensors;
    }
}
