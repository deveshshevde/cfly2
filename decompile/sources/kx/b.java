package kx;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f30583a;

    /* renamed from: b  reason: collision with root package name */
    private int f30584b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f30585c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f30586d;

    public b(int i2) {
        int i3 = i2 + 1;
        this.f30586d = i3;
        this.f30583a = new byte[i3];
    }

    private int b(int i2) {
        int i3 = this.f30584b;
        int i4 = i2 + i3;
        int i5 = this.f30585c;
        if (i3 > i5) {
            int i6 = this.f30586d;
            if (i4 < i6 || (i4 = i4 - i6) < i5) {
                return i4;
            }
            return -1;
        } else if (i4 >= i5) {
            return -1;
        }
        return i4;
    }

    private int c(int i2) {
        int i3 = this.f30584b;
        int i4 = i2 + i3;
        int i5 = this.f30585c;
        if (i3 > i5) {
            int i6 = this.f30586d;
            if (i4 < i6 || (i4 = i4 - i6) <= i5) {
                return i4;
            }
            return -1;
        } else if (i4 > i5) {
            return -1;
        }
        return i4;
    }

    public int a() {
        int i2 = this.f30585c;
        int i3 = this.f30584b;
        return i2 >= i3 ? i2 - i3 : (this.f30586d + i2) - i3;
    }

    public int a(int i2) {
        int b2 = b(i2);
        if (b2 != -1) {
            return this.f30583a[b2] & 255;
        }
        return -1;
    }

    public int b() {
        int c2 = c();
        this.f30584b = c(1);
        return c2;
    }

    public int c() {
        return a(0);
    }
}
