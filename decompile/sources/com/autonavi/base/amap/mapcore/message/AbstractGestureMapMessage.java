package com.autonavi.base.amap.mapcore.message;

import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.AbstractMapMessage;
import com.autonavi.base.ae.gmap.GLMapState;

public abstract class AbstractGestureMapMessage extends AbstractMapMessage {
    public int anchorX;
    public int anchorY;
    public int height = 0;
    public boolean isGestureScaleByMapCenter = false;
    public boolean isUseAnchor = false;
    private int state = 0;
    public int width = 0;

    public AbstractGestureMapMessage(int i2) {
        this.state = i2;
    }

    /* access modifiers changed from: protected */
    public IPoint getAnchorGeoPoint(GLMapState gLMapState, int i2, int i3) {
        IPoint obtain = IPoint.obtain();
        gLMapState.screenToP20Point(i2, i3, obtain);
        return obtain;
    }

    public int getMapGestureState() {
        return this.state;
    }

    public abstract int getType();

    public void reset() {
        this.width = 0;
        this.height = 0;
        this.state = 0;
        this.isGestureScaleByMapCenter = false;
        this.isUseAnchor = false;
        this.anchorX = 0;
        this.anchorY = 0;
    }

    public abstract void runCameraUpdate(GLMapState gLMapState);

    public void setState(int i2) {
        this.state = i2;
    }

    /* access modifiers changed from: protected */
    public void win2geo(GLMapState gLMapState, int i2, int i3, IPoint iPoint) {
        gLMapState.screenToP20Point(i2, i3, iPoint);
    }
}
