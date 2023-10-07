package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.b;
import java.util.Arrays;

public class h implements b.a {

    /* renamed from: j  reason: collision with root package name */
    private static float f2205j = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    int[] f2206a = new int[16];

    /* renamed from: b  reason: collision with root package name */
    int[] f2207b = new int[16];

    /* renamed from: c  reason: collision with root package name */
    int[] f2208c = new int[16];

    /* renamed from: d  reason: collision with root package name */
    float[] f2209d = new float[16];

    /* renamed from: e  reason: collision with root package name */
    int[] f2210e = new int[16];

    /* renamed from: f  reason: collision with root package name */
    int[] f2211f = new int[16];

    /* renamed from: g  reason: collision with root package name */
    int f2212g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f2213h = -1;

    /* renamed from: i  reason: collision with root package name */
    protected final c f2214i;

    /* renamed from: k  reason: collision with root package name */
    private final int f2215k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f2216l = 16;

    /* renamed from: m  reason: collision with root package name */
    private int f2217m = 16;

    /* renamed from: n  reason: collision with root package name */
    private final b f2218n;

    h(b bVar, c cVar) {
        this.f2218n = bVar;
        this.f2214i = cVar;
        a();
    }

    private void a(int i2, SolverVariable solverVariable, float f2) {
        this.f2208c[i2] = solverVariable.f2096b;
        this.f2209d[i2] = f2;
        this.f2210e[i2] = -1;
        this.f2211f[i2] = -1;
        solverVariable.a(this.f2218n);
        solverVariable.f2106l++;
        this.f2212g++;
    }

    private void a(SolverVariable solverVariable, int i2) {
        int[] iArr;
        int i3 = solverVariable.f2096b % this.f2217m;
        int[] iArr2 = this.f2206a;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            iArr2[i3] = i2;
        } else {
            while (true) {
                iArr = this.f2207b;
                if (iArr[i4] == -1) {
                    break;
                }
                i4 = iArr[i4];
            }
            iArr[i4] = i2;
        }
        this.f2207b[i2] = -1;
    }

    private void b(int i2, SolverVariable solverVariable, float f2) {
        int e2 = e();
        a(e2, solverVariable, f2);
        if (i2 != -1) {
            this.f2210e[e2] = i2;
            int[] iArr = this.f2211f;
            iArr[e2] = iArr[i2];
            iArr[i2] = e2;
        } else {
            this.f2210e[e2] = -1;
            if (this.f2212g > 0) {
                this.f2211f[e2] = this.f2213h;
                this.f2213h = e2;
            } else {
                this.f2211f[e2] = -1;
            }
        }
        int[] iArr2 = this.f2211f;
        if (iArr2[e2] != -1) {
            this.f2210e[iArr2[e2]] = e2;
        }
        a(solverVariable, e2);
    }

    private void d() {
        int i2 = this.f2216l * 2;
        this.f2208c = Arrays.copyOf(this.f2208c, i2);
        this.f2209d = Arrays.copyOf(this.f2209d, i2);
        this.f2210e = Arrays.copyOf(this.f2210e, i2);
        this.f2211f = Arrays.copyOf(this.f2211f, i2);
        this.f2207b = Arrays.copyOf(this.f2207b, i2);
        for (int i3 = this.f2216l; i3 < i2; i3++) {
            this.f2208c[i3] = -1;
            this.f2207b[i3] = -1;
        }
        this.f2216l = i2;
    }

    private void d(SolverVariable solverVariable) {
        int[] iArr;
        int i2 = solverVariable.f2096b % this.f2217m;
        int i3 = this.f2206a[i2];
        if (i3 != -1) {
            int i4 = solverVariable.f2096b;
            if (this.f2208c[i3] == i4) {
                int[] iArr2 = this.f2206a;
                int[] iArr3 = this.f2207b;
                iArr2[i2] = iArr3[i3];
                iArr3[i3] = -1;
                return;
            }
            while (true) {
                iArr = this.f2207b;
                if (iArr[i3] == -1 || this.f2208c[iArr[i3]] == i4) {
                    int i5 = iArr[i3];
                } else {
                    i3 = iArr[i3];
                }
            }
            int i52 = iArr[i3];
            if (i52 != -1 && this.f2208c[i52] == i4) {
                iArr[i3] = iArr[i52];
                iArr[i52] = -1;
            }
        }
    }

    private int e() {
        for (int i2 = 0; i2 < this.f2216l; i2++) {
            if (this.f2208c[i2] == -1) {
                return i2;
            }
        }
        return -1;
    }

    public float a(SolverVariable solverVariable, boolean z2) {
        int c2 = c(solverVariable);
        if (c2 == -1) {
            return 0.0f;
        }
        d(solverVariable);
        float f2 = this.f2209d[c2];
        if (this.f2213h == c2) {
            this.f2213h = this.f2211f[c2];
        }
        this.f2208c[c2] = -1;
        int[] iArr = this.f2210e;
        if (iArr[c2] != -1) {
            int[] iArr2 = this.f2211f;
            iArr2[iArr[c2]] = iArr2[c2];
        }
        int[] iArr3 = this.f2211f;
        if (iArr3[c2] != -1) {
            iArr[iArr3[c2]] = iArr[c2];
        }
        this.f2212g--;
        solverVariable.f2106l--;
        if (z2) {
            solverVariable.b(this.f2218n);
        }
        return f2;
    }

    public float a(b bVar, boolean z2) {
        float b2 = b(bVar.f2130a);
        a(bVar.f2130a, z2);
        h hVar = (h) bVar.f2134e;
        int c2 = hVar.c();
        int i2 = hVar.f2213h;
        int i3 = 0;
        int i4 = 0;
        while (i3 < c2) {
            if (hVar.f2208c[i4] != -1) {
                a(this.f2214i.f2139d[hVar.f2208c[i4]], hVar.f2209d[i4] * b2, z2);
                i3++;
            }
            i4++;
        }
        return b2;
    }

    public SolverVariable a(int i2) {
        int i3 = this.f2212g;
        if (i3 == 0) {
            return null;
        }
        int i4 = this.f2213h;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2 && i4 != -1) {
                return this.f2214i.f2139d[this.f2208c[i4]];
            }
            i4 = this.f2211f[i4];
            if (i4 == -1) {
                break;
            }
        }
        return null;
    }

    public void a() {
        int i2 = this.f2212g;
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable a2 = a(i3);
            if (a2 != null) {
                a2.b(this.f2218n);
            }
        }
        for (int i4 = 0; i4 < this.f2216l; i4++) {
            this.f2208c[i4] = -1;
            this.f2207b[i4] = -1;
        }
        for (int i5 = 0; i5 < this.f2217m; i5++) {
            this.f2206a[i5] = -1;
        }
        this.f2212g = 0;
        this.f2213h = -1;
    }

    public void a(float f2) {
        int i2 = this.f2212g;
        int i3 = this.f2213h;
        int i4 = 0;
        while (i4 < i2) {
            float[] fArr = this.f2209d;
            fArr[i3] = fArr[i3] / f2;
            i3 = this.f2211f[i3];
            if (i3 != -1) {
                i4++;
            } else {
                return;
            }
        }
    }

    public void a(SolverVariable solverVariable, float f2) {
        float f3 = f2205j;
        if (f2 <= (-f3) || f2 >= f3) {
            if (this.f2212g == 0) {
                a(0, solverVariable, f2);
                a(solverVariable, 0);
                this.f2213h = 0;
                return;
            }
            int c2 = c(solverVariable);
            if (c2 != -1) {
                this.f2209d[c2] = f2;
                return;
            }
            if (this.f2212g + 1 >= this.f2216l) {
                d();
            }
            int i2 = this.f2212g;
            int i3 = this.f2213h;
            int i4 = -1;
            for (int i5 = 0; i5 < i2; i5++) {
                if (this.f2208c[i3] == solverVariable.f2096b) {
                    this.f2209d[i3] = f2;
                    return;
                }
                if (this.f2208c[i3] < solverVariable.f2096b) {
                    i4 = i3;
                }
                i3 = this.f2211f[i3];
                if (i3 == -1) {
                    break;
                }
            }
            b(i4, solverVariable, f2);
            return;
        }
        a(solverVariable, true);
    }

    public void a(SolverVariable solverVariable, float f2, boolean z2) {
        float f3 = f2205j;
        if (f2 <= (-f3) || f2 >= f3) {
            int c2 = c(solverVariable);
            if (c2 == -1) {
                a(solverVariable, f2);
                return;
            }
            float[] fArr = this.f2209d;
            fArr[c2] = fArr[c2] + f2;
            float f4 = fArr[c2];
            float f5 = f2205j;
            if (f4 > (-f5) && fArr[c2] < f5) {
                fArr[c2] = 0.0f;
                a(solverVariable, z2);
            }
        }
    }

    public boolean a(SolverVariable solverVariable) {
        return c(solverVariable) != -1;
    }

    public float b(int i2) {
        int i3 = this.f2212g;
        int i4 = this.f2213h;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2) {
                return this.f2209d[i4];
            }
            i4 = this.f2211f[i4];
            if (i4 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public float b(SolverVariable solverVariable) {
        int c2 = c(solverVariable);
        if (c2 != -1) {
            return this.f2209d[c2];
        }
        return 0.0f;
    }

    public void b() {
        int i2 = this.f2212g;
        int i3 = this.f2213h;
        int i4 = 0;
        while (i4 < i2) {
            float[] fArr = this.f2209d;
            fArr[i3] = fArr[i3] * -1.0f;
            i3 = this.f2211f[i3];
            if (i3 != -1) {
                i4++;
            } else {
                return;
            }
        }
    }

    public int c() {
        return this.f2212g;
    }

    public int c(SolverVariable solverVariable) {
        int[] iArr;
        if (!(this.f2212g == 0 || solverVariable == null)) {
            int i2 = solverVariable.f2096b;
            int i3 = this.f2206a[i2 % this.f2217m];
            if (i3 == -1) {
                return -1;
            }
            if (this.f2208c[i3] == i2) {
                return i3;
            }
            while (true) {
                iArr = this.f2207b;
                if (iArr[i3] != -1 && this.f2208c[iArr[i3]] != i2) {
                    i3 = iArr[i3];
                }
            }
            if (iArr[i3] != -1 && this.f2208c[iArr[i3]] == i2) {
                return iArr[i3];
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder sb;
        String str;
        String str2 = hashCode() + " { ";
        int i2 = this.f2212g;
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable a2 = a(i3);
            if (a2 != null) {
                String str3 = str2 + a2 + " = " + b(i3) + " ";
                int c2 = c(a2);
                String str4 = str3 + "[p: ";
                if (this.f2210e[c2] != -1) {
                    sb = new StringBuilder();
                    sb.append(str4);
                    sb.append(this.f2214i.f2139d[this.f2208c[this.f2210e[c2]]]);
                } else {
                    sb = new StringBuilder();
                    sb.append(str4);
                    sb.append("none");
                }
                String str5 = sb.toString() + ", n: ";
                if (this.f2211f[c2] != -1) {
                    str = str5 + this.f2214i.f2139d[this.f2208c[this.f2211f[c2]]];
                } else {
                    str = str5 + "none";
                }
                str2 = str + "]";
            }
        }
        return str2 + " }";
    }
}
