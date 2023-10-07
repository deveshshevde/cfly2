package com.autonavi.base.ae.gmap.listener;

public interface AMapWidgetListener {
    void invalidateCompassView();

    void invalidateScaleView();

    void invalidateZoomController(float f2);

    void setFrontViewVisibility(boolean z2);
}
