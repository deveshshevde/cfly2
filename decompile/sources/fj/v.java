package fj;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f27413a;

    /* renamed from: b  reason: collision with root package name */
    private final int f27414b;

    /* renamed from: c  reason: collision with root package name */
    private int f27415c;

    /* renamed from: d  reason: collision with root package name */
    private int f27416d;

    public v(byte[] bArr) {
        this.f27413a = bArr;
        this.f27414b = bArr.length;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f27414b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r2 = this;
            int r0 = r2.f27415c
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f27414b
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f27416d
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.google.android.exoplayer2.util.a.b((boolean) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fj.v.c():void");
    }

    public int a(int i2) {
        int i3 = this.f27415c;
        int min = Math.min(i2, 8 - this.f27416d);
        int i4 = i3 + 1;
        int i5 = ((this.f27413a[i3] & 255) >> this.f27416d) & (255 >> (8 - min));
        while (min < i2) {
            i5 |= (this.f27413a[i4] & 255) << min;
            min += 8;
            i4++;
        }
        int i6 = i5 & (-1 >>> (32 - i2));
        b(i2);
        return i6;
    }

    public boolean a() {
        boolean z2 = (((this.f27413a[this.f27415c] & 255) >> this.f27416d) & 1) == 1;
        b(1);
        return z2;
    }

    public int b() {
        return (this.f27415c * 8) + this.f27416d;
    }

    public void b(int i2) {
        int i3 = i2 / 8;
        int i4 = this.f27415c + i3;
        this.f27415c = i4;
        int i5 = this.f27416d + (i2 - (i3 * 8));
        this.f27416d = i5;
        if (i5 > 7) {
            this.f27415c = i4 + 1;
            this.f27416d = i5 - 8;
        }
        c();
    }
}
