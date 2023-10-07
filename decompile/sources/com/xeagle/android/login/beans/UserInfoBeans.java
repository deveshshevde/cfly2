package com.xeagle.android.login.beans;

public class UserInfoBeans {
    private String account;
    private String avatar;
    private String email;

    /* renamed from: id  reason: collision with root package name */
    private String f23797id;
    private String nickname;
    private String phone;

    public UserInfoBeans() {
    }

    public UserInfoBeans(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f23797id = str;
        this.nickname = str2;
        this.account = str3;
        this.phone = str4;
        this.email = str5;
        this.avatar = str6;
    }

    public String getAccount() {
        return this.account;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getEmail() {
        return this.email;
    }

    public String getId() {
        return this.f23797id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setId(String str) {
        this.f23797id = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public String toString() {
        return "UserInfoBeans{id='" + this.f23797id + '\'' + ", nickName='" + this.nickname + '\'' + ", account='" + this.account + '\'' + ", phone='" + this.phone + '\'' + ", email='" + this.email + '\'' + ", avatar='" + this.avatar + '\'' + '}';
    }
}
