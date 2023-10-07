package com.google.android.exoplayer2.util;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f17100a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f17101b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f17102c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private static int a(p pVar) {
        int c2 = pVar.c(5);
        return c2 == 31 ? pVar.c(6) + 32 : c2;
    }

    public static Pair<Integer, Integer> a(p pVar, boolean z2) throws ParserException {
        int a2 = a(pVar);
        int b2 = b(pVar);
        int c2 = pVar.c(4);
        if (a2 == 5 || a2 == 29) {
            b2 = b(pVar);
            a2 = a(pVar);
            if (a2 == 22) {
                c2 = pVar.c(4);
            }
        }
        boolean z3 = true;
        if (z2) {
            if (!(a2 == 1 || a2 == 2 || a2 == 3 || a2 == 4 || a2 == 6 || a2 == 7 || a2 == 17)) {
                switch (a2) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        StringBuilder sb = new StringBuilder(42);
                        sb.append("Unsupported audio object type: ");
                        sb.append(a2);
                        throw new ParserException(sb.toString());
                }
            }
            a(pVar, a2, c2);
            switch (a2) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int c3 = pVar.c(2);
                    if (c3 == 2 || c3 == 3) {
                        StringBuilder sb2 = new StringBuilder(33);
                        sb2.append("Unsupported epConfig: ");
                        sb2.append(c3);
                        throw new ParserException(sb2.toString());
                    }
            }
        }
        int i2 = f17102c[c2];
        if (i2 == -1) {
            z3 = false;
        }
        a.a(z3);
        return Pair.create(Integer.valueOf(b2), Integer.valueOf(i2));
    }

    public static Pair<Integer, Integer> a(byte[] bArr) throws ParserException {
        return a(new p(bArr), false);
    }

    private static void a(p pVar, int i2, int i3) {
        pVar.b(1);
        if (pVar.e()) {
            pVar.b(14);
        }
        boolean e2 = pVar.e();
        if (i3 != 0) {
            if (i2 == 6 || i2 == 20) {
                pVar.b(3);
            }
            if (e2) {
                if (i2 == 22) {
                    pVar.b(16);
                }
                if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                    pVar.b(3);
                }
                pVar.b(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }

    public static byte[] a(int i2, int i3, int i4) {
        return new byte[]{(byte) (((i2 << 3) & 248) | ((i3 >> 1) & 7)), (byte) (((i3 << 7) & 128) | ((i4 << 3) & 120))};
    }

    public static byte[] a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = f17100a;
        byte[] bArr3 = new byte[(bArr2.length + i3)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i2, bArr3, bArr2.length, i3);
        return bArr3;
    }

    private static int b(p pVar) {
        int c2 = pVar.c(4);
        if (c2 == 15) {
            return pVar.c(24);
        }
        a.a(c2 < 13);
        return f17101b[c2];
    }

    public static Pair<Integer, Integer> b(byte[] bArr) {
        q qVar = new q(bArr);
        qVar.c(9);
        int h2 = qVar.h();
        qVar.c(20);
        return Pair.create(Integer.valueOf(qVar.v()), Integer.valueOf(h2));
    }

    public static String b(int i2, int i3, int i4) {
        return String.format("avc1.%02X%02X%02X", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }
}
