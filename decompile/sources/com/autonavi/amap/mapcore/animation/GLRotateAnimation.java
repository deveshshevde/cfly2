package com.autonavi.amap.mapcore.animation;

public class GLRotateAnimation extends GLAnimation {
    private float mFromDegrees = 0.0f;
    private float mToDegrees = 1.0f;

    public GLRotateAnimation(float f2, float f3, float f4, float f5, float f6) {
        this.mFromDegrees = f2;
        this.mToDegrees = f3;
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, GLTransformation gLTransformation) {
        float f3 = this.mFromDegrees;
        gLTransformation.rotate = (double) (f3 + ((this.mToDegrees - f3) * f2));
    }
}
