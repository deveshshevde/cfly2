package com.autonavi.base.amap.mapcore;

import android.util.Log;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.autonavi.base.amap.mapcore.annotations.ParameterIsClass;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AMapNativeGlOverlayLayer extends NativeBase {
    protected long mNative = 0;
    private NativeFunCallListener nativeFunCallListener;
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public interface NativeFunCallListener {
        BitmapDescriptor getBuildInImageData(int i2);

        BitmapDescriptor getInfoContents(String str);

        BitmapDescriptor getInfoWindow(String str);

        BitmapDescriptor getInfoWindowClick(String str);

        long getInfoWindowUpdateOffsetTime(String str);

        BitmapDescriptor getOverturnInfoWindow(String str);

        BitmapDescriptor getOverturnInfoWindowClick(String str);

        void onRedrawInfowindow();

        void onSetRunLowFrame(boolean z2);
    }

    private BitmapDescriptor getBuildInImageData(int i2) {
        NativeFunCallListener nativeFunCallListener2 = this.nativeFunCallListener;
        if (nativeFunCallListener2 != null) {
            return nativeFunCallListener2.getBuildInImageData(i2);
        }
        return null;
    }

    private BitmapDescriptor getInfoContents(String str) {
        NativeFunCallListener nativeFunCallListener2 = this.nativeFunCallListener;
        if (nativeFunCallListener2 != null) {
            return nativeFunCallListener2.getInfoContents(str);
        }
        return null;
    }

    private BitmapDescriptor getInfoWindow(String str) {
        NativeFunCallListener nativeFunCallListener2 = this.nativeFunCallListener;
        if (nativeFunCallListener2 != null) {
            return nativeFunCallListener2.getInfoWindow(str);
        }
        return null;
    }

    private BitmapDescriptor getInfoWindowClick(String str) {
        NativeFunCallListener nativeFunCallListener2 = this.nativeFunCallListener;
        if (nativeFunCallListener2 != null) {
            return nativeFunCallListener2.getInfoWindowClick(str);
        }
        return null;
    }

    private long getInfoWindowUpdateOffsetTime(String str) {
        NativeFunCallListener nativeFunCallListener2 = this.nativeFunCallListener;
        if (nativeFunCallListener2 != null) {
            return nativeFunCallListener2.getInfoWindowUpdateOffsetTime(str);
        }
        return 0;
    }

    private BitmapDescriptor getOverturnInfoWindow(String str) {
        NativeFunCallListener nativeFunCallListener2 = this.nativeFunCallListener;
        if (nativeFunCallListener2 != null) {
            return nativeFunCallListener2.getOverturnInfoWindow(str);
        }
        return null;
    }

    private BitmapDescriptor getOverturnInfoWindowClick(String str) {
        NativeFunCallListener nativeFunCallListener2 = this.nativeFunCallListener;
        if (nativeFunCallListener2 != null) {
            return nativeFunCallListener2.getOverturnInfoWindowClick(str);
        }
        return null;
    }

    private native void nativeClear(String[] strArr);

    private native String nativeContain(Object obj, int i2);

    private native void nativeCreate(long j2);

    private native void nativeCreateOverlay(String str, Object obj);

    private native void nativeDestroy();

    private native void nativeFinalize();

    private native int nativeGetCurrentParticleNum(String str);

    private native Object nativeGetNativeOverlayProperties(String str, String str2, Object[] objArr);

    private native void nativeRemoveOverlay(String str);

    private native void nativeRender(int i2, int i3, boolean z2);

    private native void nativeSetAMapEngine(long j2);

    private native void nativeUpdateConfig(Object obj, float f2);

    private native void nativeUpdateOptions(String str, Object obj);

    private void redrawInfoWindow() {
        NativeFunCallListener nativeFunCallListener2 = this.nativeFunCallListener;
        if (nativeFunCallListener2 != null) {
            nativeFunCallListener2.onRedrawInfowindow();
        }
    }

    /* access modifiers changed from: private */
    public void setRunLowFrame(boolean z2) {
        NativeFunCallListener nativeFunCallListener2 = this.nativeFunCallListener;
        if (nativeFunCallListener2 != null) {
            nativeFunCallListener2.onSetRunLowFrame(z2);
        }
    }

    @ParameterIsClass
    public void clear(final String... strArr) {
        if (!isReady()) {
            storeUncallFunctionArray(this, new Runnable() {
                public void run() {
                    AMapNativeGlOverlayLayer.this.clear(strArr);
                }
            }, strArr);
            return;
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            nativeClear(strArr);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public String contain(LatLng latLng, int i2) {
        if (!isReady()) {
            return "";
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            return nativeContain(latLng, i2);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public void createNative() {
    }

    public void createNative(long j2) {
        try {
            if (this.mNative == 0) {
                try {
                    ReentrantReadWriteLock reentrantReadWriteLock = this.readWriteLock;
                    if (reentrantReadWriteLock != null) {
                        reentrantReadWriteLock.writeLock().lock();
                    }
                    nativeCreate(j2);
                    ReentrantReadWriteLock reentrantReadWriteLock2 = this.readWriteLock;
                    if (reentrantReadWriteLock2 != null) {
                        reentrantReadWriteLock2.writeLock().unlock();
                    }
                } catch (Throwable unused) {
                    ReentrantReadWriteLock reentrantReadWriteLock3 = this.readWriteLock;
                    if (reentrantReadWriteLock3 != null) {
                        reentrantReadWriteLock3.writeLock().unlock();
                    }
                }
            }
        } catch (UnsatisfiedLinkError e2) {
            getClass().getSimpleName();
            e2.toString();
        }
    }

    public void createOverlay(final String str, final BaseOptions baseOptions) {
        if (!isReady()) {
            storeUncallFunction(this, new Runnable() {
                public void run() {
                    AMapNativeGlOverlayLayer.this.createOverlay(str, baseOptions);
                }
            }, str, baseOptions);
            return;
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            nativeCreateOverlay(str, baseOptions);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public void destroy() {
        try {
            super.destroy();
            this.readWriteLock.writeLock().lock();
            nativeDestroy();
        } finally {
            this.readWriteLock.writeLock().unlock();
        }
    }

    /* access modifiers changed from: protected */
    public void finalizeNative() {
        nativeFinalize();
    }

    public int getCurrentParticleNum(String str) {
        if (!isReady()) {
            return 0;
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            return nativeGetCurrentParticleNum(str);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    /* access modifiers changed from: protected */
    public long getNative() {
        return this.mNative;
    }

    public Object getNativeProperties(final String str, final String str2, final Object[] objArr) {
        if (!isReady() || str == null) {
            storeUncallFunction(this, new Runnable() {
                public void run() {
                    AMapNativeGlOverlayLayer.this.getNativeProperties(str, str2, objArr);
                }
            }, str, str2, objArr);
            return null;
        }
        try {
            this.readWriteLock.readLock().lock();
            if (this.destroy) {
                return null;
            }
            Object nativeGetNativeOverlayProperties = nativeGetNativeOverlayProperties(str, str2, objArr);
            this.readWriteLock.readLock().unlock();
            return nativeGetNativeOverlayProperties;
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    @ParameterIsClass
    public void removeOverlay(final String str) {
        if (!isReady()) {
            storeUncallFunction(this, new Runnable() {
                public void run() {
                    AMapNativeGlOverlayLayer.this.removeOverlay(str);
                }
            }, str);
            return;
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            nativeRemoveOverlay(str);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public void render(int i2, int i3, boolean z2) {
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            nativeRender(i2, i3, z2);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public void setAMapEngine(long j2) {
        try {
            this.readWriteLock.readLock().lock();
            nativeSetAMapEngine(j2);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    @ParameterIsClass
    public void setConfig(final MapConfig mapConfig, final Float f2) {
        if (!isReady()) {
            storeUncallFunction(this, new Runnable() {
                public void run() {
                    AMapNativeGlOverlayLayer.this.setConfig(mapConfig, f2);
                }
            }, mapConfig, f2);
            return;
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            nativeUpdateConfig(mapConfig, f2.floatValue());
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public void setNativeFunCallListener(NativeFunCallListener nativeFunCallListener2) {
        this.nativeFunCallListener = nativeFunCallListener2;
    }

    @ParameterIsClass
    public void updateOptions(final String str, final BaseOptions baseOptions) {
        try {
            if (!isReady()) {
                storeUncallFunction(this, new Runnable() {
                    public void run() {
                        AMapNativeGlOverlayLayer.this.updateOptions(str, baseOptions);
                        BaseOptions baseOptions = baseOptions;
                        if (baseOptions != null) {
                            baseOptions.resetUpdateFlags();
                        }
                        AMapNativeGlOverlayLayer.this.setRunLowFrame(false);
                    }
                }, str, baseOptions);
                return;
            }
            callAllFunction();
            this.readWriteLock.readLock().lock();
            nativeUpdateOptions(str, baseOptions);
            if (baseOptions != null) {
                baseOptions.resetUpdateFlags();
            }
            this.readWriteLock.readLock().unlock();
        } catch (Throwable th) {
            th.printStackTrace();
            Log.d("amapApi", "AMapNativeGlOverlayLayer updateOptions error:" + th.getMessage());
        }
    }
}
