package com.xeagle.android.login.beans;

public class BatteryInfoInDevice {
    private int activated;
    private String activated_at;
    private String create_at;
    private String delete_at;
    private String drone_sn;
    private long flight_mileage;
    private int flight_num;
    private String flight_time;

    /* renamed from: id  reason: collision with root package name */
    private int f23793id;
    private String model;
    private String sn;
    private int status;
    private String uid;
    private String update_at;

    public BatteryInfoInDevice(int i2, String str, String str2, String str3, String str4, int i3, String str5, String str6, int i4, long j2, int i5, String str7, String str8, String str9) {
        this.f23793id = i2;
        this.model = str;
        this.drone_sn = str2;
        this.sn = str3;
        this.uid = str4;
        this.activated = i3;
        this.activated_at = str5;
        this.flight_time = str6;
        this.flight_num = i4;
        this.flight_mileage = j2;
        this.status = i5;
        this.create_at = str7;
        this.update_at = str8;
        this.delete_at = str9;
    }

    public int getActivated() {
        return this.activated;
    }

    public String getActivated_at() {
        return this.activated_at;
    }

    public String getCreate_at() {
        return this.create_at;
    }

    public String getDelete_at() {
        return this.delete_at;
    }

    public String getDrone_sn() {
        return this.drone_sn;
    }

    public long getFlight_mileage() {
        return this.flight_mileage;
    }

    public int getFlight_num() {
        return this.flight_num;
    }

    public String getFlight_time() {
        return this.flight_time;
    }

    public int getId() {
        return this.f23793id;
    }

    public String getModel() {
        return this.model;
    }

    public String getSn() {
        return this.sn;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUpdate_at() {
        return this.update_at;
    }

    public void setActivated(int i2) {
        this.activated = i2;
    }

    public void setActivated_at(String str) {
        this.activated_at = str;
    }

    public void setCreate_at(String str) {
        this.create_at = str;
    }

    public void setDelete_at(String str) {
        this.delete_at = str;
    }

    public void setDrone_sn(String str) {
        this.drone_sn = str;
    }

    public void setFlight_mileage(long j2) {
        this.flight_mileage = j2;
    }

    public void setFlight_num(int i2) {
        this.flight_num = i2;
    }

    public void setFlight_time(String str) {
        this.flight_time = str;
    }

    public void setId(int i2) {
        this.f23793id = i2;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setSn(String str) {
        this.sn = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUpdate_at(String str) {
        this.update_at = str;
    }

    public String toString() {
        return "BatteryInfoInDevice{id=" + this.f23793id + ", model='" + this.model + '\'' + ", drone_sn='" + this.drone_sn + '\'' + ", sn='" + this.sn + '\'' + ", uid='" + this.uid + '\'' + ", activated=" + this.activated + ", activated_at='" + this.activated_at + '\'' + ", flight_time='" + this.flight_time + '\'' + ", flight_num=" + this.flight_num + ", flight_mileage=" + this.flight_mileage + ", status=" + this.status + ", create_at='" + this.create_at + '\'' + ", update_at='" + this.update_at + '\'' + ", delete_at='" + this.delete_at + '\'' + '}';
    }
}
