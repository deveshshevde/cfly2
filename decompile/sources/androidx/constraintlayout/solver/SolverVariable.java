package androidx.constraintlayout.solver;

import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable {

    /* renamed from: q  reason: collision with root package name */
    private static int f2090q = 1;

    /* renamed from: r  reason: collision with root package name */
    private static int f2091r = 1;

    /* renamed from: s  reason: collision with root package name */
    private static int f2092s = 1;

    /* renamed from: t  reason: collision with root package name */
    private static int f2093t = 1;

    /* renamed from: u  reason: collision with root package name */
    private static int f2094u = 1;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2095a;

    /* renamed from: b  reason: collision with root package name */
    public int f2096b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f2097c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f2098d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f2099e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2100f = false;

    /* renamed from: g  reason: collision with root package name */
    float[] f2101g = new float[9];

    /* renamed from: h  reason: collision with root package name */
    float[] f2102h = new float[9];

    /* renamed from: i  reason: collision with root package name */
    Type f2103i;

    /* renamed from: j  reason: collision with root package name */
    b[] f2104j = new b[16];

    /* renamed from: k  reason: collision with root package name */
    int f2105k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f2106l = 0;

    /* renamed from: m  reason: collision with root package name */
    boolean f2107m = false;

    /* renamed from: n  reason: collision with root package name */
    int f2108n = -1;

    /* renamed from: o  reason: collision with root package name */
    float f2109o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    HashSet<b> f2110p = null;

    /* renamed from: v  reason: collision with root package name */
    private String f2111v;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.f2103i = type;
    }

    static void a() {
        f2091r++;
    }

    public void a(Type type, String str) {
        this.f2103i = type;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.f2105k;
            if (i2 >= i3) {
                b[] bVarArr = this.f2104j;
                if (i3 >= bVarArr.length) {
                    this.f2104j = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f2104j;
                int i4 = this.f2105k;
                bVarArr2[i4] = bVar;
                this.f2105k = i4 + 1;
                return;
            } else if (this.f2104j[i2] != bVar) {
                i2++;
            } else {
                return;
            }
        }
    }

    public void a(d dVar, float f2) {
        this.f2099e = f2;
        this.f2100f = true;
        this.f2107m = false;
        this.f2108n = -1;
        this.f2109o = 0.0f;
        int i2 = this.f2105k;
        this.f2097c = -1;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f2104j[i3].a(dVar, this, false);
        }
        this.f2105k = 0;
    }

    public final void a(d dVar, b bVar) {
        int i2 = this.f2105k;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f2104j[i3].a(dVar, bVar, false);
        }
        this.f2105k = 0;
    }

    public void b() {
        this.f2111v = null;
        this.f2103i = Type.UNKNOWN;
        this.f2098d = 0;
        this.f2096b = -1;
        this.f2097c = -1;
        this.f2099e = 0.0f;
        this.f2100f = false;
        this.f2107m = false;
        this.f2108n = -1;
        this.f2109o = 0.0f;
        int i2 = this.f2105k;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f2104j[i3] = null;
        }
        this.f2105k = 0;
        this.f2106l = 0;
        this.f2095a = false;
        Arrays.fill(this.f2102h, 0.0f);
    }

    public final void b(b bVar) {
        int i2 = this.f2105k;
        int i3 = 0;
        while (i3 < i2) {
            if (this.f2104j[i3] == bVar) {
                while (i3 < i2 - 1) {
                    b[] bVarArr = this.f2104j;
                    int i4 = i3 + 1;
                    bVarArr[i3] = bVarArr[i4];
                    i3 = i4;
                }
                this.f2105k--;
                return;
            }
            i3++;
        }
    }

    public String toString() {
        StringBuilder sb;
        if (this.f2111v != null) {
            sb = new StringBuilder();
            sb.append("");
            sb.append(this.f2111v);
        } else {
            sb = new StringBuilder();
            sb.append("");
            sb.append(this.f2096b);
        }
        return sb.toString();
    }
}
