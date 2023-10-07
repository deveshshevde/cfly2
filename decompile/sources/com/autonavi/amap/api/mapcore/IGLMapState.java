package com.autonavi.amap.api.mapcore;

import android.graphics.Point;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;

public interface IGLMapState {
    float calculateMapZoomer(int i2, int i3, int i4, int i5, int i6);

    float getCameraDegree();

    float getMapAngle();

    DPoint getMapGeoCenter();

    void getMapGeoCenter(IPoint iPoint);

    float getMapZoomer();

    void recalculate();

    void recycle();

    void screenToP20Point(int i2, int i3, Point point);

    void setCameraDegree(float f2);

    void setMapAngle(float f2);

    void setMapGeoCenter(double d2, double d3);

    void setMapZoomer(float f2);
}
