package com.xeagle.android.login.beans.sochipBeans;

public class SochipSdcardBean {
    private int capacity;
    private int disk_id;
    private int disk_num;
    private int disk_status;
    private int disk_type;
    private int free_space;

    public SochipSdcardBean(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.capacity = i2;
        this.disk_id = i3;
        this.disk_num = i4;
        this.disk_status = i5;
        this.disk_type = i6;
        this.free_space = i7;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getDisk_id() {
        return this.disk_id;
    }

    public int getDisk_num() {
        return this.disk_num;
    }

    public int getDisk_status() {
        return this.disk_status;
    }

    public int getDisk_type() {
        return this.disk_type;
    }

    public int getFree_space() {
        return this.free_space;
    }

    public void setCapacity(int i2) {
        this.capacity = i2;
    }

    public void setDisk_id(int i2) {
        this.disk_id = i2;
    }

    public void setDisk_num(int i2) {
        this.disk_num = i2;
    }

    public void setDisk_status(int i2) {
        this.disk_status = i2;
    }

    public void setDisk_type(int i2) {
        this.disk_type = i2;
    }

    public void setFree_space(int i2) {
        this.free_space = i2;
    }
}
