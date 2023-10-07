package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private int f17129a;

    /* renamed from: b  reason: collision with root package name */
    private long[] f17130b;

    public l() {
        this(32);
    }

    public l(int i2) {
        this.f17130b = new long[i2];
    }

    public int a() {
        return this.f17129a;
    }

    public long a(int i2) {
        if (i2 >= 0 && i2 < this.f17129a) {
            return this.f17130b[i2];
        }
        int i3 = this.f17129a;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Invalid index ");
        sb.append(i2);
        sb.append(", size is ");
        sb.append(i3);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public void a(long j2) {
        int i2 = this.f17129a;
        long[] jArr = this.f17130b;
        if (i2 == jArr.length) {
            this.f17130b = Arrays.copyOf(jArr, i2 * 2);
        }
        long[] jArr2 = this.f17130b;
        int i3 = this.f17129a;
        this.f17129a = i3 + 1;
        jArr2[i3] = j2;
    }

    public long[] b() {
        return Arrays.copyOf(this.f17130b, this.f17129a);
    }
}
