package com.xeagle.android.login.beans;

public class BaseBeans {
    private int code;
    private boolean status;

    public BaseBeans(boolean z2, int i2) {
        this.status = z2;
        this.code = i2;
    }

    public int getCode() {
        return this.code;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setStatus(boolean z2) {
        this.status = z2;
    }

    public String toString() {
        return "BaseBeans{status=" + this.status + ", code=" + this.code + '}';
    }
}
