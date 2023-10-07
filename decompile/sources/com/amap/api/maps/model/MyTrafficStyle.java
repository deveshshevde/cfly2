package com.amap.api.maps.model;

public class MyTrafficStyle {
    private int congestedColor = -1441006;
    private float ratio = 0.8f;
    private int seriousCongestedColor = -7208950;
    private int slowColor = -35576;
    private int smoothColor = -16735735;
    private int trafficRoadBackgroundColor = -1;

    public int getCongestedColor() {
        return this.congestedColor;
    }

    public float getRatio() {
        return this.ratio;
    }

    public int getSeriousCongestedColor() {
        return this.seriousCongestedColor;
    }

    public int getSlowColor() {
        return this.slowColor;
    }

    public int getSmoothColor() {
        return this.smoothColor;
    }

    public int getTrafficRoadBackgroundColor() {
        return this.trafficRoadBackgroundColor;
    }

    public void setCongestedColor(int i2) {
        this.congestedColor = i2;
    }

    public void setRatio(float f2) {
        this.ratio = f2;
    }

    public void setSeriousCongestedColor(int i2) {
        this.seriousCongestedColor = i2;
    }

    public void setSlowColor(int i2) {
        this.slowColor = i2;
    }

    public void setSmoothColor(int i2) {
        this.smoothColor = i2;
    }

    public void setTrafficRoadBackgroundColor(int i2) {
        this.trafficRoadBackgroundColor = i2;
    }
}
