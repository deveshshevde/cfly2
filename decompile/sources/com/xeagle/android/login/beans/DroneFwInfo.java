package com.xeagle.android.login.beans;

import java.util.ArrayList;

public class DroneFwInfo {
    private ArrayList<DroneFwBeans> drone_firmware;

    public DroneFwInfo() {
    }

    public DroneFwInfo(ArrayList<DroneFwBeans> arrayList) {
        this.drone_firmware = arrayList;
    }

    public ArrayList<DroneFwBeans> getDrone_firmware() {
        return this.drone_firmware;
    }

    public void setDrone_firmware(ArrayList<DroneFwBeans> arrayList) {
        this.drone_firmware = arrayList;
    }

    public String toString() {
        ArrayList<DroneFwBeans> arrayList = this.drone_firmware;
        if (arrayList == null || arrayList.size() <= 0) {
            return "drone firmware is null";
        }
        return "DroneFwInfo{drone_firmware=" + this.drone_firmware.toString() + '}';
    }
}
