package com.amap.api.mapcore.util;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

public final class z {
    public static AbstractCameraUpdateMessage a() {
        y yVar = new y();
        yVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        yVar.amount = 1.0f;
        return yVar;
    }

    public static AbstractCameraUpdateMessage a(float f2) {
        w wVar = new w();
        wVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        wVar.zoom = f2;
        return wVar;
    }

    public static AbstractCameraUpdateMessage a(float f2, float f3) {
        x xVar = new x();
        xVar.nowType = AbstractCameraUpdateMessage.Type.scrollBy;
        xVar.xPixel = f2;
        xVar.yPixel = f3;
        return xVar;
    }

    public static AbstractCameraUpdateMessage a(float f2, Point point) {
        y yVar = new y();
        yVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        yVar.amount = f2;
        yVar.focus = point;
        return yVar;
    }

    public static AbstractCameraUpdateMessage a(Point point) {
        w wVar = new w();
        wVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        wVar.geoPoint = new DPoint((double) point.x, (double) point.y);
        return wVar;
    }

    public static AbstractCameraUpdateMessage a(CameraPosition cameraPosition) {
        w wVar = new w();
        wVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        if (!(cameraPosition == null || cameraPosition.target == null)) {
            DPoint latLongToPixelsDouble = VirtualEarthProjection.latLongToPixelsDouble(cameraPosition.target.latitude, cameraPosition.target.longitude, 20);
            wVar.geoPoint = new DPoint(latLongToPixelsDouble.f10009x, latLongToPixelsDouble.f10010y);
            wVar.zoom = cameraPosition.zoom;
            wVar.bearing = cameraPosition.bearing;
            wVar.tilt = cameraPosition.tilt;
            wVar.cameraPosition = cameraPosition;
        }
        return wVar;
    }

    public static AbstractCameraUpdateMessage a(LatLng latLng) {
        return a(CameraPosition.builder().target(latLng).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage a(LatLng latLng, float f2) {
        return a(CameraPosition.builder().target(latLng).zoom(f2).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i2) {
        v vVar = new v();
        vVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        vVar.bounds = latLngBounds;
        vVar.paddingLeft = i2;
        vVar.paddingRight = i2;
        vVar.paddingTop = i2;
        vVar.paddingBottom = i2;
        return vVar;
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i2, int i3, int i4) {
        v vVar = new v();
        vVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
        vVar.bounds = latLngBounds;
        vVar.paddingLeft = i4;
        vVar.paddingRight = i4;
        vVar.paddingTop = i4;
        vVar.paddingBottom = i4;
        vVar.width = i2;
        vVar.height = i3;
        return vVar;
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i2, int i3, int i4, int i5) {
        v vVar = new v();
        vVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        vVar.bounds = latLngBounds;
        vVar.paddingLeft = i2;
        vVar.paddingRight = i3;
        vVar.paddingTop = i4;
        vVar.paddingBottom = i5;
        return vVar;
    }

    public static AbstractCameraUpdateMessage b() {
        y yVar = new y();
        yVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        yVar.amount = -1.0f;
        return yVar;
    }

    public static AbstractCameraUpdateMessage b(float f2) {
        return a(f2, (Point) null);
    }

    public static AbstractCameraUpdateMessage b(float f2, Point point) {
        w wVar = new w();
        wVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        wVar.geoPoint = new DPoint((double) point.x, (double) point.y);
        wVar.bearing = f2;
        return wVar;
    }

    public static AbstractCameraUpdateMessage c() {
        return new w();
    }

    public static AbstractCameraUpdateMessage c(float f2) {
        w wVar = new w();
        wVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        wVar.tilt = f2;
        return wVar;
    }

    public static AbstractCameraUpdateMessage d(float f2) {
        w wVar = new w();
        wVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        wVar.bearing = f2;
        return wVar;
    }
}
