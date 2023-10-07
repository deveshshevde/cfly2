package com.xeagle.android.login.beans;

public class LoginData {
    private String email;
    private String phone;
    private String token;
    private int uid;

    public LoginData(int i2, String str, String str2, String str3) {
        this.uid = i2;
        this.email = str;
        this.phone = str2;
        this.token = str3;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getToken() {
        return this.token;
    }

    public int getUid() {
        return this.uid;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUid(int i2) {
        this.uid = i2;
    }

    public String toString() {
        return "LoginData{uid=" + this.uid + ", email='" + this.email + '\'' + ", phone='" + this.phone + '\'' + ", token='" + this.token + '\'' + '}';
    }
}
