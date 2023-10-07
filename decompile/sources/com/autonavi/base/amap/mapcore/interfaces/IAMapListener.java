package com.autonavi.base.amap.mapcore.interfaces;

import com.autonavi.base.ae.gmap.GLMapState;

public interface IAMapListener {
    void afterAnimation();

    void afterDrawFrame(int i2, GLMapState gLMapState);

    void afterDrawLabel(int i2, GLMapState gLMapState);

    void afterRendererOver(int i2, GLMapState gLMapState);

    void beforeDrawLabel(int i2, GLMapState gLMapState);
}
