package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.b;
import java.util.Arrays;
import java.util.Comparator;

public class g extends b {

    /* renamed from: g  reason: collision with root package name */
    a f2195g = new a(this);

    /* renamed from: h  reason: collision with root package name */
    c f2196h;

    /* renamed from: i  reason: collision with root package name */
    private int f2197i = 128;

    /* renamed from: j  reason: collision with root package name */
    private SolverVariable[] f2198j = new SolverVariable[128];

    /* renamed from: k  reason: collision with root package name */
    private SolverVariable[] f2199k = new SolverVariable[128];

    /* renamed from: l  reason: collision with root package name */
    private int f2200l = 0;

    class a implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        SolverVariable f2202a;

        /* renamed from: b  reason: collision with root package name */
        g f2203b;

        public a(g gVar) {
            this.f2203b = gVar;
        }

        public void a(SolverVariable solverVariable) {
            this.f2202a = solverVariable;
        }

        public final boolean a() {
            for (int i2 = 8; i2 >= 0; i2--) {
                float f2 = this.f2202a.f2102h[i2];
                if (f2 > 0.0f) {
                    return false;
                }
                if (f2 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public boolean a(SolverVariable solverVariable, float f2) {
            boolean z2 = true;
            if (this.f2202a.f2095a) {
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr = this.f2202a.f2102h;
                    fArr[i2] = fArr[i2] + (solverVariable.f2102h[i2] * f2);
                    if (Math.abs(this.f2202a.f2102h[i2]) < 1.0E-4f) {
                        this.f2202a.f2102h[i2] = 0.0f;
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    g.this.f(this.f2202a);
                }
                return false;
            }
            for (int i3 = 0; i3 < 9; i3++) {
                float f3 = solverVariable.f2102h[i3];
                if (f3 != 0.0f) {
                    float f4 = f3 * f2;
                    if (Math.abs(f4) < 1.0E-4f) {
                        f4 = 0.0f;
                    }
                    this.f2202a.f2102h[i3] = f4;
                } else {
                    this.f2202a.f2102h[i3] = 0.0f;
                }
            }
            return true;
        }

        public void b() {
            Arrays.fill(this.f2202a.f2102h, 0.0f);
        }

        public final boolean b(SolverVariable solverVariable) {
            int i2 = 8;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                float f2 = solverVariable.f2102h[i2];
                float f3 = this.f2202a.f2102h[i2];
                if (f3 == f2) {
                    i2--;
                } else if (f3 < f2) {
                    return true;
                }
            }
            return false;
        }

        public int compareTo(Object obj) {
            return this.f2202a.f2096b - ((SolverVariable) obj).f2096b;
        }

        public String toString() {
            String str = "[ ";
            if (this.f2202a != null) {
                for (int i2 = 0; i2 < 9; i2++) {
                    str = str + this.f2202a.f2102h[i2] + " ";
                }
            }
            return str + "] " + this.f2202a;
        }
    }

    public g(c cVar) {
        super(cVar);
        this.f2196h = cVar;
    }

    private final void e(SolverVariable solverVariable) {
        int i2;
        int i3 = this.f2200l + 1;
        SolverVariable[] solverVariableArr = this.f2198j;
        if (i3 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f2198j = solverVariableArr2;
            this.f2199k = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f2198j;
        int i4 = this.f2200l;
        solverVariableArr3[i4] = solverVariable;
        int i5 = i4 + 1;
        this.f2200l = i5;
        if (i5 > 1 && solverVariableArr3[i5 - 1].f2096b > solverVariable.f2096b) {
            int i6 = 0;
            while (true) {
                i2 = this.f2200l;
                if (i6 >= i2) {
                    break;
                }
                this.f2199k[i6] = this.f2198j[i6];
                i6++;
            }
            Arrays.sort(this.f2199k, 0, i2, new Comparator<SolverVariable>() {
                /* renamed from: a */
                public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
                    return solverVariable.f2096b - solverVariable2.f2096b;
                }
            });
            for (int i7 = 0; i7 < this.f2200l; i7++) {
                this.f2198j[i7] = this.f2199k[i7];
            }
        }
        solverVariable.f2095a = true;
        solverVariable.a(this);
    }

    /* access modifiers changed from: private */
    public final void f(SolverVariable solverVariable) {
        int i2 = 0;
        while (i2 < this.f2200l) {
            if (this.f2198j[i2] == solverVariable) {
                while (true) {
                    int i3 = this.f2200l;
                    if (i2 < i3 - 1) {
                        SolverVariable[] solverVariableArr = this.f2198j;
                        int i4 = i2 + 1;
                        solverVariableArr[i2] = solverVariableArr[i4];
                        i2 = i4;
                    } else {
                        this.f2200l = i3 - 1;
                        solverVariable.f2095a = false;
                        return;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    public SolverVariable a(d dVar, boolean[] zArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < this.f2200l; i3++) {
            SolverVariable solverVariable = this.f2198j[i3];
            if (!zArr[solverVariable.f2096b]) {
                this.f2195g.a(solverVariable);
                a aVar = this.f2195g;
                if (i2 == -1) {
                    if (!aVar.a()) {
                    }
                } else if (!aVar.b(this.f2198j[i2])) {
                }
                i2 = i3;
            }
        }
        if (i2 == -1) {
            return null;
        }
        return this.f2198j[i2];
    }

    public void a(d dVar, b bVar, boolean z2) {
        SolverVariable solverVariable = bVar.f2130a;
        if (solverVariable != null) {
            b.a aVar = bVar.f2134e;
            int c2 = aVar.c();
            for (int i2 = 0; i2 < c2; i2++) {
                SolverVariable a2 = aVar.a(i2);
                float b2 = aVar.b(i2);
                this.f2195g.a(a2);
                if (this.f2195g.a(solverVariable, b2)) {
                    e(a2);
                }
                this.f2131b += bVar.f2131b * b2;
            }
            f(solverVariable);
        }
    }

    public void d(SolverVariable solverVariable) {
        this.f2195g.a(solverVariable);
        this.f2195g.b();
        solverVariable.f2102h[solverVariable.f2098d] = 1.0f;
        e(solverVariable);
    }

    public boolean e() {
        return this.f2200l == 0;
    }

    public void f() {
        this.f2200l = 0;
        this.f2131b = 0.0f;
    }

    public String toString() {
        String str = "" + " goal -> (" + this.f2131b + ") : ";
        for (int i2 = 0; i2 < this.f2200l; i2++) {
            this.f2195g.a(this.f2198j[i2]);
            str = str + this.f2195g + " ";
        }
        return str;
    }
}
