package fj;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.q;
import java.util.Arrays;

public final class w {

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f27417a;

        /* renamed from: b  reason: collision with root package name */
        public final int f27418b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f27419c;

        /* renamed from: d  reason: collision with root package name */
        public final int f27420d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f27421e;

        public a(int i2, int i3, long[] jArr, int i4, boolean z2) {
            this.f27417a = i2;
            this.f27418b = i3;
            this.f27419c = jArr;
            this.f27420d = i4;
            this.f27421e = z2;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f27422a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f27423b;

        /* renamed from: c  reason: collision with root package name */
        public final int f27424c;

        public b(String str, String[] strArr, int i2) {
            this.f27422a = str;
            this.f27423b = strArr;
            this.f27424c = i2;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f27425a;

        /* renamed from: b  reason: collision with root package name */
        public final int f27426b;

        /* renamed from: c  reason: collision with root package name */
        public final int f27427c;

        /* renamed from: d  reason: collision with root package name */
        public final int f27428d;

        public c(boolean z2, int i2, int i3, int i4) {
            this.f27425a = z2;
            this.f27426b = i2;
            this.f27427c = i3;
            this.f27428d = i4;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final long f27429a;

        /* renamed from: b  reason: collision with root package name */
        public final int f27430b;

        /* renamed from: c  reason: collision with root package name */
        public final long f27431c;

        /* renamed from: d  reason: collision with root package name */
        public final int f27432d;

        /* renamed from: e  reason: collision with root package name */
        public final int f27433e;

        /* renamed from: f  reason: collision with root package name */
        public final int f27434f;

        /* renamed from: g  reason: collision with root package name */
        public final int f27435g;

        /* renamed from: h  reason: collision with root package name */
        public final int f27436h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f27437i;

        /* renamed from: j  reason: collision with root package name */
        public final byte[] f27438j;

        public d(long j2, int i2, long j3, int i3, int i4, int i5, int i6, int i7, boolean z2, byte[] bArr) {
            this.f27429a = j2;
            this.f27430b = i2;
            this.f27431c = j3;
            this.f27432d = i3;
            this.f27433e = i4;
            this.f27434f = i5;
            this.f27435g = i6;
            this.f27436h = i7;
            this.f27437i = z2;
            this.f27438j = bArr;
        }
    }

    public static int a(int i2) {
        int i3 = 0;
        while (i2 > 0) {
            i3++;
            i2 >>>= 1;
        }
        return i3;
    }

    private static long a(long j2, long j3) {
        double d2 = (double) j3;
        Double.isNaN(d2);
        return (long) Math.floor(Math.pow((double) j2, 1.0d / d2));
    }

    public static b a(q qVar, boolean z2, boolean z3) throws ParserException {
        if (z2) {
            a(3, qVar, false);
        }
        String e2 = qVar.e((int) qVar.o());
        int length = 11 + e2.length();
        long o2 = qVar.o();
        String[] strArr = new String[((int) o2)];
        int i2 = length + 4;
        for (int i3 = 0; ((long) i3) < o2; i3++) {
            strArr[i3] = qVar.e((int) qVar.o());
            i2 = i2 + 4 + strArr[i3].length();
        }
        if (!z3 || (qVar.h() & 1) != 0) {
            return new b(e2, strArr, i2 + 1);
        }
        throw new ParserException("framing bit expected to be set");
    }

    public static d a(q qVar) throws ParserException {
        q qVar2 = qVar;
        a(1, qVar2, false);
        long o2 = qVar.o();
        int h2 = qVar.h();
        long o3 = qVar.o();
        int q2 = qVar.q();
        int q3 = qVar.q();
        int q4 = qVar.q();
        int h3 = qVar.h();
        return new d(o2, h2, o3, q2, q3, q4, (int) Math.pow(2.0d, (double) (h3 & 15)), (int) Math.pow(2.0d, (double) ((h3 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) >> 4)), (qVar.h() & 1) > 0, Arrays.copyOf(qVar2.f17159a, qVar.c()));
    }

    private static void a(int i2, v vVar) throws ParserException {
        int a2 = vVar.a(6) + 1;
        for (int i3 = 0; i3 < a2; i3++) {
            int a3 = vVar.a(16);
            if (a3 != 0) {
                StringBuilder sb = new StringBuilder(52);
                sb.append("mapping type other than 0 not supported: ");
                sb.append(a3);
                k.d("VorbisUtil", sb.toString());
            } else {
                int a4 = vVar.a() ? vVar.a(4) + 1 : 1;
                if (vVar.a()) {
                    int a5 = vVar.a(8) + 1;
                    for (int i4 = 0; i4 < a5; i4++) {
                        int i5 = i2 - 1;
                        vVar.b(a(i5));
                        vVar.b(a(i5));
                    }
                }
                if (vVar.a(2) == 0) {
                    if (a4 > 1) {
                        for (int i6 = 0; i6 < i2; i6++) {
                            vVar.b(4);
                        }
                    }
                    for (int i7 = 0; i7 < a4; i7++) {
                        vVar.b(8);
                        vVar.b(8);
                        vVar.b(8);
                    }
                } else {
                    throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                }
            }
        }
    }

    public static boolean a(int i2, q qVar, boolean z2) throws ParserException {
        if (qVar.b() < 7) {
            if (z2) {
                return false;
            }
            int b2 = qVar.b();
            StringBuilder sb = new StringBuilder(29);
            sb.append("too short header: ");
            sb.append(b2);
            throw new ParserException(sb.toString());
        } else if (qVar.h() != i2) {
            if (z2) {
                return false;
            }
            String valueOf = String.valueOf(Integer.toHexString(i2));
            throw new ParserException(valueOf.length() != 0 ? "expected header type ".concat(valueOf) : new String("expected header type "));
        } else if (qVar.h() == 118 && qVar.h() == 111 && qVar.h() == 114 && qVar.h() == 98 && qVar.h() == 105 && qVar.h() == 115) {
            return true;
        } else {
            if (z2) {
                return false;
            }
            throw new ParserException("expected characters 'vorbis'");
        }
    }

    public static c[] a(q qVar, int i2) throws ParserException {
        int i3 = 0;
        a(5, qVar, false);
        int h2 = qVar.h() + 1;
        v vVar = new v(qVar.f17159a);
        vVar.b(qVar.d() * 8);
        for (int i4 = 0; i4 < h2; i4++) {
            d(vVar);
        }
        int a2 = vVar.a(6) + 1;
        while (i3 < a2) {
            if (vVar.a(16) == 0) {
                i3++;
            } else {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
        }
        c(vVar);
        b(vVar);
        a(i2, vVar);
        c[] a3 = a(vVar);
        if (vVar.a()) {
            return a3;
        }
        throw new ParserException("framing bit after modes not set as expected");
    }

    private static c[] a(v vVar) {
        int a2 = vVar.a(6) + 1;
        c[] cVarArr = new c[a2];
        for (int i2 = 0; i2 < a2; i2++) {
            cVarArr[i2] = new c(vVar.a(), vVar.a(16), vVar.a(16), vVar.a(8));
        }
        return cVarArr;
    }

    public static b b(q qVar) throws ParserException {
        return a(qVar, true, true);
    }

    private static void b(v vVar) throws ParserException {
        int a2 = vVar.a(6) + 1;
        int i2 = 0;
        while (i2 < a2) {
            if (vVar.a(16) <= 2) {
                vVar.b(24);
                vVar.b(24);
                vVar.b(24);
                int a3 = vVar.a(6) + 1;
                vVar.b(8);
                int[] iArr = new int[a3];
                for (int i3 = 0; i3 < a3; i3++) {
                    iArr[i3] = ((vVar.a() ? vVar.a(5) : 0) * 8) + vVar.a(3);
                }
                for (int i4 = 0; i4 < a3; i4++) {
                    for (int i5 = 0; i5 < 8; i5++) {
                        if ((iArr[i4] & (1 << i5)) != 0) {
                            vVar.b(8);
                        }
                    }
                }
                i2++;
            } else {
                throw new ParserException("residueType greater than 2 is not decodable");
            }
        }
    }

    private static void c(v vVar) throws ParserException {
        int a2 = vVar.a(6) + 1;
        for (int i2 = 0; i2 < a2; i2++) {
            int a3 = vVar.a(16);
            if (a3 == 0) {
                vVar.b(8);
                vVar.b(16);
                vVar.b(16);
                vVar.b(6);
                vVar.b(8);
                int a4 = vVar.a(4) + 1;
                for (int i3 = 0; i3 < a4; i3++) {
                    vVar.b(8);
                }
            } else if (a3 == 1) {
                int a5 = vVar.a(5);
                int i4 = -1;
                int[] iArr = new int[a5];
                for (int i5 = 0; i5 < a5; i5++) {
                    iArr[i5] = vVar.a(4);
                    if (iArr[i5] > i4) {
                        i4 = iArr[i5];
                    }
                }
                int i6 = i4 + 1;
                int[] iArr2 = new int[i6];
                for (int i7 = 0; i7 < i6; i7++) {
                    iArr2[i7] = vVar.a(3) + 1;
                    int a6 = vVar.a(2);
                    if (a6 > 0) {
                        vVar.b(8);
                    }
                    for (int i8 = 0; i8 < (1 << a6); i8++) {
                        vVar.b(8);
                    }
                }
                vVar.b(2);
                int a7 = vVar.a(4);
                int i9 = 0;
                int i10 = 0;
                for (int i11 = 0; i11 < a5; i11++) {
                    i9 += iArr2[iArr[i11]];
                    while (i10 < i9) {
                        vVar.b(a7);
                        i10++;
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder(52);
                sb.append("floor type greater than 1 not decodable: ");
                sb.append(a3);
                throw new ParserException(sb.toString());
            }
        }
    }

    private static a d(v vVar) throws ParserException {
        if (vVar.a(24) == 5653314) {
            int a2 = vVar.a(16);
            int a3 = vVar.a(24);
            long[] jArr = new long[a3];
            boolean a4 = vVar.a();
            long j2 = 0;
            if (!a4) {
                boolean a5 = vVar.a();
                for (int i2 = 0; i2 < a3; i2++) {
                    if (!a5) {
                        jArr[i2] = (long) (vVar.a(5) + 1);
                    } else if (vVar.a()) {
                        jArr[i2] = (long) (vVar.a(5) + 1);
                    } else {
                        jArr[i2] = 0;
                    }
                }
            } else {
                int a6 = vVar.a(5) + 1;
                int i3 = 0;
                while (i3 < a3) {
                    int a7 = vVar.a(a(a3 - i3));
                    for (int i4 = 0; i4 < a7 && i3 < a3; i4++) {
                        jArr[i3] = (long) a6;
                        i3++;
                    }
                    a6++;
                }
            }
            int a8 = vVar.a(4);
            if (a8 <= 2) {
                if (a8 == 1 || a8 == 2) {
                    vVar.b(32);
                    vVar.b(32);
                    int a9 = vVar.a(4) + 1;
                    vVar.b(1);
                    if (a8 != 1) {
                        j2 = ((long) a3) * ((long) a2);
                    } else if (a2 != 0) {
                        j2 = a((long) a3, (long) a2);
                    }
                    vVar.b((int) (j2 * ((long) a9)));
                }
                return new a(a2, a3, jArr, a8, a4);
            }
            StringBuilder sb = new StringBuilder(53);
            sb.append("lookup type greater than 2 not decodable: ");
            sb.append(a8);
            throw new ParserException(sb.toString());
        }
        int b2 = vVar.b();
        StringBuilder sb2 = new StringBuilder(66);
        sb2.append("expected code book to start with [0x56, 0x43, 0x42] at ");
        sb2.append(b2);
        throw new ParserException(sb2.toString());
    }
}
