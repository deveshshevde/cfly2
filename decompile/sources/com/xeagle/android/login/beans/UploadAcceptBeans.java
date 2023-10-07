package com.xeagle.android.login.beans;

public class UploadAcceptBeans {
    private int code;
    private String data;
    private String message;
    private boolean status;

    public UploadAcceptBeans(boolean z2, int i2, String str, String str2) {
        this.status = z2;
        this.code = i2;
        this.data = str;
        this.message = str2;
    }

    public int getCode() {
        return this.code;
    }

    public String getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(boolean z2) {
        this.status = z2;
    }

    public String toString() {
        return "UploadAcceptBeans{status=" + this.status + ", code=" + this.code + ", data='" + this.data + '\'' + ", message='" + this.message + '\'' + '}';
    }
}
