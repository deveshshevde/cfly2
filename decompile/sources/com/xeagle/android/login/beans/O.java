package com.xeagle.android.login.beans;

public class O {
    private String bssid;
    private int signal;
    private String ssid;
    private int status;

    public String getBssid() {
        return this.bssid;
    }

    public int getSignal() {
        return this.signal;
    }

    public String getSsid() {
        return this.ssid;
    }

    public int getStatus() {
        return this.status;
    }

    public void setBssid(String str) {
        this.bssid = str;
    }

    public void setSignal(int i2) {
        this.signal = i2;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public String toString() {
        return "RcJsonBeans{bssid='" + this.bssid + '\'' + ", ssid='" + this.ssid + '\'' + ", signal=" + this.signal + ", status=" + this.status + '}';
    }
}
