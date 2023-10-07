package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;

public class AlphaAnimation extends Animation {
    private float mFromAlpha = 0.0f;
    private float mToAlpha = 1.0f;

    public AlphaAnimation(float f2, float f3) {
        this.glAnimation = new GLAlphaAnimation(f2, f3);
        this.mFromAlpha = f2;
        this.mToAlpha = f3;
    }

    /* access modifiers changed from: protected */
    public String getAnimationType() {
        return "AlphaAnimation";
    }
}
