package com.xeagle.android.helpers;

public class ListenerInfo {
    private String appVersion;
    private String deviceBrand;
    private String droneId;
    private String droneType;
    private String droneVersion;
    private String imageVersion;
    private String rcVersion;
    private String repeatVersion;
    private String systemLanguage;
    private String systemModel;
    private String systemVersion;

    public ListenerInfo() {
    }

    public ListenerInfo(String str, String str2, String str3, String str4, String str5) {
        this.droneId = "-";
        this.appVersion = str;
        this.systemModel = str2;
        this.deviceBrand = str3;
        this.systemVersion = str4;
        this.systemLanguage = str5;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getDeviceBrand() {
        return this.deviceBrand;
    }

    public String getDroneId() {
        return this.droneId;
    }

    public String getDroneType() {
        return this.droneType;
    }

    public String getDroneVersion() {
        return this.droneVersion;
    }

    public String getImageVersion() {
        return this.imageVersion;
    }

    public String getRcVersion() {
        return this.rcVersion;
    }

    public String getRepeatVersion() {
        return this.repeatVersion;
    }

    public String getSystemLanguage() {
        return this.systemLanguage;
    }

    public String getSystemModel() {
        return this.systemModel;
    }

    public String getSystemVersion() {
        return this.systemVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setDeviceBrand(String str) {
        this.deviceBrand = str;
    }

    public void setDroneId(String str) {
        this.droneId = str;
    }

    public void setDroneType(String str) {
        this.droneType = str;
    }

    public void setDroneVersion(String str) {
        this.droneVersion = str;
    }

    public void setImageVersion(String str) {
        this.imageVersion = str;
    }

    public void setRcVersion(String str) {
        this.rcVersion = str;
    }

    public void setRepeatVersion(String str) {
        this.repeatVersion = str;
    }

    public void setSystemLanguage(String str) {
        this.systemLanguage = str;
    }

    public void setSystemModel(String str) {
        this.systemModel = str;
    }

    public void setSystemVersion(String str) {
        this.systemVersion = str;
    }

    public String toString() {
        return "ListenerInfo{droneId='" + this.droneId + '\'' + ", droneType='" + this.droneType + '\'' + ", appVersion='" + this.appVersion + '\'' + ", droneVersion='" + this.droneVersion + '\'' + ", imageVersion='" + this.imageVersion + '\'' + ", rcVersion='" + this.rcVersion + '\'' + ", repeatVersion='" + this.repeatVersion + '\'' + ", systemModel='" + this.systemModel + '\'' + ", deviceBrand='" + this.deviceBrand + '\'' + ", systemVersion='" + this.systemVersion + '\'' + ", systemLanguage='" + this.systemLanguage + '\'' + '}';
    }
}
