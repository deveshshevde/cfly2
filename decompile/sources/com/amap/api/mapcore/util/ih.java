package com.amap.api.mapcore.util;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;

public final class ih implements AMapLocationListener {

    /* renamed from: a  reason: collision with root package name */
    public Inner_3dMap_locationListener f9228a = null;

    public final void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        this.f9228a = inner_3dMap_locationListener;
    }

    public final void onLocationChanged(AMapLocation aMapLocation) {
        try {
            Inner_3dMap_location a2 = iu.a(aMapLocation);
            if (jd.a(a2)) {
                iu.f9359a = a2;
            }
            Inner_3dMap_locationListener inner_3dMap_locationListener = this.f9228a;
            if (inner_3dMap_locationListener != null) {
                inner_3dMap_locationListener.onLocationChanged(a2);
            }
        } catch (Throwable th) {
            io.a(th, "LocationListener", "onLocationChanged");
        }
    }
}
