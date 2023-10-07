package com.amap.api.mapcore.util;

import com.amap.api.maps.model.LatLng;
import fg.i;

public final class dg {
    private static double a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d2 = latLng.latitude - latLng3.latitude;
        return ((latLng.longitude - latLng2.longitude) * (latLng.latitude - latLng2.latitude)) - ((latLng.longitude - latLng2.longitude) * d2);
    }

    public static boolean a(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4) {
        LatLng latLng5 = latLng;
        LatLng latLng6 = latLng2;
        LatLng latLng7 = latLng3;
        LatLng latLng8 = latLng4;
        double a2 = a(latLng7, latLng8, latLng5);
        double a3 = a(latLng7, latLng8, latLng6);
        double a4 = a(latLng, latLng2, latLng3);
        double a5 = a(latLng5, latLng6, latLng8);
        if (((a2 > i.f27244a && a3 < i.f27244a) || (a2 < i.f27244a && a3 > i.f27244a)) && ((a4 > i.f27244a && a5 < i.f27244a) || (a4 < i.f27244a && a5 > i.f27244a))) {
            return true;
        }
        if (a2 == i.f27244a && b(latLng7, latLng8, latLng5)) {
            return true;
        }
        if (a3 == i.f27244a && b(latLng7, latLng8, latLng6)) {
            return true;
        }
        if (a4 != i.f27244a || !b(latLng, latLng2, latLng3)) {
            return a5 == i.f27244a && b(latLng5, latLng6, latLng8);
        }
        return true;
    }

    private static boolean b(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d2 = latLng.longitude - latLng2.longitude > i.f27244a ? latLng.longitude : latLng2.longitude;
        return (((latLng.longitude - latLng2.longitude) > i.f27244a ? 1 : ((latLng.longitude - latLng2.longitude) == i.f27244a ? 0 : -1)) < 0 ? latLng.longitude : latLng2.longitude) <= latLng3.longitude && latLng3.longitude <= d2 && (((latLng.latitude - latLng2.latitude) > i.f27244a ? 1 : ((latLng.latitude - latLng2.latitude) == i.f27244a ? 0 : -1)) < 0 ? latLng.latitude : latLng2.latitude) <= latLng3.latitude && latLng3.latitude <= (((latLng.latitude - latLng2.latitude) > i.f27244a ? 1 : ((latLng.latitude - latLng2.latitude) == i.f27244a ? 0 : -1)) > 0 ? latLng.latitude : latLng2.latitude);
    }
}
