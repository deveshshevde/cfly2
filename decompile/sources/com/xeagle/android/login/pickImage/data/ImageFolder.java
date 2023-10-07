package com.xeagle.android.login.pickImage.data;

import java.io.Serializable;
import java.util.ArrayList;

public class ImageFolder implements Serializable {
    public GLImage cover;
    public ArrayList<GLImage> images = new ArrayList<>();
    public String name;
    public String path;

    public ImageFolder copyPath() {
        ImageFolder imageFolder = new ImageFolder();
        imageFolder.name = this.name;
        imageFolder.path = this.path;
        imageFolder.cover = this.cover;
        return imageFolder;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageFolder)) {
            return false;
        }
        ImageFolder imageFolder = (ImageFolder) obj;
        return this.path.equalsIgnoreCase(imageFolder.path) && this.name.equalsIgnoreCase(imageFolder.name);
    }

    public int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.path;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public void merge(ImageFolder imageFolder) {
        ArrayList<GLImage> arrayList;
        if (imageFolder != null && (arrayList = imageFolder.images) != null) {
            this.images.addAll(arrayList);
        }
    }
}
