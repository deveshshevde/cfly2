package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

public class AdglMapAnimFling extends AbstractAdglAnimation {
    private IPoint fromCenter;
    private boolean hasCheckParams;
    private int lastMoveX;
    private int lastMoveY;
    private AbstractAdglAnimationParam2V moveParam = null;
    private boolean needMove;
    private int screenCenterX;
    private int screenCenterY;
    private float velocityX;
    private float velocityY;

    public AdglMapAnimFling(int i2, int i3, int i4) {
        this.screenCenterX = i3;
        this.screenCenterY = i4;
        this.lastMoveX = i3;
        this.lastMoveY = i4;
        reset();
        this.duration = i2;
    }

    public void commitAnimation(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState != null) {
            this.hasCheckParams = false;
            this.isOver = true;
            int i2 = (int) ((this.velocityX * ((float) this.duration)) / 2000.0f);
            int i3 = (int) ((this.velocityY * ((float) this.duration)) / 2000.0f);
            if (!(Math.abs(i2) == 0 || Math.abs(i3) == 0)) {
                if (this.fromCenter == null) {
                    this.fromCenter = IPoint.obtain();
                }
                gLMapState.getMapGeoCenter(this.fromCenter);
                this.isOver = false;
                this.moveParam.setFromValue((double) this.screenCenterX, (double) this.screenCenterY);
                this.moveParam.setToValue((double) (this.screenCenterX - i2), (double) (this.screenCenterY - i3));
                this.needMove = this.moveParam.needToCaculate();
            }
            this.hasCheckParams = true;
            this.startTime = SystemClock.uptimeMillis();
        }
    }

    public void commitAnimationold(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState != null) {
            this.hasCheckParams = false;
            this.isOver = true;
            float f2 = this.velocityX;
            float f3 = this.velocityY;
            float sqrt = ((float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)))) / 1000.0f;
            if (sqrt >= 0.1f) {
                float f4 = sqrt * 0.02f;
                if (this.fromCenter == null) {
                    this.fromCenter = IPoint.obtain();
                }
                gLMapState.getMapGeoCenter(this.fromCenter);
                this.isOver = false;
                this.moveParam.setFromValue((double) this.screenCenterX, (double) this.screenCenterY);
                this.moveParam.setToValue((double) (((float) this.screenCenterX) - (this.velocityX * f4)), (double) (((float) this.screenCenterY) - (this.velocityY * f4)));
                this.needMove = this.moveParam.needToCaculate();
            }
            this.hasCheckParams = true;
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
                if (f2 >= 0.0f && f2 <= 1.0f && this.needMove) {
                    this.moveParam.setNormalizedTime(f2);
                    int curXValue = (int) this.moveParam.getCurXValue();
                    int curYValue = (int) this.moveParam.getCurYValue();
                    IPoint obtain = IPoint.obtain();
                    gLMapState.screenToP20Point((this.screenCenterX + curXValue) - this.lastMoveX, (this.screenCenterY + curYValue) - this.lastMoveY, obtain);
                    gLMapState.setMapGeoCenter((double) obtain.x, (double) obtain.y);
                    this.lastMoveX = curXValue;
                    this.lastMoveY = curYValue;
                    obtain.recycle();
                }
            }
        }
    }

    public void reset() {
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        this.velocityX = 0.0f;
        this.velocityY = 0.0f;
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public void setPositionAndVelocity(float f2, float f3) {
        this.moveParam = null;
        this.velocityX = f2;
        this.velocityY = f3;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = new AbstractAdglAnimationParam2V();
        this.moveParam = abstractAdglAnimationParam2V;
        abstractAdglAnimationParam2V.setInterpolatorType(2, 1.2f);
        this.needMove = false;
        this.hasCheckParams = false;
    }
}
