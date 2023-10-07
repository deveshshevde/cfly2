package okio;

import java.util.Arrays;

final class SegmentedByteString extends ByteString {

    /* renamed from: f  reason: collision with root package name */
    final transient byte[][] f32420f;

    /* renamed from: g  reason: collision with root package name */
    final transient int[] f32421g;

    SegmentedByteString(c cVar, int i2) {
        super((byte[]) null);
        t.a(cVar.f32436b, 0, (long) i2);
        o oVar = cVar.f32435a;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            if (oVar.f32467c != oVar.f32466b) {
                i4 += oVar.f32467c - oVar.f32466b;
                i5++;
                oVar = oVar.f32470f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f32420f = new byte[i5][];
        this.f32421g = new int[(i5 * 2)];
        o oVar2 = cVar.f32435a;
        int i6 = 0;
        while (i3 < i2) {
            this.f32420f[i6] = oVar2.f32465a;
            i3 += oVar2.f32467c - oVar2.f32466b;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.f32421g;
            iArr[i6] = i3;
            iArr[this.f32420f.length + i6] = oVar2.f32466b;
            oVar2.f32468d = true;
            i6++;
            oVar2 = oVar2.f32470f;
        }
    }

    private int b(int i2) {
        int binarySearch = Arrays.binarySearch(this.f32421g, 0, this.f32420f.length, i2 + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    private ByteString i() {
        return new ByteString(h());
    }

    public byte a(int i2) {
        t.a((long) this.f32421g[this.f32420f.length - 1], (long) i2, 1);
        int b2 = b(i2);
        int i3 = b2 == 0 ? 0 : this.f32421g[b2 - 1];
        int[] iArr = this.f32421g;
        byte[][] bArr = this.f32420f;
        return bArr[b2][(i2 - i3) + iArr[bArr.length + b2]];
    }

    public String a() {
        return i().a();
    }

    public ByteString a(int i2, int i3) {
        return i().a(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        int length = this.f32420f.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f32421g;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            o oVar = new o(this.f32420f[i2], i4, (i4 + i5) - i3, true, false);
            if (cVar.f32435a == null) {
                oVar.f32471g = oVar;
                oVar.f32470f = oVar;
                cVar.f32435a = oVar;
            } else {
                cVar.f32435a.f32471g.a(oVar);
            }
            i2++;
            i3 = i5;
        }
        cVar.f32436b += (long) i3;
    }

    public boolean a(int i2, ByteString byteString, int i3, int i4) {
        if (i2 < 0 || i2 > g() - i4) {
            return false;
        }
        int b2 = b(i2);
        while (i4 > 0) {
            int i5 = b2 == 0 ? 0 : this.f32421g[b2 - 1];
            int min = Math.min(i4, ((this.f32421g[b2] - i5) + i5) - i2);
            int[] iArr = this.f32421g;
            byte[][] bArr = this.f32420f;
            if (!byteString.a(i3, bArr[b2], (i2 - i5) + iArr[bArr.length + b2], min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            b2++;
        }
        return true;
    }

    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > g() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int b2 = b(i2);
        while (i4 > 0) {
            int i5 = b2 == 0 ? 0 : this.f32421g[b2 - 1];
            int min = Math.min(i4, ((this.f32421g[b2] - i5) + i5) - i2);
            int[] iArr = this.f32421g;
            byte[][] bArr2 = this.f32420f;
            if (!t.a(bArr2[b2], (i2 - i5) + iArr[bArr2.length + b2], bArr, i3, min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            b2++;
        }
        return true;
    }

    public String b() {
        return i().b();
    }

    public ByteString c() {
        return i().c();
    }

    public ByteString d() {
        return i().d();
    }

    public String e() {
        return i().e();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.g() == g() && a(0, byteString, 0, g());
        }
    }

    public ByteString f() {
        return i().f();
    }

    public int g() {
        return this.f32421g[this.f32420f.length - 1];
    }

    public byte[] h() {
        int[] iArr = this.f32421g;
        byte[][] bArr = this.f32420f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f32421g;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f32420f[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    public int hashCode() {
        int i2 = this.f32418d;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f32420f.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < length) {
            byte[] bArr = this.f32420f[i3];
            int[] iArr = this.f32421g;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i4) + i6;
            while (i6 < i8) {
                i5 = (i5 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i4 = i7;
        }
        this.f32418d = i5;
        return i5;
    }

    public String toString() {
        return i().toString();
    }
}
