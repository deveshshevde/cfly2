package com.amap.api.mapcore.util;

import android.graphics.Point;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

public final class x extends AbstractCameraUpdateMessage {
    private static void a(IGLMapState iGLMapState, int i2, int i3, Point point) {
        iGLMapState.screenToP20Point(i2, i3, point);
    }

    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    public final void runCameraUpdate(IGLMapState iGLMapState) {
        float f2 = this.xPixel;
        float f3 = this.yPixel;
        float f4 = (((float) this.width) / 2.0f) + f2;
        float f5 = (((float) this.height) / 2.0f) + f3;
        Point point = new Point();
        a(iGLMapState, (int) f4, (int) f5, point);
        iGLMapState.setMapGeoCenter((double) point.x, (double) point.y);
    }
}
