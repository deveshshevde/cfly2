package com.autonavi.base.amap.mapcore;

import android.graphics.PointF;
import com.autonavi.ae.gmap.maploader.Pools;

public class FPoint extends PointF {
    private static final Pools.SynchronizedPool<FPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    public FPoint() {
    }

    public FPoint(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public static FPoint obtain() {
        FPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new FPoint();
        }
        acquire.set(0.0f, 0.0f);
        return acquire;
    }

    public static FPoint obtain(float f2, float f3) {
        FPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new FPoint(f2, f3);
        }
        acquire.set(f2, f3);
        return acquire;
    }

    public boolean equals(Object obj) {
        FPoint fPoint = (FPoint) obj;
        return fPoint != null && this.x == fPoint.x && this.y == fPoint.y;
    }

    public int hashCode() {
        Float.floatToIntBits(this.x);
        return Float.floatToIntBits(this.y) * 37;
    }

    public void recycle() {
        M_POOL.release(this);
    }
}
