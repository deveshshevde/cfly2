package com.xeagle.android.bean;

import fg.i;
import java.io.Serializable;

public final class ProgressBean implements Serializable {
    private double current;
    private double total;

    public ProgressBean() {
        this(i.f27244a, i.f27244a, 3, (f) null);
    }

    public ProgressBean(double d2, double d3) {
        this.current = d2;
        this.total = d3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProgressBean(double d2, double d3, int i2, f fVar) {
        this((i2 & 1) != 0 ? 0.0d : d2, (i2 & 2) != 0 ? 0.0d : d3);
    }

    public static /* synthetic */ ProgressBean copy$default(ProgressBean progressBean, double d2, double d3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = progressBean.current;
        }
        if ((i2 & 2) != 0) {
            d3 = progressBean.total;
        }
        return progressBean.copy(d2, d3);
    }

    public final double component1() {
        return this.current;
    }

    public final double component2() {
        return this.total;
    }

    public final ProgressBean copy(double d2, double d3) {
        return new ProgressBean(d2, d3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressBean)) {
            return false;
        }
        ProgressBean progressBean = (ProgressBean) obj;
        return Double.compare(this.current, progressBean.current) == 0 && Double.compare(this.total, progressBean.total) == 0;
    }

    public final double getCurrent() {
        return this.current;
    }

    public final double getTotal() {
        return this.total;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.current);
        long doubleToLongBits2 = Double.doubleToLongBits(this.total);
        return (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public final void setCurrent(double d2) {
        this.current = d2;
    }

    public final void setTotal(double d2) {
        this.total = d2;
    }

    public String toString() {
        return "ProgressBean(current=" + this.current + ", total=" + this.total + ")";
    }
}
