package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.b;
import java.util.Arrays;

public class a implements b.a {

    /* renamed from: l  reason: collision with root package name */
    private static float f2118l = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    int f2119a = 0;

    /* renamed from: b  reason: collision with root package name */
    protected final c f2120b;

    /* renamed from: c  reason: collision with root package name */
    private final b f2121c;

    /* renamed from: d  reason: collision with root package name */
    private int f2122d = 8;

    /* renamed from: e  reason: collision with root package name */
    private SolverVariable f2123e = null;

    /* renamed from: f  reason: collision with root package name */
    private int[] f2124f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    private int[] f2125g = new int[8];

    /* renamed from: h  reason: collision with root package name */
    private float[] f2126h = new float[8];

    /* renamed from: i  reason: collision with root package name */
    private int f2127i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f2128j = -1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2129k = false;

    a(b bVar, c cVar) {
        this.f2121c = bVar;
        this.f2120b = cVar;
    }

    public final float a(SolverVariable solverVariable, boolean z2) {
        if (this.f2123e == solverVariable) {
            this.f2123e = null;
        }
        int i2 = this.f2127i;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f2119a) {
            if (this.f2124f[i2] == solverVariable.f2096b) {
                if (i2 == this.f2127i) {
                    this.f2127i = this.f2125g[i2];
                } else {
                    int[] iArr = this.f2125g;
                    iArr[i4] = iArr[i2];
                }
                if (z2) {
                    solverVariable.b(this.f2121c);
                }
                solverVariable.f2106l--;
                this.f2119a--;
                this.f2124f[i2] = -1;
                if (this.f2129k) {
                    this.f2128j = i2;
                }
                return this.f2126h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f2125g[i2];
        }
        return 0.0f;
    }

    public float a(b bVar, boolean z2) {
        float b2 = b(bVar.f2130a);
        a(bVar.f2130a, z2);
        b.a aVar = bVar.f2134e;
        int c2 = aVar.c();
        for (int i2 = 0; i2 < c2; i2++) {
            SolverVariable a2 = aVar.a(i2);
            a(a2, aVar.b(a2) * b2, z2);
        }
        return b2;
    }

    public SolverVariable a(int i2) {
        int i3 = this.f2127i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f2119a) {
            if (i4 == i2) {
                return this.f2120b.f2139d[this.f2124f[i3]];
            }
            i3 = this.f2125g[i3];
            i4++;
        }
        return null;
    }

    public final void a() {
        int i2 = this.f2127i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2119a) {
            SolverVariable solverVariable = this.f2120b.f2139d[this.f2124f[i2]];
            if (solverVariable != null) {
                solverVariable.b(this.f2121c);
            }
            i2 = this.f2125g[i2];
            i3++;
        }
        this.f2127i = -1;
        this.f2128j = -1;
        this.f2129k = false;
        this.f2119a = 0;
    }

    public void a(float f2) {
        int i2 = this.f2127i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2119a) {
            float[] fArr = this.f2126h;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f2125g[i2];
            i3++;
        }
    }

    public final void a(SolverVariable solverVariable, float f2) {
        if (f2 == 0.0f) {
            a(solverVariable, true);
            return;
        }
        int i2 = this.f2127i;
        if (i2 == -1) {
            this.f2127i = 0;
            this.f2126h[0] = f2;
            this.f2124f[0] = solverVariable.f2096b;
            this.f2125g[this.f2127i] = -1;
            solverVariable.f2106l++;
            solverVariable.a(this.f2121c);
            this.f2119a++;
            if (!this.f2129k) {
                int i3 = this.f2128j + 1;
                this.f2128j = i3;
                int[] iArr = this.f2124f;
                if (i3 >= iArr.length) {
                    this.f2129k = true;
                    this.f2128j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i2 != -1 && i4 < this.f2119a) {
            if (this.f2124f[i2] == solverVariable.f2096b) {
                this.f2126h[i2] = f2;
                return;
            }
            if (this.f2124f[i2] < solverVariable.f2096b) {
                i5 = i2;
            }
            i2 = this.f2125g[i2];
            i4++;
        }
        int i6 = this.f2128j;
        int i7 = i6 + 1;
        if (this.f2129k) {
            int[] iArr2 = this.f2124f;
            if (iArr2[i6] != -1) {
                i6 = iArr2.length;
            }
        } else {
            i6 = i7;
        }
        int[] iArr3 = this.f2124f;
        if (i6 >= iArr3.length && this.f2119a < iArr3.length) {
            int i8 = 0;
            while (true) {
                int[] iArr4 = this.f2124f;
                if (i8 >= iArr4.length) {
                    break;
                } else if (iArr4[i8] == -1) {
                    i6 = i8;
                    break;
                } else {
                    i8++;
                }
            }
        }
        int[] iArr5 = this.f2124f;
        if (i6 >= iArr5.length) {
            i6 = iArr5.length;
            int i9 = this.f2122d * 2;
            this.f2122d = i9;
            this.f2129k = false;
            this.f2128j = i6 - 1;
            this.f2126h = Arrays.copyOf(this.f2126h, i9);
            this.f2124f = Arrays.copyOf(this.f2124f, this.f2122d);
            this.f2125g = Arrays.copyOf(this.f2125g, this.f2122d);
        }
        this.f2124f[i6] = solverVariable.f2096b;
        this.f2126h[i6] = f2;
        int[] iArr6 = this.f2125g;
        if (i5 != -1) {
            iArr6[i6] = iArr6[i5];
            iArr6[i5] = i6;
        } else {
            iArr6[i6] = this.f2127i;
            this.f2127i = i6;
        }
        solverVariable.f2106l++;
        solverVariable.a(this.f2121c);
        int i10 = this.f2119a + 1;
        this.f2119a = i10;
        if (!this.f2129k) {
            this.f2128j++;
        }
        int[] iArr7 = this.f2124f;
        if (i10 >= iArr7.length) {
            this.f2129k = true;
        }
        if (this.f2128j >= iArr7.length) {
            this.f2129k = true;
            this.f2128j = iArr7.length - 1;
        }
    }

    public void a(SolverVariable solverVariable, float f2, boolean z2) {
        float f3 = f2118l;
        if (f2 <= (-f3) || f2 >= f3) {
            int i2 = this.f2127i;
            if (i2 == -1) {
                this.f2127i = 0;
                this.f2126h[0] = f2;
                this.f2124f[0] = solverVariable.f2096b;
                this.f2125g[this.f2127i] = -1;
                solverVariable.f2106l++;
                solverVariable.a(this.f2121c);
                this.f2119a++;
                if (!this.f2129k) {
                    int i3 = this.f2128j + 1;
                    this.f2128j = i3;
                    int[] iArr = this.f2124f;
                    if (i3 >= iArr.length) {
                        this.f2129k = true;
                        this.f2128j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i2 != -1 && i4 < this.f2119a) {
                if (this.f2124f[i2] == solverVariable.f2096b) {
                    float[] fArr = this.f2126h;
                    float f4 = fArr[i2] + f2;
                    float f5 = f2118l;
                    if (f4 > (-f5) && f4 < f5) {
                        f4 = 0.0f;
                    }
                    fArr[i2] = f4;
                    if (f4 == 0.0f) {
                        if (i2 == this.f2127i) {
                            this.f2127i = this.f2125g[i2];
                        } else {
                            int[] iArr2 = this.f2125g;
                            iArr2[i5] = iArr2[i2];
                        }
                        if (z2) {
                            solverVariable.b(this.f2121c);
                        }
                        if (this.f2129k) {
                            this.f2128j = i2;
                        }
                        solverVariable.f2106l--;
                        this.f2119a--;
                        return;
                    }
                    return;
                }
                if (this.f2124f[i2] < solverVariable.f2096b) {
                    i5 = i2;
                }
                i2 = this.f2125g[i2];
                i4++;
            }
            int i6 = this.f2128j;
            int i7 = i6 + 1;
            if (this.f2129k) {
                int[] iArr3 = this.f2124f;
                if (iArr3[i6] != -1) {
                    i6 = iArr3.length;
                }
            } else {
                i6 = i7;
            }
            int[] iArr4 = this.f2124f;
            if (i6 >= iArr4.length && this.f2119a < iArr4.length) {
                int i8 = 0;
                while (true) {
                    int[] iArr5 = this.f2124f;
                    if (i8 >= iArr5.length) {
                        break;
                    } else if (iArr5[i8] == -1) {
                        i6 = i8;
                        break;
                    } else {
                        i8++;
                    }
                }
            }
            int[] iArr6 = this.f2124f;
            if (i6 >= iArr6.length) {
                i6 = iArr6.length;
                int i9 = this.f2122d * 2;
                this.f2122d = i9;
                this.f2129k = false;
                this.f2128j = i6 - 1;
                this.f2126h = Arrays.copyOf(this.f2126h, i9);
                this.f2124f = Arrays.copyOf(this.f2124f, this.f2122d);
                this.f2125g = Arrays.copyOf(this.f2125g, this.f2122d);
            }
            this.f2124f[i6] = solverVariable.f2096b;
            this.f2126h[i6] = f2;
            int[] iArr7 = this.f2125g;
            if (i5 != -1) {
                iArr7[i6] = iArr7[i5];
                iArr7[i5] = i6;
            } else {
                iArr7[i6] = this.f2127i;
                this.f2127i = i6;
            }
            solverVariable.f2106l++;
            solverVariable.a(this.f2121c);
            this.f2119a++;
            if (!this.f2129k) {
                this.f2128j++;
            }
            int i10 = this.f2128j;
            int[] iArr8 = this.f2124f;
            if (i10 >= iArr8.length) {
                this.f2129k = true;
                this.f2128j = iArr8.length - 1;
            }
        }
    }

    public boolean a(SolverVariable solverVariable) {
        int i2 = this.f2127i;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2119a) {
            if (this.f2124f[i2] == solverVariable.f2096b) {
                return true;
            }
            i2 = this.f2125g[i2];
            i3++;
        }
        return false;
    }

    public float b(int i2) {
        int i3 = this.f2127i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f2119a) {
            if (i4 == i2) {
                return this.f2126h[i3];
            }
            i3 = this.f2125g[i3];
            i4++;
        }
        return 0.0f;
    }

    public final float b(SolverVariable solverVariable) {
        int i2 = this.f2127i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2119a) {
            if (this.f2124f[i2] == solverVariable.f2096b) {
                return this.f2126h[i2];
            }
            i2 = this.f2125g[i2];
            i3++;
        }
        return 0.0f;
    }

    public void b() {
        int i2 = this.f2127i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2119a) {
            float[] fArr = this.f2126h;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.f2125g[i2];
            i3++;
        }
    }

    public int c() {
        return this.f2119a;
    }

    public String toString() {
        int i2 = this.f2127i;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2119a) {
            str = ((str + " -> ") + this.f2126h[i2] + " : ") + this.f2120b.f2139d[this.f2124f[i2]];
            i2 = this.f2125g[i2];
            i3++;
        }
        return str;
    }
}
