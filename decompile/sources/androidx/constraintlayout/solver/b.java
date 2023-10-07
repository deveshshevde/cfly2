package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.d;
import java.util.ArrayList;

public class b implements d.a {

    /* renamed from: a  reason: collision with root package name */
    SolverVariable f2130a = null;

    /* renamed from: b  reason: collision with root package name */
    float f2131b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    boolean f2132c = false;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<SolverVariable> f2133d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public a f2134e;

    /* renamed from: f  reason: collision with root package name */
    boolean f2135f = false;

    public interface a {
        float a(SolverVariable solverVariable, boolean z2);

        float a(b bVar, boolean z2);

        SolverVariable a(int i2);

        void a();

        void a(float f2);

        void a(SolverVariable solverVariable, float f2);

        void a(SolverVariable solverVariable, float f2, boolean z2);

        boolean a(SolverVariable solverVariable);

        float b(int i2);

        float b(SolverVariable solverVariable);

        void b();

        int c();
    }

    public b() {
    }

    public b(c cVar) {
        this.f2134e = new a(this, cVar);
    }

    private SolverVariable a(boolean[] zArr, SolverVariable solverVariable) {
        int c2 = this.f2134e.c();
        SolverVariable solverVariable2 = null;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < c2; i2++) {
            float b2 = this.f2134e.b(i2);
            if (b2 < 0.0f) {
                SolverVariable a2 = this.f2134e.a(i2);
                if ((zArr == null || !zArr[a2.f2096b]) && a2 != solverVariable && ((a2.f2103i == SolverVariable.Type.SLACK || a2.f2103i == SolverVariable.Type.ERROR) && b2 < f2)) {
                    f2 = b2;
                    solverVariable2 = a2;
                }
            }
        }
        return solverVariable2;
    }

    private boolean a(SolverVariable solverVariable, d dVar) {
        return solverVariable.f2106l <= 1;
    }

    public SolverVariable a(d dVar, boolean[] zArr) {
        return a(zArr, (SolverVariable) null);
    }

    public b a(float f2, float f3, float f4, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f2131b = 0.0f;
        if (f3 == 0.0f || f2 == f4) {
            this.f2134e.a(solverVariable, 1.0f);
            this.f2134e.a(solverVariable2, -1.0f);
            this.f2134e.a(solverVariable4, 1.0f);
            this.f2134e.a(solverVariable3, -1.0f);
        } else if (f2 == 0.0f) {
            this.f2134e.a(solverVariable, 1.0f);
            this.f2134e.a(solverVariable2, -1.0f);
        } else if (f4 == 0.0f) {
            this.f2134e.a(solverVariable3, 1.0f);
            this.f2134e.a(solverVariable4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.f2134e.a(solverVariable, 1.0f);
            this.f2134e.a(solverVariable2, -1.0f);
            this.f2134e.a(solverVariable4, f5);
            this.f2134e.a(solverVariable3, -f5);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public b a(SolverVariable solverVariable, int i2) {
        this.f2130a = solverVariable;
        float f2 = (float) i2;
        solverVariable.f2099e = f2;
        this.f2131b = f2;
        this.f2135f = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, float f2) {
        this.f2134e.a(solverVariable, -1.0f);
        this.f2134e.a(solverVariable2, f2);
        return this;
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, int i2) {
        boolean z2 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z2 = true;
            }
            this.f2131b = (float) i2;
        }
        if (!z2) {
            this.f2134e.a(solverVariable, -1.0f);
            this.f2134e.a(solverVariable2, 1.0f);
        } else {
            this.f2134e.a(solverVariable, 1.0f);
            this.f2134e.a(solverVariable2, -1.0f);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3) {
        float f3;
        int i4;
        if (solverVariable2 == solverVariable3) {
            this.f2134e.a(solverVariable, 1.0f);
            this.f2134e.a(solverVariable4, 1.0f);
            this.f2134e.a(solverVariable2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.f2134e.a(solverVariable, 1.0f);
            this.f2134e.a(solverVariable2, -1.0f);
            this.f2134e.a(solverVariable3, -1.0f);
            this.f2134e.a(solverVariable4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                i4 = (-i2) + i3;
            }
            return this;
        }
        if (f2 <= 0.0f) {
            this.f2134e.a(solverVariable, -1.0f);
            this.f2134e.a(solverVariable2, 1.0f);
            f3 = (float) i2;
        } else if (f2 >= 1.0f) {
            this.f2134e.a(solverVariable4, -1.0f);
            this.f2134e.a(solverVariable3, 1.0f);
            i4 = -i3;
        } else {
            float f4 = 1.0f - f2;
            this.f2134e.a(solverVariable, f4 * 1.0f);
            this.f2134e.a(solverVariable2, f4 * -1.0f);
            this.f2134e.a(solverVariable3, -1.0f * f2);
            this.f2134e.a(solverVariable4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                f3 = (((float) (-i2)) * f4) + (((float) i3) * f2);
            }
            return this;
        }
        this.f2131b = f3;
        return this;
        f3 = (float) i4;
        this.f2131b = f3;
        return this;
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
        boolean z2 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z2 = true;
            }
            this.f2131b = (float) i2;
        }
        if (!z2) {
            this.f2134e.a(solverVariable, -1.0f);
            this.f2134e.a(solverVariable2, 1.0f);
            this.f2134e.a(solverVariable3, 1.0f);
        } else {
            this.f2134e.a(solverVariable, 1.0f);
            this.f2134e.a(solverVariable2, -1.0f);
            this.f2134e.a(solverVariable3, -1.0f);
        }
        return this;
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.f2134e.a(solverVariable, -1.0f);
        this.f2134e.a(solverVariable2, 1.0f);
        this.f2134e.a(solverVariable3, f2);
        this.f2134e.a(solverVariable4, -f2);
        return this;
    }

    public b a(d dVar, int i2) {
        this.f2134e.a(dVar.a(i2, "ep"), 1.0f);
        this.f2134e.a(dVar.a(i2, "em"), -1.0f);
        return this;
    }

    public void a(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f2130a = null;
            this.f2134e.a();
            for (int i2 = 0; i2 < bVar.f2134e.c(); i2++) {
                this.f2134e.a(bVar.f2134e.a(i2), bVar.f2134e.b(i2), true);
            }
        }
    }

    public void a(d dVar, SolverVariable solverVariable, boolean z2) {
        if (solverVariable.f2100f) {
            this.f2131b += solverVariable.f2099e * this.f2134e.b(solverVariable);
            this.f2134e.a(solverVariable, z2);
            if (z2) {
                solverVariable.b(this);
            }
            if (d.f2142c && solverVariable != null && this.f2134e.c() == 0) {
                this.f2135f = true;
                dVar.f2150g = true;
            }
        }
    }

    public void a(d dVar, b bVar, boolean z2) {
        this.f2131b += bVar.f2131b * this.f2134e.a(bVar, z2);
        if (z2) {
            bVar.f2130a.b(this);
        }
        if (d.f2142c && this.f2130a != null && this.f2134e.c() == 0) {
            this.f2135f = true;
            dVar.f2150g = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        SolverVariable solverVariable = this.f2130a;
        return solverVariable != null && (solverVariable.f2103i == SolverVariable.Type.UNRESTRICTED || this.f2131b >= 0.0f);
    }

    /* access modifiers changed from: package-private */
    public boolean a(SolverVariable solverVariable) {
        return this.f2134e.a(solverVariable);
    }

    /* access modifiers changed from: package-private */
    public boolean a(d dVar) {
        boolean z2;
        SolverVariable b2 = b(dVar);
        if (b2 == null) {
            z2 = true;
        } else {
            b(b2);
            z2 = false;
        }
        if (this.f2134e.c() == 0) {
            this.f2135f = true;
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable b(d dVar) {
        int c2 = this.f2134e.c();
        SolverVariable solverVariable = null;
        SolverVariable solverVariable2 = null;
        boolean z2 = false;
        boolean z3 = false;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < c2; i2++) {
            float b2 = this.f2134e.b(i2);
            SolverVariable a2 = this.f2134e.a(i2);
            if (a2.f2103i == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null || f2 > b2) {
                    z2 = a(a2, dVar);
                    f2 = b2;
                    solverVariable = a2;
                } else if (!z2 && a(a2, dVar)) {
                    f2 = b2;
                    solverVariable = a2;
                    z2 = true;
                }
            } else if (solverVariable == null && b2 < 0.0f) {
                if (solverVariable2 == null || f3 > b2) {
                    z3 = a(a2, dVar);
                    f3 = b2;
                    solverVariable2 = a2;
                } else if (!z3 && a(a2, dVar)) {
                    f3 = b2;
                    solverVariable2 = a2;
                    z3 = true;
                }
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    public b b(SolverVariable solverVariable, int i2) {
        a aVar;
        float f2;
        if (i2 < 0) {
            this.f2131b = (float) (i2 * -1);
            aVar = this.f2134e;
            f2 = 1.0f;
        } else {
            this.f2131b = (float) i2;
            aVar = this.f2134e;
            f2 = -1.0f;
        }
        aVar.a(solverVariable, f2);
        return this;
    }

    public b b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
        boolean z2 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z2 = true;
            }
            this.f2131b = (float) i2;
        }
        if (!z2) {
            this.f2134e.a(solverVariable, -1.0f);
            this.f2134e.a(solverVariable2, 1.0f);
            this.f2134e.a(solverVariable3, -1.0f);
        } else {
            this.f2134e.a(solverVariable, 1.0f);
            this.f2134e.a(solverVariable2, -1.0f);
            this.f2134e.a(solverVariable3, 1.0f);
        }
        return this;
    }

    public b b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.f2134e.a(solverVariable3, 0.5f);
        this.f2134e.a(solverVariable4, 0.5f);
        this.f2134e.a(solverVariable, -0.5f);
        this.f2134e.a(solverVariable2, -0.5f);
        this.f2131b = -f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b() {
        /*
            r9 = this;
            androidx.constraintlayout.solver.SolverVariable r0 = r9.f2130a
            if (r0 != 0) goto L_0x0007
            java.lang.String r0 = "0"
            goto L_0x001a
        L_0x0007:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            r0.append(r1)
            androidx.constraintlayout.solver.SolverVariable r1 = r9.f2130a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x001a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r9.f2131b
            r2 = 0
            r3 = 1
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0047
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r9.f2131b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            goto L_0x0048
        L_0x0047:
            r1 = 0
        L_0x0048:
            androidx.constraintlayout.solver.b$a r5 = r9.f2134e
            int r5 = r5.c()
        L_0x004e:
            if (r2 >= r5) goto L_0x00cb
            androidx.constraintlayout.solver.b$a r6 = r9.f2134e
            androidx.constraintlayout.solver.SolverVariable r6 = r6.a((int) r2)
            if (r6 != 0) goto L_0x0059
            goto L_0x00c8
        L_0x0059:
            androidx.constraintlayout.solver.b$a r7 = r9.f2134e
            float r7 = r7.b((int) r2)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 != 0) goto L_0x0064
            goto L_0x00c8
        L_0x0064:
            java.lang.String r6 = r6.toString()
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x007b
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00a4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            goto L_0x009b
        L_0x007b:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x0091
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00a4
        L_0x0091:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
        L_0x009b:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r7 = r7 * r8
        L_0x00a4:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00b0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L_0x00bd
        L_0x00b0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
        L_0x00bd:
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            r1 = 1
        L_0x00c8:
            int r2 = r2 + 1
            goto L_0x004e
        L_0x00cb:
            if (r1 != 0) goto L_0x00de
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00de:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.b.b():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public void b(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f2130a;
        if (solverVariable2 != null) {
            this.f2134e.a(solverVariable2, -1.0f);
            this.f2130a.f2097c = -1;
            this.f2130a = null;
        }
        float a2 = this.f2134e.a(solverVariable, true) * -1.0f;
        this.f2130a = solverVariable;
        if (a2 != 1.0f) {
            this.f2131b /= a2;
            this.f2134e.a(a2);
        }
    }

    public void b(d dVar, SolverVariable solverVariable, boolean z2) {
        if (solverVariable.f2107m) {
            float b2 = this.f2134e.b(solverVariable);
            this.f2131b += solverVariable.f2109o * b2;
            this.f2134e.a(solverVariable, z2);
            if (z2) {
                solverVariable.b(this);
            }
            this.f2134e.a(dVar.f2157n.f2139d[solverVariable.f2108n], b2, z2);
            if (d.f2142c && solverVariable != null && this.f2134e.c() == 0) {
                this.f2135f = true;
                dVar.f2150g = true;
            }
        }
    }

    public SolverVariable c(SolverVariable solverVariable) {
        return a((boolean[]) null, solverVariable);
    }

    /* access modifiers changed from: package-private */
    public b c(SolverVariable solverVariable, int i2) {
        this.f2134e.a(solverVariable, (float) i2);
        return this;
    }

    public void c() {
        this.f2130a = null;
        this.f2134e.a();
        this.f2131b = 0.0f;
        this.f2135f = false;
    }

    public void c(d dVar) {
        if (dVar.f2152i.length != 0) {
            boolean z2 = false;
            while (!z2) {
                int c2 = this.f2134e.c();
                for (int i2 = 0; i2 < c2; i2++) {
                    SolverVariable a2 = this.f2134e.a(i2);
                    if (a2.f2097c != -1 || a2.f2100f || a2.f2107m) {
                        this.f2133d.add(a2);
                    }
                }
                int size = this.f2133d.size();
                if (size > 0) {
                    for (int i3 = 0; i3 < size; i3++) {
                        SolverVariable solverVariable = this.f2133d.get(i3);
                        if (solverVariable.f2100f) {
                            a(dVar, solverVariable, true);
                        } else if (solverVariable.f2107m) {
                            b(dVar, solverVariable, true);
                        } else {
                            a(dVar, dVar.f2152i[solverVariable.f2097c], true);
                        }
                    }
                    this.f2133d.clear();
                } else {
                    z2 = true;
                }
            }
            if (d.f2142c && this.f2130a != null && this.f2134e.c() == 0) {
                this.f2135f = true;
                dVar.f2150g = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        float f2 = this.f2131b;
        if (f2 < 0.0f) {
            this.f2131b = f2 * -1.0f;
            this.f2134e.b();
        }
    }

    public void d(SolverVariable solverVariable) {
        float f2 = 1.0f;
        if (solverVariable.f2098d != 1) {
            if (solverVariable.f2098d == 2) {
                f2 = 1000.0f;
            } else if (solverVariable.f2098d == 3) {
                f2 = 1000000.0f;
            } else if (solverVariable.f2098d == 4) {
                f2 = 1.0E9f;
            } else if (solverVariable.f2098d == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f2134e.a(solverVariable, f2);
    }

    public boolean e() {
        return this.f2130a == null && this.f2131b == 0.0f && this.f2134e.c() == 0;
    }

    public void f() {
        this.f2134e.a();
        this.f2130a = null;
        this.f2131b = 0.0f;
    }

    public SolverVariable g() {
        return this.f2130a;
    }

    public String toString() {
        return b();
    }
}
