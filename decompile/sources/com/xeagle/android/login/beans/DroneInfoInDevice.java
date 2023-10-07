package com.xeagle.android.login.beans;

public class DroneInfoInDevice {
    private int activated;
    private String activated_at;
    private String create_at;
    private String delete_at;
    private long flight_mileage;
    private int flight_num;
    private String flight_time;

    /* renamed from: id  reason: collision with root package name */
    private int f23795id;
    private String insurable_stop_time;
    private int insured;
    private String insured_valid_at;
    private int is_locked;
    private String model;
    private String sn;
    private int status;
    private String uid;
    private String update_at;

    public DroneInfoInDevice(int i2, String str, String str2, String str3, int i3, String str4, String str5, int i4, String str6, int i5, String str7, int i6, long j2, int i7, String str8, String str9, String str10) {
        this.f23795id = i2;
        this.model = str;
        this.sn = str2;
        this.uid = str3;
        this.activated = i3;
        this.activated_at = str4;
        this.insurable_stop_time = str5;
        this.insured = i4;
        this.insured_valid_at = str6;
        this.is_locked = i5;
        this.flight_time = str7;
        this.flight_num = i6;
        this.flight_mileage = j2;
        this.status = i7;
        this.create_at = str8;
        this.update_at = str9;
        this.delete_at = str10;
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
        return this.f23795id;
    }

    public String getInsurable_stop_time() {
        return this.insurable_stop_time;
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
        this.f23795id = i2;
    }

    public void setInsurable_stop_time(String str) {
        this.insurable_stop_time = str;
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
        return "DroneInfoInDevice{id=" + this.f23795id + ", model='" + this.model + '\'' + ", sn='" + this.sn + '\'' + ", uid='" + this.uid + '\'' + ", activated=" + this.activated + ", activated_at='" + this.activated_at + '\'' + ",insurable_stop_time=" + this.insurable_stop_time + '\'' + ", insured=" + this.insured + ", insured_valid_at='" + this.insured_valid_at + '\'' + ", is_locked=" + this.is_locked + ", flight_time='" + this.flight_time + '\'' + ", flight_num=" + this.flight_num + ", flight_mileage=" + this.flight_mileage + ", status=" + this.status + ", create_at='" + this.create_at + '\'' + ", update_at='" + this.update_at + '\'' + ", delete_at='" + this.delete_at + '\'' + '}';
    }
}
