package com.xeagle.android.login.beans;

public class SplashBeans {
    private String image_url;
    private String splash_content;
    private String splash_title;
    private String target_url;
    private String update_time;

    public SplashBeans() {
    }

    public SplashBeans(String str, String str2, String str3, String str4, String str5) {
        this.update_time = str;
        this.image_url = str2;
        this.target_url = str3;
        this.splash_title = str4;
        this.splash_content = str5;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public String getSplash_content() {
        return this.splash_content;
    }

    public String getSplash_title() {
        return this.splash_title;
    }

    public String getTarget_url() {
        return this.target_url;
    }

    public String getUpdate_time() {
        return this.update_time;
    }

    public void setImage_url(String str) {
        this.image_url = str;
    }

    public void setSplash_content(String str) {
        this.splash_content = str;
    }

    public void setSplash_title(String str) {
        this.splash_title = str;
    }

    public void setTarget_url(String str) {
        this.target_url = str;
    }

    public void setUpdate_time(String str) {
        this.update_time = str;
    }

    public String toString() {
        return "SplashBeans{update_time='" + this.update_time + '\'' + ", image_url='" + this.image_url + '\'' + ", target_url='" + this.target_url + '\'' + ", splash_title='" + this.splash_title + '\'' + ", splash_content='" + this.splash_content + '\'' + '}';
    }
}
