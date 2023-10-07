package com.autonavi.base.amap.mapcore.message;

import com.autonavi.ae.gmap.maploader.Pools;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

public class ScaleGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<ScaleGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public int pivotX = 0;
    public int pivotY = 0;
    public float scaleDelta = 0.0f;

    public ScaleGestureMapMessage(int i2, float f2, int i3, int i4) {
        super(i2);
        setParams(i2, f2, i3, i4);
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static ScaleGestureMapMessage obtain(int i2, float f2, int i3, int i4) {
        ScaleGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            return new ScaleGestureMapMessage(i2, f2, i3, i4);
        }
        acquire.reset();
        acquire.setParams(i2, f2, i3, i4);
        return acquire;
    }

    private void setMapZoomer(GLMapState gLMapState) {
        gLMapState.setMapZoomer(gLMapState.getMapZoomer() + this.scaleDelta);
        gLMapState.recalculate();
    }

    private void setParams(int i2, float f2, int i3, int i4) {
        setState(i2);
        this.scaleDelta = f2;
        this.pivotX = i3;
        this.pivotY = i4;
    }

    public int getType() {
        return 1;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public void runCameraUpdate(GLMapState gLMapState) {
        IPoint iPoint;
        if (this.isUseAnchor) {
            setMapZoomer(gLMapState);
            return;
        }
        int i2 = this.pivotX;
        int i3 = this.pivotY;
        if (this.isGestureScaleByMapCenter) {
            i2 = this.width >> 1;
            i3 = this.height >> 1;
        }
        IPoint iPoint2 = null;
        if (i2 > 0 || i3 > 0) {
            iPoint2 = IPoint.obtain();
            iPoint = IPoint.obtain();
            win2geo(gLMapState, i2, i3, iPoint2);
            gLMapState.setMapGeoCenter((double) iPoint2.x, (double) iPoint2.y);
        } else {
            iPoint = null;
        }
        setMapZoomer(gLMapState);
        if (i2 > 0 || i3 > 0) {
            win2geo(gLMapState, i2, i3, iPoint);
            if (iPoint2 != null) {
                gLMapState.setMapGeoCenter((double) ((iPoint2.x * 2) - iPoint.x), (double) ((iPoint2.y * 2) - iPoint.y));
            }
            gLMapState.recalculate();
        }
        if (iPoint2 != null) {
            iPoint2.recycle();
        }
        if (iPoint != null) {
            iPoint.recycle();
        }
    }
}
