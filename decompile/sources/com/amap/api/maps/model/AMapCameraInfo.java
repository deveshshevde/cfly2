package com.amap.api.maps.model;

public class AMapCameraInfo {
    private float aspectRatio = 1.0f;
    private float fov = 0.0f;
    private float positionX = 0.0f;
    private float positionY = 0.0f;
    private float positionZ = 0.0f;
    private float rotate = 0.0f;

    public AMapCameraInfo(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.fov = f2;
        this.aspectRatio = f3;
        this.rotate = f4;
        this.positionX = f5;
        this.positionY = f6;
        this.positionZ = f7;
    }

    public float getAspectRatio() {
        return this.aspectRatio;
    }

    public float getFov() {
        return this.fov;
    }

    public float getRotate() {
        return this.rotate;
    }

    public float getX() {
        return this.positionX;
    }

    public float getY() {
        return this.positionY;
    }

    public float getZ() {
        return this.positionZ;
    }

    public String toString() {
        return "[fov:" + this.fov + " " + "aspectRatio:" + this.aspectRatio + " " + "rotate:" + this.rotate + " " + "pos_x:" + this.positionX + " " + "pos_y:" + this.positionY + " " + "pos_z:" + this.positionZ + "]";
    }
}
