package com.xeagle.android.login.beans;

public class AvatarBeans {
    private String avatar;

    public AvatarBeans() {
    }

    public AvatarBeans(String str) {
        this.avatar = str;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public String toString() {
        return "AvatarBeans{avatar='" + this.avatar + '\'' + '}';
    }
}
