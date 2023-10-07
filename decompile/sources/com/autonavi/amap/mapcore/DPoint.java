package com.autonavi.amap.mapcore;

import com.autonavi.ae.gmap.maploader.Pools;
import fg.i;

public class DPoint {
    private static final Pools.SynchronizedPool<DPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    /* renamed from: x  reason: collision with root package name */
    public double f10009x;

    /* renamed from: y  reason: collision with root package name */
    public double f10010y;

    public DPoint() {
    }

    public DPoint(double d2, double d3) {
        this.f10009x = d2;
        this.f10010y = d3;
    }

    public static DPoint obtain() {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint();
        }
        acquire.set(i.f27244a, i.f27244a);
        return acquire;
    }

    public static DPoint obtain(double d2, double d3) {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint(d2, d3);
        }
        acquire.set(d2, d3);
        return acquire;
    }

    private void set(double d2, double d3) {
        this.f10009x = d2;
        this.f10010y = d3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DPoint)) {
            return false;
        }
        DPoint dPoint = (DPoint) obj;
        return Double.doubleToLongBits(this.f10009x) == Double.doubleToLongBits(dPoint.f10009x) && Double.doubleToLongBits(this.f10010y) == Double.doubleToLongBits(dPoint.f10010y);
    }

    public void recycle() {
        M_POOL.release(this);
    }
}
