package okio;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class c implements Cloneable, ByteChannel, d, e {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f32434c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a  reason: collision with root package name */
    o f32435a;

    /* renamed from: b  reason: collision with root package name */
    long f32436b;

    public int a(l lVar) {
        int a2 = a(lVar, false);
        if (a2 == -1) {
            return -1;
        }
        try {
            h((long) lVar.f32455a[a2].g());
            return a2;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public int a(l lVar, boolean z2) {
        int i2;
        int i3;
        int i4;
        o oVar;
        int i5;
        l lVar2 = lVar;
        o oVar2 = this.f32435a;
        int i6 = -2;
        if (oVar2 != null) {
            byte[] bArr = oVar2.f32465a;
            int i7 = oVar2.f32466b;
            int i8 = oVar2.f32467c;
            int[] iArr = lVar2.f32456b;
            o oVar3 = oVar2;
            int i9 = 0;
            int i10 = -1;
            loop0:
            while (true) {
                int i11 = i9 + 1;
                int i12 = iArr[i9];
                int i13 = i11 + 1;
                int i14 = iArr[i11];
                if (i14 != -1) {
                    i10 = i14;
                }
                if (oVar3 == null) {
                    break;
                }
                if (i12 < 0) {
                    int i15 = i13 + (i12 * -1);
                    while (true) {
                        int i16 = i7 + 1;
                        int i17 = i13 + 1;
                        if ((bArr[i7] & 255) != iArr[i13]) {
                            return i10;
                        }
                        boolean z3 = i17 == i15;
                        if (i16 == i8) {
                            o oVar4 = oVar3.f32470f;
                            i5 = oVar4.f32466b;
                            byte[] bArr2 = oVar4.f32465a;
                            i4 = oVar4.f32467c;
                            if (oVar4 != oVar2) {
                                byte[] bArr3 = bArr2;
                                oVar = oVar4;
                                bArr = bArr3;
                            } else if (!z3) {
                                break loop0;
                            } else {
                                bArr = bArr2;
                                oVar = null;
                            }
                        } else {
                            o oVar5 = oVar3;
                            i4 = i8;
                            i5 = i16;
                            oVar = oVar5;
                        }
                        if (z3) {
                            i2 = iArr[i17];
                            i3 = i5;
                            i8 = i4;
                            oVar3 = oVar;
                            break;
                        }
                        i7 = i5;
                        i8 = i4;
                        i13 = i17;
                        oVar3 = oVar;
                    }
                } else {
                    int i18 = i7 + 1;
                    byte b2 = bArr[i7] & 255;
                    int i19 = i13 + i12;
                    while (i13 != i19) {
                        if (b2 == iArr[i13]) {
                            i2 = iArr[i13 + i12];
                            if (i18 == i8) {
                                oVar3 = oVar3.f32470f;
                                i3 = oVar3.f32466b;
                                bArr = oVar3.f32465a;
                                i8 = oVar3.f32467c;
                                if (oVar3 == oVar2) {
                                    oVar3 = null;
                                }
                            } else {
                                i3 = i18;
                            }
                        } else {
                            i13++;
                        }
                    }
                    return i10;
                }
                if (i2 >= 0) {
                    return i2;
                }
                i9 = -i2;
                i7 = i3;
                i6 = -2;
            }
            return z2 ? i6 : i10;
        } else if (z2) {
            return -2;
        } else {
            return lVar2.indexOf(ByteString.f32416b);
        }
    }

    public int a(byte[] bArr, int i2, int i3) {
        t.a((long) bArr.length, (long) i2, (long) i3);
        o oVar = this.f32435a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i3, oVar.f32467c - oVar.f32466b);
        System.arraycopy(oVar.f32465a, oVar.f32466b, bArr, i2, min);
        oVar.f32466b += min;
        this.f32436b -= (long) min;
        if (oVar.f32466b == oVar.f32467c) {
            this.f32435a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    public final long a() {
        return this.f32436b;
    }

    public long a(byte b2) {
        return a(b2, 0, Long.MAX_VALUE);
    }

    public long a(byte b2, long j2, long j3) {
        o oVar;
        long j4 = 0;
        if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f32436b), Long.valueOf(j2), Long.valueOf(j3)}));
        }
        long j5 = this.f32436b;
        long j6 = j3 > j5 ? j5 : j3;
        if (j2 == j6 || (oVar = this.f32435a) == null) {
            return -1;
        }
        if (j5 - j2 < j2) {
            while (j5 > j2) {
                oVar = oVar.f32471g;
                j5 -= (long) (oVar.f32467c - oVar.f32466b);
            }
        } else {
            while (true) {
                long j7 = ((long) (oVar.f32467c - oVar.f32466b)) + j4;
                if (j7 >= j2) {
                    break;
                }
                oVar = oVar.f32470f;
                j4 = j7;
            }
            j5 = j4;
        }
        long j8 = j2;
        while (j5 < j6) {
            byte[] bArr = oVar.f32465a;
            int min = (int) Math.min((long) oVar.f32467c, (((long) oVar.f32466b) + j6) - j5);
            for (int i2 = (int) ((((long) oVar.f32466b) + j8) - j5); i2 < min; i2++) {
                if (bArr[i2] == b2) {
                    return ((long) (i2 - oVar.f32466b)) + j5;
                }
            }
            byte b3 = b2;
            j5 += (long) (oVar.f32467c - oVar.f32466b);
            oVar = oVar.f32470f;
            j8 = j5;
        }
        return -1;
    }

    public long a(q qVar) throws IOException {
        long j2 = this.f32436b;
        if (j2 > 0) {
            qVar.write(this, j2);
        }
        return j2;
    }

    public long a(r rVar) throws IOException {
        if (rVar != null) {
            long j2 = 0;
            while (true) {
                long read = rVar.read(this, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER);
                if (read == -1) {
                    return j2;
                }
                j2 += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public String a(long j2, Charset charset) throws EOFException {
        t.a(this.f32436b, 0, j2);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j2 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
        } else if (j2 == 0) {
            return "";
        } else {
            o oVar = this.f32435a;
            if (((long) oVar.f32466b) + j2 > ((long) oVar.f32467c)) {
                return new String(g(j2), charset);
            }
            String str = new String(oVar.f32465a, oVar.f32466b, (int) j2, charset);
            oVar.f32466b = (int) (((long) oVar.f32466b) + j2);
            this.f32436b -= j2;
            if (oVar.f32466b == oVar.f32467c) {
                this.f32435a = oVar.b();
                p.a(oVar);
            }
            return str;
        }
    }

    public String a(Charset charset) {
        try {
            return a(this.f32436b, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public c a(int i2) {
        int i3;
        int i4;
        if (i2 >= 128) {
            if (i2 < 2048) {
                i4 = (i2 >> 6) | 192;
            } else {
                if (i2 < 65536) {
                    if (i2 < 55296 || i2 > 57343) {
                        i3 = (i2 >> 12) | 224;
                    } else {
                        i(63);
                        return this;
                    }
                } else if (i2 <= 1114111) {
                    i((i2 >> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
                    i3 = ((i2 >> 12) & 63) | 128;
                } else {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
                }
                i(i3);
                i4 = ((i2 >> 6) & 63) | 128;
            }
            i(i4);
            i2 = (i2 & 63) | 128;
        }
        i(i2);
        return this;
    }

    /* renamed from: a */
    public c b(String str) {
        return a(str, 0, str.length());
    }

    public c a(String str, int i2, int i3) {
        int i4;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i2);
        } else if (i3 < i2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
        } else if (i3 <= str.length()) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    o e2 = e(1);
                    byte[] bArr = e2.f32465a;
                    int i5 = e2.f32467c - i2;
                    int min = Math.min(i3, 8192 - i5);
                    int i6 = i2 + 1;
                    bArr[i2 + i5] = (byte) charAt;
                    while (i6 < min) {
                        char charAt2 = str.charAt(i6);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i6 + i5] = (byte) charAt2;
                        i6++;
                    }
                    int i7 = (i5 + i6) - e2.f32467c;
                    e2.f32467c += i7;
                    this.f32436b += (long) i7;
                    i2 = i6;
                } else {
                    if (charAt < 2048) {
                        i4 = (charAt >> 6) | 192;
                    } else if (charAt < 55296 || charAt > 57343) {
                        i((charAt >> 12) | 224);
                        i4 = ((charAt >> 6) & 63) | 128;
                    } else {
                        int i8 = i2 + 1;
                        char charAt3 = i8 < i3 ? str.charAt(i8) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            i(63);
                            i2 = i8;
                        } else {
                            int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 0;
                            i((i9 >> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
                            i(((i9 >> 12) & 63) | 128);
                            i(((i9 >> 6) & 63) | 128);
                            i((i9 & 63) | 128);
                            i2 += 2;
                        }
                    }
                    i(i4);
                    i((int) (charAt & '?') | 128);
                    i2++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        }
    }

    public c a(String str, int i2, int i3, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i2 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i2);
        } else if (i3 < i2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
        } else if (i3 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(t.f32478a)) {
            return a(str, i2, i3);
        } else {
            byte[] bytes = str.substring(i2, i3).getBytes(charset);
            return c(bytes, 0, bytes.length);
        }
    }

    public c a(String str, Charset charset) {
        return a(str, 0, str.length(), charset);
    }

    /* renamed from: a */
    public c b(ByteString byteString) {
        if (byteString != null) {
            byteString.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public final c a(c cVar, long j2, long j3) {
        if (cVar != null) {
            t.a(this.f32436b, j2, j3);
            if (j3 == 0) {
                return this;
            }
            cVar.f32436b += j3;
            o oVar = this.f32435a;
            while (j2 >= ((long) (oVar.f32467c - oVar.f32466b))) {
                j2 -= (long) (oVar.f32467c - oVar.f32466b);
                oVar = oVar.f32470f;
            }
            while (j3 > 0) {
                o a2 = oVar.a();
                a2.f32466b = (int) (((long) a2.f32466b) + j2);
                a2.f32467c = Math.min(a2.f32466b + ((int) j3), a2.f32467c);
                o oVar2 = cVar.f32435a;
                if (oVar2 == null) {
                    a2.f32471g = a2;
                    a2.f32470f = a2;
                    cVar.f32435a = a2;
                } else {
                    oVar2.f32471g.a(a2);
                }
                j3 -= (long) (a2.f32467c - a2.f32466b);
                oVar = oVar.f32470f;
                j2 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public void a(long j2) throws EOFException {
        if (this.f32436b < j2) {
            throw new EOFException();
        }
    }

    public void a(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int a2 = a(bArr, i2, bArr.length - i2);
            if (a2 != -1) {
                i2 += a2;
            } else {
                throw new EOFException();
            }
        }
    }

    public final byte b(long j2) {
        t.a(this.f32436b, j2, 1);
        long j3 = this.f32436b;
        if (j3 - j2 > j2) {
            o oVar = this.f32435a;
            while (true) {
                long j4 = (long) (oVar.f32467c - oVar.f32466b);
                if (j2 < j4) {
                    return oVar.f32465a[oVar.f32466b + ((int) j2)];
                }
                j2 -= j4;
                oVar = oVar.f32470f;
            }
        } else {
            long j5 = j2 - j3;
            o oVar2 = this.f32435a;
            do {
                oVar2 = oVar2.f32471g;
                j5 += (long) (oVar2.f32467c - oVar2.f32466b);
            } while (j5 < 0);
            return oVar2.f32465a[oVar2.f32466b + ((int) j5)];
        }
    }

    public c b() {
        return this;
    }

    /* renamed from: b */
    public c i(int i2) {
        o e2 = e(1);
        byte[] bArr = e2.f32465a;
        int i3 = e2.f32467c;
        e2.f32467c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f32436b++;
        return this;
    }

    /* renamed from: b */
    public c c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: b */
    public c c(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j2 = (long) i3;
            t.a((long) bArr.length, (long) i2, j2);
            int i4 = i3 + i2;
            while (i2 < i4) {
                o e2 = e(1);
                int min = Math.min(i4 - i2, 8192 - e2.f32467c);
                System.arraycopy(bArr, i2, e2.f32465a, e2.f32467c, min);
                i2 += min;
                e2.f32467c += min;
            }
            this.f32436b += j2;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public ByteString c(long j2) throws EOFException {
        return new ByteString(g(j2));
    }

    public c c() {
        return this;
    }

    /* renamed from: c */
    public c h(int i2) {
        o e2 = e(2);
        byte[] bArr = e2.f32465a;
        int i3 = e2.f32467c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        e2.f32467c = i4 + 1;
        this.f32436b += 2;
        return this;
    }

    public void close() {
    }

    public OutputStream d() {
        return new OutputStream() {
            public void close() {
            }

            public void flush() {
            }

            public String toString() {
                return c.this + ".outputStream()";
            }

            public void write(int i2) {
                c.this.i((int) (byte) i2);
            }

            public void write(byte[] bArr, int i2, int i3) {
                c.this.c(bArr, i2, i3);
            }
        };
    }

    public String d(long j2) throws EOFException {
        return a(j2, t.f32478a);
    }

    /* renamed from: d */
    public c g(int i2) {
        o e2 = e(4);
        byte[] bArr = e2.f32465a;
        int i3 = e2.f32467c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        e2.f32467c = i6 + 1;
        this.f32436b += 4;
        return this;
    }

    public String e(long j2) throws EOFException {
        if (j2 >= 0) {
            long j3 = Long.MAX_VALUE;
            if (j2 != Long.MAX_VALUE) {
                j3 = j2 + 1;
            }
            long a2 = a((byte) 10, 0, j3);
            if (a2 != -1) {
                return f(a2);
            }
            if (j3 < a() && b(j3 - 1) == 13 && b(j3) == 10) {
                return f(j3);
            }
            c cVar = new c();
            a(cVar, 0, Math.min(32, a()));
            throw new EOFException("\\n not found: limit=" + Math.min(a(), j2) + " content=" + cVar.o().e() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j2);
    }

    /* renamed from: e */
    public c v() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public o e(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        o oVar = this.f32435a;
        if (oVar == null) {
            o a2 = p.a();
            this.f32435a = a2;
            a2.f32471g = a2;
            a2.f32470f = a2;
            return a2;
        }
        o oVar2 = oVar.f32471g;
        return (oVar2.f32467c + i2 > 8192 || !oVar2.f32469e) ? oVar2.a(p.a()) : oVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j2 = this.f32436b;
        if (j2 != cVar.f32436b) {
            return false;
        }
        long j3 = 0;
        if (j2 == 0) {
            return true;
        }
        o oVar = this.f32435a;
        o oVar2 = cVar.f32435a;
        int i2 = oVar.f32466b;
        int i3 = oVar2.f32466b;
        while (j3 < this.f32436b) {
            long min = (long) Math.min(oVar.f32467c - i2, oVar2.f32467c - i3);
            int i4 = 0;
            while (((long) i4) < min) {
                int i5 = i2 + 1;
                int i6 = i3 + 1;
                if (oVar.f32465a[i2] != oVar2.f32465a[i3]) {
                    return false;
                }
                i4++;
                i2 = i5;
                i3 = i6;
            }
            if (i2 == oVar.f32467c) {
                oVar = oVar.f32470f;
                i2 = oVar.f32466b;
            }
            if (i3 == oVar2.f32467c) {
                oVar2 = oVar2.f32470f;
                i3 = oVar2.f32466b;
            }
            j3 += min;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public String f(long j2) throws EOFException {
        String d2;
        long j3 = 1;
        if (j2 > 0) {
            long j4 = j2 - 1;
            if (b(j4) == 13) {
                d2 = d(j4);
                j3 = 2;
                h(j3);
                return d2;
            }
        }
        d2 = d(j2);
        h(j3);
        return d2;
    }

    public final ByteString f(int i2) {
        return i2 == 0 ? ByteString.f32416b : new SegmentedByteString(this, i2);
    }

    public boolean f() {
        return this.f32436b == 0;
    }

    public void flush() {
    }

    public InputStream g() {
        return new InputStream() {
            public int available() {
                return (int) Math.min(c.this.f32436b, 2147483647L);
            }

            public void close() {
            }

            public int read() {
                if (c.this.f32436b > 0) {
                    return c.this.i() & 255;
                }
                return -1;
            }

            public int read(byte[] bArr, int i2, int i3) {
                return c.this.a(bArr, i2, i3);
            }

            public String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    public byte[] g(long j2) throws EOFException {
        t.a(this.f32436b, 0, j2);
        if (j2 <= 2147483647L) {
            byte[] bArr = new byte[((int) j2)];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
    }

    public final long h() {
        long j2 = this.f32436b;
        if (j2 == 0) {
            return 0;
        }
        o oVar = this.f32435a.f32471g;
        return (oVar.f32467c >= 8192 || !oVar.f32469e) ? j2 : j2 - ((long) (oVar.f32467c - oVar.f32466b));
    }

    public void h(long j2) throws EOFException {
        while (j2 > 0) {
            o oVar = this.f32435a;
            if (oVar != null) {
                int min = (int) Math.min(j2, (long) (oVar.f32467c - this.f32435a.f32466b));
                long j3 = (long) min;
                this.f32436b -= j3;
                j2 -= j3;
                this.f32435a.f32466b += min;
                if (this.f32435a.f32466b == this.f32435a.f32467c) {
                    o oVar2 = this.f32435a;
                    this.f32435a = oVar2.b();
                    p.a(oVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public int hashCode() {
        o oVar = this.f32435a;
        if (oVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = oVar.f32467c;
            for (int i4 = oVar.f32466b; i4 < i3; i4++) {
                i2 = (i2 * 31) + oVar.f32465a[i4];
            }
            oVar = oVar.f32470f;
        } while (oVar != this.f32435a);
        return i2;
    }

    public byte i() {
        if (this.f32436b != 0) {
            o oVar = this.f32435a;
            int i2 = oVar.f32466b;
            int i3 = oVar.f32467c;
            int i4 = i2 + 1;
            byte b2 = oVar.f32465a[i2];
            this.f32436b--;
            if (i4 == i3) {
                this.f32435a = oVar.b();
                p.a(oVar);
            } else {
                oVar.f32466b = i4;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    /* renamed from: i */
    public c l(long j2) {
        if (j2 == 0) {
            return i(48);
        }
        boolean z2 = false;
        int i2 = 1;
        if (j2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return b("-9223372036854775808");
            }
            z2 = true;
        }
        if (j2 >= 100000000) {
            i2 = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i2 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i2 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i2 = 2;
        }
        if (z2) {
            i2++;
        }
        o e2 = e(i2);
        byte[] bArr = e2.f32465a;
        int i3 = e2.f32467c + i2;
        while (j2 != 0) {
            i3--;
            bArr[i3] = f32434c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z2) {
            bArr[i3 - 1] = 45;
        }
        e2.f32467c += i2;
        this.f32436b += (long) i2;
        return this;
    }

    public boolean isOpen() {
        return true;
    }

    /* renamed from: j */
    public c k(long j2) {
        if (j2 == 0) {
            return i(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j2)) / 4) + 1;
        o e2 = e(numberOfTrailingZeros);
        byte[] bArr = e2.f32465a;
        int i2 = e2.f32467c;
        for (int i3 = (e2.f32467c + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f32434c[(int) (15 & j2)];
            j2 >>>= 4;
        }
        e2.f32467c += numberOfTrailingZeros;
        this.f32436b += (long) numberOfTrailingZeros;
        return this;
    }

    public short j() {
        if (this.f32436b >= 2) {
            o oVar = this.f32435a;
            int i2 = oVar.f32466b;
            int i3 = oVar.f32467c;
            if (i3 - i2 < 2) {
                return (short) (((i() & 255) << 8) | (i() & 255));
            }
            byte[] bArr = oVar.f32465a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            this.f32436b -= 2;
            if (i5 == i3) {
                this.f32435a = oVar.b();
                p.a(oVar);
            } else {
                oVar.f32466b = i5;
            }
            return (short) b2;
        }
        throw new IllegalStateException("size < 2: " + this.f32436b);
    }

    public int k() {
        if (this.f32436b >= 4) {
            o oVar = this.f32435a;
            int i2 = oVar.f32466b;
            int i3 = oVar.f32467c;
            if (i3 - i2 < 4) {
                return ((i() & 255) << 24) | ((i() & 255) << 16) | ((i() & 255) << 8) | (i() & 255);
            }
            byte[] bArr = oVar.f32465a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i6 = i5 + 1;
            byte b3 = b2 | ((bArr[i5] & 255) << 8);
            int i7 = i6 + 1;
            byte b4 = b3 | (bArr[i6] & 255);
            this.f32436b -= 4;
            if (i7 == i3) {
                this.f32435a = oVar.b();
                p.a(oVar);
            } else {
                oVar.f32466b = i7;
            }
            return b4;
        }
        throw new IllegalStateException("size < 4: " + this.f32436b);
    }

    public short l() {
        return t.a(j());
    }

    public int m() {
        return t.a(k());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r8 != r9) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        r15.f32435a = r6.b();
        okio.p.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
        r6.f32466b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009f, code lost:
        if (r1 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long n() {
        /*
            r15 = this;
            long r0 = r15.f32436b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00ac
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            okio.o r6 = r15.f32435a
            byte[] r7 = r6.f32465a
            int r8 = r6.f32466b
            int r9 = r6.f32467c
        L_0x0013:
            if (r8 >= r9) goto L_0x0091
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x003a
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002f
            int r11 = r10 + -97
        L_0x002c:
            int r11 = r11 + 10
            goto L_0x003a
        L_0x002f:
            r11 = 65
            if (r10 < r11) goto L_0x0072
            r11 = 70
            if (r10 > r11) goto L_0x0072
            int r11 = r10 + -65
            goto L_0x002c
        L_0x003a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x004a:
            okio.c r0 = new okio.c
            r0.<init>()
            okio.c r0 = r0.k(r4)
            okio.c r0 = r0.i((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.p()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0072:
            if (r0 == 0) goto L_0x0076
            r1 = 1
            goto L_0x0091
        L_0x0076:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0091:
            if (r8 != r9) goto L_0x009d
            okio.o r7 = r6.b()
            r15.f32435a = r7
            okio.p.a(r6)
            goto L_0x009f
        L_0x009d:
            r6.f32466b = r8
        L_0x009f:
            if (r1 != 0) goto L_0x00a5
            okio.o r6 = r15.f32435a
            if (r6 != 0) goto L_0x000b
        L_0x00a5:
            long r1 = r15.f32436b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f32436b = r1
            return r4
        L_0x00ac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto L_0x00b5
        L_0x00b4:
            throw r0
        L_0x00b5:
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.c.n():long");
    }

    public ByteString o() {
        return new ByteString(r());
    }

    public String p() {
        try {
            return a(this.f32436b, t.f32478a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String q() throws EOFException {
        return e(Long.MAX_VALUE);
    }

    public byte[] r() {
        try {
            return g(this.f32436b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        o oVar = this.f32435a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.f32467c - oVar.f32466b);
        byteBuffer.put(oVar.f32465a, oVar.f32466b, min);
        oVar.f32466b += min;
        this.f32436b -= (long) min;
        if (oVar.f32466b == oVar.f32467c) {
            this.f32435a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    public long read(c cVar, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j2 >= 0) {
            long j3 = this.f32436b;
            if (j3 == 0) {
                return -1;
            }
            if (j2 > j3) {
                j2 = j3;
            }
            cVar.write(this, j2);
            return j2;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
    }

    public final void s() {
        try {
            h(this.f32436b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    /* renamed from: t */
    public c clone() {
        c cVar = new c();
        if (this.f32436b == 0) {
            return cVar;
        }
        o a2 = this.f32435a.a();
        cVar.f32435a = a2;
        a2.f32471g = a2;
        a2.f32470f = a2;
        o oVar = this.f32435a;
        while (true) {
            oVar = oVar.f32470f;
            if (oVar != this.f32435a) {
                cVar.f32435a.f32471g.a(oVar.a());
            } else {
                cVar.f32436b = this.f32436b;
                return cVar;
            }
        }
    }

    public s timeout() {
        return s.f32474c;
    }

    public String toString() {
        return u().toString();
    }

    public final ByteString u() {
        long j2 = this.f32436b;
        if (j2 <= 2147483647L) {
            return f((int) j2);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f32436b);
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = remaining;
            while (i2 > 0) {
                o e2 = e(1);
                int min = Math.min(i2, 8192 - e2.f32467c);
                byteBuffer.get(e2.f32465a, e2.f32467c, min);
                i2 -= min;
                e2.f32467c += min;
            }
            this.f32436b += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void write(c cVar, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar != this) {
            t.a(cVar.f32436b, 0, j2);
            while (j2 > 0) {
                if (j2 < ((long) (cVar.f32435a.f32467c - cVar.f32435a.f32466b))) {
                    o oVar = this.f32435a;
                    o oVar2 = oVar != null ? oVar.f32471g : null;
                    if (oVar2 != null && oVar2.f32469e) {
                        if ((((long) oVar2.f32467c) + j2) - ((long) (oVar2.f32468d ? 0 : oVar2.f32466b)) <= IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) {
                            cVar.f32435a.a(oVar2, (int) j2);
                            cVar.f32436b -= j2;
                            this.f32436b += j2;
                            return;
                        }
                    }
                    cVar.f32435a = cVar.f32435a.a((int) j2);
                }
                o oVar3 = cVar.f32435a;
                long j3 = (long) (oVar3.f32467c - oVar3.f32466b);
                cVar.f32435a = oVar3.b();
                o oVar4 = this.f32435a;
                if (oVar4 == null) {
                    this.f32435a = oVar3;
                    oVar3.f32471g = oVar3;
                    oVar3.f32470f = oVar3;
                } else {
                    oVar4.f32471g.a(oVar3).c();
                }
                cVar.f32436b -= j3;
                this.f32436b += j3;
                j2 -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }
}
