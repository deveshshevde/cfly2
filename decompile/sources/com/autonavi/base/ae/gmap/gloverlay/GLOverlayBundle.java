package com.autonavi.base.ae.gmap.gloverlay;

import android.util.SparseArray;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;
import java.util.List;

public class GLOverlayBundle<E extends BaseMapOverlay<?, ?>> {
    private int mEngineID;
    private long mNativeInstance = 0;
    private final List<E> mOverlayList = new ArrayList();
    private SparseArray<GLOverlayTexture> mTextureCaches = new SparseArray<>();

    public static class GLAmapFocusHits {
        public long mHitedIndex = 0;
        public long mHitedTimes = 1000;
        public long mOverlayHashCode = 0;
    }

    public GLOverlayBundle(int i2, IAMapDelegate iAMapDelegate) {
        this.mEngineID = i2;
        if (iAMapDelegate != null) {
            try {
                this.mNativeInstance = iAMapDelegate.getGLMapEngine().getGlOverlayMgrPtr(this.mEngineID);
            } catch (Throwable unused) {
            }
        }
    }

    private int getOverlyExType(E e2) {
        return 0;
    }

    public static void intClr2PVRClr(float[] fArr, int i2) {
        fArr[2] = ((float) (i2 & 255)) / 255.0f;
        fArr[1] = ((float) ((i2 >> 8) & 255)) / 255.0f;
        fArr[0] = ((float) ((i2 >> 16) & 255)) / 255.0f;
        fArr[3] = ((float) ((i2 >> 24) & 255)) / 255.0f;
    }

    private static native void nativeAddGLOverlay(long j2, long j3, long j4);

    private static native void nativeAddGLOverlayEx(long j2, long j3, long j4, int i2);

    private static native void nativeClearAllGLOverlay(long j2, boolean z2);

    private static native boolean nativeOnSingleTapLineOverlay(long j2, int i2, int i3, long[] jArr);

    private static native boolean nativeOnSingleTapPointOverlay(long j2, int i2, int i3, long[] jArr);

    private static native void nativeRemoveGLOverlay(long j2, long j3);

    private static native void nativeRemoveGLOverlayEx(long j2, long j3, int i2);

    private static native void nativeSortAllGLOverlay(long j2);

    public void addOverlay(E e2) {
        if (e2 != null) {
            nativeAddGLOverlay(this.mNativeInstance, e2.getGLOverlay().getNativeInstatnce(), (long) e2.getGLOverlay().getCode());
            e2.getGLOverlay().mIsInBundle = true;
            synchronized (this.mOverlayList) {
                this.mOverlayList.add(e2);
            }
        }
    }

    public boolean addOverlayTextureItem(int i2, int i3, float f2, float f3, int i4, int i5) {
        GLOverlayTexture gLOverlayTexture = new GLOverlayTexture(i2, i3, f2, f3, i4, i5);
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.put(i2, gLOverlayTexture);
        }
        return true;
    }

    public boolean addOverlayTextureItem(int i2, int i3, int i4, int i5) {
        GLOverlayTexture gLOverlayTexture = new GLOverlayTexture(i2, i3, i4, i5);
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.put(i2, gLOverlayTexture);
        }
        return true;
    }

    public long checkSingleTapOnLine(int i2, int i3) {
        long[] jArr = new long[3];
        if (nativeOnSingleTapLineOverlay(this.mNativeInstance, i2, i3, jArr)) {
            return jArr[0];
        }
        return -1;
    }

    public long checkSingleTapOnPoint(int i2, int i3) {
        long[] jArr = new long[3];
        if (nativeOnSingleTapPointOverlay(this.mNativeInstance, i2, i3, jArr)) {
            return jArr[0];
        }
        return -1;
    }

    public void clearFocus() {
        List<E> list = this.mOverlayList;
        if (list != null) {
            synchronized (list) {
                for (int i2 = 0; i2 < this.mOverlayList.size(); i2++) {
                    BaseMapOverlay baseMapOverlay = (BaseMapOverlay) this.mOverlayList.get(i2);
                    if (baseMapOverlay != null) {
                        baseMapOverlay.clearFocus();
                    }
                }
            }
        }
    }

    public void clearOverlayTexture() {
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.clear();
        }
    }

    public boolean cotainsOverlay(E e2) {
        boolean contains;
        if (e2 == null) {
            return false;
        }
        synchronized (this.mOverlayList) {
            contains = this.mOverlayList.contains(e2);
        }
        return contains;
    }

    public E getOverlay(int i2) {
        synchronized (this.mOverlayList) {
            if (i2 >= 0) {
                if (i2 <= this.mOverlayList.size() - 1) {
                    E e2 = (BaseMapOverlay) this.mOverlayList.get(i2);
                    return e2;
                }
            }
            return null;
        }
    }

    public int getOverlayCount() {
        int size;
        synchronized (this.mOverlayList) {
            size = this.mOverlayList.size();
        }
        return size;
    }

    public GLOverlayTexture getOverlayTextureItem(int i2) {
        GLOverlayTexture gLOverlayTexture;
        synchronized (this.mTextureCaches) {
            gLOverlayTexture = this.mTextureCaches.get(i2);
        }
        return gLOverlayTexture;
    }

    public boolean onSingleTap(int i2, int i3, int i4, int i5) {
        boolean onSingleTapPoints = (i5 & 1) == 1 ? onSingleTapPoints(i2, i3, i4) : false;
        if (onSingleTapPoints) {
            return true;
        }
        if ((i5 & 2) == 2) {
            onSingleTapPoints = onSingleTapLines(i2, i3, i4);
        }
        return onSingleTapPoints;
    }

    /* access modifiers changed from: package-private */
    public boolean onSingleTapLines(int i2, int i3, int i4) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean onSingleTapPoints(int i2, int i3, int i4) {
        return false;
    }

    public void reculateRouteBoard(IAMapDelegate iAMapDelegate) {
    }

    public void removeAll(boolean z2) {
        nativeClearAllGLOverlay(this.mNativeInstance, z2);
        synchronized (this.mOverlayList) {
            for (int i2 = 0; i2 < this.mOverlayList.size(); i2++) {
                BaseMapOverlay baseMapOverlay = (BaseMapOverlay) this.mOverlayList.get(i2);
                if (baseMapOverlay != null) {
                    baseMapOverlay.getGLOverlay().mIsInBundle = false;
                    baseMapOverlay.getGLOverlay().releaseInstance();
                }
            }
            this.mOverlayList.clear();
        }
    }

    public void removeOverlay(E e2) {
        if (e2 != null) {
            nativeRemoveGLOverlay(this.mNativeInstance, e2.getGLOverlay().getNativeInstatnce());
            e2.getGLOverlay().mIsInBundle = false;
            synchronized (this.mOverlayList) {
                this.mOverlayList.remove(e2);
            }
        }
    }

    public void sortOverlay() {
        nativeSortAllGLOverlay(this.mNativeInstance);
    }
}
