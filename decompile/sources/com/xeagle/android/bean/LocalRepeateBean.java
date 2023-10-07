package com.xeagle.android.bean;

public class LocalRepeateBean {
    private String content;
    private String file_size;
    private String firmware_version;
    private String md5;

    public LocalRepeateBean(String str, String str2, String str3, String str4) {
        this.content = str;
        this.md5 = str2;
        this.firmware_version = str3;
        this.file_size = str4;
    }

    public String getContent() {
        return this.content;
    }

    public String getFile_size() {
        return this.file_size;
    }

    public String getFirmware_version() {
        return this.firmware_version;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFile_size(String str) {
        this.file_size = str;
    }

    public void setFirmware_version(String str) {
        this.firmware_version = str;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public String toString() {
        return "LocalRepeateBean{content='" + this.content + '\'' + ", md5='" + this.md5 + '\'' + ", firmware_version='" + this.firmware_version + '\'' + ", file_size='" + this.file_size + '\'' + '}';
    }
}
