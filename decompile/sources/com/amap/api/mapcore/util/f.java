package com.amap.api.mapcore.util;

import android.location.Location;
import com.amap.api.maps.LocationSource;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

final class f implements LocationSource.OnLocationChangedListener {

    /* renamed from: a  reason: collision with root package name */
    Location f8731a;

    /* renamed from: b  reason: collision with root package name */
    private IAMapDelegate f8732b;

    f(IAMapDelegate iAMapDelegate) {
        this.f8732b = iAMapDelegate;
    }

    public final void onLocationChanged(Location location) {
        this.f8731a = location;
        try {
            if (this.f8732b.isMyLocationEnabled()) {
                this.f8732b.showMyLocationOverlay(location);
            }
        } catch (Throwable th) {
            fz.c(th, "AMapOnLocationChangedListener", "onLocationChanged");
            th.printStackTrace();
        }
    }
}
