package com.autonavi.base.ae.gmap;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.mapcore.FPoint;

public class GLMapState implements IGLMapState {
    private boolean isNewInstance = false;
    private long nativeEngineInstance = 0;
    private long nativeStateInstance = 0;

    public GLMapState(int i2, long j2) {
        if (j2 != 0) {
            this.nativeEngineInstance = j2;
            this.nativeStateInstance = nativeNewInstance(i2, j2);
            this.isNewInstance = true;
        }
    }

    public GLMapState(long j2, long j3) {
        if (j2 != 0) {
            this.nativeEngineInstance = j2;
            this.nativeStateInstance = j3;
            this.isNewInstance = true;
        }
    }

    public static float calMapZoomScalefactor(int i2, int i3, int i4) {
        return nativeCalMapZoomScalefactor(i2, i3, (float) i4);
    }

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

    public static native float nativeCalMapZoomScalefactor(int i2, int i3, float f2);

    public static native float nativeCalculateMapZoomer(long j2, int i2, int i3, int i4, int i5, int i6);

    public static native float nativeGetCameraDegree(long j2);

    public static native float nativeGetGLUnitWithWin(long j2, int i2);

    public static native float nativeGetMapAngle(long j2);

    public static native void nativeGetMapCenter(long j2, Point point);

    public static native double nativeGetMapCenterXDouble(long j2);

    public static native double nativeGetMapCenterYDouble(long j2);

    public static native float nativeGetMapZoomer(long j2);

    public static native void nativeGetPixel20Bound(long j2, Rect rect, int i2, int i3);

    public static native void nativeGetProjectionMatrix(long j2, float[] fArr);

    public static native float nativeGetSkyHeight(long j2);

    public static native void nativeGetViewMatrix(long j2, float[] fArr);

    public static native long nativeNewInstance(int i2, long j2);

    public static native void nativeP20ToScreenPoint(long j2, int i2, int i3, int i4, PointF pointF);

    public static native void nativeRecalculate(long j2);

    public static native void nativeScreenToP20Point(long j2, float f2, float f3, Point point);

    public static native void nativeSetCameraDegree(long j2, float f2);

    public static native void nativeSetMapAngle(long j2, float f2);

    public static native void nativeSetMapCenter(long j2, double d2, double d3);

    private static native void nativeSetMapState(int i2, long j2, long j3);

    public static native void nativeSetMapZoomer(long j2, float f2);

    public static native void nativeStateDestroy(long j2, long j3);

    public float calculateMapZoomer(int i2, int i3, int i4, int i5, int i6) {
        long j2 = this.nativeStateInstance;
        if (j2 != 0) {
            return nativeCalculateMapZoomer(j2, i2, i3, i4, i5, i6);
        }
        return 3.0f;
    }

    public float getCameraDegree() {
        long j2 = this.nativeStateInstance;
        if (j2 != 0) {
            return nativeGetCameraDegree(j2);
        }
        return 0.0f;
    }

    public float getGLUnitWithWin(int i2) {
        long j2 = this.nativeStateInstance;
        if (j2 != 0) {
            return nativeGetGLUnitWithWin(j2, i2);
        }
        return 0.0f;
    }

    public float getMapAngle() {
        long j2 = this.nativeStateInstance;
        if (j2 != 0) {
            return nativeGetMapAngle(j2);
        }
        return 0.0f;
    }

    public DPoint getMapGeoCenter() {
        DPoint dPoint = new DPoint();
        dPoint.f10009x = nativeGetMapCenterXDouble(this.nativeStateInstance);
        dPoint.f10010y = nativeGetMapCenterYDouble(this.nativeStateInstance);
        return dPoint;
    }

    public void getMapGeoCenter(IPoint iPoint) {
        nativeGetMapCenter(this.nativeStateInstance, iPoint);
    }

    public double getMapGeoCenterX() {
        return nativeGetMapCenterXDouble(this.nativeStateInstance);
    }

    public double getMapGeoCenterY() {
        return nativeGetMapCenterXDouble(this.nativeStateInstance);
    }

    public float getMapLenWithWin(int i2) {
        return getGLUnitWithWin(i2);
    }

    public float getMapZoomer() {
        long j2 = this.nativeStateInstance;
        if (j2 != 0) {
            return nativeGetMapZoomer(j2);
        }
        return 0.0f;
    }

    public long getNativeInstance() {
        return this.nativeStateInstance;
    }

    public void getPixel20Bound(Rect rect, int i2, int i3) {
        long j2 = this.nativeStateInstance;
        if (j2 != 0) {
            nativeGetPixel20Bound(j2, rect, i2, i3);
        }
    }

    public void getProjectionMatrix(float[] fArr) {
        if (fArr != null && fArr.length == 16) {
            nativeGetProjectionMatrix(this.nativeStateInstance, fArr);
        }
    }

    public float getSkyHeight() {
        long j2 = this.nativeStateInstance;
        if (j2 != 0) {
            return nativeGetSkyHeight(j2);
        }
        return 0.0f;
    }

    public void getViewMatrix(float[] fArr) {
        if (fArr != null && fArr.length == 16) {
            nativeGetViewMatrix(this.nativeStateInstance, fArr);
        }
    }

    public void p20ToScreenPoint(int i2, int i3, FPoint fPoint) {
        long j2 = this.nativeStateInstance;
        if (j2 != 0) {
            nativeP20ToScreenPoint(j2, i2, i3, 0, fPoint);
        }
    }

    public void recalculate() {
        long j2 = this.nativeStateInstance;
        if (j2 != 0) {
            nativeRecalculate(j2);
        }
    }

    public void recycle() {
        long j2 = this.nativeStateInstance;
        if (j2 != 0 && this.isNewInstance) {
            nativeStateDestroy(j2, this.nativeEngineInstance);
        }
        this.nativeStateInstance = 0;
    }

    public void reset() {
        if (this.nativeStateInstance != 0) {
            recycle();
        }
        long j2 = this.nativeEngineInstance;
        if (j2 != 0) {
            this.nativeStateInstance = nativeNewInstance(1, j2);
        }
    }

    public void screenToP20Point(int i2, int i3, Point point) {
        long j2 = this.nativeStateInstance;
        if (j2 != 0) {
            nativeScreenToP20Point(j2, (float) i2, (float) i3, point);
        }
    }

    public void setCameraDegree(float f2) {
        long j2 = this.nativeStateInstance;
        if (j2 != 0) {
            nativeSetCameraDegree(j2, f2);
        }
    }

    public void setMapAngle(float f2) {
        long j2 = this.nativeStateInstance;
        if (j2 != 0) {
            nativeSetMapAngle(j2, f2);
        }
    }

    public void setMapGeoCenter(double d2, double d3) {
        long j2 = this.nativeStateInstance;
        if (j2 != 0) {
            nativeSetMapCenter(j2, d2, d3);
        }
    }

    public void setMapZoomer(float f2) {
        long j2 = this.nativeStateInstance;
        if (j2 != 0) {
            nativeSetMapZoomer(j2, f2);
        }
    }

    public void setNativeMapengineState(int i2, long j2) {
        if (j2 != 0) {
            long j3 = this.nativeStateInstance;
            if (j3 != 0) {
                this.nativeEngineInstance = j2;
                nativeSetMapState(i2, j2, j3);
            }
        }
    }

    public String toString() {
        return "instance: " + this.nativeStateInstance + " center: " + getMapGeoCenter().f10009x + " , " + getMapGeoCenter().f10010y + " bearing:" + getCameraDegree() + "  tilt:" + getMapAngle() + "  zoom:" + getMapZoomer() + "  ";
    }
}
