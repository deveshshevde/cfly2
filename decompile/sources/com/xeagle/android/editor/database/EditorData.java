package com.xeagle.android.editor.database;

import com.xeagle.android.login.pickImage.data.GLImage;
import java.util.Objects;
import org.litepal.crud.LitePalSupport;

public class EditorData extends LitePalSupport {
    private long addTime;
    private long duration;
    private int height;
    private long imageId;
    private int leftProgress;
    private String mimeType;
    private String name;
    private String path;
    private int rightProgress;
    private long size;
    private int width;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.path.equals(((EditorData) obj).path);
    }

    public long getAddTime() {
        return this.addTime;
    }

    public long getDuration() {
        return this.duration;
    }

    public GLImage getGlImage() {
        return GLImage.Builder.newBuilder().setName(this.name).setPath(this.path).setSize(this.size).setWidth(this.width).setHeight(this.height).setMimeType(this.mimeType).setAddTime(this.addTime).setId(this.imageId).setDuration(this.duration).build();
    }

    public int getHeight() {
        return this.height;
    }

    public long getImageId() {
        return this.imageId;
    }

    public int getLeftProgress() {
        return this.leftProgress;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public int getRightProgress() {
        return this.rightProgress;
    }

    public long getSize() {
        return this.size;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.path});
    }

    public void setAddTime(long j2) {
        this.addTime = j2;
    }

    public void setDuration(long j2) {
        this.duration = j2;
    }

    public void setGlImage(GLImage gLImage) {
        this.name = gLImage.getName();
        this.path = gLImage.getPath();
        this.size = gLImage.getSize();
        this.width = gLImage.getWidth();
        this.height = gLImage.getHeight();
        this.mimeType = gLImage.getMimeType();
        this.addTime = gLImage.getAddTime();
        this.imageId = gLImage.getId();
        this.duration = gLImage.getDuration();
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setImageId(long j2) {
        this.imageId = j2;
    }

    public void setLeftProgress(int i2) {
        this.leftProgress = i2;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setRightProgress(int i2) {
        this.rightProgress = i2;
    }

    public void setSize(long j2) {
        this.size = j2;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }
}
