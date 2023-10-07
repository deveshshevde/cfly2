package hd;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f13317a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f13318b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f13319c = 0;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f13320d;

    public a(int i2) {
        this.f13319c = i2;
        this.f13320d = new byte[(i2 + 1)];
    }

    private int a(int i2, byte[] bArr, int i3, int i4) {
        int min = Math.min(b(), i4);
        int i5 = i2 + min;
        int i6 = this.f13319c;
        if (i5 > i6 + 1) {
            int i7 = (i6 - i2) + 1;
            int a2 = min - a(i2, bArr, i3, i7);
            int i8 = i7 + 0;
            int i9 = (i2 + i7) % (this.f13319c + 1);
            if (a2 != 0) {
                i8 += a(i9, bArr, i3 + i7, a2);
            }
            return i8;
        } else if (min == 0) {
            return 0;
        } else {
            System.arraycopy(this.f13320d, i2, bArr, i3, min);
            return 0 + min;
        }
    }

    public int a() {
        return this.f13319c;
    }

    public int a(byte[] bArr, int i2, int i3) {
        int c2 = c();
        if (c2 == 0) {
            return 0;
        }
        int min = Math.min(c2, i3);
        int i4 = this.f13318b;
        int i5 = i4 + min;
        int i6 = this.f13319c;
        if (i5 > i6 + 1) {
            int i7 = (i6 - i4) + 1;
            int a2 = a(bArr, i2, i7) + 0;
            int i8 = min - i7;
            if (i8 != 0) {
                a2 += a(bArr, i2 + i7, i8);
            }
            return a2;
        } else if (min == 0) {
            return 0;
        } else {
            System.arraycopy(bArr, i2, this.f13320d, i4, min);
            this.f13318b = (this.f13318b + min) % (this.f13319c + 1);
            return 0 + min;
        }
    }

    public byte[] a(int i2) {
        int min = Math.min(b(), i2);
        if (min == 0) {
            return null;
        }
        byte[] bArr = new byte[min];
        b(bArr, 0, min);
        this.f13317a = (this.f13317a + min) % (this.f13319c + 1);
        return bArr;
    }

    public int b() {
        int i2 = this.f13318b - this.f13317a;
        int i3 = this.f13319c;
        return ((i2 + i3) + 1) % (i3 + 1);
    }

    public int b(byte[] bArr, int i2, int i3) {
        return a(this.f13317a, bArr, i2, i3);
    }

    public int c() {
        return a() - b();
    }

    public void d() {
        this.f13317a = 0;
        this.f13318b = 0;
    }
}
