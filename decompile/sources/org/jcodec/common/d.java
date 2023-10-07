package org.jcodec.common;

import java.util.Arrays;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private int[] f33149a;

    /* renamed from: b  reason: collision with root package name */
    private int f33150b;

    /* renamed from: c  reason: collision with root package name */
    private int f33151c;

    public d() {
        this(128);
    }

    public d(int i2) {
        this.f33151c = i2;
        this.f33149a = new int[i2];
    }

    public void a(int i2) {
        int i3 = this.f33150b;
        int[] iArr = this.f33149a;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[(iArr.length + this.f33151c)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f33149a = iArr2;
        }
        int[] iArr3 = this.f33149a;
        int i4 = this.f33150b;
        this.f33150b = i4 + 1;
        iArr3[i4] = i2;
    }

    public void a(int i2, int i3) {
        this.f33149a[i2] = i3;
    }

    public void a(int i2, int i3, int i4) {
        int[] iArr = this.f33149a;
        if (i3 > iArr.length) {
            int[] iArr2 = new int[(this.f33151c + i3)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f33149a = iArr2;
        }
        Arrays.fill(this.f33149a, i2, i3, i4);
        this.f33150b = Math.max(this.f33150b, i3);
    }

    public int[] a() {
        int i2 = this.f33150b;
        int[] iArr = new int[i2];
        System.arraycopy(this.f33149a, 0, iArr, 0, i2);
        return iArr;
    }

    public void b() {
        int i2 = this.f33150b;
        if (i2 != 0) {
            this.f33150b = i2 - 1;
        }
    }

    public void b(int i2) {
        a(i2);
    }

    public int c() {
        return this.f33150b;
    }

    public int c(int i2) {
        return this.f33149a[i2];
    }

    public boolean d(int i2) {
        for (int i3 = 0; i3 < this.f33150b; i3++) {
            if (this.f33149a[i3] == i2) {
                return true;
            }
        }
        return false;
    }
}
