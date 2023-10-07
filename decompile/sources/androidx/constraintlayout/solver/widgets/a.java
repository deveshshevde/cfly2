package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.d;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.HashMap;

public class a extends h {

    /* renamed from: a  reason: collision with root package name */
    boolean f2298a = false;
    private int aA = 0;

    /* renamed from: ay  reason: collision with root package name */
    private int f2299ay = 0;

    /* renamed from: az  reason: collision with root package name */
    private boolean f2300az = true;

    public void a(int i2) {
        this.f2299ay = i2;
    }

    public void a(d dVar, boolean z2) {
        boolean z3;
        SolverVariable solverVariable;
        ConstraintAnchor constraintAnchor;
        int i2;
        int i3;
        int i4;
        SolverVariable solverVariable2;
        int i5;
        this.G[0] = this.f2289y;
        this.G[2] = this.f2290z;
        this.G[1] = this.A;
        this.G[3] = this.B;
        for (int i6 = 0; i6 < this.G.length; i6++) {
            this.G[i6].f2224f = dVar.a((Object) this.G[i6]);
        }
        int i7 = this.f2299ay;
        if (i7 >= 0 && i7 < 4) {
            ConstraintAnchor constraintAnchor2 = this.G[this.f2299ay];
            if (!this.f2298a) {
                i();
            }
            if (this.f2298a) {
                this.f2298a = false;
                int i8 = this.f2299ay;
                if (i8 == 0 || i8 == 1) {
                    dVar.a(this.f2289y.f2224f, this.O);
                    solverVariable2 = this.A.f2224f;
                    i5 = this.O;
                } else if (i8 == 2 || i8 == 3) {
                    dVar.a(this.f2290z.f2224f, this.P);
                    solverVariable2 = this.B.f2224f;
                    i5 = this.P;
                } else {
                    return;
                }
                dVar.a(solverVariable2, i5);
                return;
            }
            int i9 = 0;
            while (true) {
                if (i9 >= this.f2448ax) {
                    z3 = false;
                    break;
                }
                ConstraintWidget constraintWidget = this.f2447aw[i9];
                if ((this.f2300az || constraintWidget.a()) && ((((i3 = this.f2299ay) == 0 || i3 == 1) && constraintWidget.S() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f2289y.f2221c != null && constraintWidget.A.f2221c != null) || (((i4 = this.f2299ay) == 2 || i4 == 3) && constraintWidget.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f2290z.f2221c != null && constraintWidget.B.f2221c != null))) {
                    z3 = true;
                } else {
                    i9++;
                }
            }
            boolean z4 = this.f2289y.c() || this.A.c();
            boolean z5 = this.f2290z.c() || this.B.c();
            boolean z6 = !z3 && (((i2 = this.f2299ay) == 0 && z4) || ((i2 == 2 && z5) || ((i2 == 1 && z4) || (i2 == 3 && z5))));
            int i10 = 5;
            if (!z6) {
                i10 = 4;
            }
            for (int i11 = 0; i11 < this.f2448ax; i11++) {
                ConstraintWidget constraintWidget2 = this.f2447aw[i11];
                if (this.f2300az || constraintWidget2.a()) {
                    SolverVariable a2 = dVar.a((Object) constraintWidget2.G[this.f2299ay]);
                    constraintWidget2.G[this.f2299ay].f2224f = a2;
                    int i12 = (constraintWidget2.G[this.f2299ay].f2221c == null || constraintWidget2.G[this.f2299ay].f2221c.f2219a != this) ? 0 : constraintWidget2.G[this.f2299ay].f2222d + 0;
                    int i13 = this.f2299ay;
                    if (i13 == 0 || i13 == 2) {
                        dVar.b(constraintAnchor2.f2224f, a2, this.aA - i12, z3);
                    } else {
                        dVar.a(constraintAnchor2.f2224f, a2, this.aA + i12, z3);
                    }
                    dVar.c(constraintAnchor2.f2224f, a2, this.aA + i12, i10);
                }
            }
            int i14 = this.f2299ay;
            if (i14 == 0) {
                dVar.c(this.A.f2224f, this.f2289y.f2224f, 0, 8);
                dVar.c(this.f2289y.f2224f, this.J.A.f2224f, 0, 4);
                solverVariable = this.f2289y.f2224f;
                constraintAnchor = this.J.f2289y;
            } else if (i14 == 1) {
                dVar.c(this.f2289y.f2224f, this.A.f2224f, 0, 8);
                dVar.c(this.f2289y.f2224f, this.J.f2289y.f2224f, 0, 4);
                solverVariable = this.f2289y.f2224f;
                constraintAnchor = this.J.A;
            } else if (i14 == 2) {
                dVar.c(this.B.f2224f, this.f2290z.f2224f, 0, 8);
                dVar.c(this.f2290z.f2224f, this.J.B.f2224f, 0, 4);
                solverVariable = this.f2290z.f2224f;
                constraintAnchor = this.J.f2290z;
            } else if (i14 == 3) {
                dVar.c(this.f2290z.f2224f, this.B.f2224f, 0, 8);
                dVar.c(this.f2290z.f2224f, this.J.f2290z.f2224f, 0, 4);
                solverVariable = this.f2290z.f2224f;
                constraintAnchor = this.J.B;
            } else {
                return;
            }
            dVar.c(solverVariable, constraintAnchor.f2224f, 0, 0);
        }
    }

    public void a(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.a(constraintWidget, hashMap);
        a aVar = (a) constraintWidget;
        this.f2299ay = aVar.f2299ay;
        this.f2300az = aVar.f2300az;
        this.aA = aVar.aA;
    }

    public void a(boolean z2) {
        this.f2300az = z2;
    }

    public boolean a() {
        return true;
    }

    public int b() {
        return this.f2299ay;
    }

    public void b(int i2) {
        this.aA = i2;
    }

    public boolean c() {
        return this.f2300az;
    }

    public boolean d() {
        return this.f2298a;
    }

    public boolean e() {
        return this.f2298a;
    }

    /* access modifiers changed from: protected */
    public void f() {
        for (int i2 = 0; i2 < this.f2448ax; i2++) {
            ConstraintWidget constraintWidget = this.f2447aw[i2];
            int i3 = this.f2299ay;
            if (i3 == 0 || i3 == 1) {
                constraintWidget.a(0, true);
            } else if (i3 == 2 || i3 == 3) {
                constraintWidget.a(1, true);
            }
        }
    }

    public int g() {
        return this.aA;
    }

    public int h() {
        int i2 = this.f2299ay;
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        return (i2 == 2 || i2 == 3) ? 1 : -1;
    }

    public boolean i() {
        ConstraintAnchor.Type type;
        ConstraintAnchor.Type type2;
        ConstraintAnchor.Type type3;
        int i2;
        int i3;
        boolean z2 = true;
        for (int i4 = 0; i4 < this.f2448ax; i4++) {
            ConstraintWidget constraintWidget = this.f2447aw[i4];
            if ((this.f2300az || constraintWidget.a()) && ((((i2 = this.f2299ay) == 0 || i2 == 1) && !constraintWidget.d()) || (((i3 = this.f2299ay) == 2 || i3 == 3) && !constraintWidget.e()))) {
                z2 = false;
            }
        }
        if (!z2 || this.f2448ax <= 0) {
            return false;
        }
        int i5 = 0;
        boolean z3 = false;
        for (int i6 = 0; i6 < this.f2448ax; i6++) {
            ConstraintWidget constraintWidget2 = this.f2447aw[i6];
            if (this.f2300az || constraintWidget2.a()) {
                if (!z3) {
                    int i7 = this.f2299ay;
                    if (i7 == 0) {
                        type3 = ConstraintAnchor.Type.LEFT;
                    } else if (i7 == 1) {
                        type3 = ConstraintAnchor.Type.RIGHT;
                    } else if (i7 == 2) {
                        type3 = ConstraintAnchor.Type.TOP;
                    } else {
                        if (i7 == 3) {
                            type3 = ConstraintAnchor.Type.BOTTOM;
                        }
                        z3 = true;
                    }
                    i5 = constraintWidget2.a(type3).d();
                    z3 = true;
                }
                int i8 = this.f2299ay;
                if (i8 == 0) {
                    type2 = ConstraintAnchor.Type.LEFT;
                } else {
                    if (i8 == 1) {
                        type = ConstraintAnchor.Type.RIGHT;
                    } else if (i8 == 2) {
                        type2 = ConstraintAnchor.Type.TOP;
                    } else if (i8 == 3) {
                        type = ConstraintAnchor.Type.BOTTOM;
                    }
                    i5 = Math.max(i5, constraintWidget2.a(type).d());
                }
                i5 = Math.min(i5, constraintWidget2.a(type2).d());
            }
        }
        int i9 = i5 + this.aA;
        int i10 = this.f2299ay;
        if (i10 == 0 || i10 == 1) {
            a(i9, i9);
        } else {
            b(i9, i9);
        }
        this.f2298a = true;
        return true;
    }

    public String toString() {
        String str = "[Barrier] " + x() + " {";
        for (int i2 = 0; i2 < this.f2448ax; i2++) {
            ConstraintWidget constraintWidget = this.f2447aw[i2];
            if (i2 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.x();
        }
        return str + "}";
    }
}
