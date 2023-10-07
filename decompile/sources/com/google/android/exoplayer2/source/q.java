package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.util.a;

public final class q extends af {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f16503b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final long f16504c;

    /* renamed from: d  reason: collision with root package name */
    private final long f16505d;

    /* renamed from: e  reason: collision with root package name */
    private final long f16506e;

    /* renamed from: f  reason: collision with root package name */
    private final long f16507f;

    /* renamed from: g  reason: collision with root package name */
    private final long f16508g;

    /* renamed from: h  reason: collision with root package name */
    private final long f16509h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f16510i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f16511j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f16512k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f16513l;

    /* renamed from: m  reason: collision with root package name */
    private final Object f16514m;

    public q(long j2, long j3, long j4, long j5, long j6, long j7, boolean z2, boolean z3, boolean z4, Object obj, Object obj2) {
        this.f16504c = j2;
        this.f16505d = j3;
        this.f16506e = j4;
        this.f16507f = j5;
        this.f16508g = j6;
        this.f16509h = j7;
        this.f16510i = z2;
        this.f16511j = z3;
        this.f16512k = z4;
        this.f16514m = obj;
        this.f16513l = obj2;
    }

    public q(long j2, long j3, long j4, long j5, boolean z2, boolean z3, boolean z4, Object obj, Object obj2) {
        this(-9223372036854775807L, -9223372036854775807L, j2, j3, j4, j5, z2, z3, z4, obj, obj2);
    }

    public q(long j2, boolean z2, boolean z3, boolean z4, Object obj, Object obj2) {
        this(j2, j2, 0, 0, z2, z3, z4, obj, obj2);
    }

    public int a(Object obj) {
        return f16503b.equals(obj) ? 0 : -1;
    }

    public af.a a(int i2, af.a aVar, boolean z2) {
        a.a(i2, 0, 1);
        return aVar.a((Object) null, z2 ? f16503b : null, 0, this.f16506e, -this.f16508g);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
        if (r1 > r6) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.af.b a(int r26, com.google.android.exoplayer2.af.b r27, long r28) {
        /*
            r25 = this;
            r0 = r25
            r1 = 0
            r2 = 1
            r3 = r26
            com.google.android.exoplayer2.util.a.a(r3, r1, r2)
            long r1 = r0.f16509h
            boolean r3 = r0.f16511j
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 == 0) goto L_0x002a
            r6 = 0
            int r3 = (r28 > r6 ? 1 : (r28 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x002a
            long r6 = r0.f16507f
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0023
        L_0x0020:
            r17 = r4
            goto L_0x002c
        L_0x0023:
            long r1 = r1 + r28
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x002a
            goto L_0x0020
        L_0x002a:
            r17 = r1
        L_0x002c:
            java.lang.Object r7 = com.google.android.exoplayer2.af.b.f15172a
            java.lang.Object r8 = r0.f16513l
            java.lang.Object r9 = r0.f16514m
            long r10 = r0.f16504c
            long r12 = r0.f16505d
            boolean r14 = r0.f16510i
            boolean r15 = r0.f16511j
            boolean r1 = r0.f16512k
            r16 = r1
            long r1 = r0.f16507f
            r19 = r1
            r21 = 0
            r22 = 0
            long r1 = r0.f16508g
            r23 = r1
            r6 = r27
            com.google.android.exoplayer2.af$b r1 = r6.a(r7, r8, r9, r10, r12, r14, r15, r16, r17, r19, r21, r22, r23)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.q.a(int, com.google.android.exoplayer2.af$b, long):com.google.android.exoplayer2.af$b");
    }

    public Object a(int i2) {
        a.a(i2, 0, 1);
        return f16503b;
    }

    public int b() {
        return 1;
    }

    public int c() {
        return 1;
    }
}
