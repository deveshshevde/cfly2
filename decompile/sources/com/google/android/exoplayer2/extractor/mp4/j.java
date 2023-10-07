package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final int f15625a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15626b;

    /* renamed from: c  reason: collision with root package name */
    public final long f15627c;

    /* renamed from: d  reason: collision with root package name */
    public final long f15628d;

    /* renamed from: e  reason: collision with root package name */
    public final long f15629e;

    /* renamed from: f  reason: collision with root package name */
    public final Format f15630f;

    /* renamed from: g  reason: collision with root package name */
    public final int f15631g;

    /* renamed from: h  reason: collision with root package name */
    public final long[] f15632h;

    /* renamed from: i  reason: collision with root package name */
    public final long[] f15633i;

    /* renamed from: j  reason: collision with root package name */
    public final int f15634j;

    /* renamed from: k  reason: collision with root package name */
    private final k[] f15635k;

    public j(int i2, int i3, long j2, long j3, long j4, Format format, int i4, k[] kVarArr, int i5, long[] jArr, long[] jArr2) {
        this.f15625a = i2;
        this.f15626b = i3;
        this.f15627c = j2;
        this.f15628d = j3;
        this.f15629e = j4;
        this.f15630f = format;
        this.f15631g = i4;
        this.f15635k = kVarArr;
        this.f15634j = i5;
        this.f15632h = jArr;
        this.f15633i = jArr2;
    }

    public k a(int i2) {
        k[] kVarArr = this.f15635k;
        if (kVarArr == null) {
            return null;
        }
        return kVarArr[i2];
    }
}
