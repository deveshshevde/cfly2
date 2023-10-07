package com.xeagle.android.login.beans;

public class WifiBean implements Comparable<WifiBean> {
    private String capabilities;
    private int level;
    private String state;
    private String wifiName;

    public int compareTo(WifiBean wifiBean) {
        return -(getLevel() - wifiBean.getLevel());
    }

    public String getCapabilities() {
        return this.capabilities;
    }

    public int getLevel() {
        return this.level;
    }

    public String getState() {
        return this.state;
    }

    public String getWifiName() {
        return this.wifiName;
    }

    public void setCapabilities(String str) {
        this.capabilities = str;
    }

    public void setLevel(int i2) {
        this.level = i2;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setWifiName(String str) {
        this.wifiName = str;
    }

    public String toString() {
        return "WifiBean{wifiName='" + this.wifiName + '\'' + ", level='" + this.level + '\'' + ", state='" + this.state + '\'' + ", capabilities='" + this.capabilities + '\'' + '}';
    }
}
