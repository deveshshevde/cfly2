package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.d;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public class i {

    /* renamed from: a  reason: collision with root package name */
    static boolean[] f2449a = new boolean[3];

    static void a(d dVar, d dVar2, ConstraintWidget constraintWidget) {
        constraintWidget.f2274j = -1;
        constraintWidget.f2275k = -1;
        if (dVar.I[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.I[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i2 = constraintWidget.f2289y.f2222d;
            int A = dVar.A() - constraintWidget.A.f2222d;
            constraintWidget.f2289y.f2224f = dVar2.a((Object) constraintWidget.f2289y);
            constraintWidget.A.f2224f = dVar2.a((Object) constraintWidget.A);
            dVar2.a(constraintWidget.f2289y.f2224f, i2);
            dVar2.a(constraintWidget.A.f2224f, A);
            constraintWidget.f2274j = 2;
            constraintWidget.e(i2, A);
        }
        if (dVar.I[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.I[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i3 = constraintWidget.f2290z.f2222d;
            int B = dVar.B() - constraintWidget.B.f2222d;
            constraintWidget.f2290z.f2224f = dVar2.a((Object) constraintWidget.f2290z);
            constraintWidget.B.f2224f = dVar2.a((Object) constraintWidget.B);
            dVar2.a(constraintWidget.f2290z.f2224f, i3);
            dVar2.a(constraintWidget.B.f2224f, B);
            if (constraintWidget.U > 0 || constraintWidget.w() == 8) {
                constraintWidget.C.f2224f = dVar2.a((Object) constraintWidget.C);
                dVar2.a(constraintWidget.C.f2224f, constraintWidget.U + i3);
            }
            constraintWidget.f2275k = 2;
            constraintWidget.f(i3, B);
        }
    }

    public static final boolean a(int i2, int i3) {
        return (i2 & i3) == i3;
    }
}
