package com.xeagle.android.login.beans;

public class DroneFwBeans {
    private String chip_type;
    private String content;
    private String drone_type;
    private int enforce;
    private String file_path;
    private String file_size;
    private String firmware_version;
    private String md5;

    public DroneFwBeans() {
    }

    public DroneFwBeans(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2) {
        this.content = str;
        this.file_path = str2;
        this.md5 = str3;
        this.firmware_version = str4;
        this.drone_type = str5;
        this.chip_type = str6;
        this.file_size = str7;
        this.enforce = i2;
    }

    public String getChip_type() {
        return this.chip_type;
    }

    public String getContent() {
        return this.content;
    }

    public String getDrone_type() {
        return this.drone_type;
    }

    public int getEnforce() {
        return this.enforce;
    }

    public String getFile_path() {
        return this.file_path;
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

    public void setChip_type(String str) {
        this.chip_type = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDrone_type(String str) {
        this.drone_type = str;
    }

    public void setEnforce(int i2) {
        this.enforce = i2;
    }

    public void setFile_path(String str) {
        this.file_path = str;
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
        return "DroneFwBeans{file_path='" + this.file_path + '\'' + ", md5='" + this.md5 + '\'' + ", firmware_version='" + this.firmware_version + '\'' + ", drone_type='" + this.drone_type + '\'' + ", chip_type='" + this.chip_type + '\'' + ", file_size='" + this.file_size + '\'' + ", enforce=" + this.enforce + '}';
    }
}
