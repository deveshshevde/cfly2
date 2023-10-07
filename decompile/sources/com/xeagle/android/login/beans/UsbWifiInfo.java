package com.xeagle.android.login.beans;

public class UsbWifiInfo {
    private String bssid;
    private String frequency;
    private int signal_level;
    private String ssid;

    public UsbWifiInfo(String str, int i2, String str2, String str3) {
        this.frequency = str;
        this.signal_level = i2;
        this.ssid = str2;
        this.bssid = str3;
    }

    public String getBssid() {
        return this.bssid;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public int getSignal_level() {
        return this.signal_level;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setBssid(String str) {
        this.bssid = str;
    }

    public void setFrequency(String str) {
        this.frequency = str;
    }

    public void setSignal_level(int i2) {
        this.signal_level = i2;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }
}
