package com.xeagle.android.login.database;

import org.litepal.crud.LitePalSupport;

public class FirmwareInfoData extends LitePalSupport {
    private String droneChipType;
    private String droneMd5;
    private String droneType;
    private String droneVersion;
    private String imageChipType;
    private String imageMd5;
    private String imageVersion;
    private String repeaterChipType = "-";
    private String repeaterMd5 = "-";
    private String repeaterVersion = "-";

    public FirmwareInfoData() {
    }

    public FirmwareInfoData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.droneVersion = str;
        this.imageVersion = str2;
        this.droneChipType = str3;
        this.imageChipType = str4;
        this.droneType = str5;
        this.droneMd5 = str6;
        this.imageMd5 = str7;
        this.repeaterVersion = str8;
        this.repeaterChipType = str9;
        this.repeaterMd5 = str10;
    }

    public String getDroneChipType() {
        return this.droneChipType;
    }

    public String getDroneMd5() {
        return this.droneMd5;
    }

    public String getDroneType() {
        return this.droneType;
    }

    public String getDroneVersion() {
        return this.droneVersion;
    }

    public String getImageChipType() {
        return this.imageChipType;
    }

    public String getImageMd5() {
        return this.imageMd5;
    }

    public String getImageVersion() {
        return this.imageVersion;
    }

    public String getRepeaterChipType() {
        return this.repeaterChipType;
    }

    public String getRepeaterMd5() {
        return this.repeaterMd5;
    }

    public String getRepeaterVersion() {
        return this.repeaterVersion;
    }

    public void setDroneChipType(String str) {
        this.droneChipType = str;
    }

    public void setDroneMd5(String str) {
        this.droneMd5 = str;
    }

    public void setDroneType(String str) {
        this.droneType = str;
    }

    public void setDroneVersion(String str) {
        this.droneVersion = str;
    }

    public void setImageChipType(String str) {
        this.imageChipType = str;
    }

    public void setImageMd5(String str) {
        this.imageMd5 = str;
    }

    public void setImageVersion(String str) {
        this.imageVersion = str;
    }

    public void setRepeaterChipType(String str) {
        this.repeaterChipType = str;
    }

    public void setRepeaterMd5(String str) {
        this.repeaterMd5 = str;
    }

    public void setRepeaterVersion(String str) {
        this.repeaterVersion = str;
    }

    public String toString() {
        return "FirmwareInfoData{droneVersion='" + this.droneVersion + '\'' + ", imageVersion='" + this.imageVersion + '\'' + ", droneChipType='" + this.droneChipType + '\'' + ", droneType='" + this.droneType + '\'' + '}';
    }
}
