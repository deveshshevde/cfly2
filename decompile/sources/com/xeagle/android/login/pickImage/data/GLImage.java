package com.xeagle.android.login.pickImage.data;

import android.os.Bundle;
import java.io.Serializable;

public class GLImage implements GLMedia, Serializable, Comparable<GLImage> {
    public static final String KEY_ADDTIME = "addTime";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_MIMETYPE = "mimeType";
    public static final String KEY_NAME = "name";
    public static final String KEY_PATH = "path";
    public static final String KEY_SIZE = "size";
    public static final String KEY_WIDTH = "width";
    private long addTime;
    private long duration;
    private int height;

    /* renamed from: id  reason: collision with root package name */
    private long f23803id;
    private String mimeType;
    private String name;
    private String path;
    private long size;
    private int width;

    public static final class Builder {
        private long addTime;
        private long duration;
        private int height;

        /* renamed from: id  reason: collision with root package name */
        private long f23804id;
        private String mimeType;
        private String name;
        private String path;
        private long size;
        private int width;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static Builder newBuilder(GLImage gLImage) {
            return new Builder().setId(gLImage.getId()).setName(gLImage.getName()).setPath(gLImage.getPath()).setSize(gLImage.getSize()).setWidth(gLImage.getWidth()).setHeight(gLImage.getHeight()).setMimeType(gLImage.getMimeType()).setAddTime(gLImage.getAddTime());
        }

        public GLImage build() {
            GLImage gLImage = new GLImage(this.f23804id, this.name, this.path, this.size, this.width, this.height, this.mimeType, this.addTime);
            gLImage.setId(this.f23804id);
            gLImage.setDuration(this.duration);
            return gLImage;
        }

        public Builder setAddTime(long j2) {
            this.addTime = j2;
            return this;
        }

        public Builder setDuration(long j2) {
            this.duration = j2;
            return this;
        }

        public Builder setHeight(int i2) {
            this.height = i2;
            return this;
        }

        public Builder setId(long j2) {
            this.f23804id = j2;
            return this;
        }

        public Builder setMimeType(String str) {
            this.mimeType = str;
            return this;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setPath(String str) {
            this.path = str;
            return this;
        }

        public Builder setSize(long j2) {
            this.size = j2;
            return this;
        }

        public Builder setWidth(int i2) {
            this.width = i2;
            return this;
        }
    }

    private GLImage(long j2, String str, String str2, long j3, int i2, int i3, String str3, long j4) {
        this.name = str;
        this.path = str2;
        this.size = j3;
        this.width = i2;
        this.height = i3;
        this.mimeType = str3;
        this.addTime = j4;
    }

    public GLImage(String str) {
        this.path = str;
    }

    /* access modifiers changed from: private */
    public void setId(long j2) {
        this.f23803id = j2;
    }

    public int compareTo(GLImage gLImage) {
        long j2 = this.addTime;
        long j3 = gLImage.addTime;
        if (j2 != j3) {
            return j2 > j3 ? -1 : 1;
        }
        if (isVideo() && gLImage.isVideo()) {
            return 0;
        }
        if (isVideo() || gLImage.isVideo()) {
            return isVideo() ? 1 : -1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GLImage)) {
            return false;
        }
        return this.path.equalsIgnoreCase(((GLImage) obj).path);
    }

    public long getAddTime() {
        return this.addTime;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public long getId() {
        return this.f23803id;
    }

    public String getMimeType() {
        String str = this.mimeType;
        return str != null ? str : "";
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.size;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.path;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean isVideo() {
        if (getMimeType() == null) {
            return false;
        }
        return getMimeType().contains("video");
    }

    public void setDuration(long j2) {
        this.duration = j2;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("name", this.name);
        bundle.putString(KEY_PATH, this.path);
        bundle.putLong(KEY_SIZE, this.size);
        bundle.putInt("width", this.width);
        bundle.putInt("height", this.height);
        bundle.putString(KEY_MIMETYPE, this.mimeType);
        bundle.putLong(KEY_ADDTIME, this.addTime);
        return bundle;
    }

    public String toString() {
        return "GLImage{name='" + this.name + '\'' + ", path='" + this.path + '\'' + ", mimeType='" + this.mimeType + '\'' + ", duration=" + this.duration + '}';
    }
}
