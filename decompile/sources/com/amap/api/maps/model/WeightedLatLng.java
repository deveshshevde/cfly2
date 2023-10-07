package com.amap.api.maps.model;

import com.amap.api.mapcore.util.dl;
import com.autonavi.amap.mapcore.DPoint;
import fg.i;

public class WeightedLatLng {
    public static final double DEFAULT_INTENSITY = 1.0d;
    public final double intensity;
    public final LatLng latLng;
    private DPoint mPoint;

    public WeightedLatLng(LatLng latLng2) {
        this(latLng2, 1.0d);
    }

    public WeightedLatLng(LatLng latLng2, double d2) {
        if (latLng2 != null) {
            this.latLng = latLng2;
            this.mPoint = dl.a(latLng2);
            if (d2 >= i.f27244a) {
                this.intensity = d2;
            } else {
                this.intensity = 1.0d;
            }
        } else {
            throw new IllegalArgumentException("latLng can not null");
        }
    }

    /* access modifiers changed from: protected */
    public DPoint getPoint() {
        return this.mPoint;
    }
}
