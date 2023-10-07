package com.autonavi.base.ae.gmap.gloverlay;

import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

public abstract class GLOverlay {
    protected boolean isNightStyle = false;
    protected int mCode;
    protected int mEngineID;
    protected IAMapDelegate mGLMapView;
    boolean mIsInBundle = false;
    protected int mItemPriority = 0;
    protected long mNativeInstance = 0;

    public enum EAMapOverlayTpye {
        AMAPOVERLAY_POINT,
        AMAPOVERLAY_POLYLINE,
        AMAPOVERLAY_POLYGON,
        AMAPOVERLAY_ARC,
        AMAPOVERLAY_ARROW,
        AMAPOVERLAY_VECTOR,
        AMAPOVERLAY_GROUP,
        AMAPOVERLAY_MODEL,
        AMAPOVERLAY_PLANE
    }

    public GLOverlay(int i2, IAMapDelegate iAMapDelegate, int i3) {
        this.mEngineID = i2;
        this.mGLMapView = iAMapDelegate;
        this.mCode = i3;
        this.mNativeInstance = 0;
        this.mItemPriority = 0;
    }

    private static native int nativeGetCount(long j2);

    private static native int nativeGetOverlayPriority(long j2);

    private static native int nativeGetSubType(long j2);

    private static native int nativeGetType(long j2);

    private static native boolean nativeIsClickable(long j2);

    private static native boolean nativeIsVisible(long j2);

    private static native void nativeRemoveAll(long j2);

    private static native void nativeRemoveItem(long j2, int i2);

    private static native void nativeSetClickable(long j2, boolean z2);

    private static native void nativeSetMaxDisplayLevel(long j2, float f2);

    private static native void nativeSetMinDisplayLevel(long j2, float f2);

    private static native void nativeSetOverlayItemPriority(long j2, int i2);

    private static native void nativeSetOverlayOnTop(long j2, boolean z2);

    private static native void nativeSetOverlayPriority(long j2, int i2);

    private static native void nativeSetShownMaxCount(long j2, int i2);

    protected static native void nativeSetVisible(long j2, boolean z2);

    public void clearFocus() {
    }

    public int getCode() {
        return this.mCode;
    }

    public boolean getIsInBundle() {
        return this.mIsInBundle;
    }

    public long getNativeInstatnce() {
        return this.mNativeInstance;
    }

    public int getOverlayPriority() {
        return nativeGetOverlayPriority(this.mNativeInstance);
    }

    public int getSize() {
        long j2 = this.mNativeInstance;
        if (j2 == 0) {
            return 0;
        }
        return nativeGetCount(j2);
    }

    public int getSubType() {
        long j2 = this.mNativeInstance;
        if (j2 == 0) {
            return -1;
        }
        return nativeGetSubType(j2);
    }

    public int getType() {
        long j2 = this.mNativeInstance;
        if (j2 == 0) {
            return -1;
        }
        return nativeGetType(j2);
    }

    public boolean isClickable() {
        long j2 = this.mNativeInstance;
        if (j2 == 0) {
            return false;
        }
        return nativeIsClickable(j2);
    }

    public boolean isVisible() {
        long j2 = this.mNativeInstance;
        if (j2 == 0) {
            return false;
        }
        return nativeIsVisible(j2);
    }

    /* access modifiers changed from: package-private */
    public void releaseInstance() {
        if (this.mNativeInstance != 0) {
            this.mNativeInstance = 0;
        }
    }

    public void removeAll() {
        long j2 = this.mNativeInstance;
        if (j2 != 0) {
            nativeRemoveAll(j2);
        }
    }

    public void removeItem(int i2) {
        long j2 = this.mNativeInstance;
        if (j2 != 0) {
            nativeRemoveItem(j2, i2);
        }
    }

    public void setClickable(boolean z2) {
        long j2 = this.mNativeInstance;
        if (j2 != 0) {
            nativeSetClickable(j2, z2);
        }
    }

    public void setMaxCountShown(int i2) {
        nativeSetShownMaxCount(this.mNativeInstance, i2);
    }

    public void setMaxDisplayLevel(float f2) {
        nativeSetMaxDisplayLevel(this.mNativeInstance, f2);
    }

    public void setMinDisplayLevel(float f2) {
        nativeSetMinDisplayLevel(this.mNativeInstance, f2);
    }

    public void setOverlayItemPriority(int i2) {
        this.mItemPriority = i2;
    }

    public void setOverlayOnTop(boolean z2) {
        nativeSetOverlayOnTop(this.mNativeInstance, z2);
    }

    public void setOverlayPriority(int i2) {
        GLOverlayBundle overlayBundle;
        nativeSetOverlayPriority(this.mNativeInstance, i2);
        IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate != null && iAMapDelegate.getGLMapEngine() != null && (overlayBundle = this.mGLMapView.getGLMapEngine().getOverlayBundle(this.mEngineID)) != null) {
            overlayBundle.sortOverlay();
        }
    }

    public void setVisible(boolean z2) {
        long j2 = this.mNativeInstance;
        if (j2 != 0) {
            nativeSetVisible(j2, z2);
        }
    }

    public void useNightStyle(boolean z2) {
        this.isNightStyle = z2;
    }
}
