package org.jcodec.common;

import java.util.Arrays;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private int[] f33152a;

    /* renamed from: b  reason: collision with root package name */
    private int f33153b;

    public e() {
        int[] b2 = b(128);
        this.f33152a = b2;
        Arrays.fill(b2, Integer.MIN_VALUE);
    }

    private int[] b(int i2) {
        return new int[i2];
    }

    public int a(int i2) {
        int[] iArr = this.f33152a;
        return (i2 >= iArr.length ? null : Integer.valueOf(iArr[i2])).intValue();
    }

    public void a(int i2, int i3) {
        if (i3 != Integer.MIN_VALUE) {
            if (this.f33152a.length <= i2) {
                int[] b2 = b(i2 + 128);
                int[] iArr = this.f33152a;
                System.arraycopy(iArr, 0, b2, 0, iArr.length);
                Arrays.fill(b2, this.f33152a.length, b2.length, Integer.MIN_VALUE);
                this.f33152a = b2;
            }
            int[] iArr2 = this.f33152a;
            if (iArr2[i2] == Integer.MIN_VALUE) {
                this.f33153b++;
            }
            iArr2[i2] = i3;
            return;
        }
        throw new IllegalArgumentException("This implementation can not store -2147483648");
    }
}
