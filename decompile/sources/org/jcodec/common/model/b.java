package org.jcodec.common.model;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private ColorSpace f33222a;

    /* renamed from: b  reason: collision with root package name */
    private int f33223b;

    /* renamed from: c  reason: collision with root package name */
    private int f33224c;

    /* renamed from: d  reason: collision with root package name */
    private int[][] f33225d;

    /* renamed from: e  reason: collision with root package name */
    private d f33226e;

    public b(int i2, int i3, int[][] iArr, ColorSpace colorSpace) {
        this(i2, i3, iArr, colorSpace, new d(0, 0, i2, i3));
    }

    public b(int i2, int i3, int[][] iArr, ColorSpace colorSpace, d dVar) {
        this.f33223b = i2;
        this.f33224c = i3;
        this.f33225d = iArr;
        this.f33222a = colorSpace;
        this.f33226e = dVar;
    }

    public static b a(int i2, int i3, ColorSpace colorSpace) {
        return a(i2, i3, colorSpace, (d) null);
    }

    public static b a(int i2, int i3, ColorSpace colorSpace, d dVar) {
        int[] iArr = new int[4];
        for (int i4 = 0; i4 < colorSpace.f33206l; i4++) {
            int i5 = colorSpace.f33207m[i4];
            iArr[i5] = iArr[i5] + ((i2 >> colorSpace.f33208n[i4]) * (i3 >> colorSpace.f33209o[i4]));
        }
        int i6 = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            i6 += iArr[i7] != 0 ? 1 : 0;
        }
        int[][] iArr2 = new int[i6][];
        int i8 = 0;
        for (int i9 = 0; i9 < 4; i9++) {
            if (iArr[i9] != 0) {
                iArr2[i8] = new int[iArr[i9]];
                i8++;
            }
        }
        return new b(i2, i3, iArr2, colorSpace, dVar);
    }

    public int a() {
        return this.f33223b;
    }

    public int[] a(int i2) {
        return this.f33225d[i2];
    }

    public int b() {
        return this.f33224c;
    }

    public int b(int i2) {
        return this.f33223b >> this.f33222a.f33208n[i2];
    }

    public int c(int i2) {
        return this.f33224c >> this.f33222a.f33209o[i2];
    }

    public ColorSpace c() {
        return this.f33222a;
    }

    public int[][] d() {
        return this.f33225d;
    }

    public int e() {
        d dVar = this.f33226e;
        return dVar == null ? this.f33223b : dVar.a();
    }

    public int f() {
        d dVar = this.f33226e;
        return dVar == null ? this.f33224c : dVar.b();
    }
}
