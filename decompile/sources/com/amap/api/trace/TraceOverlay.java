package com.amap.api.trace;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;

public class TraceOverlay {
    public static final int TRACE_STATUS_FAILURE = 3;
    public static final int TRACE_STATUS_FINISH = 2;
    public static final int TRACE_STATUS_PREPARE = 4;
    public static final int TRACE_STATUS_PROCESSING = 1;

    /* renamed from: a  reason: collision with root package name */
    private Polyline f9857a;

    /* renamed from: b  reason: collision with root package name */
    private PolylineOptions f9858b;

    /* renamed from: c  reason: collision with root package name */
    private AMap f9859c;

    /* renamed from: d  reason: collision with root package name */
    private List<LatLng> f9860d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private int f9861e = 4;

    /* renamed from: f  reason: collision with root package name */
    private int f9862f;

    /* renamed from: g  reason: collision with root package name */
    private int f9863g;

    public TraceOverlay(AMap aMap) {
        this.f9859c = aMap;
        a();
    }

    public TraceOverlay(AMap aMap, List<LatLng> list) {
        this.f9859c = aMap;
        a();
        this.f9860d = list;
        this.f9858b.addAll(list);
        this.f9857a = aMap.addPolyline(this.f9858b);
    }

    private PolylineOptions a() {
        if (this.f9858b == null) {
            PolylineOptions polylineOptions = new PolylineOptions();
            this.f9858b = polylineOptions;
            polylineOptions.setCustomTexture(BitmapDescriptorFactory.fromAsset("tracelinetexture.png"));
            this.f9858b.width(40.0f);
        }
        return this.f9858b;
    }

    public void add(List<LatLng> list) {
        if (list != null && list.size() != 0) {
            this.f9860d.addAll(list);
            a();
            if (this.f9857a == null) {
                this.f9857a = this.f9859c.addPolyline(this.f9858b);
            }
            Polyline polyline = this.f9857a;
            if (polyline != null) {
                polyline.setPoints(this.f9860d);
            }
        }
    }

    public int getDistance() {
        return this.f9862f;
    }

    public int getTraceStatus() {
        return this.f9861e;
    }

    public int getWaitTime() {
        return this.f9863g;
    }

    public void remove() {
        Polyline polyline = this.f9857a;
        if (polyline != null) {
            polyline.remove();
        }
    }

    public void setDistance(int i2) {
        this.f9862f = i2;
    }

    public void setProperCamera(List<LatLng> list) {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        if (list != null && list.size() != 0) {
            for (LatLng include : list) {
                builder.include(include);
            }
            try {
                this.f9859c.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 20));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setTraceStatus(int i2) {
        this.f9861e = i2;
    }

    public void setWaitTime(int i2) {
        this.f9863g = i2;
    }

    public void zoopToSpan() {
        setProperCamera(this.f9858b.getPoints());
    }
}
