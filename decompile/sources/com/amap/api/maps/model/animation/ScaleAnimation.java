package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLScaleAnimation;

public class ScaleAnimation extends Animation {
    private float mFromX;
    private float mFromY;
    private float mPivotX = 0.0f;
    private float mPivotY = 0.0f;
    private float mToX;
    private float mToY;

    public ScaleAnimation(float f2, float f3, float f4, float f5) {
        this.glAnimation = new GLScaleAnimation(f2, f3, f4, f5);
        this.mFromX = f2;
        this.mToX = f3;
        this.mFromY = f4;
        this.mToY = f5;
        setFillMode(1);
    }

    /* access modifiers changed from: protected */
    public String getAnimationType() {
        return "ScaleAnimation";
    }
}
