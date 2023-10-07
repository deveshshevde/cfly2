package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;

final class m {

    /* renamed from: a  reason: collision with root package name */
    public final j f15660a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15661b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f15662c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f15663d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15664e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f15665f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f15666g;

    /* renamed from: h  reason: collision with root package name */
    public final long f15667h;

    public m(j jVar, long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2) {
        boolean z2 = false;
        a.a(iArr.length == jArr2.length);
        a.a(jArr.length == jArr2.length);
        a.a(iArr2.length == jArr2.length ? true : z2);
        this.f15660a = jVar;
        this.f15662c = jArr;
        this.f15663d = iArr;
        this.f15664e = i2;
        this.f15665f = jArr2;
        this.f15666g = iArr2;
        this.f15667h = j2;
        this.f15661b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j2) {
        for (int a2 = ad.a(this.f15665f, j2, true, false); a2 >= 0; a2--) {
            if ((this.f15666g[a2] & 1) != 0) {
                return a2;
            }
        }
        return -1;
    }

    public int b(long j2) {
        for (int b2 = ad.b(this.f15665f, j2, true, false); b2 < this.f15665f.length; b2++) {
            if ((this.f15666g[b2] & 1) != 0) {
                return b2;
            }
        }
        return -1;
    }
}
