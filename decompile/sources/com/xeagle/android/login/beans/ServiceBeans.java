package com.xeagle.android.login.beans;

public class ServiceBeans {
    private String online_service;

    public ServiceBeans(String str) {
        this.online_service = str;
    }

    public String getOnline_service() {
        return this.online_service;
    }

    public void setOnline_service(String str) {
        this.online_service = str;
    }

    public String toString() {
        return "ServiceBeans{online_service='" + this.online_service + '\'' + '}';
    }
}
