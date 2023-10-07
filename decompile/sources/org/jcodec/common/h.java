package org.jcodec.common;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private long[] f33156a;

    /* renamed from: b  reason: collision with root package name */
    private int f33157b;

    /* renamed from: c  reason: collision with root package name */
    private int f33158c;

    public h() {
        this(128);
    }

    public h(int i2) {
        this.f33158c = i2;
        this.f33156a = new long[i2];
    }

    public void a(long j2) {
        int i2 = this.f33157b;
        long[] jArr = this.f33156a;
        if (i2 >= jArr.length) {
            long[] jArr2 = new long[(jArr.length + this.f33158c)];
            System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
            this.f33156a = jArr2;
        }
        long[] jArr3 = this.f33156a;
        int i3 = this.f33157b;
        this.f33157b = i3 + 1;
        jArr3[i3] = j2;
    }

    public long[] a() {
        int i2 = this.f33157b;
        long[] jArr = new long[i2];
        System.arraycopy(this.f33156a, 0, jArr, 0, i2);
        return jArr;
    }
}
