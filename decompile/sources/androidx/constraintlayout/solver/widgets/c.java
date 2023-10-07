package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class c {

    /* renamed from: a  reason: collision with root package name */
    protected ConstraintWidget f2395a;

    /* renamed from: b  reason: collision with root package name */
    protected ConstraintWidget f2396b;

    /* renamed from: c  reason: collision with root package name */
    protected ConstraintWidget f2397c;

    /* renamed from: d  reason: collision with root package name */
    protected ConstraintWidget f2398d;

    /* renamed from: e  reason: collision with root package name */
    protected ConstraintWidget f2399e;

    /* renamed from: f  reason: collision with root package name */
    protected ConstraintWidget f2400f;

    /* renamed from: g  reason: collision with root package name */
    protected ConstraintWidget f2401g;

    /* renamed from: h  reason: collision with root package name */
    protected ArrayList<ConstraintWidget> f2402h;

    /* renamed from: i  reason: collision with root package name */
    protected int f2403i;

    /* renamed from: j  reason: collision with root package name */
    protected int f2404j;

    /* renamed from: k  reason: collision with root package name */
    protected float f2405k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    int f2406l;

    /* renamed from: m  reason: collision with root package name */
    int f2407m;

    /* renamed from: n  reason: collision with root package name */
    int f2408n;

    /* renamed from: o  reason: collision with root package name */
    boolean f2409o;

    /* renamed from: p  reason: collision with root package name */
    protected boolean f2410p;

    /* renamed from: q  reason: collision with root package name */
    protected boolean f2411q;

    /* renamed from: r  reason: collision with root package name */
    protected boolean f2412r;

    /* renamed from: s  reason: collision with root package name */
    protected boolean f2413s;

    /* renamed from: t  reason: collision with root package name */
    private int f2414t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f2415u = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f2416v;

    public c(ConstraintWidget constraintWidget, int i2, boolean z2) {
        this.f2395a = constraintWidget;
        this.f2414t = i2;
        this.f2415u = z2;
    }

    private static boolean a(ConstraintWidget constraintWidget, int i2) {
        return constraintWidget.w() != 8 && constraintWidget.I[i2] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (constraintWidget.f2278n[i2] == 0 || constraintWidget.f2278n[i2] == 3);
    }

    private void b() {
        int i2 = this.f2414t * 2;
        ConstraintWidget constraintWidget = this.f2395a;
        boolean z2 = true;
        this.f2409o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z3 = false;
        while (!z3) {
            this.f2403i++;
            ConstraintWidget constraintWidget3 = null;
            constraintWidget.f2257ar[this.f2414t] = null;
            constraintWidget.f2256aq[this.f2414t] = null;
            if (constraintWidget.w() != 8) {
                this.f2406l++;
                if (constraintWidget.v(this.f2414t) != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f2407m += constraintWidget.k(this.f2414t);
                }
                int j2 = this.f2407m + constraintWidget.G[i2].j();
                this.f2407m = j2;
                int i3 = i2 + 1;
                this.f2407m = j2 + constraintWidget.G[i3].j();
                int j3 = this.f2408n + constraintWidget.G[i2].j();
                this.f2408n = j3;
                this.f2408n = j3 + constraintWidget.G[i3].j();
                if (this.f2396b == null) {
                    this.f2396b = constraintWidget;
                }
                this.f2398d = constraintWidget;
                if (constraintWidget.I[this.f2414t] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (constraintWidget.f2278n[this.f2414t] == 0 || constraintWidget.f2278n[this.f2414t] == 3 || constraintWidget.f2278n[this.f2414t] == 2) {
                        this.f2404j++;
                        float f2 = constraintWidget.f2255ap[this.f2414t];
                        if (f2 > 0.0f) {
                            this.f2405k += constraintWidget.f2255ap[this.f2414t];
                        }
                        if (a(constraintWidget, this.f2414t)) {
                            if (f2 < 0.0f) {
                                this.f2410p = true;
                            } else {
                                this.f2411q = true;
                            }
                            if (this.f2402h == null) {
                                this.f2402h = new ArrayList<>();
                            }
                            this.f2402h.add(constraintWidget);
                        }
                        if (this.f2400f == null) {
                            this.f2400f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f2401g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.f2256aq[this.f2414t] = constraintWidget;
                        }
                        this.f2401g = constraintWidget;
                    }
                    if (this.f2414t != 0 ? !(constraintWidget.f2277m == 0 && constraintWidget.f2282r == 0 && constraintWidget.f2283s == 0) : !(constraintWidget.f2276l == 0 && constraintWidget.f2279o == 0 && constraintWidget.f2280p == 0)) {
                        this.f2409o = false;
                    }
                    if (constraintWidget.M != 0.0f) {
                        this.f2409o = false;
                        this.f2413s = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.f2257ar[this.f2414t] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.G[i2 + 1].f2221c;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f2219a;
                if (constraintWidget5.G[i2].f2221c != null && constraintWidget5.G[i2].f2221c.f2219a == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z3 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.f2396b;
        if (constraintWidget6 != null) {
            this.f2407m -= constraintWidget6.G[i2].j();
        }
        ConstraintWidget constraintWidget7 = this.f2398d;
        if (constraintWidget7 != null) {
            this.f2407m -= constraintWidget7.G[i2 + 1].j();
        }
        this.f2397c = constraintWidget;
        if (this.f2414t != 0 || !this.f2415u) {
            this.f2399e = this.f2395a;
        } else {
            this.f2399e = constraintWidget;
        }
        if (!this.f2411q || !this.f2410p) {
            z2 = false;
        }
        this.f2412r = z2;
    }

    public void a() {
        if (!this.f2416v) {
            b();
        }
        this.f2416v = true;
    }
}
