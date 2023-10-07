package com.xeagle.android.login.beans;

public class DroneInServerData {
    private int activated;
    private String activated_at;
    private long flight_mileage;
    private int flight_number;
    private String flight_time;

    /* renamed from: id  reason: collision with root package name */
    private int f23794id;
    private int insured;
    private String insured_valid_at;
    private int is_locked;
    private String model;
    private String sn;
    private String uid;

    public DroneInServerData(int i2, String str, String str2, String str3, int i3, int i4, String str4, int i5, String str5, String str6, long j2, int i6) {
        this.f23794id = i2;
        this.model = str;
        this.sn = str2;
        this.uid = str3;
        this.is_locked = i3;
        this.activated = i4;
        this.activated_at = str4;
        this.insured = i5;
        this.insured_valid_at = str5;
        this.flight_time = str6;
        this.flight_mileage = j2;
        this.flight_number = i6;
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

    public int getFlight_num() {
        return this.flight_number;
    }

    public String getFlight_time() {
        return this.flight_time;
    }

    public int getId() {
        return this.f23794id;
    }

    public int getInsured() {
        return this.insured;
    }

    public String getInsured_valid_at() {
        return this.insured_valid_at;
    }

    public int getIs_locked() {
        return this.is_locked;
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

    public void setFlight_num(int i2) {
        this.flight_number = i2;
    }

    public void setFlight_time(String str) {
        this.flight_time = str;
    }

    public void setId(int i2) {
        this.f23794id = i2;
    }

    public void setInsured(int i2) {
        this.insured = i2;
    }

    public void setInsured_valid_at(String str) {
        this.insured_valid_at = str;
    }

    public void setIs_locked(int i2) {
        this.is_locked = i2;
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
        return "DroneInServerData{id=" + this.f23794id + ", model='" + this.model + '\'' + ", sn='" + this.sn + '\'' + ", uid='" + this.uid + '\'' + ", is_locked=" + this.is_locked + ", activated=" + this.activated + ", activated_at=" + this.activated_at + ", insured=" + this.insured + ", insured_valid_at='" + this.insured_valid_at + '\'' + ", flight_time='" + this.flight_time + '\'' + ", flight_mileage=" + this.flight_mileage + ", flight_num=" + this.flight_number + '}';
    }
}
