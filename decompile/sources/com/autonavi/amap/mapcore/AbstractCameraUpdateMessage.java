package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.amap.api.mapcore.util.dl;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import fg.i;

public abstract class AbstractCameraUpdateMessage {
    public float amount;
    public int anchorX;
    public int anchorY;
    public float bearing = Float.NaN;
    public LatLngBounds bounds;
    public CameraPosition cameraPosition;
    public float curZoolScale = 0.0f;
    public Point focus = null;
    public DPoint geoPoint;
    public int height;
    public boolean isChangeFinished;
    public boolean isUseAnchor = false;
    public AMap.CancelableCallback mCallback;
    public long mDuration = 250;
    public IMapConfig mapConfig;
    public float maxZoomLevel = 0.0f;
    public float minZoomLevel = 0.0f;
    public Type nowType = Type.none;
    public int paddingBottom;
    public int paddingLeft;
    public int paddingRight;
    public int paddingTop;
    public float tilt = Float.NaN;
    public int width;
    public float xPixel;
    public float yPixel;
    public float zoom = Float.NaN;

    public enum Type {
        none,
        zoomIn,
        changeCenter,
        changeTilt,
        changeBearing,
        changeBearingGeoCenter,
        changeGeoCenterZoom,
        zoomOut,
        zoomTo,
        zoomBy,
        scrollBy,
        newCameraPosition,
        newLatLngBounds,
        newLatLngBoundsWithSize,
        changeGeoCenterZoomTiltBearing
    }

    /* access modifiers changed from: protected */
    public void changeCenterByAnchor(IGLMapState iGLMapState, DPoint dPoint) {
        changeCenterByAnchor(iGLMapState, dPoint, this.anchorX, this.anchorY);
    }

    /* access modifiers changed from: protected */
    public void changeCenterByAnchor(IGLMapState iGLMapState, DPoint dPoint, int i2, int i3) {
        iGLMapState.recalculate();
        Point anchorGeoPoint = getAnchorGeoPoint(iGLMapState, i2, i3);
        DPoint mapGeoCenter = iGLMapState.getMapGeoCenter();
        double d2 = mapGeoCenter.f10009x + dPoint.f10009x;
        double d3 = (double) anchorGeoPoint.x;
        Double.isNaN(d3);
        double d4 = (double) anchorGeoPoint.y;
        Double.isNaN(d4);
        iGLMapState.setMapGeoCenter(d2 - d3, (mapGeoCenter.f10010y + dPoint.f10010y) - d4);
    }

    public void generateMapAnimation(IGLMapEngine iGLMapEngine) {
        IGLMapState newMapState = iGLMapEngine.getNewMapState(1);
        runCameraUpdate(newMapState);
        DPoint mapGeoCenter = newMapState.getMapGeoCenter();
        iGLMapEngine.addGroupAnimation(1, (int) this.mDuration, newMapState.getMapZoomer(), (int) newMapState.getMapAngle(), (int) newMapState.getCameraDegree(), (int) mapGeoCenter.f10009x, (int) mapGeoCenter.f10010y, this.mCallback);
        newMapState.recycle();
    }

    /* access modifiers changed from: protected */
    public Point getAnchorGeoPoint(IGLMapState iGLMapState, int i2, int i3) {
        Point point = new Point();
        iGLMapState.screenToP20Point(i2, i3, point);
        return point;
    }

    public abstract void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage);

    /* access modifiers changed from: protected */
    public void normalChange(IGLMapState iGLMapState) {
        this.zoom = Float.isNaN(this.zoom) ? iGLMapState.getMapZoomer() : this.zoom;
        this.bearing = Float.isNaN(this.bearing) ? iGLMapState.getMapAngle() : this.bearing;
        this.tilt = Float.isNaN(this.tilt) ? iGLMapState.getCameraDegree() : this.tilt;
        float a2 = dl.a(this.mapConfig, this.zoom);
        this.zoom = a2;
        this.tilt = dl.a(this.mapConfig, this.tilt, a2);
        double d2 = (double) this.bearing;
        Double.isNaN(d2);
        this.bearing = (float) (((d2 % 360.0d) + 360.0d) % 360.0d);
        Point point = this.focus;
        if (point != null && this.geoPoint == null) {
            Point anchorGeoPoint = getAnchorGeoPoint(iGLMapState, point.x, this.focus.y);
            this.geoPoint = new DPoint((double) anchorGeoPoint.x, (double) anchorGeoPoint.y);
        }
        if (!Float.isNaN(this.zoom)) {
            iGLMapState.setMapZoomer(this.zoom);
        }
        if (!Float.isNaN(this.bearing)) {
            iGLMapState.setMapAngle(this.bearing);
        }
        if (!Float.isNaN(this.tilt)) {
            iGLMapState.setCameraDegree(this.tilt);
        }
        Point point2 = this.focus;
        if (point2 != null) {
            changeCenterByAnchor(iGLMapState, this.geoPoint, point2.x, this.focus.y);
            return;
        }
        DPoint dPoint = this.geoPoint;
        if ((dPoint == null || (dPoint.f10009x == i.f27244a && this.geoPoint.f10010y == i.f27244a)) ? false : true) {
            iGLMapState.setMapGeoCenter(this.geoPoint.f10009x, this.geoPoint.f10010y);
        }
    }

    public abstract void runCameraUpdate(IGLMapState iGLMapState);
}
