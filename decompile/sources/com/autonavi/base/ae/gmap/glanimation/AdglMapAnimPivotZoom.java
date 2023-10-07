package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

public class AdglMapAnimPivotZoom extends AbstractAdglAnimation {
    private int beginCenterGeoX;
    private int beginCenterGeoY;
    private boolean hasCheckParams;
    private float mapLevelTo;
    private int pivotGeoX;
    private int pivotGeoY;
    private float winPivotX;
    private float winPivotY;
    private boolean zoomCenter;
    AbstractAdglAnimationParam1V zoomParam = null;

    public AdglMapAnimPivotZoom(int i2) {
        reset();
        this.duration = i2;
    }

    public void commitAnimation(Object obj) {
        this.isOver = true;
        this.hasCheckParams = false;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState != null) {
            float mapZoomer = gLMapState.getMapZoomer();
            if (((double) Math.abs(this.mapLevelTo - mapZoomer)) < 1.0E-6d) {
                this.isOver = true;
                this.hasCheckParams = true;
                return;
            }
            this.zoomParam.setFromValue(mapZoomer);
            this.zoomParam.setToValue(this.mapLevelTo);
            if (!this.zoomCenter) {
                IPoint obtain = IPoint.obtain();
                gLMapState.getMapGeoCenter(obtain);
                this.beginCenterGeoX = obtain.x;
                this.beginCenterGeoY = obtain.y;
                IPoint obtain2 = IPoint.obtain();
                gLMapState.screenToP20Point((int) this.winPivotX, (int) this.winPivotY, obtain2);
                this.pivotGeoX = obtain2.x;
                this.pivotGeoY = obtain2.y;
                obtain.recycle();
                obtain2.recycle();
            }
            this.hasCheckParams = true;
            this.isOver = false;
            this.startTime = SystemClock.uptimeMillis();
        }
    }

    public void doAnimation(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState != null) {
            if (!this.hasCheckParams) {
                commitAnimation(obj);
            }
            if (!this.isOver) {
                this.offsetTime = SystemClock.uptimeMillis() - this.startTime;
                float f2 = ((float) this.offsetTime) / ((float) this.duration);
                if (f2 > 1.0f) {
                    this.isOver = true;
                    f2 = 1.0f;
                }
                if (f2 >= 0.0f && f2 <= 1.0f) {
                    this.zoomParam.setNormalizedTime(f2);
                    float curValue = this.zoomParam.getCurValue();
                    if (curValue > 20.0f) {
                        this.isOver = true;
                        curValue = 20.0f;
                    }
                    if (curValue < 3.0f) {
                        this.isOver = true;
                        curValue = 3.0f;
                    }
                    if (!this.zoomCenter) {
                        float pow = (float) Math.pow(2.0d, (double) (curValue - this.zoomParam.getFromValue()));
                        int i2 = this.pivotGeoX;
                        int i3 = this.beginCenterGeoX;
                        float f3 = 1.0f - (1.0f / pow);
                        int i4 = (int) (((float) (i2 - i3)) * f3);
                        int i5 = this.pivotGeoY;
                        int i6 = this.beginCenterGeoY;
                        gLMapState.setMapGeoCenter((double) (i3 + i4), (double) (i6 + ((int) (((float) (i5 - i6)) * f3))));
                    }
                    gLMapState.setMapZoomer(curValue);
                }
            }
        }
    }

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.zoomCenter = true;
        this.mapLevelTo = 0.0f;
        this.beginCenterGeoX = 0;
        this.beginCenterGeoY = 0;
        this.pivotGeoX = 0;
        this.pivotGeoY = 0;
        this.winPivotX = 0.0f;
        this.winPivotY = 0.0f;
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.zoomParam;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
    }

    public void setToMapZoomAndPivot(float f2, int i2, Point point) {
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = new AbstractAdglAnimationParam1V();
        this.zoomParam = abstractAdglAnimationParam1V;
        abstractAdglAnimationParam1V.setInterpolatorType(i2, 1.0f);
        if (f2 > 20.0f) {
            f2 = 20.0f;
        }
        if (f2 < 3.0f) {
            f2 = 3.0f;
        }
        this.mapLevelTo = f2;
        if (point != null) {
            this.winPivotX = (float) point.x;
            this.winPivotY = (float) point.y;
            this.zoomCenter = false;
        }
    }
}
