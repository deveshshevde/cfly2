package com.xeagle.android.login.database;

import org.litepal.crud.LitePalSupport;

public class ListenerListData extends LitePalSupport {
    private String fid;
    private String fly_total_time;
    private String flying_off;
    private double mileage;
    private String name;
    private float size;

    public ListenerListData() {
    }

    public ListenerListData(String str, String str2, String str3, String str4, double d2, float f2) {
        this.fid = str;
        this.name = str2;
        this.flying_off = str3;
        this.fly_total_time = str4;
        this.mileage = d2;
        this.size = f2;
    }

    public String getFly_total_time() {
        return this.fly_total_time;
    }

    public String getFlying_off() {
        return this.flying_off;
    }

    public String getId() {
        return this.fid;
    }

    public double getMileage() {
        return this.mileage;
    }

    public String getName() {
        return this.name;
    }

    public float getSize() {
        return this.size;
    }

    public void setFly_total_time(String str) {
        this.fly_total_time = str;
    }

    public void setFlying_off(String str) {
        this.flying_off = str;
    }

    public void setId(String str) {
        this.fid = str;
    }

    public void setMileage(double d2) {
        this.mileage = d2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSize(float f2) {
        this.size = f2;
    }

    public String toString() {
        return "ListenerListData{id=" + this.fid + ", name='" + this.name + '\'' + ", flying_off='" + this.flying_off + '\'' + ", fly_total_time='" + this.fly_total_time + '\'' + ", mileage=" + this.mileage + ", size=" + this.size + '}';
    }
}
