package com.autonavi.base.amap.mapcore.message;

import com.autonavi.ae.gmap.maploader.Pools;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

public class MoveGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<MoveGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(1024);
    static int newCount;
    public float touchDeltaX = 0.0f;
    public float touchDeltaY = 0.0f;

    public MoveGestureMapMessage(int i2, float f2, float f3) {
        super(i2);
        this.touchDeltaX = f2;
        this.touchDeltaY = f3;
        newCount++;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static synchronized MoveGestureMapMessage obtain(int i2, float f2, float f3) {
        MoveGestureMapMessage acquire;
        synchronized (MoveGestureMapMessage.class) {
            acquire = M_POOL.acquire();
            if (acquire == null) {
                acquire = new MoveGestureMapMessage(i2, f2, f3);
            } else {
                acquire.reset();
                acquire.setParams(i2, f2, f3);
            }
        }
        return acquire;
    }

    private void setParams(int i2, float f2, float f3) {
        setState(i2);
        this.touchDeltaX = f2;
        this.touchDeltaY = f3;
    }

    public int getType() {
        return 0;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public void runCameraUpdate(GLMapState gLMapState) {
        int i2 = (int) this.touchDeltaX;
        int i3 = (int) this.touchDeltaY;
        float f2 = (float) (this.width >> 1);
        float f3 = (float) (this.height >> 1);
        if (this.isUseAnchor) {
            f2 = (float) this.anchorX;
            f3 = (float) this.anchorY;
        }
        IPoint obtain = IPoint.obtain();
        win2geo(gLMapState, (int) (f2 - ((float) i2)), (int) (f3 - ((float) i3)), obtain);
        gLMapState.setMapGeoCenter((double) obtain.x, (double) obtain.y);
        gLMapState.recalculate();
        obtain.recycle();
    }
}
