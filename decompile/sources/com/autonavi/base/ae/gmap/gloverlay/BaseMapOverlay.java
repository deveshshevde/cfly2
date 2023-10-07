package com.autonavi.base.ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public abstract class BaseMapOverlay<T extends GLOverlay, E> implements Serializable {
    private static final long serialVersionUID = 1;
    protected Context mContext;
    protected int mEngineID = 1;
    protected T mGLOverlay;
    protected Vector<E> mItemList = null;
    protected int mLastFocusedIndex;
    protected IAMapDelegate mMapView;

    public BaseMapOverlay(int i2, Context context, IAMap iAMap) {
        this.mEngineID = i2;
        this.mContext = context;
        try {
            this.mMapView = (IAMapDelegate) iAMap;
        } catch (Throwable unused) {
        }
        this.mItemList = new Vector<>();
        iniGLOverlay();
    }

    public abstract void addItem(E e2);

    public boolean clear() {
        try {
            this.mItemList.clear();
            clearFocus();
            T t2 = this.mGLOverlay;
            if (t2 == null) {
                return true;
            }
            t2.removeAll();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void clearFocus() {
        this.mLastFocusedIndex = -1;
        this.mGLOverlay.clearFocus();
    }

    public T getGLOverlay() {
        return this.mGLOverlay;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final E getItem(int r4) {
        /*
            r3 = this;
            r0 = 0
            java.util.Vector<E> r1 = r3.mItemList     // Catch:{ IndexOutOfBoundsException -> 0x001e }
            monitor-enter(r1)     // Catch:{ IndexOutOfBoundsException -> 0x001e }
            if (r4 < 0) goto L_0x0019
            java.util.Vector<E> r2 = r3.mItemList     // Catch:{ all -> 0x001b }
            int r2 = r2.size()     // Catch:{ all -> 0x001b }
            int r2 = r2 + -1
            if (r4 <= r2) goto L_0x0011
            goto L_0x0019
        L_0x0011:
            java.util.Vector<E> r2 = r3.mItemList     // Catch:{ all -> 0x001b }
            java.lang.Object r4 = r2.get(r4)     // Catch:{ all -> 0x001b }
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return r4
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return r0
        L_0x001b:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r4     // Catch:{ IndexOutOfBoundsException -> 0x001e }
        L_0x001e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay.getItem(int):java.lang.Object");
    }

    public List<E> getItems() {
        return this.mItemList;
    }

    public int getSize() {
        return this.mItemList.size();
    }

    /* access modifiers changed from: protected */
    public abstract void iniGLOverlay();

    public boolean isClickable() {
        T t2 = this.mGLOverlay;
        if (t2 != null) {
            return t2.isClickable();
        }
        return false;
    }

    public boolean isVisible() {
        T t2 = this.mGLOverlay;
        if (t2 != null) {
            return t2.isVisible();
        }
        return false;
    }

    public void releaseInstance() {
        if (getGLOverlay() != null) {
            IAMapDelegate iAMapDelegate = this.mMapView;
            if (iAMapDelegate != null && iAMapDelegate.isMaploaded()) {
                this.mMapView.removeEngineGLOverlay(this);
            }
            getGLOverlay().releaseInstance();
            this.mGLOverlay = null;
        }
    }

    public boolean removeAll() {
        return clear();
    }

    public void removeItem(int i2) {
        if (i2 >= 0) {
            try {
                if (i2 <= this.mItemList.size() - 1) {
                    if (i2 == this.mLastFocusedIndex) {
                        this.mLastFocusedIndex = -1;
                        clearFocus();
                    }
                    this.mItemList.remove(i2);
                    T t2 = this.mGLOverlay;
                    if (t2 != null) {
                        t2.removeItem(i2);
                    }
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }

    public void removeItem(E e2) {
        if (e2 != null) {
            try {
                synchronized (this.mItemList) {
                    removeItem(this.mItemList.indexOf(e2));
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }

    public abstract void resumeMarker(Bitmap bitmap);

    public void setClickable(boolean z2) {
        T t2 = this.mGLOverlay;
        if (t2 != null) {
            t2.setClickable(z2);
        }
    }

    public abstract void setVisible(boolean z2);
}
