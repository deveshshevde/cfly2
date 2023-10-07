package com.autonavi.amap.mapcore;

import android.graphics.Point;

public class MapProjection {
    public static void geo2LonLat(int i2, int i3, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) i2, (long) i3, 20);
        dPoint.f10009x = pixelsToLatLong.f10009x;
        dPoint.f10010y = pixelsToLatLong.f10010y;
        pixelsToLatLong.recycle();
    }

    public static void lonlat2Geo(double d2, double d3, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d3, d2, 20);
        iPoint.x = latLongToPixels.x;
        iPoint.y = latLongToPixels.y;
    }
}
