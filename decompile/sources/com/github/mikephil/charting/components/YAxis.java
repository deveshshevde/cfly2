package com.github.mikephil.charting.components;

import android.graphics.Paint;
import fg.i;

public class YAxis extends a {
    protected boolean C;
    protected boolean D;
    protected int E;
    protected float F;
    protected float G;
    protected float H;
    protected float I;
    protected float J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private YAxisLabelPosition O;
    private AxisDependency P;

    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis() {
        this.K = true;
        this.L = true;
        this.C = false;
        this.D = false;
        this.M = false;
        this.N = false;
        this.E = -7829368;
        this.F = 1.0f;
        this.G = 10.0f;
        this.H = 10.0f;
        this.O = YAxisLabelPosition.OUTSIDE_CHART;
        this.I = 0.0f;
        this.J = Float.POSITIVE_INFINITY;
        this.P = AxisDependency.LEFT;
        this.f14947y = 0.0f;
    }

    public YAxis(AxisDependency axisDependency) {
        this.K = true;
        this.L = true;
        this.C = false;
        this.D = false;
        this.M = false;
        this.N = false;
        this.E = -7829368;
        this.F = 1.0f;
        this.G = 10.0f;
        this.H = 10.0f;
        this.O = YAxisLabelPosition.OUTSIDE_CHART;
        this.I = 0.0f;
        this.J = Float.POSITIVE_INFINITY;
        this.P = axisDependency;
        this.f14947y = 0.0f;
    }

    public float A() {
        return this.I;
    }

    public float B() {
        return this.J;
    }

    public YAxisLabelPosition C() {
        return this.O;
    }

    public boolean D() {
        return this.L;
    }

    public boolean E() {
        return this.K;
    }

    public boolean F() {
        return this.C;
    }

    public float G() {
        return this.G;
    }

    public float H() {
        return this.H;
    }

    public boolean I() {
        return this.D;
    }

    public int J() {
        return this.E;
    }

    public float K() {
        return this.F;
    }

    public boolean L() {
        return y() && h() && C() == YAxisLabelPosition.OUTSIDE_CHART;
    }

    public float a(Paint paint) {
        paint.setTextSize(this.A);
        float a2 = ((float) i.a(paint, p())) + (t() * 2.0f);
        float A = A();
        float B = B();
        if (A > 0.0f) {
            A = i.a(A);
        }
        if (B > 0.0f && B != Float.POSITIVE_INFINITY) {
            B = i.a(B);
        }
        if (((double) B) <= i.f27244a) {
            B = a2;
        }
        return Math.max(A, Math.min(a2, B));
    }

    public void a(float f2, float f3) {
        if (Math.abs(f3 - f2) == 0.0f) {
            f3 += 1.0f;
            f2 -= 1.0f;
        }
        float abs = Math.abs(f3 - f2);
        this.f14943u = this.f14940r ? this.f14943u : f2 - ((abs / 100.0f) * H());
        this.f14942t = this.f14941s ? this.f14942t : f3 + ((abs / 100.0f) * G());
        this.f14944v = Math.abs(this.f14943u - this.f14942t);
    }

    public float b(Paint paint) {
        paint.setTextSize(this.A);
        return ((float) i.b(paint, p())) + (u() * 2.0f);
    }

    public AxisDependency z() {
        return this.P;
    }
}
