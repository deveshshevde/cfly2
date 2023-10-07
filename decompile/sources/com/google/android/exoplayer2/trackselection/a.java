package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.e;
import com.google.android.exoplayer2.util.ad;
import fg.i;
import ft.l;
import ft.m;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class a extends b {

    /* renamed from: d  reason: collision with root package name */
    private final C0116a f16701d;

    /* renamed from: e  reason: collision with root package name */
    private final long f16702e;

    /* renamed from: f  reason: collision with root package name */
    private final long f16703f;

    /* renamed from: g  reason: collision with root package name */
    private final long f16704g;

    /* renamed from: h  reason: collision with root package name */
    private final float f16705h;

    /* renamed from: i  reason: collision with root package name */
    private final long f16706i;

    /* renamed from: j  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.b f16707j;

    /* renamed from: k  reason: collision with root package name */
    private float f16708k;

    /* renamed from: l  reason: collision with root package name */
    private int f16709l;

    /* renamed from: m  reason: collision with root package name */
    private int f16710m;

    /* renamed from: n  reason: collision with root package name */
    private long f16711n;

    /* renamed from: com.google.android.exoplayer2.trackselection.a$a  reason: collision with other inner class name */
    private interface C0116a {
        long a();
    }

    private static final class b implements C0116a {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.android.exoplayer2.upstream.c f16712a;

        /* renamed from: b  reason: collision with root package name */
        private final float f16713b;

        /* renamed from: c  reason: collision with root package name */
        private final long f16714c;

        /* renamed from: d  reason: collision with root package name */
        private long[][] f16715d;

        b(com.google.android.exoplayer2.upstream.c cVar, float f2, long j2) {
            this.f16712a = cVar;
            this.f16713b = f2;
            this.f16714c = j2;
        }

        public long a() {
            long[][] jArr;
            long max = Math.max(0, ((long) (((float) this.f16712a.a()) * this.f16713b)) - this.f16714c);
            if (this.f16715d == null) {
                return max;
            }
            int i2 = 1;
            while (true) {
                jArr = this.f16715d;
                if (i2 >= jArr.length - 1 || jArr[i2][0] >= max) {
                    long[] jArr2 = jArr[i2 - 1];
                    long[] jArr3 = jArr[i2];
                } else {
                    i2++;
                }
            }
            long[] jArr22 = jArr[i2 - 1];
            long[] jArr32 = jArr[i2];
            return jArr22[1] + ((long) ((((float) (max - jArr22[0])) / ((float) (jArr32[0] - jArr22[0]))) * ((float) (jArr32[1] - jArr22[1]))));
        }

        /* access modifiers changed from: package-private */
        public void a(long[][] jArr) {
            com.google.android.exoplayer2.util.a.a(jArr.length >= 2);
            this.f16715d = jArr;
        }
    }

    public static class c implements e.b {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.android.exoplayer2.upstream.c f16716a;

        /* renamed from: b  reason: collision with root package name */
        private final int f16717b;

        /* renamed from: c  reason: collision with root package name */
        private final int f16718c;

        /* renamed from: d  reason: collision with root package name */
        private final int f16719d;

        /* renamed from: e  reason: collision with root package name */
        private final float f16720e;

        /* renamed from: f  reason: collision with root package name */
        private final float f16721f;

        /* renamed from: g  reason: collision with root package name */
        private final long f16722g;

        /* renamed from: h  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.b f16723h;

        public c() {
            this(10000, 25000, 25000, 0.7f, 0.75f, 2000, com.google.android.exoplayer2.util.b.f17099a);
        }

        public c(int i2, int i3, int i4, float f2, float f3, long j2, com.google.android.exoplayer2.util.b bVar) {
            this((com.google.android.exoplayer2.upstream.c) null, i2, i3, i4, f2, f3, j2, bVar);
        }

        @Deprecated
        public c(com.google.android.exoplayer2.upstream.c cVar, int i2, int i3, int i4, float f2, float f3, long j2, com.google.android.exoplayer2.util.b bVar) {
            this.f16716a = cVar;
            this.f16717b = i2;
            this.f16718c = i3;
            this.f16719d = i4;
            this.f16720e = f2;
            this.f16721f = f3;
            this.f16722g = j2;
            this.f16723h = bVar;
        }

        /* access modifiers changed from: protected */
        public a a(TrackGroup trackGroup, com.google.android.exoplayer2.upstream.c cVar, int[] iArr, int i2) {
            return new a(trackGroup, iArr, new b(cVar, this.f16720e, (long) i2), (long) this.f16717b, (long) this.f16718c, (long) this.f16719d, this.f16721f, this.f16722g, this.f16723h);
        }

        public final e[] a(e.a[] aVarArr, com.google.android.exoplayer2.upstream.c cVar) {
            com.google.android.exoplayer2.upstream.c cVar2 = this.f16716a;
            if (cVar2 != null) {
                cVar = cVar2;
            }
            e[] eVarArr = new e[aVarArr.length];
            int i2 = 0;
            for (int i3 = 0; i3 < aVarArr.length; i3++) {
                e.a aVar = aVarArr[i3];
                if (aVar != null && aVar.f16741b.length == 1) {
                    eVarArr[i3] = new c(aVar.f16740a, aVar.f16741b[0], aVar.f16742c, aVar.f16743d);
                    int i4 = aVar.f16740a.a(aVar.f16741b[0]).f15088e;
                    if (i4 != -1) {
                        i2 += i4;
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < aVarArr.length; i5++) {
                e.a aVar2 = aVarArr[i5];
                if (aVar2 != null && aVar2.f16741b.length > 1) {
                    a a2 = a(aVar2.f16740a, cVar, aVar2.f16741b, i2);
                    arrayList.add(a2);
                    eVarArr[i5] = a2;
                }
            }
            if (arrayList.size() > 1) {
                long[][] jArr = new long[arrayList.size()][];
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    a aVar3 = (a) arrayList.get(i6);
                    jArr[i6] = new long[aVar3.h()];
                    for (int i7 = 0; i7 < aVar3.h(); i7++) {
                        jArr[i6][i7] = (long) aVar3.a((aVar3.h() - i7) - 1).f15088e;
                    }
                }
                long[][][] b2 = a.c(jArr);
                for (int i8 = 0; i8 < arrayList.size(); i8++) {
                    ((a) arrayList.get(i8)).a(b2[i8]);
                }
            }
            return eVarArr;
        }
    }

    private a(TrackGroup trackGroup, int[] iArr, C0116a aVar, long j2, long j3, long j4, float f2, long j5, com.google.android.exoplayer2.util.b bVar) {
        super(trackGroup, iArr);
        this.f16701d = aVar;
        this.f16702e = j2 * 1000;
        this.f16703f = j3 * 1000;
        this.f16704g = j4 * 1000;
        this.f16705h = f2;
        this.f16706i = j5;
        this.f16707j = bVar;
        this.f16708k = 1.0f;
        this.f16710m = 0;
        this.f16711n = -9223372036854775807L;
    }

    private static void a(long[][][] jArr, int i2, long[][] jArr2, int[] iArr) {
        long j2 = 0;
        for (int i3 = 0; i3 < jArr.length; i3++) {
            jArr[i3][i2][1] = jArr2[i3][iArr[i3]];
            j2 += jArr[i3][i2][1];
        }
        for (long[][] jArr3 : jArr) {
            jArr3[i2][0] = j2;
        }
    }

    private static double[][] a(double[][] dArr) {
        double[][] dArr2 = new double[dArr.length][];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr2[i2] = new double[(dArr[i2].length - 1)];
            if (dArr2[i2].length != 0) {
                double d2 = dArr[i2][dArr[i2].length - 1] - dArr[i2][0];
                int i3 = 0;
                while (i3 < dArr[i2].length - 1) {
                    int i4 = i3 + 1;
                    dArr2[i2][i3] = d2 == i.f27244a ? 1.0d : (((dArr[i2][i3] + dArr[i2][i4]) * 0.5d) - dArr[i2][0]) / d2;
                    i3 = i4;
                }
            }
        }
        return dArr2;
    }

    private int b(long j2) {
        long a2 = this.f16701d.a();
        int i2 = 0;
        for (int i3 = 0; i3 < this.f16725b; i3++) {
            if (j2 == Long.MIN_VALUE || !b(i3, j2)) {
                Format a3 = a(i3);
                if (a(a3, a3.f15088e, this.f16708k, a2)) {
                    return i3;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    private static int b(double[][] dArr) {
        int i2 = 0;
        for (double[] length : dArr) {
            i2 += length.length;
        }
        return i2;
    }

    private long c(long j2) {
        return (j2 > -9223372036854775807L ? 1 : (j2 == -9223372036854775807L ? 0 : -1)) != 0 && (j2 > this.f16702e ? 1 : (j2 == this.f16702e ? 0 : -1)) <= 0 ? (long) (((float) j2) * this.f16705h) : this.f16702e;
    }

    /* access modifiers changed from: private */
    public static long[][][] c(long[][] jArr) {
        int i2;
        long[][] jArr2 = jArr;
        double[][] d2 = d(jArr);
        double[][] a2 = a(d2);
        int b2 = b(a2) + 3;
        int length = d2.length;
        int[] iArr = new int[3];
        iArr[2] = 2;
        iArr[1] = b2;
        iArr[0] = length;
        long[][][] jArr3 = (long[][][]) Array.newInstance(long.class, iArr);
        int[] iArr2 = new int[d2.length];
        a(jArr3, 1, jArr2, iArr2);
        int i3 = 2;
        while (true) {
            i2 = b2 - 1;
            if (i3 >= i2) {
                break;
            }
            double d3 = Double.MAX_VALUE;
            int i4 = 0;
            for (int i5 = 0; i5 < d2.length; i5++) {
                if (iArr2[i5] + 1 != d2[i5].length) {
                    double d4 = a2[i5][iArr2[i5]];
                    if (d4 < d3) {
                        i4 = i5;
                        d3 = d4;
                    }
                }
            }
            iArr2[i4] = iArr2[i4] + 1;
            a(jArr3, i3, jArr2, iArr2);
            i3++;
        }
        for (long[][] jArr4 : jArr3) {
            int i6 = b2 - 2;
            jArr4[i2][0] = jArr4[i6][0] * 2;
            jArr4[i2][1] = jArr4[i6][1] * 2;
        }
        return jArr3;
    }

    private static double[][] d(long[][] jArr) {
        double[][] dArr = new double[jArr.length][];
        for (int i2 = 0; i2 < jArr.length; i2++) {
            dArr[i2] = new double[jArr[i2].length];
            for (int i3 = 0; i3 < jArr[i2].length; i3++) {
                dArr[i2][i3] = jArr[i2][i3] == -1 ? i.f27244a : Math.log((double) jArr[i2][i3]);
            }
        }
        return dArr;
    }

    public int a() {
        return this.f16709l;
    }

    public int a(long j2, List<? extends l> list) {
        long a2 = this.f16707j.a();
        if (!a(a2)) {
            return list.size();
        }
        this.f16711n = a2;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long b2 = ad.b(((l) list.get(size - 1)).f13115h - j2, this.f16708k);
        long e2 = e();
        if (b2 < e2) {
            return size;
        }
        Format a3 = a(b(a2));
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = (l) list.get(i2);
            Format format = lVar.f13112e;
            if (ad.b(lVar.f13115h - j2, this.f16708k) >= e2 && format.f15088e < a3.f15088e && format.f15098o != -1 && format.f15098o < 720 && format.f15097n != -1 && format.f15097n < 1280 && format.f15098o < a3.f15098o) {
                return i2;
            }
        }
        return size;
    }

    public void a(float f2) {
        this.f16708k = f2;
    }

    public void a(long j2, long j3, long j4, List<? extends l> list, m[] mVarArr) {
        long a2 = this.f16707j.a();
        if (this.f16710m == 0) {
            this.f16710m = 1;
            this.f16709l = b(a2);
            return;
        }
        int i2 = this.f16709l;
        int b2 = b(a2);
        this.f16709l = b2;
        if (b2 != i2) {
            if (!b(i2, a2)) {
                Format a3 = a(i2);
                Format a4 = a(this.f16709l);
                if ((a4.f15088e > a3.f15088e && j3 < c(j4)) || (a4.f15088e < a3.f15088e && j3 >= this.f16703f)) {
                    this.f16709l = i2;
                }
            }
            if (this.f16709l != i2) {
                this.f16710m = 3;
            }
        }
    }

    public void a(long[][] jArr) {
        ((b) this.f16701d).a(jArr);
    }

    /* access modifiers changed from: protected */
    public boolean a(long j2) {
        long j3 = this.f16711n;
        return j3 == -9223372036854775807L || j2 - j3 >= this.f16706i;
    }

    /* access modifiers changed from: protected */
    public boolean a(Format format, int i2, float f2, long j2) {
        return ((long) Math.round(((float) i2) * f2)) <= j2;
    }

    public int b() {
        return this.f16710m;
    }

    public Object c() {
        return null;
    }

    public void d() {
        this.f16711n = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public long e() {
        return this.f16704g;
    }
}
