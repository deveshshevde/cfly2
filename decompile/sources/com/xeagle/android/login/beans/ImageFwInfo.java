package com.xeagle.android.login.beans;

import java.util.ArrayList;

public class ImageFwInfo {
    private ArrayList<ImageFwBeans> image_firmware;

    public ImageFwInfo() {
    }

    public ImageFwInfo(ArrayList<ImageFwBeans> arrayList) {
        this.image_firmware = arrayList;
    }

    public ArrayList<ImageFwBeans> getImage_firmware() {
        return this.image_firmware;
    }

    public void setImage_firmware(ArrayList<ImageFwBeans> arrayList) {
        this.image_firmware = arrayList;
    }

    public String toString() {
        ArrayList<ImageFwBeans> arrayList = this.image_firmware;
        if (arrayList == null || arrayList.size() <= 0) {
            return "image firmware is null";
        }
        return "ImageFwInfo{image_firmware=" + this.image_firmware.toString() + '}';
    }
}
