package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2140a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2141b = true;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f2142c = true;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f2143d = true;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f2144e = true;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f2145f = false;

    /* renamed from: o  reason: collision with root package name */
    public static e f2146o = null;

    /* renamed from: p  reason: collision with root package name */
    public static long f2147p = 0;

    /* renamed from: q  reason: collision with root package name */
    public static long f2148q = 0;

    /* renamed from: r  reason: collision with root package name */
    private static int f2149r = 1000;
    private a A;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2150g;

    /* renamed from: h  reason: collision with root package name */
    int f2151h;

    /* renamed from: i  reason: collision with root package name */
    b[] f2152i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2153j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2154k;

    /* renamed from: l  reason: collision with root package name */
    int f2155l;

    /* renamed from: m  reason: collision with root package name */
    int f2156m;

    /* renamed from: n  reason: collision with root package name */
    final c f2157n;

    /* renamed from: s  reason: collision with root package name */
    private HashMap<String, SolverVariable> f2158s;

    /* renamed from: t  reason: collision with root package name */
    private a f2159t;

    /* renamed from: u  reason: collision with root package name */
    private int f2160u;

    /* renamed from: v  reason: collision with root package name */
    private int f2161v;

    /* renamed from: w  reason: collision with root package name */
    private boolean[] f2162w;

    /* renamed from: x  reason: collision with root package name */
    private int f2163x;

    /* renamed from: y  reason: collision with root package name */
    private SolverVariable[] f2164y;

    /* renamed from: z  reason: collision with root package name */
    private int f2165z;

    interface a {
        SolverVariable a(d dVar, boolean[] zArr);

        void a(a aVar);

        void d(SolverVariable solverVariable);

        boolean e();

        void f();

        SolverVariable g();
    }

    class b extends b {
        public b(c cVar) {
            this.f2134e = new h(this, cVar);
        }
    }

    public d() {
        this.f2150g = false;
        this.f2151h = 0;
        this.f2158s = null;
        this.f2160u = 32;
        this.f2161v = 32;
        this.f2152i = null;
        this.f2153j = false;
        this.f2154k = false;
        this.f2162w = new boolean[32];
        this.f2155l = 1;
        this.f2156m = 0;
        this.f2163x = 32;
        this.f2164y = new SolverVariable[f2149r];
        this.f2165z = 0;
        this.f2152i = new b[32];
        i();
        c cVar = new c();
        this.f2157n = cVar;
        this.f2159t = new g(cVar);
        this.A = f2145f ? new b(cVar) : new b(cVar);
    }

    private final int a(a aVar, boolean z2) {
        e eVar = f2146o;
        if (eVar != null) {
            eVar.f2174h++;
        }
        for (int i2 = 0; i2 < this.f2155l; i2++) {
            this.f2162w[i2] = false;
        }
        boolean z3 = false;
        int i3 = 0;
        while (!z3) {
            e eVar2 = f2146o;
            if (eVar2 != null) {
                eVar2.f2175i++;
            }
            i3++;
            if (i3 >= this.f2155l * 2) {
                return i3;
            }
            if (aVar.g() != null) {
                this.f2162w[aVar.g().f2096b] = true;
            }
            SolverVariable a2 = aVar.a(this, this.f2162w);
            if (a2 != null) {
                if (this.f2162w[a2.f2096b]) {
                    return i3;
                }
                this.f2162w[a2.f2096b] = true;
            }
            if (a2 != null) {
                float f2 = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.f2156m; i5++) {
                    b bVar = this.f2152i[i5];
                    if (bVar.f2130a.f2103i != SolverVariable.Type.UNRESTRICTED && !bVar.f2135f && bVar.a(a2)) {
                        float b2 = bVar.f2134e.b(a2);
                        if (b2 < 0.0f) {
                            float f3 = (-bVar.f2131b) / b2;
                            if (f3 < f2) {
                                i4 = i5;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    b bVar2 = this.f2152i[i4];
                    bVar2.f2130a.f2097c = -1;
                    e eVar3 = f2146o;
                    if (eVar3 != null) {
                        eVar3.f2176j++;
                    }
                    bVar2.b(a2);
                    bVar2.f2130a.f2097c = i4;
                    bVar2.f2130a.a(this, bVar2);
                }
            } else {
                z3 = true;
            }
        }
        return i3;
    }

    private SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable a2 = this.f2157n.f2138c.a();
        if (a2 == null) {
            a2 = new SolverVariable(type, str);
        } else {
            a2.b();
        }
        a2.a(type, str);
        int i2 = this.f2165z;
        int i3 = f2149r;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            f2149r = i4;
            this.f2164y = (SolverVariable[]) Arrays.copyOf(this.f2164y, i4);
        }
        SolverVariable[] solverVariableArr = this.f2164y;
        int i5 = this.f2165z;
        this.f2165z = i5 + 1;
        solverVariableArr[i5] = a2;
        return a2;
    }

    public static b a(d dVar, SolverVariable solverVariable, SolverVariable solverVariable2, float f2) {
        return dVar.c().a(solverVariable, solverVariable2, f2);
    }

    public static e a() {
        return f2146o;
    }

    private int b(a aVar) throws Exception {
        boolean z2;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f2156m) {
                z2 = false;
                break;
            } else if (this.f2152i[i2].f2130a.f2103i != SolverVariable.Type.UNRESTRICTED && this.f2152i[i2].f2131b < 0.0f) {
                z2 = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z2) {
            return 0;
        }
        boolean z3 = false;
        int i3 = 0;
        while (!z3) {
            e eVar = f2146o;
            if (eVar != null) {
                eVar.f2177k++;
            }
            i3++;
            float f2 = Float.MAX_VALUE;
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < this.f2156m; i7++) {
                b bVar = this.f2152i[i7];
                if (bVar.f2130a.f2103i != SolverVariable.Type.UNRESTRICTED && !bVar.f2135f && bVar.f2131b < 0.0f) {
                    int i8 = 9;
                    if (f2144e) {
                        int c2 = bVar.f2134e.c();
                        int i9 = 0;
                        while (i9 < c2) {
                            SolverVariable a2 = bVar.f2134e.a(i9);
                            float b2 = bVar.f2134e.b(a2);
                            if (b2 > 0.0f) {
                                int i10 = 0;
                                while (i10 < i8) {
                                    float f3 = a2.f2101g[i10] / b2;
                                    if ((f3 < f2 && i10 == i6) || i10 > i6) {
                                        i5 = a2.f2096b;
                                        i6 = i10;
                                        i4 = i7;
                                        f2 = f3;
                                    }
                                    i10++;
                                    i8 = 9;
                                }
                            }
                            i9++;
                            i8 = 9;
                        }
                    } else {
                        for (int i11 = 1; i11 < this.f2155l; i11++) {
                            SolverVariable solverVariable = this.f2157n.f2139d[i11];
                            float b3 = bVar.f2134e.b(solverVariable);
                            if (b3 > 0.0f) {
                                for (int i12 = 0; i12 < 9; i12++) {
                                    float f4 = solverVariable.f2101g[i12] / b3;
                                    if ((f4 < f2 && i12 == i6) || i12 > i6) {
                                        i5 = i11;
                                        i6 = i12;
                                        i4 = i7;
                                        f2 = f4;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i4 != -1) {
                b bVar2 = this.f2152i[i4];
                bVar2.f2130a.f2097c = -1;
                e eVar2 = f2146o;
                if (eVar2 != null) {
                    eVar2.f2176j++;
                }
                bVar2.b(this.f2157n.f2139d[i5]);
                bVar2.f2130a.f2097c = i4;
                bVar2.f2130a.a(this, bVar2);
            } else {
                z3 = true;
            }
            if (i3 > this.f2155l / 2) {
                z3 = true;
            }
        }
        return i3;
    }

    private final void b(b bVar) {
        int i2;
        if (!f2142c || !bVar.f2135f) {
            this.f2152i[this.f2156m] = bVar;
            bVar.f2130a.f2097c = this.f2156m;
            this.f2156m++;
            bVar.f2130a.a(this, bVar);
        } else {
            bVar.f2130a.a(this, bVar.f2131b);
        }
        if (f2142c && this.f2150g) {
            int i3 = 0;
            while (i3 < this.f2156m) {
                if (this.f2152i[i3] == null) {
                    System.out.println("WTF");
                }
                b[] bVarArr = this.f2152i;
                if (bVarArr[i3] != null && bVarArr[i3].f2135f) {
                    b bVar2 = this.f2152i[i3];
                    bVar2.f2130a.a(this, bVar2.f2131b);
                    (f2145f ? this.f2157n.f2136a : this.f2157n.f2137b).a(bVar2);
                    this.f2152i[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i2 = this.f2156m;
                        if (i4 >= i2) {
                            break;
                        }
                        b[] bVarArr2 = this.f2152i;
                        int i6 = i4 - 1;
                        bVarArr2[i6] = bVarArr2[i4];
                        if (bVarArr2[i6].f2130a.f2097c == i4) {
                            this.f2152i[i6].f2130a.f2097c = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i2) {
                        this.f2152i[i5] = null;
                    }
                    this.f2156m = i2 - 1;
                    i3--;
                }
                i3++;
            }
            this.f2150g = false;
        }
    }

    private void h() {
        int i2 = this.f2160u * 2;
        this.f2160u = i2;
        this.f2152i = (b[]) Arrays.copyOf(this.f2152i, i2);
        c cVar = this.f2157n;
        cVar.f2139d = (SolverVariable[]) Arrays.copyOf(cVar.f2139d, this.f2160u);
        int i3 = this.f2160u;
        this.f2162w = new boolean[i3];
        this.f2161v = i3;
        this.f2163x = i3;
        e eVar = f2146o;
        if (eVar != null) {
            eVar.f2170d++;
            e eVar2 = f2146o;
            eVar2.f2181o = Math.max(eVar2.f2181o, (long) this.f2160u);
            e eVar3 = f2146o;
            eVar3.f2190x = eVar3.f2181o;
        }
    }

    private void i() {
        int i2 = 0;
        if (f2145f) {
            while (i2 < this.f2156m) {
                b bVar = this.f2152i[i2];
                if (bVar != null) {
                    this.f2157n.f2136a.a(bVar);
                }
                this.f2152i[i2] = null;
                i2++;
            }
            return;
        }
        while (i2 < this.f2156m) {
            b bVar2 = this.f2152i[i2];
            if (bVar2 != null) {
                this.f2157n.f2137b.a(bVar2);
            }
            this.f2152i[i2] = null;
            i2++;
        }
    }

    private void j() {
        for (int i2 = 0; i2 < this.f2156m; i2++) {
            b bVar = this.f2152i[i2];
            bVar.f2130a.f2099e = bVar.f2131b;
        }
    }

    public SolverVariable a(int i2, String str) {
        e eVar = f2146o;
        if (eVar != null) {
            eVar.f2178l++;
        }
        if (this.f2155l + 1 >= this.f2161v) {
            h();
        }
        SolverVariable a2 = a(SolverVariable.Type.ERROR, str);
        int i3 = this.f2151h + 1;
        this.f2151h = i3;
        this.f2155l++;
        a2.f2096b = i3;
        a2.f2098d = i2;
        this.f2157n.f2139d[this.f2151h] = a2;
        this.f2159t.d(a2);
        return a2;
    }

    public SolverVariable a(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f2155l + 1 >= this.f2161v) {
            h();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.g();
            if (solverVariable == null) {
                constraintAnchor.a(this.f2157n);
                solverVariable = constraintAnchor.g();
            }
            if (solverVariable.f2096b == -1 || solverVariable.f2096b > this.f2151h || this.f2157n.f2139d[solverVariable.f2096b] == null) {
                if (solverVariable.f2096b != -1) {
                    solverVariable.b();
                }
                int i2 = this.f2151h + 1;
                this.f2151h = i2;
                this.f2155l++;
                solverVariable.f2096b = i2;
                solverVariable.f2103i = SolverVariable.Type.UNRESTRICTED;
                this.f2157n.f2139d[this.f2151h] = solverVariable;
            }
        }
        return solverVariable;
    }

    public void a(SolverVariable solverVariable, int i2) {
        b bVar;
        if (!f2141b || solverVariable.f2097c != -1) {
            int i3 = solverVariable.f2097c;
            if (solverVariable.f2097c != -1) {
                b bVar2 = this.f2152i[i3];
                if (!bVar2.f2135f) {
                    if (bVar2.f2134e.c() == 0) {
                        bVar2.f2135f = true;
                    } else {
                        bVar = c();
                        bVar.b(solverVariable, i2);
                    }
                }
                bVar2.f2131b = (float) i2;
                return;
            }
            bVar = c();
            bVar.a(solverVariable, i2);
            a(bVar);
            return;
        }
        float f2 = (float) i2;
        solverVariable.a(this, f2);
        for (int i4 = 0; i4 < this.f2151h + 1; i4++) {
            SolverVariable solverVariable2 = this.f2157n.f2139d[i4];
            if (solverVariable2 != null && solverVariable2.f2107m && solverVariable2.f2108n == solverVariable.f2096b) {
                solverVariable2.a(this, solverVariable2.f2109o + f2);
            }
        }
    }

    public void a(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3, int i4) {
        int i5 = i4;
        b c2 = c();
        c2.a(solverVariable, solverVariable2, i2, f2, solverVariable3, solverVariable4, i3);
        if (i5 != 8) {
            c2.a(this, i5);
        }
        a(c2);
    }

    public void a(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        b c2 = c();
        SolverVariable d2 = d();
        d2.f2098d = 0;
        c2.a(solverVariable, solverVariable2, d2, i2);
        if (i3 != 8) {
            a(c2, (int) (c2.f2134e.b(d2) * -1.0f), i3);
        }
        a(c2);
    }

    public void a(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z2) {
        b c2 = c();
        SolverVariable d2 = d();
        d2.f2098d = 0;
        c2.a(solverVariable, solverVariable2, d2, i2);
        a(c2);
    }

    public void a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2, int i2) {
        b c2 = c();
        c2.a(solverVariable, solverVariable2, solverVariable3, solverVariable4, f2);
        if (i2 != 8) {
            c2.a(this, i2);
        }
        a(c2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.constraintlayout.solver.b r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            androidx.constraintlayout.solver.e r0 = f2146o
            r1 = 1
            if (r0 == 0) goto L_0x0019
            long r3 = r0.f2172f
            long r3 = r3 + r1
            r0.f2172f = r3
            boolean r0 = r8.f2135f
            if (r0 == 0) goto L_0x0019
            androidx.constraintlayout.solver.e r0 = f2146o
            long r3 = r0.f2173g
            long r3 = r3 + r1
            r0.f2173g = r3
        L_0x0019:
            int r0 = r7.f2156m
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.f2163x
            if (r0 >= r4) goto L_0x0028
            int r0 = r7.f2155l
            int r0 = r0 + r3
            int r4 = r7.f2161v
            if (r0 < r4) goto L_0x002b
        L_0x0028:
            r7.h()
        L_0x002b:
            r0 = 0
            boolean r4 = r8.f2135f
            if (r4 != 0) goto L_0x00a0
            r8.c((androidx.constraintlayout.solver.d) r7)
            boolean r4 = r8.e()
            if (r4 == 0) goto L_0x003a
            return
        L_0x003a:
            r8.d()
            boolean r4 = r8.a((androidx.constraintlayout.solver.d) r7)
            if (r4 == 0) goto L_0x0097
            androidx.constraintlayout.solver.SolverVariable r4 = r7.e()
            r8.f2130a = r4
            int r5 = r7.f2156m
            r7.b((androidx.constraintlayout.solver.b) r8)
            int r6 = r7.f2156m
            int r5 = r5 + r3
            if (r6 != r5) goto L_0x0097
            androidx.constraintlayout.solver.d$a r0 = r7.A
            r0.a(r8)
            androidx.constraintlayout.solver.d$a r0 = r7.A
            r7.a((androidx.constraintlayout.solver.d.a) r0, (boolean) r3)
            int r0 = r4.f2097c
            r5 = -1
            if (r0 != r5) goto L_0x0098
            androidx.constraintlayout.solver.SolverVariable r0 = r8.f2130a
            if (r0 != r4) goto L_0x0078
            androidx.constraintlayout.solver.SolverVariable r0 = r8.c((androidx.constraintlayout.solver.SolverVariable) r4)
            if (r0 == 0) goto L_0x0078
            androidx.constraintlayout.solver.e r4 = f2146o
            if (r4 == 0) goto L_0x0075
            long r5 = r4.f2176j
            long r5 = r5 + r1
            r4.f2176j = r5
        L_0x0075:
            r8.b((androidx.constraintlayout.solver.SolverVariable) r0)
        L_0x0078:
            boolean r0 = r8.f2135f
            if (r0 != 0) goto L_0x0081
            androidx.constraintlayout.solver.SolverVariable r0 = r8.f2130a
            r0.a((androidx.constraintlayout.solver.d) r7, (androidx.constraintlayout.solver.b) r8)
        L_0x0081:
            boolean r0 = f2145f
            if (r0 == 0) goto L_0x008a
            androidx.constraintlayout.solver.c r0 = r7.f2157n
            androidx.constraintlayout.solver.f$a<androidx.constraintlayout.solver.b> r0 = r0.f2136a
            goto L_0x008e
        L_0x008a:
            androidx.constraintlayout.solver.c r0 = r7.f2157n
            androidx.constraintlayout.solver.f$a<androidx.constraintlayout.solver.b> r0 = r0.f2137b
        L_0x008e:
            r0.a(r8)
            int r0 = r7.f2156m
            int r0 = r0 - r3
            r7.f2156m = r0
            goto L_0x0098
        L_0x0097:
            r3 = 0
        L_0x0098:
            boolean r0 = r8.a()
            if (r0 != 0) goto L_0x009f
            return
        L_0x009f:
            r0 = r3
        L_0x00a0:
            if (r0 != 0) goto L_0x00a5
            r7.b((androidx.constraintlayout.solver.b) r8)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.d.a(androidx.constraintlayout.solver.b):void");
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar, int i2, int i3) {
        bVar.c(a(i3, (String) null), i2);
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) throws Exception {
        e eVar = f2146o;
        if (eVar != null) {
            eVar.f2186t++;
            e eVar2 = f2146o;
            eVar2.f2187u = Math.max(eVar2.f2187u, (long) this.f2155l);
            e eVar3 = f2146o;
            eVar3.f2188v = Math.max(eVar3.f2188v, (long) this.f2156m);
        }
        b(aVar);
        a(aVar, false);
        j();
    }

    public void a(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f2, int i2) {
        ConstraintWidget constraintWidget3 = constraintWidget;
        ConstraintWidget constraintWidget4 = constraintWidget2;
        SolverVariable a2 = a((Object) constraintWidget3.a(ConstraintAnchor.Type.LEFT));
        SolverVariable a3 = a((Object) constraintWidget3.a(ConstraintAnchor.Type.TOP));
        SolverVariable a4 = a((Object) constraintWidget3.a(ConstraintAnchor.Type.RIGHT));
        SolverVariable a5 = a((Object) constraintWidget3.a(ConstraintAnchor.Type.BOTTOM));
        SolverVariable a6 = a((Object) constraintWidget4.a(ConstraintAnchor.Type.LEFT));
        SolverVariable a7 = a((Object) constraintWidget4.a(ConstraintAnchor.Type.TOP));
        SolverVariable a8 = a((Object) constraintWidget4.a(ConstraintAnchor.Type.RIGHT));
        SolverVariable a9 = a((Object) constraintWidget4.a(ConstraintAnchor.Type.BOTTOM));
        b c2 = c();
        double d2 = (double) f2;
        double sin = Math.sin(d2);
        SolverVariable solverVariable = a4;
        double d3 = (double) i2;
        Double.isNaN(d3);
        c2.b(a3, a5, a7, a9, (float) (sin * d3));
        a(c2);
        b c3 = c();
        double cos = Math.cos(d2);
        Double.isNaN(d3);
        c3.b(a2, solverVariable, a6, a8, (float) (cos * d3));
        a(c3);
    }

    public int b(Object obj) {
        SolverVariable g2 = ((ConstraintAnchor) obj).g();
        if (g2 != null) {
            return (int) (g2.f2099e + 0.5f);
        }
        return 0;
    }

    public void b() {
        for (SolverVariable solverVariable : this.f2157n.f2139d) {
            if (solverVariable != null) {
                solverVariable.b();
            }
        }
        this.f2157n.f2138c.a(this.f2164y, this.f2165z);
        this.f2165z = 0;
        Arrays.fill(this.f2157n.f2139d, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.f2158s;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f2151h = 0;
        this.f2159t.f();
        this.f2155l = 1;
        for (int i2 = 0; i2 < this.f2156m; i2++) {
            b[] bVarArr = this.f2152i;
            if (bVarArr[i2] != null) {
                bVarArr[i2].f2132c = false;
            }
        }
        i();
        this.f2156m = 0;
        this.A = f2145f ? new b(this.f2157n) : new b(this.f2157n);
    }

    public void b(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        b c2 = c();
        SolverVariable d2 = d();
        d2.f2098d = 0;
        c2.b(solverVariable, solverVariable2, d2, i2);
        if (i3 != 8) {
            a(c2, (int) (c2.f2134e.b(d2) * -1.0f), i3);
        }
        a(c2);
    }

    public void b(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z2) {
        b c2 = c();
        SolverVariable d2 = d();
        d2.f2098d = 0;
        c2.b(solverVariable, solverVariable2, d2, i2);
        a(c2);
    }

    public b c() {
        b bVar;
        if (f2145f) {
            bVar = this.f2157n.f2136a.a();
            if (bVar == null) {
                bVar = new b(this.f2157n);
                f2148q++;
                SolverVariable.a();
                return bVar;
            }
        } else {
            bVar = this.f2157n.f2137b.a();
            if (bVar == null) {
                bVar = new b(this.f2157n);
                f2147p++;
                SolverVariable.a();
                return bVar;
            }
        }
        bVar.c();
        SolverVariable.a();
        return bVar;
    }

    public b c(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        if (!f2141b || i3 != 8 || !solverVariable2.f2100f || solverVariable.f2097c != -1) {
            b c2 = c();
            c2.a(solverVariable, solverVariable2, i2);
            if (i3 != 8) {
                c2.a(this, i3);
            }
            a(c2);
            return c2;
        }
        solverVariable.a(this, solverVariable2.f2099e + ((float) i2));
        return null;
    }

    public SolverVariable d() {
        e eVar = f2146o;
        if (eVar != null) {
            eVar.f2179m++;
        }
        if (this.f2155l + 1 >= this.f2161v) {
            h();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, (String) null);
        int i2 = this.f2151h + 1;
        this.f2151h = i2;
        this.f2155l++;
        a2.f2096b = i2;
        this.f2157n.f2139d[this.f2151h] = a2;
        return a2;
    }

    public SolverVariable e() {
        e eVar = f2146o;
        if (eVar != null) {
            eVar.f2180n++;
        }
        if (this.f2155l + 1 >= this.f2161v) {
            h();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, (String) null);
        int i2 = this.f2151h + 1;
        this.f2151h = i2;
        this.f2155l++;
        a2.f2096b = i2;
        this.f2157n.f2139d[this.f2151h] = a2;
        return a2;
    }

    public void f() throws Exception {
        e eVar = f2146o;
        if (eVar != null) {
            eVar.f2171e++;
        }
        if (this.f2159t.e()) {
            j();
            return;
        }
        if (this.f2153j || this.f2154k) {
            e eVar2 = f2146o;
            if (eVar2 != null) {
                eVar2.f2183q++;
            }
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= this.f2156m) {
                    z2 = true;
                    break;
                } else if (!this.f2152i[i2].f2135f) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                e eVar3 = f2146o;
                if (eVar3 != null) {
                    eVar3.f2182p++;
                }
                j();
                return;
            }
        }
        a(this.f2159t);
    }

    public c g() {
        return this.f2157n;
    }
}
