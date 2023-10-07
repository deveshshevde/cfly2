package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

public class AdglMapAnimGroup extends AbstractAdglAnimation {
    public static final int CAMERA_MAX_DEGREE = 80;
    public static final int CAMERA_MIN_DEGREE = 0;
    public static final int MAXMAPLEVEL = 20;
    public static final int MINMAPLEVEL = 3;
    int endZoomDuration;
    boolean hasCheckParams;
    boolean hasMidZoom;
    int midZoomDuration;
    AbstractAdglAnimationParam2V moveParam = null;
    public boolean needMove;
    boolean needRotateCamera;
    boolean needRotateMap;
    boolean needZoom;
    AbstractAdglAnimationParam1V rotateCameraParam = null;
    AbstractAdglAnimationParam1V rotateMapParam = null;
    int startZoomDuration;
    AbstractAdglAnimationParam1V zoomEndParam = null;
    AbstractAdglAnimationParam1V zoomStartParam = null;

    public AdglMapAnimGroup(int i2) {
        reset();
        this.duration = i2;
    }

    public static boolean checkLevel(float f2) {
        return f2 >= 3.0f && f2 <= 20.0f;
    }

    private void initZoomEndParam(float f2, float f3, int i2) {
        if (this.zoomEndParam == null) {
            this.zoomEndParam = new AbstractAdglAnimationParam1V();
        }
        this.zoomEndParam.reset();
        this.zoomEndParam.setInterpolatorType(i2, 1.0f);
        this.zoomEndParam.setToValue(f3);
        this.zoomEndParam.setFromValue(f2);
    }

    private void initZoomStartParam(float f2, int i2) {
        if (this.zoomStartParam == null) {
            this.zoomStartParam = new AbstractAdglAnimationParam1V();
        }
        this.zoomStartParam.reset();
        this.zoomStartParam.setInterpolatorType(i2, 1.0f);
        this.zoomStartParam.setToValue(f2);
    }

    public void commitAnimation(Object obj) {
        this.isOver = true;
        this.hasCheckParams = false;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState != null) {
            if (this.needZoom) {
                if (this.zoomStartParam == null) {
                    this.hasCheckParams = true;
                    return;
                }
                float mapZoomer = gLMapState.getMapZoomer();
                this.zoomStartParam.setFromValue(mapZoomer);
                if (this.hasMidZoom) {
                    float toValue = this.zoomStartParam.getToValue() - mapZoomer;
                    float fromValue = this.zoomEndParam.getFromValue() - this.zoomEndParam.getToValue();
                    if (((double) Math.abs(toValue)) < 1.0E-6d || ((double) Math.abs(fromValue)) < 1.0E-6d) {
                        this.hasMidZoom = false;
                        this.zoomStartParam.setToValue(this.zoomEndParam.getToValue());
                        this.zoomStartParam.needToCaculate();
                        this.zoomEndParam = null;
                    } else {
                        this.zoomStartParam.needToCaculate();
                        this.zoomEndParam.needToCaculate();
                    }
                }
                if (!this.hasMidZoom && ((double) Math.abs(this.zoomStartParam.getFromValue() - this.zoomStartParam.getToValue())) < 1.0E-6d) {
                    this.needZoom = false;
                }
                if (this.needZoom) {
                    if (this.hasMidZoom) {
                        int i2 = (this.duration - this.midZoomDuration) >> 1;
                        this.startZoomDuration = i2;
                        this.endZoomDuration = i2;
                    } else {
                        this.startZoomDuration = this.duration;
                    }
                }
            }
            if (this.needMove && this.moveParam != null) {
                IPoint obtain = IPoint.obtain();
                gLMapState.getMapGeoCenter(obtain);
                int i3 = obtain.x;
                int i4 = obtain.y;
                obtain.recycle();
                this.moveParam.setFromValue((double) i3, (double) i4);
                this.needMove = this.moveParam.needToCaculate();
            }
            if (this.needRotateMap && this.rotateMapParam != null) {
                float mapAngle = gLMapState.getMapAngle();
                float toValue2 = this.rotateMapParam.getToValue();
                if (mapAngle > 180.0f && toValue2 == 0.0f) {
                    toValue2 = 360.0f;
                }
                float f2 = (float) (((int) toValue2) - ((int) mapAngle));
                if (f2 > 180.0f) {
                    toValue2 -= 360.0f;
                } else if (f2 < -180.0f) {
                    toValue2 += 360.0f;
                }
                this.rotateMapParam.setFromValue(mapAngle);
                this.rotateMapParam.setToValue(toValue2);
                this.needRotateMap = this.rotateMapParam.needToCaculate();
            }
            if (this.needRotateCamera && this.rotateCameraParam != null) {
                this.rotateCameraParam.setFromValue(gLMapState.getCameraDegree());
                this.needRotateCamera = this.rotateCameraParam.needToCaculate();
            }
            if (this.needMove || this.needZoom || this.needRotateMap || this.needRotateCamera) {
                this.isOver = false;
            } else {
                this.isOver = true;
            }
            this.hasCheckParams = true;
            this.startTime = SystemClock.uptimeMillis();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doAnimation(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = r8
            com.autonavi.base.ae.gmap.GLMapState r0 = (com.autonavi.base.ae.gmap.GLMapState) r0
            if (r0 != 0) goto L_0x0006
            return
        L_0x0006:
            boolean r1 = r7.hasCheckParams
            if (r1 != 0) goto L_0x000d
            r7.commitAnimation(r8)
        L_0x000d:
            boolean r8 = r7.isOver
            if (r8 == 0) goto L_0x0012
            return
        L_0x0012:
            long r1 = android.os.SystemClock.uptimeMillis()
            long r3 = r7.startTime
            long r1 = r1 - r3
            r7.offsetTime = r1
            int r8 = r7.duration
            float r8 = (float) r8
            r1 = 0
            r2 = 1
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x0027
            r7.isOver = r2
            return
        L_0x0027:
            long r3 = r7.offsetTime
            float r8 = (float) r3
            int r3 = r7.duration
            float r3 = (float) r3
            float r8 = r8 / r3
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0039
            r7.isOver = r2
            r8 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0040
        L_0x0039:
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0040
            r7.isOver = r2
            return
        L_0x0040:
            boolean r1 = r7.needZoom
            if (r1 == 0) goto L_0x00a8
            r0.getMapZoomer()
            boolean r1 = r7.hasMidZoom
            if (r1 == 0) goto L_0x009a
            long r1 = r7.offsetTime
            int r3 = r7.startZoomDuration
            long r3 = (long) r3
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            long r1 = r7.offsetTime
            if (r5 > 0) goto L_0x0067
            float r1 = (float) r1
            int r2 = r7.startZoomDuration
            float r2 = (float) r2
            float r1 = r1 / r2
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V r2 = r7.zoomStartParam
            r2.setNormalizedTime(r1)
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V r1 = r7.zoomStartParam
        L_0x0062:
            float r1 = r1.getCurValue()
            goto L_0x008f
        L_0x0067:
            int r3 = r7.startZoomDuration
            int r4 = r7.midZoomDuration
            int r3 = r3 + r4
            long r3 = (long) r3
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0078
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V r1 = r7.zoomStartParam
            float r1 = r1.getToValue()
            goto L_0x008f
        L_0x0078:
            long r1 = r7.offsetTime
            int r3 = r7.startZoomDuration
            long r3 = (long) r3
            long r1 = r1 - r3
            int r3 = r7.midZoomDuration
            long r3 = (long) r3
            long r1 = r1 - r3
            float r1 = (float) r1
            int r2 = r7.endZoomDuration
            float r2 = (float) r2
            float r1 = r1 / r2
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V r2 = r7.zoomEndParam
            r2.setNormalizedTime(r1)
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V r1 = r7.zoomEndParam
            goto L_0x0062
        L_0x008f:
            boolean r2 = r7.isOver
            if (r2 == 0) goto L_0x00a5
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V r1 = r7.zoomEndParam
            float r1 = r1.getToValue()
            goto L_0x00a5
        L_0x009a:
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V r1 = r7.zoomStartParam
            r1.setNormalizedTime(r8)
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V r1 = r7.zoomStartParam
            float r1 = r1.getCurValue()
        L_0x00a5:
            r0.setMapZoomer(r1)
        L_0x00a8:
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V r1 = r7.moveParam
            if (r1 == 0) goto L_0x00e6
            boolean r2 = r7.needMove
            if (r2 == 0) goto L_0x00e6
            r1.setNormalizedTime(r8)
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V r1 = r7.moveParam
            double r1 = r1.getFromXValue()
            int r1 = (int) r1
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V r2 = r7.moveParam
            double r2 = r2.getFromYValue()
            int r2 = (int) r2
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V r3 = r7.moveParam
            double r3 = r3.getToXValue()
            int r3 = (int) r3
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V r4 = r7.moveParam
            double r4 = r4.getToYValue()
            int r4 = (int) r4
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V r5 = r7.moveParam
            float r5 = r5.getCurMult()
            int r3 = r3 - r1
            float r3 = (float) r3
            float r3 = r3 * r5
            int r3 = (int) r3
            int r4 = r4 - r2
            float r4 = (float) r4
            float r4 = r4 * r5
            int r4 = (int) r4
            int r1 = r1 + r3
            double r5 = (double) r1
            int r2 = r2 + r4
            double r1 = (double) r2
            r0.setMapGeoCenter(r5, r1)
        L_0x00e6:
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V r1 = r7.rotateMapParam
            if (r1 == 0) goto L_0x00fc
            boolean r2 = r7.needRotateMap
            if (r2 == 0) goto L_0x00fc
            r1.setNormalizedTime(r8)
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V r1 = r7.rotateMapParam
            float r1 = r1.getCurValue()
            int r1 = (int) r1
            float r1 = (float) r1
            r0.setMapAngle(r1)
        L_0x00fc:
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V r1 = r7.rotateCameraParam
            if (r1 == 0) goto L_0x0112
            boolean r2 = r7.needRotateCamera
            if (r2 == 0) goto L_0x0112
            r1.setNormalizedTime(r8)
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V r8 = r7.rotateCameraParam
            float r8 = r8.getCurValue()
            int r8 = (int) r8
            float r8 = (float) r8
            r0.setCameraDegree(r8)
        L_0x0112:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup.doAnimation(java.lang.Object):void");
    }

    public boolean isValid() {
        return this.needRotateCamera || this.needRotateMap || this.needMove || this.needZoom;
    }

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.needZoom = false;
        this.needMove = false;
        this.moveParam = null;
        this.needRotateMap = false;
        this.rotateMapParam = null;
        this.hasMidZoom = false;
        this.duration = 0;
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.rotateMapParam;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V2 = this.zoomStartParam;
        if (abstractAdglAnimationParam1V2 != null) {
            abstractAdglAnimationParam1V2.reset();
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V3 = this.zoomEndParam;
        if (abstractAdglAnimationParam1V3 != null) {
            abstractAdglAnimationParam1V3.reset();
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V4 = this.rotateCameraParam;
        if (abstractAdglAnimationParam1V4 != null) {
            abstractAdglAnimationParam1V4.reset();
        }
    }

    public void setDuration(int i2) {
        this.duration = i2;
    }

    public void setToCameraDegree(float f2, int i2) {
        this.needRotateCamera = false;
        if (f2 <= 80.0f && f2 >= 0.0f) {
            this.needRotateCamera = true;
            if (this.rotateCameraParam == null) {
                this.rotateCameraParam = new AbstractAdglAnimationParam1V();
            }
            this.rotateCameraParam.reset();
            this.rotateCameraParam.setInterpolatorType(i2, 1.0f);
            this.rotateCameraParam.setToValue(f2);
        }
    }

    public void setToMapAngle(float f2, int i2) {
        float f3 = f2 % 360.0f;
        this.needRotateMap = true;
        if (this.rotateMapParam == null) {
            this.rotateMapParam = new AbstractAdglAnimationParam1V();
        }
        this.rotateMapParam.reset();
        this.rotateMapParam.setInterpolatorType(i2, 1.0f);
        this.rotateMapParam.setToValue(f3);
    }

    public void setToMapCenterGeo(int i2, int i3, int i4) {
        if (i2 > 0 && i3 > 0) {
            this.needMove = true;
            if (this.moveParam == null) {
                this.moveParam = new AbstractAdglAnimationParam2V();
            }
            this.moveParam.reset();
            this.moveParam.setInterpolatorType(i4, 1.0f);
            this.moveParam.setToValue((double) i2, (double) i3);
        }
    }

    public void setToMapLevel(float f2, float f3, int i2) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (i2 > 0 && i2 < this.duration) {
            this.midZoomDuration = i2;
        }
        if (checkLevel(f2) && checkLevel(f3)) {
            this.hasMidZoom = true;
            initZoomStartParam(f3, 0);
            initZoomEndParam(f3, f2, 0);
        } else if (checkLevel(f2)) {
            this.hasMidZoom = false;
            initZoomStartParam(f2, 0);
        } else if (checkLevel(f3)) {
            this.hasMidZoom = false;
            initZoomStartParam(f3, 0);
        } else {
            this.needZoom = false;
        }
    }

    public void setToMapLevel(float f2, int i2) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (checkLevel(f2)) {
            initZoomStartParam(f2, i2);
        } else {
            this.needZoom = false;
        }
    }

    public boolean typeEqueal(AdglMapAnimGroup adglMapAnimGroup) {
        return this.needRotateCamera == adglMapAnimGroup.needRotateCamera && this.needRotateMap == adglMapAnimGroup.needRotateMap && this.needZoom == adglMapAnimGroup.needZoom && this.needMove == adglMapAnimGroup.needMove;
    }
}
