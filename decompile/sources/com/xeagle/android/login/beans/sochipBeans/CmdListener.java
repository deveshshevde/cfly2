package com.xeagle.android.login.beans.sochipBeans;

public class CmdListener {
    private int Cmd;
    private int Value;

    public CmdListener(int i2, int i3) {
        this.Cmd = i2;
        this.Value = i3;
    }

    public int getCmd() {
        return this.Cmd;
    }

    public int getValue() {
        return this.Value;
    }

    public void setCmd(int i2) {
        this.Cmd = i2;
    }

    public void setValue(int i2) {
        this.Value = i2;
    }
}
