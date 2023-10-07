package com.xeagle.android.login.beans;

public class ApkVersion {
    private String apk_size;
    private String apk_url;
    private String apk_version;
    private String img_url;
    private int need_upgrade;
    private String update_info;
    private long versionCode;

    public String getApk_size() {
        return this.apk_size;
    }

    public String getApk_url() {
        return this.apk_url;
    }

    public String getApk_version() {
        return this.apk_version;
    }

    public String getImg_url() {
        return this.img_url;
    }

    public int getNeed_upgrade() {
        return this.need_upgrade;
    }

    public String getUpdate_info() {
        return this.update_info;
    }

    public long getVersionCode() {
        return this.versionCode;
    }

    public void setApk_size(String str) {
        this.apk_size = str;
    }

    public void setApk_url(String str) {
        this.apk_url = str;
    }

    public void setApk_version(String str) {
        this.apk_version = str;
    }

    public void setImg_url(String str) {
        this.img_url = str;
    }

    public void setNeed_upgrade(int i2) {
        this.need_upgrade = i2;
    }

    public void setUpdate_info(String str) {
        this.update_info = str;
    }

    public void setVersionCode(long j2) {
        this.versionCode = j2;
    }

    public String toString() {
        return "ApkVersion{update_info='" + this.update_info + '\'' + ", apk_version='" + this.apk_version + '\'' + ", versionCode='" + this.versionCode + '\'' + ", apk_size='" + this.apk_size + '\'' + ", img_url='" + this.img_url + '\'' + ", apk_url='" + this.apk_url + '\'' + '}';
    }
}
