package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.b;
import androidx.constraintlayout.solver.widgets.analyzer.e;
import androidx.constraintlayout.solver.widgets.analyzer.g;
import androidx.constraintlayout.solver.widgets.analyzer.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class d extends k {
    static int aQ;

    /* renamed from: a  reason: collision with root package name */
    b f2417a = new b(this);
    int aA;
    int aB;
    int aC;
    int aD;
    public int aE = 0;
    public int aF = 0;
    c[] aG = new c[4];
    c[] aH = new c[4];
    public boolean aI = false;
    public boolean aJ = false;
    public boolean aK = false;
    public int aL = 0;
    public int aM = 0;
    public boolean aN = false;
    int aO = 0;
    public b.a aP = new b.a();
    private boolean aS = false;
    private int aT = 257;
    private boolean aU = false;
    private boolean aV = false;
    private WeakReference<ConstraintAnchor> aW = null;
    private WeakReference<ConstraintAnchor> aX = null;
    private WeakReference<ConstraintAnchor> aY = null;
    private WeakReference<ConstraintAnchor> aZ = null;

    /* renamed from: aw  reason: collision with root package name */
    public e f2418aw = new e(this);

    /* renamed from: ax  reason: collision with root package name */
    protected b.C0022b f2419ax = null;

    /* renamed from: ay  reason: collision with root package name */
    public androidx.constraintlayout.solver.e f2420ay;

    /* renamed from: az  reason: collision with root package name */
    protected androidx.constraintlayout.solver.d f2421az = new androidx.constraintlayout.solver.d();

    private void a(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.f2421az.a(this.f2421az.a((Object) constraintAnchor), solverVariable, 0, 5);
    }

    public static boolean a(ConstraintWidget constraintWidget, b.C0022b bVar, b.a aVar, int i2) {
        int i3;
        int i4;
        if (bVar == null) {
            return false;
        }
        aVar.f2344d = constraintWidget.S();
        aVar.f2345e = constraintWidget.T();
        aVar.f2346f = constraintWidget.A();
        aVar.f2347g = constraintWidget.B();
        aVar.f2352l = false;
        aVar.f2353m = i2;
        boolean z2 = aVar.f2344d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = aVar.f2345e == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z4 = z2 && constraintWidget.M > 0.0f;
        boolean z5 = z3 && constraintWidget.M > 0.0f;
        if (z2 && constraintWidget.g(0) && constraintWidget.f2276l == 0 && !z4) {
            aVar.f2344d = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z3 && constraintWidget.f2277m == 0) {
                aVar.f2344d = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z2 = false;
        }
        if (z3 && constraintWidget.g(1) && constraintWidget.f2277m == 0 && !z5) {
            aVar.f2345e = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z2 && constraintWidget.f2276l == 0) {
                aVar.f2345e = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z3 = false;
        }
        if (constraintWidget.d()) {
            aVar.f2344d = ConstraintWidget.DimensionBehaviour.FIXED;
            z2 = false;
        }
        if (constraintWidget.e()) {
            aVar.f2345e = ConstraintWidget.DimensionBehaviour.FIXED;
            z3 = false;
        }
        if (z4) {
            if (constraintWidget.f2278n[0] == 4) {
                aVar.f2344d = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z3) {
                if (aVar.f2345e == ConstraintWidget.DimensionBehaviour.FIXED) {
                    i4 = aVar.f2347g;
                } else {
                    aVar.f2344d = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    bVar.a(constraintWidget, aVar);
                    i4 = aVar.f2349i;
                }
                aVar.f2344d = ConstraintWidget.DimensionBehaviour.FIXED;
                aVar.f2346f = (int) ((constraintWidget.N == 0 || constraintWidget.N == -1) ? constraintWidget.N() * ((float) i4) : constraintWidget.N() / ((float) i4));
            }
        }
        if (z5) {
            if (constraintWidget.f2278n[1] == 4) {
                aVar.f2345e = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z2) {
                if (aVar.f2344d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    i3 = aVar.f2346f;
                } else {
                    aVar.f2345e = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    bVar.a(constraintWidget, aVar);
                    i3 = aVar.f2348h;
                }
                aVar.f2345e = ConstraintWidget.DimensionBehaviour.FIXED;
                aVar.f2347g = (int) ((constraintWidget.N == 0 || constraintWidget.N == -1) ? ((float) i3) / constraintWidget.N() : ((float) i3) * constraintWidget.N());
            }
        }
        bVar.a(constraintWidget, aVar);
        constraintWidget.o(aVar.f2348h);
        constraintWidget.p(aVar.f2349i);
        constraintWidget.c(aVar.f2351k);
        constraintWidget.s(aVar.f2350j);
        aVar.f2353m = b.a.f2341a;
        return aVar.f2352l;
    }

    private void ae() {
        this.aE = 0;
        this.aF = 0;
    }

    private void b(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.f2421az.a(solverVariable, this.f2421az.a((Object) constraintAnchor), 0, 5);
    }

    private void d(ConstraintWidget constraintWidget) {
        int i2 = this.aE + 1;
        c[] cVarArr = this.aH;
        if (i2 >= cVarArr.length) {
            this.aH = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.aH[this.aE] = new c(constraintWidget, 0, Y());
        this.aE++;
    }

    private void e(ConstraintWidget constraintWidget) {
        int i2 = this.aF + 1;
        c[] cVarArr = this.aG;
        if (i2 >= cVarArr.length) {
            this.aG = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.aG[this.aF] = new c(constraintWidget, 1, Y());
        this.aF++;
    }

    public boolean X() {
        return this.aV;
    }

    public boolean Y() {
        return this.aS;
    }

    /* JADX WARNING: type inference failed for: r6v5, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r6v8 */
    public void Z() {
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        ? r6;
        this.O = 0;
        this.P = 0;
        this.aU = false;
        this.aV = false;
        int size = this.aR.size();
        int max = Math.max(0, A());
        int max2 = Math.max(0, B());
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.I[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.I[0];
        androidx.constraintlayout.solver.e eVar = this.f2420ay;
        if (eVar != null) {
            eVar.D++;
        }
        if (i.a(this.aT, 1)) {
            g.a(this, g());
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) this.aR.get(i4);
                if (constraintWidget.p() && !(constraintWidget instanceof f) && !(constraintWidget instanceof a) && !(constraintWidget instanceof j) && !constraintWidget.l()) {
                    if (!(constraintWidget.v(0) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f2276l != 1 && constraintWidget.v(1) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f2277m != 1)) {
                        a(constraintWidget, this.f2419ax, new b.a(), b.a.f2341a);
                    }
                }
            }
        }
        if (size <= 2 || (!(dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || !i.a(this.aT, 1024) || !h.a(this, g()))) {
            i2 = max2;
            i3 = max;
            z2 = false;
        } else {
            if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (max >= A() || max <= 0) {
                    max = A();
                } else {
                    o(max);
                    this.aU = true;
                }
            }
            if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (max2 >= B() || max2 <= 0) {
                    max2 = B();
                } else {
                    p(max2);
                    this.aV = true;
                }
            }
            i2 = max2;
            i3 = max;
            z2 = true;
        }
        boolean z4 = b(64) || b(128);
        this.f2421az.f2153j = false;
        this.f2421az.f2154k = false;
        if (this.aT != 0 && z4) {
            this.f2421az.f2154k = true;
        }
        ArrayList arrayList = this.aR;
        boolean z5 = S() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || T() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        ae();
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget2 = (ConstraintWidget) this.aR.get(i5);
            if (constraintWidget2 instanceof k) {
                ((k) constraintWidget2).Z();
            }
        }
        boolean b2 = b(64);
        boolean z6 = z2;
        int i6 = 0;
        boolean z7 = true;
        while (z7) {
            int i7 = i6 + 1;
            try {
                this.f2421az.b();
                ae();
                a(this.f2421az);
                for (int i8 = 0; i8 < size; i8++) {
                    ((ConstraintWidget) this.aR.get(i8)).a(this.f2421az);
                }
                z7 = b(this.f2421az);
                WeakReference<ConstraintAnchor> weakReference = this.aW;
                if (!(weakReference == null || weakReference.get() == null)) {
                    a((ConstraintAnchor) this.aW.get(), this.f2421az.a((Object) this.f2290z));
                    this.aW = null;
                }
                WeakReference<ConstraintAnchor> weakReference2 = this.aY;
                if (!(weakReference2 == null || weakReference2.get() == null)) {
                    b((ConstraintAnchor) this.aY.get(), this.f2421az.a((Object) this.B));
                    this.aY = null;
                }
                WeakReference<ConstraintAnchor> weakReference3 = this.aX;
                if (!(weakReference3 == null || weakReference3.get() == null)) {
                    a((ConstraintAnchor) this.aX.get(), this.f2421az.a((Object) this.f2289y));
                    this.aX = null;
                }
                WeakReference<ConstraintAnchor> weakReference4 = this.aZ;
                if (!(weakReference4 == null || weakReference4.get() == null)) {
                    b((ConstraintAnchor) this.aZ.get(), this.f2421az.a((Object) this.A));
                    this.aZ = null;
                }
                if (z7) {
                    this.f2421az.f();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                System.out.println("EXCEPTION : " + e2);
            }
            androidx.constraintlayout.solver.d dVar = this.f2421az;
            if (z7) {
                a(dVar, i.f2449a);
            } else {
                b(dVar, b2);
                for (int i9 = 0; i9 < size; i9++) {
                    ((ConstraintWidget) this.aR.get(i9)).b(this.f2421az, b2);
                }
            }
            if (!z5 || i7 >= 8 || !i.f2449a[2]) {
                z3 = false;
            } else {
                int i10 = 0;
                int i11 = 0;
                for (int i12 = 0; i12 < size; i12++) {
                    ConstraintWidget constraintWidget3 = (ConstraintWidget) this.aR.get(i12);
                    i10 = Math.max(i10, constraintWidget3.O + constraintWidget3.A());
                    i11 = Math.max(i11, constraintWidget3.P + constraintWidget3.B());
                }
                int max3 = Math.max(this.V, i10);
                int max4 = Math.max(this.W, i11);
                if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || A() >= max3) {
                    z3 = false;
                } else {
                    o(max3);
                    this.I[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    z3 = true;
                    z6 = true;
                }
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && B() < max4) {
                    p(max4);
                    this.I[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    z3 = true;
                    z6 = true;
                }
            }
            int max5 = Math.max(this.V, A());
            if (max5 > A()) {
                o(max5);
                this.I[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                z3 = true;
                z6 = true;
            }
            int max6 = Math.max(this.W, B());
            if (max6 > B()) {
                p(max6);
                r6 = 1;
                this.I[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                z3 = true;
                z6 = true;
            } else {
                r6 = 1;
            }
            if (!z6) {
                if (this.I[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && i3 > 0 && A() > i3) {
                    this.aU = r6;
                    this.I[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                    o(i3);
                    z3 = true;
                    z6 = true;
                }
                if (this.I[r6] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && i2 > 0 && B() > i2) {
                    this.aV = r6;
                    this.I[r6] = ConstraintWidget.DimensionBehaviour.FIXED;
                    p(i2);
                    z6 = true;
                    z7 = true;
                    i6 = i7;
                }
            }
            z7 = z3;
            i6 = i7;
        }
        this.aR = arrayList;
        if (z6) {
            this.I[0] = dimensionBehaviour2;
            this.I[1] = dimensionBehaviour;
        }
        a(this.f2421az.g());
    }

    public long a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = i9;
        this.aA = i11;
        int i12 = i10;
        this.aB = i12;
        return this.f2417a.a(this, i2, i11, i12, i3, i4, i5, i6, i7, i8);
    }

    public void a(int i2) {
        this.aT = i2;
        androidx.constraintlayout.solver.d.f2140a = b(512);
    }

    public void a(androidx.constraintlayout.solver.d dVar, boolean[] zArr) {
        zArr[2] = false;
        boolean b2 = b(64);
        b(dVar, b2);
        int size = this.aR.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ConstraintWidget) this.aR.get(i2)).b(dVar, b2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.aW;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.d() > ((ConstraintAnchor) this.aW.get()).d()) {
            this.aW = new WeakReference<>(constraintAnchor);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ConstraintWidget constraintWidget, int i2) {
        if (i2 == 0) {
            d(constraintWidget);
        } else if (i2 == 1) {
            e(constraintWidget);
        }
    }

    public void a(b.C0022b bVar) {
        this.f2419ax = bVar;
        this.f2418aw.a(bVar);
    }

    public void a(boolean z2, boolean z3) {
        super.a(z2, z3);
        int size = this.aR.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ConstraintWidget) this.aR.get(i2)).a(z2, z3);
        }
    }

    public boolean a(boolean z2) {
        return this.f2418aw.a(z2);
    }

    public boolean a(boolean z2, int i2) {
        return this.f2418aw.a(z2, i2);
    }

    public boolean aa() {
        return false;
    }

    public androidx.constraintlayout.solver.d ab() {
        return this.f2421az;
    }

    public void b() {
        this.f2418aw.b();
    }

    public void b(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.aX;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.d() > ((ConstraintAnchor) this.aX.get()).d()) {
            this.aX = new WeakReference<>(constraintAnchor);
        }
    }

    public boolean b(int i2) {
        return (this.aT & i2) == i2;
    }

    public boolean b(androidx.constraintlayout.solver.d dVar) {
        boolean b2 = b(64);
        a(dVar, b2);
        int size = this.aR.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.aR.get(i2);
            constraintWidget.a(0, false);
            constraintWidget.a(1, false);
            if (constraintWidget instanceof a) {
                z2 = true;
            }
        }
        if (z2) {
            for (int i3 = 0; i3 < size; i3++) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) this.aR.get(i3);
                if (constraintWidget2 instanceof a) {
                    ((a) constraintWidget2).f();
                }
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            ConstraintWidget constraintWidget3 = (ConstraintWidget) this.aR.get(i4);
            if (constraintWidget3.W()) {
                constraintWidget3.a(dVar, b2);
            }
        }
        if (androidx.constraintlayout.solver.d.f2140a) {
            HashSet hashSet = new HashSet();
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget4 = (ConstraintWidget) this.aR.get(i5);
                if (!constraintWidget4.W()) {
                    hashSet.add(constraintWidget4);
                }
            }
            a(this, dVar, (HashSet<ConstraintWidget>) hashSet, S() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                ConstraintWidget constraintWidget5 = (ConstraintWidget) it2.next();
                i.a(this, dVar, constraintWidget5);
                constraintWidget5.a(dVar, b2);
            }
        } else {
            for (int i6 = 0; i6 < size; i6++) {
                ConstraintWidget constraintWidget6 = (ConstraintWidget) this.aR.get(i6);
                if (constraintWidget6 instanceof d) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget6.I[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget6.I[1];
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget6.a(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget6.b(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget6.a(dVar, b2);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget6.a(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget6.b(dimensionBehaviour2);
                    }
                } else {
                    i.a(this, dVar, constraintWidget6);
                    if (!constraintWidget6.W()) {
                        constraintWidget6.a(dVar, b2);
                    }
                }
            }
        }
        if (this.aE > 0) {
            b.a(this, dVar, (ArrayList<ConstraintWidget>) null, 0);
        }
        if (this.aF > 0) {
            b.a(this, dVar, (ArrayList<ConstraintWidget>) null, 1);
        }
        return true;
    }

    public void c() {
        this.f2418aw.c();
    }

    /* access modifiers changed from: package-private */
    public void c(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.aY;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.d() > ((ConstraintAnchor) this.aY.get()).d()) {
            this.aY = new WeakReference<>(constraintAnchor);
        }
    }

    public void d(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.aZ;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.d() > ((ConstraintAnchor) this.aZ.get()).d()) {
            this.aZ = new WeakReference<>(constraintAnchor);
        }
    }

    public void f() {
        this.f2417a.a(this);
    }

    public boolean f(boolean z2) {
        return this.f2418aw.b(z2);
    }

    public b.C0022b g() {
        return this.f2419ax;
    }

    public void g(boolean z2) {
        this.aS = z2;
    }

    public int h() {
        return this.aT;
    }

    public boolean i() {
        return this.aU;
    }

    public void s() {
        this.f2421az.b();
        this.aA = 0;
        this.aC = 0;
        this.aB = 0;
        this.aD = 0;
        this.aN = false;
        super.s();
    }
}
