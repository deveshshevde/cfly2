package com.xeagle.android.bean;

public class GuideSelectBean {
    private int drawableId;
    private String droneType;

    public GuideSelectBean(String str, int i2) {
        this.droneType = str;
        this.drawableId = i2;
    }

    public int getDrawableId() {
        return this.drawableId;
    }

    public String getDroneType() {
        return this.droneType;
    }

    public void setDrawableId(int i2) {
        this.drawableId = i2;
    }

    public void setDroneType(String str) {
        this.droneType = str;
    }
}
