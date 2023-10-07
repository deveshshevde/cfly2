package com.xeagle.android.login.beans;

public class DroneInServerBeans {
    private int code;
    private DroneInServerData data;
    private boolean status;

    public DroneInServerBeans(boolean z2, int i2, DroneInServerData droneInServerData) {
        this.status = z2;
        this.code = i2;
        this.data = droneInServerData;
    }

    public int getCode() {
        return this.code;
    }

    public DroneInServerData getData() {
        return this.data;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setData(DroneInServerData droneInServerData) {
        this.data = droneInServerData;
    }

    public void setStatus(boolean z2) {
        this.status = z2;
    }

    public String toString() {
        return "DroneInServerBeans{status=" + this.status + ", code=" + this.code + ", data=" + this.data.toString() + '}';
    }
}
