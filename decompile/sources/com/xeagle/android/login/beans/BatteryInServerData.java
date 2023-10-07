package com.xeagle.android.login.beans;

public class BatteryInServerData {
    private int activated;
    private String activated_at;
    private long flight_mileage;
    private int flight_number;
    private String flight_time;
    private String model;
    private String sn;
    private String uid;

    public BatteryInServerData(String str, String str2, String str3, int i2, String str4, String str5, long j2, int i3) {
        this.model = str;
        this.sn = str2;
        this.uid = str3;
        this.activated = i2;
        this.activated_at = str4;
        this.flight_time = str5;
        this.flight_mileage = j2;
        this.flight_number = i3;
    }

    public int getActivated() {
        return this.activated;
    }

    public String getActivated_at() {
        return this.activated_at;
    }

    public long getFlight_mileage() {
        return this.flight_mileage;
    }

    public int getFlight_number() {
        return this.flight_number;
    }

    public String getFlight_time() {
        return this.flight_time;
    }

    public String getModel() {
        return this.model;
    }

    public String getSn() {
        return this.sn;
    }

    public String getUid() {
        return this.uid;
    }

    public void setActivated(int i2) {
        this.activated = i2;
    }

    public void setActivated_at(String str) {
        this.activated_at = str;
    }

    public void setFlight_mileage(long j2) {
        this.flight_mileage = j2;
    }

    public void setFlight_number(int i2) {
        this.flight_number = i2;
    }

    public void setFlight_time(String str) {
        this.flight_time = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setSn(String str) {
        this.sn = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "BatteryInServerData{model='" + this.model + '\'' + ", sn='" + this.sn + '\'' + ", uid='" + this.uid + '\'' + ", activated=" + this.activated + ", activated_at='" + this.activated_at + '\'' + ", flight_time='" + this.flight_time + '\'' + ", flight_mileage=" + this.flight_mileage + ", flight_number=" + this.flight_number + '}';
    }
}
