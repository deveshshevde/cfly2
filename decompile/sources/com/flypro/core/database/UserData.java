package com.flypro.core.database;

import org.litepal.crud.LitePalSupport;

public class UserData extends LitePalSupport {
    private String country;
    private String email;
    private String iconPath;
    private String password;
    private String phone;
    private String token;
    private float totalCount;
    private float totalFlightTime;
    private float totalMileage;
    private String uid;
    private String userMale;
    private String userName;

    public String getCountry() {
        return this.country;
    }

    public String getEmail() {
        return this.email;
    }

    public String getIconPath() {
        return this.iconPath;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getToken() {
        return this.token;
    }

    public float getTotalCount() {
        return this.totalCount;
    }

    public float getTotalFlightTime() {
        return this.totalFlightTime;
    }

    public float getTotalMileage() {
        return this.totalMileage;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUserMale() {
        return this.userMale;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setIconPath(String str) {
        this.iconPath = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTotalCount(float f2) {
        this.totalCount = f2;
    }

    public void setTotalFlightTime(float f2) {
        this.totalFlightTime = f2;
    }

    public void setTotalMileage(float f2) {
        this.totalMileage = f2;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUserMale(String str) {
        this.userMale = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        return "UserData{uid='" + this.uid + '\'' + ", userName='" + this.userName + '\'' + ", iconPath='" + this.iconPath + '\'' + ", email='" + this.email + '\'' + ", phone='" + this.phone + '\'' + ", token='" + this.token + '\'' + ", password='" + this.password + '\'' + ", userMale='" + this.userMale + '\'' + ", country='" + this.country + '\'' + ", totalFlightTime=" + this.totalFlightTime + ", totalMileage=" + this.totalMileage + ", totalCount=" + this.totalCount + '}';
    }
}
