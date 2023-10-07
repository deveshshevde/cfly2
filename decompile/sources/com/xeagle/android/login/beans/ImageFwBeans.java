package com.xeagle.android.login.beans;

public class ImageFwBeans {
    private String content;
    private int force;
    private String md5;
    private String pbaMd5;
    private String pbaUrl;
    private String subType;
    private String type;
    private String url;
    private String version;
    private String wideAngle;

    public ImageFwBeans() {
    }

    public ImageFwBeans(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9) {
        this.content = str;
        this.md5 = str2;
        this.type = str3;
        this.url = str4;
        this.pbaMd5 = str5;
        this.pbaUrl = str6;
        this.subType = str7;
        this.version = str8;
        this.force = i2;
        this.wideAngle = str9;
    }

    public String getContent() {
        return this.content;
    }

    public int getForce() {
        return this.force;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getPbaMd5() {
        return this.pbaMd5;
    }

    public String getPbaUrl() {
        return this.pbaUrl;
    }

    public String getSubType() {
        return this.subType;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public String getWideAngle() {
        return this.wideAngle;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setForce(int i2) {
        this.force = i2;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setPbaMd5(String str) {
        this.pbaMd5 = str;
    }

    public void setPbaUrl(String str) {
        this.pbaUrl = str;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setWideAngle(String str) {
        this.wideAngle = str;
    }

    public String toString() {
        return "ImageFwBeans{content='" + this.content + '\'' + ", md5='" + this.md5 + '\'' + ", type='" + this.type + '\'' + ", url='" + this.url + '\'' + ", pbaMd5='" + this.pbaMd5 + '\'' + ", pbaUrl='" + this.pbaUrl + '\'' + ", subType='" + this.subType + '\'' + ", version='" + this.version + '\'' + ", force=" + this.force + ", wideAngle='" + this.wideAngle + '\'' + '}';
    }
}
