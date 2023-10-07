package com.xeagle.android.login.beans;

public class DroneActivationInServerBeans {
    private int code;
    private DroneActivationInServerData data;
    private boolean status;

    public DroneActivationInServerBeans(boolean z2, int i2, DroneActivationInServerData droneActivationInServerData) {
        this.status = z2;
        this.code = i2;
        this.data = droneActivationInServerData;
    }

    public int getCode() {
        return this.code;
    }

    public DroneActivationInServerData getData() {
        return this.data;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setData(DroneActivationInServerData droneActivationInServerData) {
        this.data = droneActivationInServerData;
    }

    public void setStatus(boolean z2) {
        this.status = z2;
    }

    public String toString() {
        return "DroneActivationInServerBeans{status=" + this.status + ", code=" + this.code + ", data=" + this.data.toString() + '}';
    }
}
