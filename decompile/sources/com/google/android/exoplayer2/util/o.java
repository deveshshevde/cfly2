package com.google.android.exoplayer2.util;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f17135a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f17136b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c  reason: collision with root package name */
    private static final Object f17137c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static int[] f17138d = new int[10];

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f17139a;

        /* renamed from: b  reason: collision with root package name */
        public final int f17140b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f17141c;

        public a(int i2, int i3, boolean z2) {
            this.f17139a = i2;
            this.f17140b = i3;
            this.f17141c = z2;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f17142a;

        /* renamed from: b  reason: collision with root package name */
        public final int f17143b;

        /* renamed from: c  reason: collision with root package name */
        public final int f17144c;

        /* renamed from: d  reason: collision with root package name */
        public final int f17145d;

        /* renamed from: e  reason: collision with root package name */
        public final int f17146e;

        /* renamed from: f  reason: collision with root package name */
        public final int f17147f;

        /* renamed from: g  reason: collision with root package name */
        public final float f17148g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f17149h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f17150i;

        /* renamed from: j  reason: collision with root package name */
        public final int f17151j;

        /* renamed from: k  reason: collision with root package name */
        public final int f17152k;

        /* renamed from: l  reason: collision with root package name */
        public final int f17153l;

        /* renamed from: m  reason: collision with root package name */
        public final boolean f17154m;

        public b(int i2, int i3, int i4, int i5, int i6, int i7, float f2, boolean z2, boolean z3, int i8, int i9, int i10, boolean z4) {
            this.f17142a = i2;
            this.f17143b = i3;
            this.f17144c = i4;
            this.f17145d = i5;
            this.f17146e = i6;
            this.f17147f = i7;
            this.f17148g = f2;
            this.f17149h = z2;
            this.f17150i = z3;
            this.f17151j = i8;
            this.f17152k = i9;
            this.f17153l = i10;
            this.f17154m = z4;
        }
    }

    public static int a(byte[] bArr, int i2) {
        int i3;
        synchronized (f17137c) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                try {
                    i4 = c(bArr, i4, i2);
                    if (i4 < i2) {
                        int[] iArr = f17138d;
                        if (iArr.length <= i5) {
                            f17138d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f17138d[i5] = i4;
                        i4 += 3;
                        i5++;
                    }
                } finally {
                }
            }
            i3 = i2 - i5;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = f17138d[i8] - i7;
                System.arraycopy(bArr, i7, bArr, i6, i9);
                int i10 = i6 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i6 = i11 + 1;
                bArr[i11] = 0;
                i7 += i9 + 3;
            }
            System.arraycopy(bArr, i7, bArr, i6, i3 - i6);
        }
        return i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0097, code lost:
        r8 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(byte[] r7, int r8, int r9, boolean[] r10) {
        /*
            int r0 = r9 - r8
            r1 = 0
            r2 = 1
            if (r0 < 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            com.google.android.exoplayer2.util.a.b((boolean) r3)
            if (r0 != 0) goto L_0x000f
            return r9
        L_0x000f:
            r3 = 2
            if (r10 == 0) goto L_0x0040
            boolean r4 = r10[r1]
            if (r4 == 0) goto L_0x001c
            a((boolean[]) r10)
            int r8 = r8 + -3
            return r8
        L_0x001c:
            if (r0 <= r2) goto L_0x002b
            boolean r4 = r10[r2]
            if (r4 == 0) goto L_0x002b
            byte r4 = r7[r8]
            if (r4 != r2) goto L_0x002b
            a((boolean[]) r10)
            int r8 = r8 - r3
            return r8
        L_0x002b:
            if (r0 <= r3) goto L_0x0040
            boolean r4 = r10[r3]
            if (r4 == 0) goto L_0x0040
            byte r4 = r7[r8]
            if (r4 != 0) goto L_0x0040
            int r4 = r8 + 1
            byte r4 = r7[r4]
            if (r4 != r2) goto L_0x0040
            a((boolean[]) r10)
            int r8 = r8 - r2
            return r8
        L_0x0040:
            int r4 = r9 + -1
            int r8 = r8 + r3
        L_0x0043:
            if (r8 >= r4) goto L_0x0067
            byte r5 = r7[r8]
            r5 = r5 & 254(0xfe, float:3.56E-43)
            if (r5 == 0) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            int r5 = r8 + -2
            byte r6 = r7[r5]
            if (r6 != 0) goto L_0x0062
            int r6 = r8 + -1
            byte r6 = r7[r6]
            if (r6 != 0) goto L_0x0062
            byte r6 = r7[r8]
            if (r6 != r2) goto L_0x0062
            if (r10 == 0) goto L_0x0061
            a((boolean[]) r10)
        L_0x0061:
            return r5
        L_0x0062:
            int r8 = r8 + -2
        L_0x0064:
            int r8 = r8 + 3
            goto L_0x0043
        L_0x0067:
            if (r10 == 0) goto L_0x00bb
            if (r0 <= r3) goto L_0x007e
            int r8 = r9 + -3
            byte r8 = r7[r8]
            if (r8 != 0) goto L_0x007c
            int r8 = r9 + -2
            byte r8 = r7[r8]
            if (r8 != 0) goto L_0x007c
            byte r8 = r7[r4]
            if (r8 != r2) goto L_0x007c
            goto L_0x0097
        L_0x007c:
            r8 = 0
            goto L_0x0098
        L_0x007e:
            if (r0 != r3) goto L_0x008f
            boolean r8 = r10[r3]
            if (r8 == 0) goto L_0x007c
            int r8 = r9 + -2
            byte r8 = r7[r8]
            if (r8 != 0) goto L_0x007c
            byte r8 = r7[r4]
            if (r8 != r2) goto L_0x007c
            goto L_0x0097
        L_0x008f:
            boolean r8 = r10[r2]
            if (r8 == 0) goto L_0x007c
            byte r8 = r7[r4]
            if (r8 != r2) goto L_0x007c
        L_0x0097:
            r8 = 1
        L_0x0098:
            r10[r1] = r8
            if (r0 <= r2) goto L_0x00a7
            int r8 = r9 + -2
            byte r8 = r7[r8]
            if (r8 != 0) goto L_0x00b1
            byte r8 = r7[r4]
            if (r8 != 0) goto L_0x00b1
            goto L_0x00af
        L_0x00a7:
            boolean r8 = r10[r3]
            if (r8 == 0) goto L_0x00b1
            byte r8 = r7[r4]
            if (r8 != 0) goto L_0x00b1
        L_0x00af:
            r8 = 1
            goto L_0x00b2
        L_0x00b1:
            r8 = 0
        L_0x00b2:
            r10[r2] = r8
            byte r7 = r7[r4]
            if (r7 != 0) goto L_0x00b9
            r1 = 1
        L_0x00b9:
            r10[r3] = r1
        L_0x00bb:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.o.a(byte[], int, int, boolean[]):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.util.o.b a(byte[] r21, int r22, int r23) {
        /*
            com.google.android.exoplayer2.util.r r0 = new com.google.android.exoplayer2.util.r
            r1 = r21
            r2 = r22
            r3 = r23
            r0.<init>(r1, r2, r3)
            r1 = 8
            r0.a(r1)
            int r3 = r0.c(r1)
            int r4 = r0.c(r1)
            int r5 = r0.c(r1)
            int r6 = r0.d()
            r2 = 3
            r9 = 1
            r10 = 100
            if (r3 == r10) goto L_0x004e
            r10 = 110(0x6e, float:1.54E-43)
            if (r3 == r10) goto L_0x004e
            r10 = 122(0x7a, float:1.71E-43)
            if (r3 == r10) goto L_0x004e
            r10 = 244(0xf4, float:3.42E-43)
            if (r3 == r10) goto L_0x004e
            r10 = 44
            if (r3 == r10) goto L_0x004e
            r10 = 83
            if (r3 == r10) goto L_0x004e
            r10 = 86
            if (r3 == r10) goto L_0x004e
            r10 = 118(0x76, float:1.65E-43)
            if (r3 == r10) goto L_0x004e
            r10 = 128(0x80, float:1.794E-43)
            if (r3 == r10) goto L_0x004e
            r10 = 138(0x8a, float:1.93E-43)
            if (r3 != r10) goto L_0x004b
            goto L_0x004e
        L_0x004b:
            r10 = 1
            r11 = 0
            goto L_0x0087
        L_0x004e:
            int r10 = r0.d()
            if (r10 != r2) goto L_0x0059
            boolean r11 = r0.b()
            goto L_0x005a
        L_0x0059:
            r11 = 0
        L_0x005a:
            r0.d()
            r0.d()
            r0.a()
            boolean r12 = r0.b()
            if (r12 == 0) goto L_0x0087
            if (r10 == r2) goto L_0x006e
            r12 = 8
            goto L_0x0070
        L_0x006e:
            r12 = 12
        L_0x0070:
            r13 = 0
        L_0x0071:
            if (r13 >= r12) goto L_0x0087
            boolean r14 = r0.b()
            if (r14 == 0) goto L_0x0084
            r14 = 6
            if (r13 >= r14) goto L_0x007f
            r14 = 16
            goto L_0x0081
        L_0x007f:
            r14 = 64
        L_0x0081:
            a((com.google.android.exoplayer2.util.r) r0, (int) r14)
        L_0x0084:
            int r13 = r13 + 1
            goto L_0x0071
        L_0x0087:
            int r12 = r0.d()
            int r12 = r12 + 4
            int r13 = r0.d()
            if (r13 != 0) goto L_0x009a
            int r14 = r0.d()
            int r14 = r14 + 4
            goto L_0x00bb
        L_0x009a:
            if (r13 != r9) goto L_0x00ba
            boolean r14 = r0.b()
            r0.e()
            r0.e()
            int r15 = r0.d()
            long r1 = (long) r15
            r15 = 0
        L_0x00ac:
            long r7 = (long) r15
            int r17 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r17 >= 0) goto L_0x00b7
            r0.d()
            int r15 = r15 + 1
            goto L_0x00ac
        L_0x00b7:
            r15 = r14
            r14 = 0
            goto L_0x00bc
        L_0x00ba:
            r14 = 0
        L_0x00bb:
            r15 = 0
        L_0x00bc:
            r0.d()
            r0.a()
            int r1 = r0.d()
            int r1 = r1 + r9
            int r2 = r0.d()
            int r2 = r2 + r9
            boolean r16 = r0.b()
            int r7 = 2 - r16
            int r7 = r7 * r2
            if (r16 != 0) goto L_0x00d9
            r0.a()
        L_0x00d9:
            r0.a()
            r2 = 16
            int r1 = r1 * 16
            int r7 = r7 * 16
            boolean r2 = r0.b()
            if (r2 == 0) goto L_0x011c
            int r2 = r0.d()
            int r8 = r0.d()
            int r17 = r0.d()
            int r18 = r0.d()
            if (r10 != 0) goto L_0x00fd
            int r10 = 2 - r16
            goto L_0x0112
        L_0x00fd:
            r19 = 2
            r9 = 3
            if (r10 != r9) goto L_0x0106
            r9 = 1
            r20 = 1
            goto L_0x0109
        L_0x0106:
            r9 = 1
            r20 = 2
        L_0x0109:
            if (r10 != r9) goto L_0x010c
            r9 = 2
        L_0x010c:
            int r10 = 2 - r16
            int r10 = r10 * r9
            r9 = r20
        L_0x0112:
            int r2 = r2 + r8
            int r2 = r2 * r9
            int r1 = r1 - r2
            int r17 = r17 + r18
            int r17 = r17 * r10
            int r7 = r7 - r17
        L_0x011c:
            r8 = r7
            r7 = r1
            r1 = 1065353216(0x3f800000, float:1.0)
            boolean r2 = r0.b()
            if (r2 == 0) goto L_0x016a
            boolean r2 = r0.b()
            if (r2 == 0) goto L_0x016a
            r2 = 8
            int r2 = r0.c(r2)
            r9 = 255(0xff, float:3.57E-43)
            if (r2 != r9) goto L_0x0149
            r9 = 16
            int r2 = r0.c(r9)
            int r0 = r0.c(r9)
            if (r2 == 0) goto L_0x0147
            if (r0 == 0) goto L_0x0147
            float r1 = (float) r2
            float r0 = (float) r0
            float r1 = r1 / r0
        L_0x0147:
            r9 = r1
            goto L_0x016c
        L_0x0149:
            float[] r0 = f17136b
            int r9 = r0.length
            if (r2 >= r9) goto L_0x0152
            r0 = r0[r2]
            r9 = r0
            goto L_0x016c
        L_0x0152:
            r0 = 46
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r0)
            java.lang.String r0 = "Unexpected aspect_ratio_idc value: "
            r9.append(r0)
            r9.append(r2)
            java.lang.String r0 = r9.toString()
            java.lang.String r2 = "NalUnitUtil"
            com.google.android.exoplayer2.util.k.c(r2, r0)
        L_0x016a:
            r9 = 1065353216(0x3f800000, float:1.0)
        L_0x016c:
            com.google.android.exoplayer2.util.o$b r0 = new com.google.android.exoplayer2.util.o$b
            r2 = r0
            r10 = r11
            r11 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.o.a(byte[], int, int):com.google.android.exoplayer2.util.o$b");
    }

    private static void a(r rVar, int i2) {
        int i3 = 8;
        int i4 = 8;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i3 != 0) {
                i3 = ((rVar.e() + i4) + 256) % 256;
            }
            if (i3 != 0) {
                i4 = i3;
            }
        }
    }

    public static void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i4 < position) {
                byte b2 = byteBuffer.get(i2) & 255;
                if (i3 == 3) {
                    if (b2 == 1 && (byteBuffer.get(i4) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i2 - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (b2 == 0) {
                    i3++;
                }
                if (b2 != 0) {
                    i3 = 0;
                }
                i2 = i4;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean a(String str, byte b2) {
        if (!"video/avc".equals(str) || (b2 & 31) != 6) {
            return "video/hevc".equals(str) && ((b2 & 126) >> 1) == 39;
        }
        return true;
    }

    public static int b(byte[] bArr, int i2) {
        return bArr[i2 + 3] & 31;
    }

    public static a b(byte[] bArr, int i2, int i3) {
        r rVar = new r(bArr, i2, i3);
        rVar.a(8);
        int d2 = rVar.d();
        int d3 = rVar.d();
        rVar.a();
        return new a(d2, d3, rVar.b());
    }

    public static int c(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 126) >> 1;
    }

    private static int c(byte[] bArr, int i2, int i3) {
        while (i2 < i3 - 2) {
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 3) {
                return i2;
            }
            i2++;
        }
        return i3;
    }
}
