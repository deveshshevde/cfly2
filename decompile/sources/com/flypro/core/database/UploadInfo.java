package com.flypro.core.database;

public class UploadInfo {
    private String fileName;
    private String fly_total_time;
    private String flying_off;
    private String mileage;

    public UploadInfo() {
    }

    public UploadInfo(String str, String str2, String str3, String str4) {
        this.flying_off = str;
        this.fly_total_time = str2;
        this.mileage = str3;
        this.fileName = str4;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFly_total_time() {
        return this.fly_total_time;
    }

    public String getFlying_off() {
        return this.flying_off;
    }

    public String getMileage() {
        return this.mileage;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFly_total_time(String str) {
        this.fly_total_time = str;
    }

    public void setFlying_off(String str) {
        this.flying_off = str;
    }

    public void setMileage(String str) {
        this.mileage = str;
    }

    public String toString() {
        return "UploadInfo{flying_off='" + this.flying_off + '\'' + ", fly_total_time='" + this.fly_total_time + '\'' + ", mileage='" + this.mileage + '\'' + ", fileName='" + this.fileName + '}';
    }
}
