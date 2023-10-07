package com.xeagle.android.bean;

import java.util.ArrayList;

public class LocalRelayBean {
    private ArrayList<LocalRepeateBean> relay_firmware;

    public LocalRelayBean(ArrayList<LocalRepeateBean> arrayList) {
        this.relay_firmware = arrayList;
    }

    public ArrayList<LocalRepeateBean> getRelay_firmware() {
        return this.relay_firmware;
    }

    public void setRelay_firmware(ArrayList<LocalRepeateBean> arrayList) {
        this.relay_firmware = arrayList;
    }

    public String toString() {
        return "LocalRelayBean{relay_firmware=" + this.relay_firmware + '}';
    }
}
