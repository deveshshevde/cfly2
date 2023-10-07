package com.xeagle.android.login.beans.sochipBeans;

import java.util.ArrayList;

public class SochipStatusBean {
    private int device_id;
    private String device_name;

    /* renamed from: info  reason: collision with root package name */
    private ArrayList<SochipInfoStatus> f23798info;
    private String software;

    public SochipStatusBean(int i2, String str, ArrayList<SochipInfoStatus> arrayList, String str2) {
        this.device_id = i2;
        this.device_name = str;
        this.f23798info = arrayList;
        this.software = str2;
    }

    public int getDevice_id() {
        return this.device_id;
    }

    public String getDevice_name() {
        return this.device_name;
    }

    public ArrayList<SochipInfoStatus> getInfo() {
        return this.f23798info;
    }

    public String getSoftware() {
        return this.software;
    }

    public void setDevice_id(int i2) {
        this.device_id = i2;
    }

    public void setDevice_name(String str) {
        this.device_name = str;
    }

    public void setInfo(ArrayList<SochipInfoStatus> arrayList) {
        this.f23798info = arrayList;
    }

    public void setSoftware(String str) {
        this.software = str;
    }
}
