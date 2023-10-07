package com.xeagle.android.login.beans;

public class DroneActivationInServerData {
    private int activated;
    private String activated_at;
    private int insured;
    private String insured_valid_at;
    private int isLock;
    private String sn;
    private String uid;

    public DroneActivationInServerData(String str, String str2, int i2, int i3, String str3, int i4, String str4) {
        this.sn = str;
        this.uid = str2;
        this.isLock = i2;
        this.activated = i3;
        this.activated_at = str3;
        this.insured = i4;
        this.insured_valid_at = str4;
    }

    public int getActivated() {
        return this.activated;
    }

    public String getActivated_at() {
        return this.activated_at;
    }

    public int getInsured() {
        return this.insured;
    }

    public String getInsured_valid_at() {
        return this.insured_valid_at;
    }

    public int getIsLock() {
        return this.isLock;
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

    public void setInsured(int i2) {
        this.insured = i2;
    }

    public void setInsured_valid_at(String str) {
        this.insured_valid_at = str;
    }

    public void setIsLock(int i2) {
        this.isLock = i2;
    }

    public void setSn(String str) {
        this.sn = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "DroneActivationInServerData{sn='" + this.sn + '\'' + ", uid='" + this.uid + '\'' + ", isLock=" + this.isLock + ", activated=" + this.activated + ", activated_at='" + this.activated_at + '\'' + ", insured=" + this.insured + ", insured_valid_at='" + this.insured_valid_at + '\'' + '}';
    }
}
