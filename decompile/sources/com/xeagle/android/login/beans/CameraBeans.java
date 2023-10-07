package com.xeagle.android.login.beans;

public class CameraBeans {
    private String AWB;
    private String EV_Value;
    private String Effect_Mode;
    private String Fov;
    private String ISO;
    private String Scene_Mode;
    private String photo_size;
    private String photo_stamp;
    private String video_resolution;
    private String video_stamp;

    public CameraBeans(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.video_resolution = str;
        this.EV_Value = str2;
        this.AWB = str3;
        this.video_stamp = str4;
        this.photo_stamp = str5;
        this.photo_size = str6;
        this.ISO = str7;
        this.Fov = str8;
        this.Scene_Mode = str9;
        this.Effect_Mode = str10;
    }

    public String getAWB() {
        return this.AWB;
    }

    public String getEV_Value() {
        return this.EV_Value;
    }

    public String getEffect_Mode() {
        return this.Effect_Mode;
    }

    public String getFov() {
        return this.Fov;
    }

    public String getISO() {
        return this.ISO;
    }

    public String getPhoto_size() {
        return this.photo_size;
    }

    public String getPhoto_stamp() {
        return this.photo_stamp;
    }

    public String getScene_Mode() {
        return this.Scene_Mode;
    }

    public String getVideo_resolution() {
        return this.video_resolution;
    }

    public String getVideo_stamp() {
        return this.video_stamp;
    }

    public void setAWB(String str) {
        this.AWB = str;
    }

    public void setEV_Value(String str) {
        this.EV_Value = str;
    }

    public void setEffect_Mode(String str) {
        this.Effect_Mode = str;
    }

    public void setFov(String str) {
        this.Fov = str;
    }

    public void setISO(String str) {
        this.ISO = str;
    }

    public void setPhoto_size(String str) {
        this.photo_size = str;
    }

    public void setPhoto_stamp(String str) {
        this.photo_stamp = str;
    }

    public void setScene_Mode(String str) {
        this.Scene_Mode = str;
    }

    public void setVideo_resolution(String str) {
        this.video_resolution = str;
    }

    public void setVideo_stamp(String str) {
        this.video_stamp = str;
    }
}
