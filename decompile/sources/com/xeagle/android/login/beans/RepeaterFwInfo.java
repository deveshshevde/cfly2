package com.xeagle.android.login.beans;

import java.util.ArrayList;

public class RepeaterFwInfo {
    private ArrayList<RepeaterFwBeans> repeater_firmware;

    public RepeaterFwInfo(ArrayList<RepeaterFwBeans> arrayList) {
        this.repeater_firmware = arrayList;
    }

    public ArrayList<RepeaterFwBeans> getRepeater_firmware() {
        return this.repeater_firmware;
    }

    public void setRepeater_firmware(ArrayList<RepeaterFwBeans> arrayList) {
        this.repeater_firmware = arrayList;
    }

    public String toString() {
        return "RepeaterFwInfo{repeater_firmware=" + this.repeater_firmware.toString() + '}';
    }
}
