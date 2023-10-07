package com.xeagle.android.login.beans;

public class UserInfoAcceptBeans {
    private int code;
    private UserInfoBeans data;
    private boolean status;

    public UserInfoAcceptBeans() {
    }

    public UserInfoAcceptBeans(boolean z2, int i2, UserInfoBeans userInfoBeans) {
        this.status = z2;
        this.code = i2;
        this.data = userInfoBeans;
    }

    public int getCode() {
        return this.code;
    }

    public UserInfoBeans getData() {
        return this.data;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setData(UserInfoBeans userInfoBeans) {
        this.data = userInfoBeans;
    }

    public void setStatus(boolean z2) {
        this.status = z2;
    }

    public String toString() {
        return "UserInfoAcceptBeans{status=" + this.status + ", code=" + this.code + ", data=" + this.data + '}';
    }
}
