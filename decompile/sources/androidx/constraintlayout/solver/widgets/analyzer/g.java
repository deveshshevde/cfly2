package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.a;
import androidx.constraintlayout.solver.widgets.analyzer.b;
import androidx.constraintlayout.solver.widgets.d;
import androidx.constraintlayout.solver.widgets.f;
import java.util.ArrayList;
import java.util.Iterator;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static b.a f2366a = new b.a();

    private static void a(ConstraintWidget constraintWidget, b.C0022b bVar) {
        if (!(constraintWidget instanceof d) && constraintWidget.p() && a(constraintWidget)) {
            d.a(constraintWidget, bVar, new b.a(), b.a.f2341a);
        }
        ConstraintAnchor a2 = constraintWidget.a(ConstraintAnchor.Type.TOP);
        ConstraintAnchor a3 = constraintWidget.a(ConstraintAnchor.Type.BOTTOM);
        int d2 = a2.d();
        int d3 = a3.d();
        if (a2.a() != null && a2.f()) {
            Iterator<ConstraintAnchor> it2 = a2.a().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next = it2.next();
                ConstraintWidget constraintWidget2 = next.f2219a;
                boolean a4 = a(constraintWidget2);
                if (constraintWidget2.p() && a4) {
                    d.a(constraintWidget2, bVar, new b.a(), b.a.f2341a);
                }
                if (constraintWidget2.T() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || a4) {
                    if (!constraintWidget2.p()) {
                        if (next == constraintWidget2.f2290z && constraintWidget2.B.f2221c == null) {
                            int j2 = constraintWidget2.f2290z.j() + d2;
                            constraintWidget2.b(j2, constraintWidget2.B() + j2);
                        } else if (next == constraintWidget2.B && constraintWidget2.B.f2221c == null) {
                            int j3 = d2 - constraintWidget2.B.j();
                            constraintWidget2.b(j3 - constraintWidget2.B(), j3);
                        } else if (next == constraintWidget2.f2290z && constraintWidget2.B.f2221c != null && constraintWidget2.B.f2221c.f()) {
                            a(bVar, constraintWidget2);
                        }
                        a(constraintWidget2, bVar);
                    }
                } else if (constraintWidget2.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.f2283s >= 0 && constraintWidget2.f2282r >= 0) {
                    if ((constraintWidget2.w() == 8 || (constraintWidget2.f2277m == 0 && constraintWidget2.N() == 0.0f)) && !constraintWidget2.V() && !constraintWidget2.l()) {
                        if (((next == constraintWidget2.f2290z && constraintWidget2.B.f2221c != null && constraintWidget2.B.f2221c.f()) || (next == constraintWidget2.B && constraintWidget2.f2290z.f2221c != null && constraintWidget2.f2290z.f2221c.f())) && !constraintWidget2.V()) {
                            a(constraintWidget, bVar, constraintWidget2);
                        }
                    }
                }
            }
        }
        if (!(constraintWidget instanceof f)) {
            if (a3.a() != null && a3.f()) {
                Iterator<ConstraintAnchor> it3 = a3.a().iterator();
                while (it3.hasNext()) {
                    ConstraintAnchor next2 = it3.next();
                    ConstraintWidget constraintWidget3 = next2.f2219a;
                    boolean a5 = a(constraintWidget3);
                    if (constraintWidget3.p() && a5) {
                        d.a(constraintWidget3, bVar, new b.a(), b.a.f2341a);
                    }
                    boolean z2 = (next2 == constraintWidget3.f2290z && constraintWidget3.B.f2221c != null && constraintWidget3.B.f2221c.f()) || (next2 == constraintWidget3.B && constraintWidget3.f2290z.f2221c != null && constraintWidget3.f2290z.f2221c.f());
                    if (constraintWidget3.T() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || a5) {
                        if (!constraintWidget3.p()) {
                            if (next2 == constraintWidget3.f2290z && constraintWidget3.B.f2221c == null) {
                                int j4 = constraintWidget3.f2290z.j() + d3;
                                constraintWidget3.b(j4, constraintWidget3.B() + j4);
                            } else if (next2 == constraintWidget3.B && constraintWidget3.f2290z.f2221c == null) {
                                int j5 = d3 - constraintWidget3.B.j();
                                constraintWidget3.b(j5 - constraintWidget3.B(), j5);
                            } else if (z2 && !constraintWidget3.V()) {
                                a(bVar, constraintWidget3);
                            }
                            a(constraintWidget3, bVar);
                        }
                    } else if (constraintWidget3.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget3.f2283s >= 0 && constraintWidget3.f2282r >= 0) {
                        if ((constraintWidget3.w() == 8 || (constraintWidget3.f2277m == 0 && constraintWidget3.N() == 0.0f)) && !constraintWidget3.V() && !constraintWidget3.l() && z2 && !constraintWidget3.V()) {
                            a(constraintWidget, bVar, constraintWidget3);
                        }
                    }
                }
            }
            ConstraintAnchor a6 = constraintWidget.a(ConstraintAnchor.Type.BASELINE);
            if (a6.a() != null && a6.f()) {
                int d4 = a6.d();
                Iterator<ConstraintAnchor> it4 = a6.a().iterator();
                while (it4.hasNext()) {
                    ConstraintAnchor next3 = it4.next();
                    ConstraintWidget constraintWidget4 = next3.f2219a;
                    boolean a7 = a(constraintWidget4);
                    if (constraintWidget4.p() && a7) {
                        d.a(constraintWidget4, bVar, new b.a(), b.a.f2341a);
                    }
                    if ((constraintWidget4.T() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || a7) && !constraintWidget4.p() && next3 == constraintWidget4.C) {
                        constraintWidget4.f(d4);
                        a(constraintWidget4, bVar);
                    }
                }
            }
        }
    }

    private static void a(ConstraintWidget constraintWidget, b.C0022b bVar, ConstraintWidget constraintWidget2) {
        float J = constraintWidget2.J();
        int d2 = constraintWidget2.f2290z.f2221c.d() + constraintWidget2.f2290z.j();
        int d3 = constraintWidget2.B.f2221c.d() - constraintWidget2.B.j();
        if (d3 >= d2) {
            int B = constraintWidget2.B();
            if (constraintWidget2.w() != 8) {
                if (constraintWidget2.f2277m == 2) {
                    if (!(constraintWidget instanceof d)) {
                        constraintWidget = constraintWidget.v();
                    }
                    B = (int) (J * 0.5f * ((float) constraintWidget.B()));
                } else if (constraintWidget2.f2277m == 0) {
                    B = d3 - d2;
                }
                B = Math.max(constraintWidget2.f2282r, B);
                if (constraintWidget2.f2283s > 0) {
                    B = Math.min(constraintWidget2.f2283s, B);
                }
            }
            int i2 = d2 + ((int) ((J * ((float) ((d3 - d2) - B))) + 0.5f));
            constraintWidget2.b(i2, B + i2);
            a(constraintWidget2, bVar);
        }
    }

    private static void a(ConstraintWidget constraintWidget, b.C0022b bVar, ConstraintWidget constraintWidget2, boolean z2) {
        float I = constraintWidget2.I();
        int d2 = constraintWidget2.f2289y.f2221c.d() + constraintWidget2.f2289y.j();
        int d3 = constraintWidget2.A.f2221c.d() - constraintWidget2.A.j();
        if (d3 >= d2) {
            int A = constraintWidget2.A();
            if (constraintWidget2.w() != 8) {
                if (constraintWidget2.f2276l == 2) {
                    if (!(constraintWidget instanceof d)) {
                        constraintWidget = constraintWidget.v();
                    }
                    A = (int) (constraintWidget2.I() * 0.5f * ((float) constraintWidget.A()));
                } else if (constraintWidget2.f2276l == 0) {
                    A = d3 - d2;
                }
                A = Math.max(constraintWidget2.f2279o, A);
                if (constraintWidget2.f2280p > 0) {
                    A = Math.min(constraintWidget2.f2280p, A);
                }
            }
            int i2 = d2 + ((int) ((I * ((float) ((d3 - d2) - A))) + 0.5f));
            constraintWidget2.a(i2, A + i2);
            a(constraintWidget2, bVar, z2);
        }
    }

    private static void a(ConstraintWidget constraintWidget, b.C0022b bVar, boolean z2) {
        if (!(constraintWidget instanceof d) && constraintWidget.p() && a(constraintWidget)) {
            d.a(constraintWidget, bVar, new b.a(), b.a.f2341a);
        }
        ConstraintAnchor a2 = constraintWidget.a(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor a3 = constraintWidget.a(ConstraintAnchor.Type.RIGHT);
        int d2 = a2.d();
        int d3 = a3.d();
        if (a2.a() != null && a2.f()) {
            Iterator<ConstraintAnchor> it2 = a2.a().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next = it2.next();
                ConstraintWidget constraintWidget2 = next.f2219a;
                boolean a4 = a(constraintWidget2);
                if (constraintWidget2.p() && a4) {
                    d.a(constraintWidget2, bVar, new b.a(), b.a.f2341a);
                }
                if (constraintWidget2.S() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || a4) {
                    if (!constraintWidget2.p()) {
                        if (next == constraintWidget2.f2289y && constraintWidget2.A.f2221c == null) {
                            int j2 = constraintWidget2.f2289y.j() + d2;
                            constraintWidget2.a(j2, constraintWidget2.A() + j2);
                        } else if (next == constraintWidget2.A && constraintWidget2.f2289y.f2221c == null) {
                            int j3 = d2 - constraintWidget2.A.j();
                            constraintWidget2.a(j3 - constraintWidget2.A(), j3);
                        } else if (next == constraintWidget2.f2289y && constraintWidget2.A.f2221c != null && constraintWidget2.A.f2221c.f() && !constraintWidget2.U()) {
                            a(bVar, constraintWidget2, z2);
                        }
                        a(constraintWidget2, bVar, z2);
                    }
                } else if (constraintWidget2.S() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.f2280p >= 0 && constraintWidget2.f2279o >= 0) {
                    if ((constraintWidget2.w() == 8 || (constraintWidget2.f2276l == 0 && constraintWidget2.N() == 0.0f)) && !constraintWidget2.U() && !constraintWidget2.l()) {
                        if (((next == constraintWidget2.f2289y && constraintWidget2.A.f2221c != null && constraintWidget2.A.f2221c.f()) || (next == constraintWidget2.A && constraintWidget2.f2289y.f2221c != null && constraintWidget2.f2289y.f2221c.f())) && !constraintWidget2.U()) {
                            a(constraintWidget, bVar, constraintWidget2, z2);
                        }
                    }
                }
            }
        }
        if (!(constraintWidget instanceof f) && a3.a() != null && a3.f()) {
            Iterator<ConstraintAnchor> it3 = a3.a().iterator();
            while (it3.hasNext()) {
                ConstraintAnchor next2 = it3.next();
                ConstraintWidget constraintWidget3 = next2.f2219a;
                boolean a5 = a(constraintWidget3);
                if (constraintWidget3.p() && a5) {
                    d.a(constraintWidget3, bVar, new b.a(), b.a.f2341a);
                }
                boolean z3 = (next2 == constraintWidget3.f2289y && constraintWidget3.A.f2221c != null && constraintWidget3.A.f2221c.f()) || (next2 == constraintWidget3.A && constraintWidget3.f2289y.f2221c != null && constraintWidget3.f2289y.f2221c.f());
                if (constraintWidget3.S() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || a5) {
                    if (!constraintWidget3.p()) {
                        if (next2 == constraintWidget3.f2289y && constraintWidget3.A.f2221c == null) {
                            int j4 = constraintWidget3.f2289y.j() + d3;
                            constraintWidget3.a(j4, constraintWidget3.A() + j4);
                        } else if (next2 == constraintWidget3.A && constraintWidget3.f2289y.f2221c == null) {
                            int j5 = d3 - constraintWidget3.A.j();
                            constraintWidget3.a(j5 - constraintWidget3.A(), j5);
                        } else if (z3 && !constraintWidget3.U()) {
                            a(bVar, constraintWidget3, z2);
                        }
                        a(constraintWidget3, bVar, z2);
                    }
                } else if (constraintWidget3.S() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget3.f2280p >= 0 && constraintWidget3.f2279o >= 0) {
                    if ((constraintWidget3.w() == 8 || (constraintWidget3.f2276l == 0 && constraintWidget3.N() == 0.0f)) && !constraintWidget3.U() && !constraintWidget3.l() && z3 && !constraintWidget3.U()) {
                        a(constraintWidget, bVar, constraintWidget3, z2);
                    }
                }
            }
        }
    }

    private static void a(a aVar, b.C0022b bVar, int i2, boolean z2) {
        if (!aVar.i()) {
            return;
        }
        if (i2 == 0) {
            a((ConstraintWidget) aVar, bVar, z2);
        } else {
            a((ConstraintWidget) aVar, bVar);
        }
    }

    private static void a(b.C0022b bVar, ConstraintWidget constraintWidget) {
        float J = constraintWidget.J();
        int d2 = constraintWidget.f2290z.f2221c.d();
        int d3 = constraintWidget.B.f2221c.d();
        int j2 = constraintWidget.f2290z.j() + d2;
        int j3 = d3 - constraintWidget.B.j();
        if (d2 == d3) {
            J = 0.5f;
        } else {
            d2 = j2;
            d3 = j3;
        }
        int B = constraintWidget.B();
        int i2 = (d3 - d2) - B;
        if (d2 > d3) {
            i2 = (d2 - d3) - B;
        }
        int i3 = (int) ((J * ((float) i2)) + 0.5f);
        int i4 = d2 + i3;
        int i5 = i4 + B;
        if (d2 > d3) {
            i4 = d2 - i3;
            i5 = i4 - B;
        }
        constraintWidget.b(i4, i5);
        a(constraintWidget, bVar);
    }

    private static void a(b.C0022b bVar, ConstraintWidget constraintWidget, boolean z2) {
        float I = constraintWidget.I();
        int d2 = constraintWidget.f2289y.f2221c.d();
        int d3 = constraintWidget.A.f2221c.d();
        int j2 = constraintWidget.f2289y.j() + d2;
        int j3 = d3 - constraintWidget.A.j();
        if (d2 == d3) {
            I = 0.5f;
        } else {
            d2 = j2;
            d3 = j3;
        }
        int A = constraintWidget.A();
        int i2 = (d3 - d2) - A;
        if (d2 > d3) {
            i2 = (d2 - d3) - A;
        }
        int i3 = ((int) ((I * ((float) i2)) + 0.5f)) + d2;
        int i4 = i3 + A;
        if (d2 > d3) {
            i4 = i3 - A;
        }
        constraintWidget.a(i3, i4);
        a(constraintWidget, bVar, z2);
    }

    public static void a(d dVar, b.C0022b bVar) {
        int f2;
        int f3;
        ConstraintWidget.DimensionBehaviour S = dVar.S();
        ConstraintWidget.DimensionBehaviour T = dVar.T();
        dVar.d_();
        ArrayList<ConstraintWidget> ac2 = dVar.ac();
        int size = ac2.size();
        for (int i2 = 0; i2 < size; i2++) {
            ac2.get(i2).d_();
        }
        boolean Y = dVar.Y();
        if (S == ConstraintWidget.DimensionBehaviour.FIXED) {
            dVar.a(0, dVar.A());
        } else {
            dVar.d(0);
        }
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = ac2.get(i3);
            if (constraintWidget instanceof f) {
                f fVar = (f) constraintWidget;
                if (fVar.c() == 1) {
                    if (fVar.g() != -1) {
                        f3 = fVar.g();
                    } else if (fVar.h() == -1 || !dVar.d()) {
                        if (dVar.d()) {
                            f3 = (int) ((fVar.f() * ((float) dVar.A())) + 0.5f);
                        }
                        z2 = true;
                    } else {
                        f3 = dVar.A() - fVar.h();
                    }
                    fVar.z(f3);
                    z2 = true;
                }
            } else if ((constraintWidget instanceof a) && ((a) constraintWidget).h() == 0) {
                z3 = true;
            }
        }
        if (z2) {
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget2 = ac2.get(i4);
                if (constraintWidget2 instanceof f) {
                    f fVar2 = (f) constraintWidget2;
                    if (fVar2.c() == 1) {
                        a((ConstraintWidget) fVar2, bVar, Y);
                    }
                }
            }
        }
        a((ConstraintWidget) dVar, bVar, Y);
        if (z3) {
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget3 = ac2.get(i5);
                if (constraintWidget3 instanceof a) {
                    a aVar = (a) constraintWidget3;
                    if (aVar.h() == 0) {
                        a(aVar, bVar, 0, Y);
                    }
                }
            }
        }
        if (T == ConstraintWidget.DimensionBehaviour.FIXED) {
            dVar.b(0, dVar.B());
        } else {
            dVar.e(0);
        }
        boolean z4 = false;
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget4 = ac2.get(i6);
            if (constraintWidget4 instanceof f) {
                f fVar3 = (f) constraintWidget4;
                if (fVar3.c() == 0) {
                    if (fVar3.g() != -1) {
                        f2 = fVar3.g();
                    } else if (fVar3.h() == -1 || !dVar.e()) {
                        if (dVar.e()) {
                            f2 = (int) ((fVar3.f() * ((float) dVar.B())) + 0.5f);
                        }
                        z4 = true;
                    } else {
                        f2 = dVar.B() - fVar3.h();
                    }
                    fVar3.z(f2);
                    z4 = true;
                }
            } else if ((constraintWidget4 instanceof a) && ((a) constraintWidget4).h() == 1) {
                z5 = true;
            }
        }
        if (z4) {
            for (int i7 = 0; i7 < size; i7++) {
                ConstraintWidget constraintWidget5 = ac2.get(i7);
                if (constraintWidget5 instanceof f) {
                    f fVar4 = (f) constraintWidget5;
                    if (fVar4.c() == 0) {
                        a((ConstraintWidget) fVar4, bVar);
                    }
                }
            }
        }
        a((ConstraintWidget) dVar, bVar);
        if (z5) {
            for (int i8 = 0; i8 < size; i8++) {
                ConstraintWidget constraintWidget6 = ac2.get(i8);
                if (constraintWidget6 instanceof a) {
                    a aVar2 = (a) constraintWidget6;
                    if (aVar2.h() == 1) {
                        a(aVar2, bVar, 1, Y);
                    }
                }
            }
        }
        for (int i9 = 0; i9 < size; i9++) {
            ConstraintWidget constraintWidget7 = ac2.get(i9);
            if (constraintWidget7.p() && a(constraintWidget7)) {
                d.a(constraintWidget7, bVar, f2366a, b.a.f2341a);
                a(constraintWidget7, bVar, Y);
                a(constraintWidget7, bVar);
            }
        }
    }

    private static boolean a(ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour S = constraintWidget.S();
        ConstraintWidget.DimensionBehaviour T = constraintWidget.T();
        d dVar = constraintWidget.v() != null ? (d) constraintWidget.v() : null;
        if (dVar != null) {
            ConstraintWidget.DimensionBehaviour S2 = dVar.S();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (dVar != null) {
            ConstraintWidget.DimensionBehaviour T2 = dVar.T();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        boolean z2 = S == ConstraintWidget.DimensionBehaviour.FIXED || S == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (S == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f2276l == 0 && constraintWidget.M == 0.0f && constraintWidget.g(0)) || constraintWidget.d();
        boolean z3 = T == ConstraintWidget.DimensionBehaviour.FIXED || T == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (T == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f2277m == 0 && constraintWidget.M == 0.0f && constraintWidget.g(1)) || constraintWidget.e();
        if (constraintWidget.M <= 0.0f || (!z2 && !z3)) {
            return z2 && z3;
        }
        return true;
    }
}
