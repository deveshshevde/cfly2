package com.autonavi.amap.mapcore.animation;

public class GLAlphaAnimation extends GLAnimation {
    public float mCurAlpha = 0.0f;
    public float mFromAlpha = 0.0f;
    public float mToAlpha = 1.0f;

    public GLAlphaAnimation(float f2, float f3) {
        this.mFromAlpha = f2;
        this.mToAlpha = f3;
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, GLTransformation gLTransformation) {
        float f3 = this.mFromAlpha;
        float f4 = f3 + ((this.mToAlpha - f3) * f2);
        this.mCurAlpha = f4;
        gLTransformation.alpha = (double) f4;
    }
}
