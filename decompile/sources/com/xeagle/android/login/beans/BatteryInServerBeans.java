package com.xeagle.android.login.beans;

public class BatteryInServerBeans {
    private int code;
    private BatteryInServerData data;
    private boolean status;

    public BatteryInServerBeans(boolean z2, int i2, BatteryInServerData batteryInServerData) {
        this.status = z2;
        this.code = i2;
        this.data = batteryInServerData;
    }

    public int getCode() {
        return this.code;
    }

    public BatteryInServerData getData() {
        return this.data;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setData(BatteryInServerData batteryInServerData) {
        this.data = batteryInServerData;
    }

    public void setStatus(boolean z2) {
        this.status = z2;
    }

    public String toString() {
        return "BatteryInServerBeans{status=" + this.status + ", code=" + this.code + ", data=" + this.data + '}';
    }
}
