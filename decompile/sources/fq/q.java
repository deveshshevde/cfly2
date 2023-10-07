package fq;

import com.google.android.exoplayer2.util.a;
import java.util.Arrays;

final class q {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f27934a;

    /* renamed from: b  reason: collision with root package name */
    public int f27935b;

    /* renamed from: c  reason: collision with root package name */
    private final int f27936c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27937d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27938e;

    public q(int i2, int i3) {
        this.f27936c = i2;
        byte[] bArr = new byte[(i3 + 3)];
        this.f27934a = bArr;
        bArr[2] = 1;
    }

    public void a() {
        this.f27937d = false;
        this.f27938e = false;
    }

    public void a(int i2) {
        boolean z2 = true;
        a.b(!this.f27937d);
        if (i2 != this.f27936c) {
            z2 = false;
        }
        this.f27937d = z2;
        if (z2) {
            this.f27935b = 3;
            this.f27938e = false;
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        if (this.f27937d) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.f27934a;
            int length = bArr2.length;
            int i5 = this.f27935b;
            if (length < i5 + i4) {
                this.f27934a = Arrays.copyOf(bArr2, (i5 + i4) * 2);
            }
            System.arraycopy(bArr, i2, this.f27934a, this.f27935b, i4);
            this.f27935b += i4;
        }
    }

    public boolean b() {
        return this.f27938e;
    }

    public boolean b(int i2) {
        if (!this.f27937d) {
            return false;
        }
        this.f27935b -= i2;
        this.f27937d = false;
        this.f27938e = true;
        return true;
    }
}
