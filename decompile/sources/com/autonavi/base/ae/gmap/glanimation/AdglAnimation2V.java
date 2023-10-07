package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;
import fg.i;

public class AdglAnimation2V extends AbstractAdglAnimation {
    private double curValue1;
    private double curValue2;
    private AbstractAdglAnimationParam2V v2Param = null;

    public AdglAnimation2V(int i2) {
        reset();
        this.duration = i2;
        this.curValue1 = i.f27244a;
        this.curValue2 = i.f27244a;
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
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            if (abstractAdglAnimationParam2V != null) {
                abstractAdglAnimationParam2V.setNormalizedTime(f2);
                this.curValue1 = this.v2Param.getCurXValue();
                this.curValue2 = this.v2Param.getCurYValue();
            }
        }
    }

    public double getCurValue(int i2) {
        return i2 == 0 ? this.curValue1 : this.curValue2;
    }

    public double getEndValue(int i2) {
        if (i2 == 0) {
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            return abstractAdglAnimationParam2V != null ? abstractAdglAnimationParam2V.getToXValue() : i.f27244a;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        return abstractAdglAnimationParam2V2 != null ? abstractAdglAnimationParam2V2.getToYValue() : i.f27244a;
    }

    public double getStartValue(int i2) {
        if (i2 == 0) {
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            return abstractAdglAnimationParam2V != null ? abstractAdglAnimationParam2V.getFromXValue() : i.f27244a;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        return abstractAdglAnimationParam2V2 != null ? abstractAdglAnimationParam2V2.getFromYValue() : i.f27244a;
    }

    public void reset() {
        this.isOver = false;
        this.duration = 0;
        this.curValue1 = i.f27244a;
        this.curValue2 = i.f27244a;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
    }
}
