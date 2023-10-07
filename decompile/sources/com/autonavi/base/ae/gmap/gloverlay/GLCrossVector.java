package com.autonavi.base.ae.gmap.gloverlay;

import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

public class GLCrossVector extends GLOverlay {
    public GLCrossVector(final int i2, final IAMapDelegate iAMapDelegate, int i3) {
        super(i2, iAMapDelegate, i3);
        if (iAMapDelegate != null && iAMapDelegate.getGLMapEngine() != null) {
            iAMapDelegate.queueEvent(new Runnable() {
                public void run() {
                    GLCrossVector.this.mNativeInstance = iAMapDelegate.getGLMapEngine().createOverlay(i2, GLOverlay.EAMapOverlayTpye.AMAPOVERLAY_VECTOR.ordinal());
                }
            });
        }
    }

    private static native void nativeAddVectorCar(long j2, int i2, int i3, int i4);

    /* access modifiers changed from: private */
    public static native int nativeAddVectorData(long j2, int[] iArr, byte[] bArr);

    /* access modifiers changed from: private */
    public static native void nativeInitTextureCallback(long j2, Object obj, boolean z2);

    private static native void nativeSetArrowResId(long j2, boolean z2, int i2);

    private static native void nativeSetBackgroundResId(long j2, int i2);

    private static native void nativeSetCarResId(long j2, int i2);

    public int addVectorItem(AVectorCrossAttr aVectorCrossAttr, final byte[] bArr, int i2) {
        if (aVectorCrossAttr == null || bArr == null || i2 == 0) {
            return -1;
        }
        final int[] iArr = {aVectorCrossAttr.stAreaRect.left, aVectorCrossAttr.stAreaRect.top, aVectorCrossAttr.stAreaRect.right, aVectorCrossAttr.stAreaRect.bottom, aVectorCrossAttr.stAreaColor, aVectorCrossAttr.fArrowBorderWidth, aVectorCrossAttr.stArrowBorderColor, aVectorCrossAttr.fArrowLineWidth, aVectorCrossAttr.stArrowLineColor, aVectorCrossAttr.dayMode};
        if (this.mGLMapView != null) {
            this.mGLMapView.queueEvent(new Runnable() {
                public void run() {
                    int unused = GLCrossVector.nativeAddVectorData(GLCrossVector.this.mNativeInstance, iArr, bArr);
                }
            });
        }
        return 0;
    }

    public void initTextureCallback(final CrossVectorOverlay crossVectorOverlay, final boolean z2) {
        if (this.mGLMapView != null) {
            this.mGLMapView.queueEvent(new Runnable() {
                public void run() {
                    GLCrossVector.nativeInitTextureCallback(GLCrossVector.this.mNativeInstance, crossVectorOverlay, z2);
                }
            });
        }
    }

    public void setArrowResId(boolean z2, int i2) {
        nativeSetArrowResId(this.mNativeInstance, z2, i2);
    }

    public void setBackgroundResId(int i2) {
        nativeSetBackgroundResId(this.mNativeInstance, i2);
    }

    public void setCarResId(int i2) {
        nativeSetCarResId(this.mNativeInstance, i2);
    }
}
