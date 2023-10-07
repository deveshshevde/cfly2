package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.autonavi.ae.gmap.maploader.Pools;

public class IPoint extends Point implements Cloneable {
    private static final Pools.SynchronizedPool<IPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    public IPoint() {
    }

    public IPoint(int i2, int i3) {
        this.x = i2;
        this.y = i3;
    }

    public static IPoint obtain() {
        IPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new IPoint();
        }
        acquire.set(0, 0);
        return acquire;
    }

    public static IPoint obtain(int i2, int i3) {
        IPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new IPoint(i2, i3);
        }
        acquire.set(i2, i3);
        return acquire;
    }

    public Object clone() {
        try {
            return (IPoint) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void recycle() {
        M_POOL.release(this);
    }
}
