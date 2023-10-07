package okhttp3.internal.http2;

import java.util.Arrays;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private int f32240a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f32241b = new int[10];

    /* access modifiers changed from: package-private */
    public k a(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.f32241b;
            if (i2 < iArr.length) {
                this.f32240a = (1 << i2) | this.f32240a;
                iArr[i2] = i3;
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f32240a = 0;
        Arrays.fill(this.f32241b, 0);
    }

    /* access modifiers changed from: package-private */
    public void a(k kVar) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (kVar.a(i2)) {
                a(i2, kVar.b(i2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        return ((1 << i2) & this.f32240a) != 0;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return Integer.bitCount(this.f32240a);
    }

    /* access modifiers changed from: package-private */
    public int b(int i2) {
        return this.f32241b[i2];
    }

    /* access modifiers changed from: package-private */
    public int c() {
        if ((this.f32240a & 2) != 0) {
            return this.f32241b[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int c(int i2) {
        return (this.f32240a & 16) != 0 ? this.f32241b[4] : i2;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        if ((this.f32240a & 128) != 0) {
            return this.f32241b[7];
        }
        return 65535;
    }

    /* access modifiers changed from: package-private */
    public int d(int i2) {
        return (this.f32240a & 32) != 0 ? this.f32241b[5] : i2;
    }
}
