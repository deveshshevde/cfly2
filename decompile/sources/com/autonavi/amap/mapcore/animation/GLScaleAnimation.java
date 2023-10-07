package com.autonavi.amap.mapcore.animation;

public class GLScaleAnimation extends GLAnimation {
    private float mFromX;
    private float mFromY;
    private float mPivotX = 0.0f;
    private float mPivotY = 0.0f;
    private float mToX;
    private float mToY;

    public GLScaleAnimation(float f2, float f3, float f4, float f5) {
        this.mFromX = f2;
        this.mToX = f3;
        this.mFromY = f4;
        this.mToY = f5;
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, GLTransformation gLTransformation) {
        float f3 = this.mFromX;
        float f4 = 1.0f;
        float f5 = (f3 == 1.0f && this.mToX == 1.0f) ? 1.0f : f3 + ((this.mToX - f3) * f2);
        float f6 = this.mFromY;
        if (!(f6 == 1.0f && this.mToY == 1.0f)) {
            f4 = ((this.mToY - f6) * f2) + f6;
        }
        gLTransformation.scaleX = (double) f5;
        gLTransformation.scaleY = (double) f4;
    }
}
