package com.xeagle.android.login.beans;

import java.util.ArrayList;

public class UsbWifiBeans {
    private ArrayList<UsbWifiInfo> body;

    public UsbWifiBeans(ArrayList<UsbWifiInfo> arrayList) {
        this.body = arrayList;
    }

    public ArrayList<UsbWifiInfo> getBody() {
        return this.body;
    }

    public void setBody(ArrayList<UsbWifiInfo> arrayList) {
        this.body = arrayList;
    }

    public String toString() {
        return "UsbWifiBeans{body=" + this.body + '}';
    }
}
