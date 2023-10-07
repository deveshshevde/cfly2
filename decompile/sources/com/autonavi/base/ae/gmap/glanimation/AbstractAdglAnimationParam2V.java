package com.autonavi.base.ae.gmap.glanimation;

import fg.i;

public class AbstractAdglAnimationParam2V extends AbstractAdglAnimationParam {
    public double fromXValue;
    public double fromYValue;
    public double toXValue;
    public double toYValue;

    public AbstractAdglAnimationParam2V() {
        reset();
    }

    public void checkParam() {
        this.needToCaculate = false;
        if (this.hasFromValue && this.hasToValue) {
            double d2 = this.toXValue - this.fromXValue;
            double d3 = this.toYValue - this.fromYValue;
            if (Math.abs(d2) > 1.0E-4d || Math.abs(d3) > 1.0E-4d) {
                this.needToCaculate = true;
            }
        }
        this.hasCheckedParam = true;
    }

    public double getCurXValue() {
        double d2 = this.fromXValue;
        double d3 = (double) this.mult;
        Double.isNaN(d3);
        return d2 + ((this.toXValue - d2) * d3);
    }

    public double getCurYValue() {
        double d2 = this.fromYValue;
        double d3 = (double) this.mult;
        Double.isNaN(d3);
        return d2 + ((this.toYValue - d2) * d3);
    }

    public double getFromXValue() {
        return this.fromXValue;
    }

    public double getFromYValue() {
        return this.fromYValue;
    }

    public double getToXValue() {
        return this.toXValue;
    }

    public double getToYValue() {
        return this.toYValue;
    }

    public void reset() {
        super.reset();
        this.fromXValue = i.f27244a;
        this.toXValue = i.f27244a;
        this.fromYValue = i.f27244a;
        this.toYValue = i.f27244a;
    }

    public void setFromValue(double d2, double d3) {
        this.fromXValue = d2;
        this.fromYValue = d3;
        this.hasFromValue = true;
        this.hasCheckedParam = false;
    }

    public void setToValue(double d2, double d3) {
        this.toXValue = d2;
        this.toYValue = d3;
        this.hasToValue = true;
        this.hasCheckedParam = false;
    }
}
