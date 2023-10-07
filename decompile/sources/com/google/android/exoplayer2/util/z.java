package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class z<V> {

    /* renamed from: a  reason: collision with root package name */
    private long[] f17187a;

    /* renamed from: b  reason: collision with root package name */
    private V[] f17188b;

    /* renamed from: c  reason: collision with root package name */
    private int f17189c;

    /* renamed from: d  reason: collision with root package name */
    private int f17190d;

    public z() {
        this(10);
    }

    public z(int i2) {
        this.f17187a = new long[i2];
        this.f17188b = a(i2);
    }

    private V a(long j2, boolean z2) {
        long j3 = Long.MAX_VALUE;
        V v2 = null;
        while (true) {
            int i2 = this.f17190d;
            if (i2 <= 0) {
                break;
            }
            long[] jArr = this.f17187a;
            int i3 = this.f17189c;
            long j4 = j2 - jArr[i3];
            if (j4 < 0 && (z2 || (-j4) >= j3)) {
                break;
            }
            V[] vArr = this.f17188b;
            v2 = vArr[i3];
            vArr[i3] = null;
            this.f17189c = (i3 + 1) % vArr.length;
            this.f17190d = i2 - 1;
            j3 = j4;
        }
        return v2;
    }

    private static <V> V[] a(int i2) {
        return new Object[i2];
    }

    private void b() {
        int length = this.f17188b.length;
        if (this.f17190d >= length) {
            int i2 = length * 2;
            long[] jArr = new long[i2];
            V[] a2 = a(i2);
            int i3 = this.f17189c;
            int i4 = length - i3;
            System.arraycopy(this.f17187a, i3, jArr, 0, i4);
            System.arraycopy(this.f17188b, this.f17189c, a2, 0, i4);
            int i5 = this.f17189c;
            if (i5 > 0) {
                System.arraycopy(this.f17187a, 0, jArr, i4, i5);
                System.arraycopy(this.f17188b, 0, a2, i4, this.f17189c);
            }
            this.f17187a = jArr;
            this.f17188b = a2;
            this.f17189c = 0;
        }
    }

    private void b(long j2, V v2) {
        int i2 = this.f17189c;
        int i3 = this.f17190d;
        V[] vArr = this.f17188b;
        int length = (i2 + i3) % vArr.length;
        this.f17187a[length] = j2;
        vArr[length] = v2;
        this.f17190d = i3 + 1;
    }

    private void c(long j2) {
        int i2 = this.f17190d;
        if (i2 > 0) {
            if (j2 <= this.f17187a[((this.f17189c + i2) - 1) % this.f17188b.length]) {
                a();
            }
        }
    }

    public synchronized V a(long j2) {
        return a(j2, true);
    }

    public synchronized void a() {
        this.f17189c = 0;
        this.f17190d = 0;
        Arrays.fill(this.f17188b, (Object) null);
    }

    public synchronized void a(long j2, V v2) {
        c(j2);
        b();
        b(j2, v2);
    }

    public synchronized V b(long j2) {
        return a(j2, false);
    }
}
