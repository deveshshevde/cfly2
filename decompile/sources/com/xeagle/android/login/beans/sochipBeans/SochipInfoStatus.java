package com.xeagle.android.login.beans.sochipBeans;

public class SochipInfoStatus {
    private int cmd;
    private int status;

    public SochipInfoStatus(int i2, int i3) {
        this.cmd = i2;
        this.status = i3;
    }

    public int getCmd() {
        return this.cmd;
    }

    public int getStatus() {
        return this.status;
    }

    public void setCmd(int i2) {
        this.cmd = i2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }
}
