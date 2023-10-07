package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLRotateAnimation;

public class RotateAnimation extends Animation {
    private float mFromDegrees = 0.0f;
    private float mToDegrees = 1.0f;

    public RotateAnimation(float f2, float f3) {
        this.glAnimation = new GLRotateAnimation(f2, f3, 0.0f, 0.0f, 0.0f);
        this.mFromDegrees = f2;
        this.mToDegrees = f3;
    }

    public RotateAnimation(float f2, float f3, float f4, float f5, float f6) {
        this.glAnimation = new GLRotateAnimation(f2, f3, f4, f5, f6);
        this.mFromDegrees = f2;
        this.mToDegrees = f3;
    }

    /* access modifiers changed from: protected */
    public String getAnimationType() {
        return "RotateAnimation";
    }
}
