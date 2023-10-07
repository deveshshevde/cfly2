package com.autonavi.base.ae.gmap.gloverlay;

public class GLOverlayTexture {
    public int mAnchor;
    public float mAnchorXRatio;
    public float mAnchorYRatio;
    public int mHeight;
    public int mResHeight;
    public int mResId = 0;
    public int mResWidth;
    public int mWidth;

    public GLOverlayTexture(int i2, int i3, float f2, float f3, int i4, int i5) {
        this.mResId = i2;
        this.mWidth = i4;
        this.mHeight = i5;
        this.mResWidth = i4;
        this.mResHeight = i5;
        this.mAnchor = i3;
        this.mAnchorXRatio = f2;
        this.mAnchorYRatio = f3;
    }

    public GLOverlayTexture(int i2, int i3, int i4, int i5) {
        this.mResId = i2;
        this.mWidth = i4;
        this.mHeight = i5;
        this.mResWidth = i4;
        this.mResHeight = i5;
        this.mAnchor = i3;
    }
}
