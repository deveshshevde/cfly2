package com.autonavi.amap.api.mapcore;

import com.amap.api.maps.AMap;

public interface IGLMapEngine {
    void addGroupAnimation(int i2, int i3, float f2, int i4, int i5, int i6, int i7, AMap.CancelableCallback cancelableCallback);

    IGLMapState getNewMapState(int i2);
}
