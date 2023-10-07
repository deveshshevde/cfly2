package com.amap.api.mapcore.util;

import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

public final class y extends AbstractCameraUpdateMessage {
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        abstractCameraUpdateMessage.zoom += this.amount;
    }

    public final void runCameraUpdate(IGLMapState iGLMapState) {
        this.zoom = iGLMapState.getMapZoomer() + this.amount;
        this.zoom = dl.a(this.mapConfig, this.zoom);
        normalChange(iGLMapState);
    }
}
