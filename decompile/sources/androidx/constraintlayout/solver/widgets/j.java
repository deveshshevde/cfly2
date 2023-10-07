package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.b;

public class j extends h {

    /* renamed from: a  reason: collision with root package name */
    protected b.a f2450a = new b.a();
    private int aA = 0;
    private int aB = 0;
    private int aC = 0;
    private int aD = 0;
    private int aE = 0;
    private int aF = 0;
    private int aG = 0;
    private boolean aH = false;
    private int aI = 0;
    private int aJ = 0;

    /* renamed from: ay  reason: collision with root package name */
    b.C0022b f2451ay = null;

    /* renamed from: az  reason: collision with root package name */
    private int f2452az = 0;

    public void K(int i2) {
        this.aB = i2;
        this.f2452az = i2;
        this.aC = i2;
        this.aA = i2;
        this.aD = i2;
        this.aE = i2;
    }

    public void L(int i2) {
        this.aD = i2;
        this.aF = i2;
        this.aG = i2;
    }

    public void M(int i2) {
        this.aE = i2;
    }

    public void N(int i2) {
        this.aB = i2;
        this.aF = i2;
    }

    public void O(int i2) {
        this.f2452az = i2;
    }

    public void P(int i2) {
        this.aC = i2;
        this.aG = i2;
    }

    public void Q(int i2) {
        this.aA = i2;
    }

    public int X() {
        return this.aI;
    }

    public int Y() {
        return this.aJ;
    }

    /* access modifiers changed from: protected */
    public boolean Z() {
        b.C0022b g2 = this.J != null ? ((d) this.J).g() : null;
        if (g2 == null) {
            return false;
        }
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= this.f2448ax) {
                return true;
            }
            ConstraintWidget constraintWidget = this.f2447aw[i2];
            if (constraintWidget != null && !(constraintWidget instanceof f)) {
                ConstraintWidget.DimensionBehaviour v2 = constraintWidget.v(0);
                ConstraintWidget.DimensionBehaviour v3 = constraintWidget.v(1);
                if (v2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.f2276l == 1 || v3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.f2277m == 1) {
                    z2 = false;
                }
                if (!z2) {
                    if (v2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        v2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (v3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        v3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    this.f2450a.f2344d = v2;
                    this.f2450a.f2345e = v3;
                    this.f2450a.f2346f = constraintWidget.A();
                    this.f2450a.f2347g = constraintWidget.B();
                    g2.a(constraintWidget, this.f2450a);
                    constraintWidget.o(this.f2450a.f2348h);
                    constraintWidget.p(this.f2450a.f2349i);
                    constraintWidget.s(this.f2450a.f2350j);
                }
            }
            i2++;
        }
    }

    /* access modifiers changed from: protected */
    public void a(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i2, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i3) {
        while (this.f2451ay == null && v() != null) {
            this.f2451ay = ((d) v()).g();
        }
        this.f2450a.f2344d = dimensionBehaviour;
        this.f2450a.f2345e = dimensionBehaviour2;
        this.f2450a.f2346f = i2;
        this.f2450a.f2347g = i3;
        this.f2451ay.a(constraintWidget, this.f2450a);
        constraintWidget.o(this.f2450a.f2348h);
        constraintWidget.p(this.f2450a.f2349i);
        constraintWidget.c(this.f2450a.f2351k);
        constraintWidget.s(this.f2450a.f2350j);
    }

    public void a(d dVar) {
        i();
    }

    public void a(boolean z2) {
        int i2 = this.aD;
        if (i2 <= 0 && this.aE <= 0) {
            return;
        }
        if (z2) {
            this.aF = this.aE;
            this.aG = i2;
            return;
        }
        this.aF = i2;
        this.aG = this.aE;
    }

    public int b() {
        return this.f2452az;
    }

    public void b(int i2, int i3, int i4, int i5) {
    }

    public int c() {
        return this.aA;
    }

    public int f() {
        return this.aF;
    }

    /* access modifiers changed from: protected */
    public void f(boolean z2) {
        this.aH = z2;
    }

    public int g() {
        return this.aG;
    }

    public void g(int i2, int i3) {
        this.aI = i2;
        this.aJ = i3;
    }

    public boolean h() {
        return this.aH;
    }

    public void i() {
        for (int i2 = 0; i2 < this.f2448ax; i2++) {
            ConstraintWidget constraintWidget = this.f2447aw[i2];
            if (constraintWidget != null) {
                constraintWidget.b(true);
            }
        }
    }
}
