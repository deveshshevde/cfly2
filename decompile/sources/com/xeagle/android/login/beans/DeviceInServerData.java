package com.xeagle.android.login.beans;

import java.util.ArrayList;

public class DeviceInServerData {
    private ArrayList<BatteryInfoInDevice> battery;
    private ArrayList<DroneInfoInDevice> drone;

    public DeviceInServerData(ArrayList<DroneInfoInDevice> arrayList, ArrayList<BatteryInfoInDevice> arrayList2) {
        this.drone = arrayList;
        this.battery = arrayList2;
    }

    public ArrayList<BatteryInfoInDevice> getBattery() {
        return this.battery;
    }

    public ArrayList<DroneInfoInDevice> getDrone() {
        return this.drone;
    }

    public void setBattery(ArrayList<BatteryInfoInDevice> arrayList) {
        this.battery = arrayList;
    }

    public void setDrone(ArrayList<DroneInfoInDevice> arrayList) {
        this.drone = arrayList;
    }

    public String toString() {
        return "DeviceInServerData{drone=" + this.drone.toString() + ", battery=" + this.battery.toString() + '}';
    }
}
