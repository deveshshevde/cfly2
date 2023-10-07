package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.util.n;
import fi.e;
import java.io.IOException;

public final class b implements h, h.a {

    /* renamed from: a  reason: collision with root package name */
    public final h f16018a;

    /* renamed from: b  reason: collision with root package name */
    long f16019b;

    /* renamed from: c  reason: collision with root package name */
    long f16020c;

    /* renamed from: d  reason: collision with root package name */
    private h.a f16021d;

    /* renamed from: e  reason: collision with root package name */
    private a[] f16022e = new a[0];

    /* renamed from: f  reason: collision with root package name */
    private long f16023f;

    private final class a implements o {

        /* renamed from: a  reason: collision with root package name */
        public final o f16024a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f16026c;

        public a(o oVar) {
            this.f16024a = oVar;
        }

        public int a(o oVar, e eVar, boolean z2) {
            if (b.this.g()) {
                return -3;
            }
            if (this.f16026c) {
                eVar.setFlags(4);
                return -4;
            }
            int a2 = this.f16024a.a(oVar, eVar, z2);
            if (a2 == -5) {
                Format format = (Format) com.google.android.exoplayer2.util.a.b(oVar.f15972c);
                if (!(format.f15108y == 0 && format.f15109z == 0)) {
                    int i2 = 0;
                    int i3 = b.this.f16019b != 0 ? 0 : format.f15108y;
                    if (b.this.f16020c == Long.MIN_VALUE) {
                        i2 = format.f15109z;
                    }
                    oVar.f15972c = format.a(i3, i2);
                }
                return -5;
            } else if (b.this.f16020c == Long.MIN_VALUE || ((a2 != -4 || eVar.f13101d < b.this.f16020c) && (a2 != -3 || b.this.d() != Long.MIN_VALUE || eVar.f13100c))) {
                return a2;
            } else {
                eVar.clear();
                eVar.setFlags(4);
                this.f16026c = true;
                return -4;
            }
        }

        public void a() {
            this.f16026c = false;
        }

        public int a_(long j2) {
            if (b.this.g()) {
                return -3;
            }
            return this.f16024a.a_(j2);
        }

        public boolean b() {
            return !b.this.g() && this.f16024a.b();
        }

        public void c() throws IOException {
            this.f16024a.c();
        }
    }

    public b(h hVar, boolean z2, long j2, long j3) {
        this.f16018a = hVar;
        this.f16023f = z2 ? j2 : -9223372036854775807L;
        this.f16019b = j2;
        this.f16020c = j3;
    }

    private static boolean a(long j2, com.google.android.exoplayer2.trackselection.e[] eVarArr) {
        if (j2 != 0) {
            for (com.google.android.exoplayer2.trackselection.e eVar : eVarArr) {
                if (eVar != null && !n.a(eVar.i().f15092i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private ad b(long j2, ad adVar) {
        long a2 = com.google.android.exoplayer2.util.ad.a(adVar.f15127f, 0, j2 - this.f16019b);
        long j3 = adVar.f15128g;
        long j4 = this.f16020c;
        long a3 = com.google.android.exoplayer2.util.ad.a(j3, 0, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j2);
        return (a2 == adVar.f15127f && a3 == adVar.f15128g) ? adVar : new ad(a2, a3);
    }

    public long a(long j2, ad adVar) {
        long j3 = this.f16019b;
        if (j2 == j3) {
            return j3;
        }
        return this.f16018a.a(j2, b(j2, adVar));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
        if (r2 > r4) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long a(com.google.android.exoplayer2.trackselection.e[] r13, boolean[] r14, com.google.android.exoplayer2.source.o[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            com.google.android.exoplayer2.source.b$a[] r2 = new com.google.android.exoplayer2.source.b.a[r2]
            r0.f16022e = r2
            int r2 = r1.length
            com.google.android.exoplayer2.source.o[] r9 = new com.google.android.exoplayer2.source.o[r2]
            r10 = 0
            r2 = 0
        L_0x000c:
            int r3 = r1.length
            r11 = 0
            if (r2 >= r3) goto L_0x0025
            com.google.android.exoplayer2.source.b$a[] r3 = r0.f16022e
            r4 = r1[r2]
            com.google.android.exoplayer2.source.b$a r4 = (com.google.android.exoplayer2.source.b.a) r4
            r3[r2] = r4
            r4 = r3[r2]
            if (r4 == 0) goto L_0x0020
            r3 = r3[r2]
            com.google.android.exoplayer2.source.o r11 = r3.f16024a
        L_0x0020:
            r9[r2] = r11
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0025:
            com.google.android.exoplayer2.source.h r2 = r0.f16018a
            r3 = r13
            r4 = r14
            r5 = r9
            r6 = r16
            r7 = r17
            long r2 = r2.a(r3, r4, r5, r6, r7)
            boolean r4 = r12.g()
            if (r4 == 0) goto L_0x0047
            long r4 = r0.f16019b
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0047
            r6 = r13
            boolean r4 = a((long) r4, (com.google.android.exoplayer2.trackselection.e[]) r13)
            if (r4 == 0) goto L_0x0047
            r4 = r2
            goto L_0x004c
        L_0x0047:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x004c:
            r0.f16023f = r4
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 == 0) goto L_0x0067
            long r4 = r0.f16019b
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0065
            long r4 = r0.f16020c
            r6 = -9223372036854775808
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0067
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r4 = 0
            goto L_0x0068
        L_0x0067:
            r4 = 1
        L_0x0068:
            com.google.android.exoplayer2.util.a.b((boolean) r4)
        L_0x006b:
            int r4 = r1.length
            if (r10 >= r4) goto L_0x0099
            r4 = r9[r10]
            if (r4 != 0) goto L_0x0077
            com.google.android.exoplayer2.source.b$a[] r4 = r0.f16022e
            r4[r10] = r11
            goto L_0x0090
        L_0x0077:
            com.google.android.exoplayer2.source.b$a[] r4 = r0.f16022e
            r5 = r4[r10]
            if (r5 == 0) goto L_0x0085
            r4 = r4[r10]
            com.google.android.exoplayer2.source.o r4 = r4.f16024a
            r5 = r9[r10]
            if (r4 == r5) goto L_0x0090
        L_0x0085:
            com.google.android.exoplayer2.source.b$a[] r4 = r0.f16022e
            com.google.android.exoplayer2.source.b$a r5 = new com.google.android.exoplayer2.source.b$a
            r6 = r9[r10]
            r5.<init>(r6)
            r4[r10] = r5
        L_0x0090:
            com.google.android.exoplayer2.source.b$a[] r4 = r0.f16022e
            r4 = r4[r10]
            r1[r10] = r4
            int r10 = r10 + 1
            goto L_0x006b
        L_0x0099:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.a(com.google.android.exoplayer2.trackselection.e[], boolean[], com.google.android.exoplayer2.source.o[], boolean[], long):long");
    }

    public void a(long j2) {
        this.f16018a.a(j2);
    }

    public void a(long j2, boolean z2) {
        this.f16018a.a(j2, z2);
    }

    public void a(h.a aVar, long j2) {
        this.f16021d = aVar;
        this.f16018a.a((h.a) this, j2);
    }

    public void a(h hVar) {
        ((h.a) com.google.android.exoplayer2.util.a.b(this.f16021d)).a(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r0 > r7) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long b(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.f16023f = r0
            com.google.android.exoplayer2.source.b$a[] r0 = r6.f16022e
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000c:
            if (r3 >= r1) goto L_0x0018
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0015
            r4.a()
        L_0x0015:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0018:
            com.google.android.exoplayer2.source.h r0 = r6.f16018a
            long r0 = r0.b(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0034
            long r7 = r6.f16019b
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0035
            long r7 = r6.f16020c
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0034
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0035
        L_0x0034:
            r2 = 1
        L_0x0035:
            com.google.android.exoplayer2.util.a.b((boolean) r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.b(long):long");
    }

    public TrackGroupArray b() {
        return this.f16018a.b();
    }

    /* renamed from: b */
    public void a(h hVar) {
        ((h.a) com.google.android.exoplayer2.util.a.b(this.f16021d)).a(this);
    }

    public long c() {
        if (g()) {
            long j2 = this.f16023f;
            this.f16023f = -9223372036854775807L;
            long c2 = c();
            return c2 != -9223372036854775807L ? c2 : j2;
        }
        long c3 = this.f16018a.c();
        if (c3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z2 = true;
        com.google.android.exoplayer2.util.a.b(c3 >= this.f16019b);
        long j3 = this.f16020c;
        if (j3 != Long.MIN_VALUE && c3 > j3) {
            z2 = false;
        }
        com.google.android.exoplayer2.util.a.b(z2);
        return c3;
    }

    public boolean c(long j2) {
        return this.f16018a.c(j2);
    }

    public long d() {
        long d2 = this.f16018a.d();
        if (d2 != Long.MIN_VALUE) {
            long j2 = this.f16020c;
            if (j2 == Long.MIN_VALUE || d2 < j2) {
                return d2;
            }
        }
        return Long.MIN_VALUE;
    }

    public long e() {
        long e2 = this.f16018a.e();
        if (e2 != Long.MIN_VALUE) {
            long j2 = this.f16020c;
            if (j2 == Long.MIN_VALUE || e2 < j2) {
                return e2;
            }
        }
        return Long.MIN_VALUE;
    }

    public boolean f() {
        return this.f16018a.f();
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.f16023f != -9223372036854775807L;
    }

    public void n_() throws IOException {
        this.f16018a.n_();
    }
}
