package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;

public class AdglAnimation1V extends AbstractAdglAnimation {
    private float curValue;
    private AbstractAdglAnimationParam1V v1Param = null;

    public AdglAnimation1V(int i2) {
        reset();
        this.duration = i2;
        this.curValue = 0.0f;
    }

    public void doAnimation(Object obj) {
        if (!this.isOver) {
            this.offsetTime = SystemClock.uptimeMillis() - this.startTime;
            float f2 = ((float) this.offsetTime) / ((float) this.duration);
            if (f2 > 1.0f) {
                this.isOver = true;
                f2 = 1.0f;
            } else if (f2 < 0.0f) {
                this.isOver = true;
                return;
            }
            AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.v1Param;
            if (abstractAdglAnimationParam1V != null) {
                abstractAdglAnimationParam1V.setNormalizedTime(f2);
                this.curValue = this.v1Param.getCurValue();
            }
        }
    }

    public float getCurValue() {
        return this.curValue;
    }

    public float getEndValue() {
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.v1Param;
        if (abstractAdglAnimationParam1V != null) {
            return abstractAdglAnimationParam1V.getToValue();
        }
        return 0.0f;
    }

    public float getStartValue() {
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.v1Param;
        if (abstractAdglAnimationParam1V != null) {
            return abstractAdglAnimationParam1V.getFromValue();
        }
        return 0.0f;
    }

    public void reset() {
        this.isOver = false;
        this.duration = 0;
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.v1Param;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
    }

    public void setAnimationValue(float f2, float f3, int i2) {
        if (this.v1Param == null) {
            this.v1Param = new AbstractAdglAnimationParam1V();
        }
        this.v1Param.reset();
        this.v1Param.setInterpolatorType(i2, 1.0f);
        this.v1Param.setFromValue(f2);
        this.v1Param.setToValue(f3);
        this.startTime = SystemClock.uptimeMillis();
        this.isOver = false;
    }
}
