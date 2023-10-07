package com.flypro.core.database;

public class UserInfo {
    private String country;
    private String email;
    private String iconPath = "-";
    private String password;
    private String phone;
    private String token;
    private float totalCount;
    private float totalFlightTime;
    private float totalMileage;
    private String uid;
    private String userMale;
    private String userName;

    public UserInfo() {
    }

    public UserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, float f2, float f3, float f4) {
        this.uid = str;
        this.userName = str2;
        this.iconPath = str3;
        this.email = str4;
        this.phone = str5;
        this.token = str6;
        this.password = str7;
        this.userMale = str8;
        this.country = str9;
        this.totalFlightTime = f2;
        this.totalMileage = f3;
        this.totalCount = f4;
    }

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
        return "UserInfo{uid='" + this.uid + '\'' + ", userName='" + this.userName + '\'' + ", iconPath='" + this.iconPath + '\'' + ", email='" + this.email + '\'' + ", phone='" + this.phone + '\'' + ", token='" + this.token + '\'' + ", password='" + this.password + '\'' + ", userMale='" + this.userMale + '\'' + ", country='" + this.country + '\'' + ", totalFlightTime=" + this.totalFlightTime + ", totalMileage=" + this.totalMileage + ", totalCount=" + this.totalCount + '}';
    }
}
