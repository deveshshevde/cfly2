package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.d;
import androidx.constraintlayout.solver.widgets.f;
import androidx.constraintlayout.solver.widgets.g;
import androidx.constraintlayout.solver.widgets.i;
import androidx.constraintlayout.solver.widgets.j;
import java.util.ArrayList;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<ConstraintWidget> f2338a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private a f2339b = new a();

    /* renamed from: c  reason: collision with root package name */
    private d f2340c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f2341a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static int f2342b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static int f2343c = 2;

        /* renamed from: d  reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f2344d;

        /* renamed from: e  reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f2345e;

        /* renamed from: f  reason: collision with root package name */
        public int f2346f;

        /* renamed from: g  reason: collision with root package name */
        public int f2347g;

        /* renamed from: h  reason: collision with root package name */
        public int f2348h;

        /* renamed from: i  reason: collision with root package name */
        public int f2349i;

        /* renamed from: j  reason: collision with root package name */
        public int f2350j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f2351k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f2352l;

        /* renamed from: m  reason: collision with root package name */
        public int f2353m;
    }

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.b$b  reason: collision with other inner class name */
    public interface C0022b {
        void a();

        void a(ConstraintWidget constraintWidget, a aVar);
    }

    public b(d dVar) {
        this.f2340c = dVar;
    }

    private void a(d dVar, String str, int i2, int i3) {
        int C = dVar.C();
        int D = dVar.D();
        dVar.q(0);
        dVar.r(0);
        dVar.o(i2);
        dVar.p(i3);
        dVar.q(C);
        dVar.r(D);
        this.f2340c.Z();
    }

    private boolean a(C0022b bVar, ConstraintWidget constraintWidget, int i2) {
        this.f2339b.f2344d = constraintWidget.S();
        this.f2339b.f2345e = constraintWidget.T();
        this.f2339b.f2346f = constraintWidget.A();
        this.f2339b.f2347g = constraintWidget.B();
        this.f2339b.f2352l = false;
        this.f2339b.f2353m = i2;
        boolean z2 = this.f2339b.f2344d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = this.f2339b.f2345e == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z4 = z2 && constraintWidget.M > 0.0f;
        boolean z5 = z3 && constraintWidget.M > 0.0f;
        if (z4 && constraintWidget.f2278n[0] == 4) {
            this.f2339b.f2344d = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z5 && constraintWidget.f2278n[1] == 4) {
            this.f2339b.f2345e = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        bVar.a(constraintWidget, this.f2339b);
        constraintWidget.o(this.f2339b.f2348h);
        constraintWidget.p(this.f2339b.f2349i);
        constraintWidget.c(this.f2339b.f2351k);
        constraintWidget.s(this.f2339b.f2350j);
        this.f2339b.f2353m = a.f2341a;
        return this.f2339b.f2352l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a0, code lost:
        if (r8 != androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a7, code lost:
        if (r5.M <= 0.0f) goto L_0x00aa;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(androidx.constraintlayout.solver.widgets.d r12) {
        /*
            r11 = this;
            java.util.ArrayList r0 = r12.aR
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r12.b((int) r1)
            androidx.constraintlayout.solver.widgets.analyzer.b$b r2 = r12.g()
            r3 = 0
            r4 = 0
        L_0x0012:
            if (r4 >= r0) goto L_0x00c4
            java.util.ArrayList r5 = r12.aR
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r5
            boolean r6 = r5 instanceof androidx.constraintlayout.solver.widgets.f
            if (r6 == 0) goto L_0x0022
            goto L_0x00c0
        L_0x0022:
            boolean r6 = r5 instanceof androidx.constraintlayout.solver.widgets.a
            if (r6 == 0) goto L_0x0028
            goto L_0x00c0
        L_0x0028:
            boolean r6 = r5.l()
            if (r6 == 0) goto L_0x0030
            goto L_0x00c0
        L_0x0030:
            if (r1 == 0) goto L_0x004c
            androidx.constraintlayout.solver.widgets.analyzer.k r6 = r5.f2270f
            if (r6 == 0) goto L_0x004c
            androidx.constraintlayout.solver.widgets.analyzer.m r6 = r5.f2271g
            if (r6 == 0) goto L_0x004c
            androidx.constraintlayout.solver.widgets.analyzer.k r6 = r5.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.f r6 = r6.f2326g
            boolean r6 = r6.f2310j
            if (r6 == 0) goto L_0x004c
            androidx.constraintlayout.solver.widgets.analyzer.m r6 = r5.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.f r6 = r6.f2326g
            boolean r6 = r6.f2310j
            if (r6 == 0) goto L_0x004c
            goto L_0x00c0
        L_0x004c:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = r5.v(r3)
            r7 = 1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.v(r7)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r9) goto L_0x0067
            int r9 = r5.f2276l
            if (r9 == r7) goto L_0x0067
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 != r9) goto L_0x0067
            int r9 = r5.f2277m
            if (r9 == r7) goto L_0x0067
            r9 = 1
            goto L_0x0068
        L_0x0067:
            r9 = 0
        L_0x0068:
            if (r9 != 0) goto L_0x00aa
            boolean r10 = r12.b((int) r7)
            if (r10 == 0) goto L_0x00aa
            boolean r10 = r5 instanceof androidx.constraintlayout.solver.widgets.j
            if (r10 != 0) goto L_0x00aa
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r10) goto L_0x0087
            int r10 = r5.f2276l
            if (r10 != 0) goto L_0x0087
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 == r10) goto L_0x0087
            boolean r10 = r5.U()
            if (r10 != 0) goto L_0x0087
            r9 = 1
        L_0x0087:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 != r10) goto L_0x009a
            int r10 = r5.f2277m
            if (r10 != 0) goto L_0x009a
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 == r10) goto L_0x009a
            boolean r10 = r5.U()
            if (r10 != 0) goto L_0x009a
            r9 = 1
        L_0x009a:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 == r10) goto L_0x00a2
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 != r6) goto L_0x00aa
        L_0x00a2:
            float r6 = r5.M
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x00aa
            goto L_0x00ab
        L_0x00aa:
            r7 = r9
        L_0x00ab:
            if (r7 == 0) goto L_0x00ae
            goto L_0x00c0
        L_0x00ae:
            int r6 = androidx.constraintlayout.solver.widgets.analyzer.b.a.f2341a
            r11.a(r2, r5, r6)
            androidx.constraintlayout.solver.e r5 = r12.f2420ay
            if (r5 == 0) goto L_0x00c0
            androidx.constraintlayout.solver.e r5 = r12.f2420ay
            long r6 = r5.f2167a
            r8 = 1
            long r6 = r6 + r8
            r5.f2167a = r6
        L_0x00c0:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x00c4:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.b.b(androidx.constraintlayout.solver.widgets.d):void");
    }

    public long a(d dVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        boolean z2;
        int i12;
        boolean z3;
        boolean z4;
        int i13;
        boolean z5;
        C0022b bVar;
        int i14;
        int i15;
        int i16;
        boolean z6;
        boolean z7;
        d dVar2 = dVar;
        int i17 = i2;
        int i18 = i5;
        int i19 = i7;
        C0022b g2 = dVar.g();
        int size = dVar2.aR.size();
        int A = dVar.A();
        int B = dVar.B();
        boolean a2 = i.a(i17, 128);
        boolean z8 = a2 || i.a(i17, 64);
        if (z8) {
            int i20 = 0;
            while (true) {
                if (i20 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget = (ConstraintWidget) dVar2.aR.get(i20);
                boolean z9 = (constraintWidget.S() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (constraintWidget.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.N() > 0.0f;
                if ((!constraintWidget.U() || !z9) && ((!constraintWidget.V() || !z9) && !(constraintWidget instanceof j) && !constraintWidget.U() && !constraintWidget.V())) {
                    i20++;
                }
            }
            z8 = false;
        }
        if (z8 && androidx.constraintlayout.solver.d.f2146o != null) {
            androidx.constraintlayout.solver.d.f2146o.f2169c++;
        }
        boolean z10 = z8 & ((i18 == 1073741824 && i19 == 1073741824) || a2);
        if (z10) {
            int min = Math.min(dVar.n(), i6);
            int min2 = Math.min(dVar.m(), i8);
            if (i18 == 1073741824 && dVar.A() != min) {
                dVar2.o(min);
                dVar.b();
            }
            if (i19 == 1073741824 && dVar.B() != min2) {
                dVar2.p(min2);
                dVar.b();
            }
            if (i18 == 1073741824 && i19 == 1073741824) {
                z2 = dVar2.a(a2);
                i11 = 2;
            } else {
                boolean f2 = dVar2.f(a2);
                if (i18 == 1073741824) {
                    f2 &= dVar2.a(a2, 0);
                    i11 = 1;
                } else {
                    i11 = 0;
                }
                if (i19 == 1073741824) {
                    z2 = dVar2.a(a2, 1) & f2;
                    i11++;
                } else {
                    z2 = f2;
                }
            }
            if (z2) {
                dVar2.a(i18 == 1073741824, i19 == 1073741824);
            }
        } else {
            z2 = false;
            i11 = 0;
        }
        if (z2 && i11 == 2) {
            return 0;
        }
        int h2 = dVar.h();
        if (size > 0) {
            b(dVar);
        }
        a(dVar);
        int size2 = this.f2338a.size();
        if (size > 0) {
            a(dVar2, "First pass", A, B);
        }
        if (size2 > 0) {
            boolean z11 = dVar.S() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z12 = dVar.T() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            int max = Math.max(dVar.A(), this.f2340c.C());
            int max2 = Math.max(dVar.B(), this.f2340c.D());
            int i21 = 0;
            boolean z13 = false;
            while (i21 < size2) {
                ConstraintWidget constraintWidget2 = this.f2338a.get(i21);
                if (!(constraintWidget2 instanceof j)) {
                    i14 = h2;
                    i16 = A;
                    i15 = B;
                } else {
                    int A2 = constraintWidget2.A();
                    i14 = h2;
                    int B2 = constraintWidget2.B();
                    i16 = A;
                    boolean a3 = a(g2, constraintWidget2, a.f2342b) | z13;
                    if (dVar2.f2420ay != null) {
                        z6 = a3;
                        i15 = B;
                        dVar2.f2420ay.f2168b++;
                    } else {
                        z6 = a3;
                        i15 = B;
                    }
                    int A3 = constraintWidget2.A();
                    int B3 = constraintWidget2.B();
                    if (A3 != A2) {
                        constraintWidget2.o(A3);
                        if (z11 && constraintWidget2.E() > max) {
                            max = Math.max(max, constraintWidget2.E() + constraintWidget2.a(ConstraintAnchor.Type.RIGHT).j());
                        }
                        z7 = true;
                    } else {
                        z7 = z6;
                    }
                    if (B3 != B2) {
                        constraintWidget2.p(B3);
                        if (z12 && constraintWidget2.F() > max2) {
                            max2 = Math.max(max2, constraintWidget2.F() + constraintWidget2.a(ConstraintAnchor.Type.BOTTOM).j());
                        }
                        z7 = true;
                    }
                    z13 = z7 | ((j) constraintWidget2).h();
                }
                i21++;
                h2 = i14;
                A = i16;
                B = i15;
            }
            int i22 = h2;
            int i23 = A;
            int i24 = B;
            int i25 = 0;
            int i26 = 2;
            while (i25 < i26) {
                int i27 = 0;
                while (i27 < size2) {
                    ConstraintWidget constraintWidget3 = this.f2338a.get(i27);
                    if ((!(constraintWidget3 instanceof g) || (constraintWidget3 instanceof j)) && !(constraintWidget3 instanceof f) && constraintWidget3.w() != 8 && ((!z10 || !constraintWidget3.f2270f.f2326g.f2310j || !constraintWidget3.f2271g.f2326g.f2310j) && !(constraintWidget3 instanceof j))) {
                        int A4 = constraintWidget3.A();
                        int B4 = constraintWidget3.B();
                        int L = constraintWidget3.L();
                        int i28 = a.f2342b;
                        z5 = z10;
                        if (i25 == 1) {
                            i28 = a.f2343c;
                        }
                        boolean a4 = a(g2, constraintWidget3, i28) | z13;
                        if (dVar2.f2420ay != null) {
                            i13 = size2;
                            bVar = g2;
                            dVar2.f2420ay.f2168b++;
                        } else {
                            i13 = size2;
                            bVar = g2;
                        }
                        int A5 = constraintWidget3.A();
                        int B5 = constraintWidget3.B();
                        if (A5 != A4) {
                            constraintWidget3.o(A5);
                            if (z11 && constraintWidget3.E() > max) {
                                max = Math.max(max, constraintWidget3.E() + constraintWidget3.a(ConstraintAnchor.Type.RIGHT).j());
                            }
                            a4 = true;
                        }
                        if (B5 != B4) {
                            constraintWidget3.p(B5);
                            if (z12 && constraintWidget3.F() > max2) {
                                max2 = Math.max(max2, constraintWidget3.F() + constraintWidget3.a(ConstraintAnchor.Type.BOTTOM).j());
                            }
                            a4 = true;
                        }
                        z13 = (!constraintWidget3.K() || L == constraintWidget3.L()) ? a4 : true;
                    } else {
                        z5 = z10;
                        i13 = size2;
                        bVar = g2;
                    }
                    i27++;
                    size2 = i13;
                    g2 = bVar;
                    z10 = z5;
                }
                boolean z14 = z10;
                int i29 = size2;
                C0022b bVar2 = g2;
                if (!z13) {
                    break;
                }
                a(dVar2, "intermediate pass", i23, i24);
                i25++;
                g2 = bVar2;
                z10 = z14;
                i26 = 2;
                z13 = false;
                size2 = i29;
            }
            int i30 = i23;
            int i31 = i24;
            if (z13) {
                a(dVar2, "2nd pass", i30, i31);
                if (dVar.A() < max) {
                    dVar2.o(max);
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (dVar.B() < max2) {
                    dVar2.p(max2);
                    z4 = true;
                } else {
                    z4 = z3;
                }
                if (z4) {
                    a(dVar2, "3rd pass", i30, i31);
                }
            }
            i12 = i22;
        } else {
            i12 = h2;
        }
        dVar2.a(i12);
        return 0;
    }

    public void a(d dVar) {
        this.f2338a.clear();
        int size = dVar.aR.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) dVar.aR.get(i2);
            if (constraintWidget.S() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                this.f2338a.add(constraintWidget);
            }
        }
        dVar.b();
    }
}
