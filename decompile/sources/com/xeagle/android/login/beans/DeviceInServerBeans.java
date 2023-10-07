package com.xeagle.android.login.beans;

public class DeviceInServerBeans {
    private int code;
    private DeviceInServerData data;
    private boolean status;

    public DeviceInServerBeans(boolean z2, int i2, DeviceInServerData deviceInServerData) {
        this.status = z2;
        this.code = i2;
        this.data = deviceInServerData;
    }

    public int getCode() {
        return this.code;
    }

    public DeviceInServerData getData() {
        return this.data;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setData(DeviceInServerData deviceInServerData) {
        this.data = deviceInServerData;
    }

    public void setStatus(boolean z2) {
        this.status = z2;
    }

    public String toString() {
        return "DeviceInServerBeans{status=" + this.status + ", code=" + this.code + ", data=" + this.data.toString() + '}';
    }
}
