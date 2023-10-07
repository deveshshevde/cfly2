package com.xeagle.android.login.beans;

public class AvatarAcceptBeans {
    private int code;
    private AvatarBeans data;
    private boolean status;

    public AvatarAcceptBeans() {
    }

    public AvatarAcceptBeans(boolean z2, int i2, AvatarBeans avatarBeans) {
        this.status = z2;
        this.code = i2;
        this.data = avatarBeans;
    }

    public int getCode() {
        return this.code;
    }

    public AvatarBeans getData() {
        return this.data;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setData(AvatarBeans avatarBeans) {
        this.data = avatarBeans;
    }

    public void setStatus(boolean z2) {
        this.status = z2;
    }

    public String toString() {
        return "AvatarAcceptBeans{status=" + this.status + ", code=" + this.code + ", data=" + this.data + '}';
    }
}
