package com.amap.api.maps;

import android.graphics.Point;
import android.util.Log;
import com.amap.api.mapcore.util.z;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

public final class CameraUpdateFactory {
    private static final String CLASSNAME = "CameraUpdateFactory";

    public static CameraUpdate changeBearing(float f2) {
        return new CameraUpdate(z.d(f2 % 360.0f));
    }

    public static CameraUpdate changeBearingGeoCenter(float f2, IPoint iPoint) {
        if (iPoint != null) {
            return new CameraUpdate(z.b(f2 % 360.0f, new Point(iPoint.x, iPoint.y)));
        }
        Log.w(CLASSNAME, "geoPoint is null");
        return new CameraUpdate(z.c());
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        if (latLng != null) {
            return new CameraUpdate(z.a(VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20)));
        }
        Log.w(CLASSNAME, "target is null");
        return new CameraUpdate(z.c());
    }

    public static CameraUpdate changeTilt(float f2) {
        return new CameraUpdate(z.c(f2));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition != null) {
            return new CameraUpdate(z.a(cameraPosition));
        }
        Log.w(CLASSNAME, "cameraPosition is null");
        return new CameraUpdate(z.c());
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        if (latLng != null) {
            return new CameraUpdate(z.a(latLng));
        }
        Log.w(CLASSNAME, "latLng is null");
        return new CameraUpdate(z.c());
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i2) {
        if (latLngBounds != null) {
            return new CameraUpdate(z.a(latLngBounds, i2));
        }
        Log.w(CLASSNAME, "bounds is null");
        return new CameraUpdate(z.c());
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i2, int i3, int i4) {
        if (latLngBounds != null) {
            return new CameraUpdate(z.a(latLngBounds, i2, i3, i4));
        }
        Log.w(CLASSNAME, "bounds is null");
        return new CameraUpdate(z.c());
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i2, int i3, int i4, int i5) {
        if (latLngBounds != null) {
            return new CameraUpdate(z.a(latLngBounds, i2, i3, i4, i5));
        }
        Log.w(CLASSNAME, "bounds is null");
        return new CameraUpdate(z.c());
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f2) {
        if (latLng != null) {
            return new CameraUpdate(z.a(latLng, f2));
        }
        Log.w(CLASSNAME, "target is null");
        return new CameraUpdate(z.c());
    }

    public static CameraUpdate scrollBy(float f2, float f3) {
        return new CameraUpdate(z.a(f2, f3));
    }

    public static CameraUpdate zoomBy(float f2) {
        return new CameraUpdate(z.b(f2));
    }

    public static CameraUpdate zoomBy(float f2, Point point) {
        return new CameraUpdate(z.a(f2, point));
    }

    public static CameraUpdate zoomIn() {
        return new CameraUpdate(z.a());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(z.b());
    }

    public static CameraUpdate zoomTo(float f2) {
        return new CameraUpdate(z.a(f2));
    }
}
