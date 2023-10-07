package com.autonavi.base.amap.mapcore.message;

import com.autonavi.ae.gmap.maploader.Pools;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

public class RotateGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<RotateGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public float angleDelta = 0.0f;
    public int pivotX = 0;
    public int pivotY = 0;

    public RotateGestureMapMessage(int i2, float f2, int i3, int i4) {
        super(i2);
        setParams(i2, f2, i3, i4);
        this.angleDelta = f2;
        this.pivotX = i3;
        this.pivotY = i4;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static RotateGestureMapMessage obtain(int i2, float f2, int i3, int i4) {
        RotateGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            return new RotateGestureMapMessage(i2, f2, i3, i4);
        }
        acquire.reset();
        acquire.setParams(i2, f2, i3, i4);
        return acquire;
    }

    private void setParams(int i2, float f2, int i3, int i4) {
        setState(i2);
        this.angleDelta = f2;
        this.pivotX = i3;
        this.pivotY = i4;
    }

    public int getType() {
        return 2;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public void runCameraUpdate(GLMapState gLMapState) {
        IPoint iPoint;
        float mapAngle = gLMapState.getMapAngle() + this.angleDelta;
        if (this.isGestureScaleByMapCenter) {
            gLMapState.setMapAngle(mapAngle);
            gLMapState.recalculate();
            return;
        }
        int i2 = this.pivotX;
        int i3 = this.pivotY;
        if (this.isUseAnchor) {
            i2 = this.anchorX;
            i3 = this.anchorY;
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
        gLMapState.setMapAngle(mapAngle);
        gLMapState.recalculate();
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
