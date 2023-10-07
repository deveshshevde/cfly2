package com.amap.api.mapcore.util;

import android.util.Pair;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;

public final class v extends AbstractCameraUpdateMessage {
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    public final void runCameraUpdate(IGLMapState iGLMapState) {
        Pair<Float, IPoint> a2 = dl.a((AbstractCameraUpdateMessage) this, this.mapConfig);
        if (a2 != null) {
            iGLMapState.setMapZoomer(((Float) a2.first).floatValue());
            iGLMapState.setMapGeoCenter((double) ((IPoint) a2.second).x, (double) ((IPoint) a2.second).y);
            iGLMapState.setCameraDegree(0.0f);
            iGLMapState.setMapAngle(0.0f);
        }
    }
}
