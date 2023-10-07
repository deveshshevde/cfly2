package com.xeagle.android.login.beans;

public class LoginAcceptBeans {
    private int code;
    private LoginData data;
    private String message;
    private boolean status;

    public LoginAcceptBeans(boolean z2, int i2, LoginData loginData, String str) {
        this.status = z2;
        this.code = i2;
        this.data = loginData;
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public LoginData getData() {
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

    public void setData(LoginData loginData) {
        this.data = loginData;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(boolean z2) {
        this.status = z2;
    }

    public String toString() {
        StringBuilder sb;
        if (this.status) {
            sb = new StringBuilder();
            sb.append("LoginAcceptBeans{status=");
            sb.append(this.status);
            sb.append(", code=");
            sb.append(this.code);
            sb.append(", data=");
            sb.append(this.data);
        } else {
            sb = new StringBuilder();
            sb.append("LoginAcceptBeans{status=");
            sb.append(this.status);
            sb.append(", code=");
            sb.append(this.code);
            sb.append(", message=");
            sb.append(this.message);
        }
        sb.append('}');
        return sb.toString();
    }
}
