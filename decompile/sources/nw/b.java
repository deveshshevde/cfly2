package nw;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.jcodec.common.a;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int[] f31644a = {0, 1, 4, 8, 5, 2, 3, 6, 9, 12, 13, 10, 7, 11, 14, 15};

    /* renamed from: b  reason: collision with root package name */
    static int[][] f31645b = {new int[]{10, 13, 10, 13, 13, 16, 13, 16, 10, 13, 10, 13, 13, 16, 13, 16}, new int[]{11, 14, 11, 14, 14, 18, 14, 18, 11, 14, 11, 14, 14, 18, 14, 18}, new int[]{13, 16, 13, 16, 16, 20, 16, 20, 13, 16, 13, 16, 16, 20, 16, 20}, new int[]{14, 18, 14, 18, 18, 23, 18, 23, 14, 18, 14, 18, 18, 23, 18, 23}, new int[]{16, 20, 16, 20, 20, 25, 20, 25, 16, 20, 16, 20, 20, 25, 20, 25}, new int[]{18, 23, 18, 23, 23, 29, 23, 29, 18, 23, 18, 23, 23, 29, 23, 29}};

    /* renamed from: c  reason: collision with root package name */
    static int[][] f31646c = ((int[][]) Array.newInstance(int.class, new int[]{6, 64}));

    /* renamed from: d  reason: collision with root package name */
    static int[][] f31647d = {new int[]{20, 18, 32, 19, 25, 24}, new int[]{22, 19, 35, 21, 28, 26}, new int[]{26, 23, 42, 24, 33, 31}, new int[]{28, 25, 45, 26, 35, 33}, new int[]{32, 28, 51, 30, 40, 38}, new int[]{36, 32, 58, 34, 46, 43}};

    /* renamed from: e  reason: collision with root package name */
    public static int[] f31648e = {0, 1, 8, 16, 9, 2, 3, 10, 17, 24, 32, 25, 18, 11, 4, 5, 12, 19, 26, 33, 40, 48, 41, 34, 27, 20, 13, 6, 7, 14, 21, 28, 35, 42, 49, 56, 57, 50, 43, 36, 29, 22, 15, 23, 30, 37, 44, 51, 58, 59, 52, 45, 38, 31, 39, 46, 53, 60, 61, 54, 47, 55, 62, 63};

    /* renamed from: f  reason: collision with root package name */
    private static final int[][] f31649f = {new int[]{13107, 8066, 13107, 8066, 8066, 5243, 8066, 5243, 13107, 8066, 13107, 8066, 8066, 5243, 8066, 5243}, new int[]{11916, 7490, 11916, 7490, 7490, 4660, 7490, 4660, 11916, 7490, 11916, 7490, 7490, 4660, 7490, 4660}, new int[]{10082, 6554, 10082, 6554, 6554, 4194, 6554, 4194, 10082, 6554, 10082, 6554, 6554, 4194, 6554, 4194}, new int[]{9362, 5825, 9362, 5825, 5825, 3647, 5825, 3647, 9362, 5825, 9362, 5825, 5825, 3647, 5825, 3647}, new int[]{8192, 5243, 8192, 5243, 5243, 3355, 5243, 3355, 8192, 5243, 8192, 5243, 5243, 3355, 5243, 3355}, new int[]{7282, 4559, 7282, 4559, 4559, 2893, 4559, 2893, 7282, 4559, 7282, 4559, 4559, 2893, 4559, 2893}};

    static {
        for (int i2 = 0; i2 < 6; i2++) {
            Arrays.fill(f31646c[i2], f31647d[i2][5]);
            for (int i3 = 0; i3 < 8; i3 += 4) {
                for (int i4 = 0; i4 < 8; i4 += 4) {
                    f31646c[i2][(i3 << 3) + i4] = f31647d[i2][0];
                }
            }
            for (int i5 = 1; i5 < 8; i5 += 2) {
                for (int i6 = 1; i6 < 8; i6 += 2) {
                    f31646c[i2][(i5 << 3) + i6] = f31647d[i2][1];
                }
            }
            for (int i7 = 2; i7 < 8; i7 += 4) {
                for (int i8 = 2; i8 < 8; i8 += 4) {
                    f31646c[i2][(i7 << 3) + i8] = f31647d[i2][2];
                }
            }
            for (int i9 = 0; i9 < 8; i9 += 4) {
                for (int i10 = 1; i10 < 8; i10 += 2) {
                    f31646c[i2][(i9 << 3) + i10] = f31647d[i2][3];
                }
            }
            for (int i11 = 1; i11 < 8; i11 += 2) {
                for (int i12 = 0; i12 < 8; i12 += 4) {
                    f31646c[i2][(i11 << 3) + i12] = f31647d[i2][3];
                }
            }
            for (int i13 = 0; i13 < 8; i13 += 4) {
                for (int i14 = 2; i14 < 8; i14 += 4) {
                    f31646c[i2][(i13 << 3) + i14] = f31647d[i2][4];
                }
            }
            for (int i15 = 2; i15 < 8; i15 += 4) {
                for (int i16 = 0; i16 < 8; i16 += 4) {
                    f31646c[i2][(i15 << 3) + i16] = f31647d[i2][4];
                }
            }
        }
    }

    public static final void a(int[] iArr) {
        a(iArr, iArr);
    }

    public static void a(int[] iArr, int i2) {
        int i3 = i2 % 6;
        int i4 = 0;
        if (i2 >= 24) {
            int i5 = i2 / 6;
            while (i4 < 16) {
                iArr[i4] = (iArr[i4] * f31645b[i3][i4]) << i5;
                i4++;
            }
            return;
        }
        int i6 = i2 / 6;
        int i7 = 4 - i6;
        int i8 = 1 << (3 - i6);
        while (i4 < 16) {
            iArr[i4] = ((iArr[i4] * (f31645b[i3][i4] << 4)) + i8) >> i7;
            i4++;
        }
    }

    public static final void a(int[] iArr, int[] iArr2) {
        for (int i2 = 0; i2 < 16; i2 += 4) {
            int i3 = i2 + 2;
            int i4 = iArr[i2] + iArr[i3];
            int i5 = iArr[i2] - iArr[i3];
            int i6 = i2 + 1;
            int i7 = i2 + 3;
            int i8 = (iArr[i6] >> 1) - iArr[i7];
            int i9 = iArr[i6] + (iArr[i7] >> 1);
            iArr2[i2] = i4 + i9;
            iArr2[i6] = i5 + i8;
            iArr2[i3] = i5 - i8;
            iArr2[i7] = i4 - i9;
        }
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = i10 + 8;
            int i12 = iArr2[i10] + iArr2[i11];
            int i13 = iArr2[i10] - iArr2[i11];
            int i14 = i10 + 4;
            int i15 = i10 + 12;
            int i16 = (iArr2[i14] >> 1) - iArr2[i15];
            int i17 = iArr2[i14] + (iArr2[i15] >> 1);
            iArr2[i10] = i12 + i17;
            iArr2[i14] = i13 + i16;
            iArr2[i11] = i13 - i16;
            iArr2[i15] = i12 - i17;
        }
        for (int i18 = 0; i18 < 16; i18++) {
            iArr2[i18] = (iArr2[i18] + 32) >> 6;
        }
    }

    public static void b(int[] iArr) {
        for (int i2 = 0; i2 < 16; i2 += 4) {
            int i3 = i2 + 3;
            int i4 = iArr[i2] + iArr[i3];
            int i5 = i2 + 1;
            int i6 = i2 + 2;
            int i7 = iArr[i5] + iArr[i6];
            int i8 = iArr[i5] - iArr[i6];
            int i9 = iArr[i2] - iArr[i3];
            iArr[i2] = i4 + i7;
            iArr[i5] = (i9 << 1) + i8;
            iArr[i6] = i4 - i7;
            iArr[i3] = i9 - (i8 << 1);
        }
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = i10 + 12;
            int i12 = iArr[i10] + iArr[i11];
            int i13 = i10 + 4;
            int i14 = i10 + 8;
            int i15 = iArr[i13] + iArr[i14];
            int i16 = iArr[i13] - iArr[i14];
            int i17 = iArr[i10] - iArr[i11];
            iArr[i10] = i12 + i15;
            iArr[i13] = (i17 << 1) + i16;
            iArr[i14] = i12 - i15;
            iArr[i11] = i17 - (i16 << 1);
        }
    }

    public static void b(int[] iArr, int i2) {
        int i3 = i2 / 6;
        int i4 = i2 % 6;
        int i5 = 682 << (i3 + 4);
        int i6 = i3 + 15;
        int i7 = 1;
        if (i2 < 10) {
            while (i7 < 16) {
                int i8 = iArr[i7] >> 31;
                iArr[i7] = (Math.min(((((iArr[i7] ^ i8) - i8) * f31649f[i4][i7]) + i5) >> i6, 2063) ^ i8) - i8;
                i7++;
            }
            return;
        }
        while (i7 < 16) {
            int i9 = iArr[i7] >> 31;
            iArr[i7] = ((((((iArr[i7] ^ i9) - i9) * f31649f[i4][i7]) + i5) >> i6) ^ i9) - i9;
            i7++;
        }
    }

    public static void c(int[] iArr) {
        for (int i2 = 0; i2 < 16; i2 += 4) {
            int i3 = i2 + 2;
            int i4 = iArr[i2] + iArr[i3];
            int i5 = iArr[i2] - iArr[i3];
            int i6 = i2 + 1;
            int i7 = i2 + 3;
            int i8 = iArr[i6] - iArr[i7];
            int i9 = iArr[i6] + iArr[i7];
            iArr[i2] = i4 + i9;
            iArr[i6] = i5 + i8;
            iArr[i3] = i5 - i8;
            iArr[i7] = i4 - i9;
        }
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = i10 + 8;
            int i12 = iArr[i10] + iArr[i11];
            int i13 = iArr[i10] - iArr[i11];
            int i14 = i10 + 4;
            int i15 = i10 + 12;
            int i16 = iArr[i14] - iArr[i15];
            int i17 = iArr[i14] + iArr[i15];
            iArr[i10] = i12 + i17;
            iArr[i14] = i13 + i16;
            iArr[i11] = i13 - i16;
            iArr[i15] = i12 - i17;
        }
    }

    public static void c(int[] iArr, int i2) {
        int i3 = i2 % 6;
        if (i2 >= 36) {
            int i4 = (i2 / 6) - 2;
            for (int i5 = 0; i5 < 16; i5++) {
                iArr[i5] = (iArr[i5] * f31645b[i3][0]) << i4;
            }
            return;
        }
        int i6 = i2 / 6;
        int i7 = 6 - i6;
        int i8 = 1 << (5 - i6);
        for (int i9 = 0; i9 < 16; i9++) {
            iArr[i9] = ((iArr[i9] * (f31645b[i3][0] << 4)) + i8) >> i7;
        }
    }

    public static void d(int[] iArr) {
        for (int i2 = 0; i2 < 16; i2 += 4) {
            int i3 = i2 + 3;
            int i4 = iArr[i2] + iArr[i3];
            int i5 = i2 + 1;
            int i6 = i2 + 2;
            int i7 = iArr[i5] + iArr[i6];
            int i8 = iArr[i5] - iArr[i6];
            int i9 = iArr[i2] - iArr[i3];
            iArr[i2] = i4 + i7;
            iArr[i5] = i9 + i8;
            iArr[i6] = i4 - i7;
            iArr[i3] = i9 - i8;
        }
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = i10 + 12;
            int i12 = iArr[i10] + iArr[i11];
            int i13 = i10 + 4;
            int i14 = i10 + 8;
            int i15 = iArr[i13] + iArr[i14];
            int i16 = iArr[i13] - iArr[i14];
            int i17 = iArr[i10] - iArr[i11];
            iArr[i10] = (i12 + i15) >> 1;
            iArr[i13] = (i16 + i17) >> 1;
            iArr[i14] = (i12 - i15) >> 1;
            iArr[i11] = (i17 - i16) >> 1;
        }
    }

    public static void d(int[] iArr, int i2) {
        int i3 = i2 / 6;
        int i4 = i2 % 6;
        int i5 = 682 << (i3 + 5);
        int i6 = i3 + 16;
        if (i2 < 10) {
            for (int i7 = 0; i7 < 16; i7++) {
                int i8 = iArr[i7] >> 31;
                iArr[i7] = (Math.min(((((iArr[i7] ^ i8) - i8) * f31649f[i4][0]) + i5) >> i6, 2063) ^ i8) - i8;
            }
            return;
        }
        for (int i9 = 0; i9 < 16; i9++) {
            int i10 = iArr[i9] >> 31;
            iArr[i9] = ((((((iArr[i9] ^ i10) - i10) * f31649f[i4][0]) + i5) >> i6) ^ i10) - i10;
        }
    }

    public static void e(int[] iArr) {
        int i2 = iArr[0] + iArr[1];
        int i3 = iArr[0] - iArr[1];
        int i4 = iArr[2] + iArr[3];
        int i5 = iArr[2] - iArr[3];
        iArr[0] = i2 + i4;
        iArr[1] = i3 + i5;
        iArr[2] = i2 - i4;
        iArr[3] = i3 - i5;
    }

    public static void e(int[] iArr, int i2) {
        int i3 = i2 % 6;
        int i4 = i2 / 6;
        for (int i5 = 0; i5 < 4; i5++) {
            iArr[i5] = ((iArr[i5] * f31645b[i3][0]) << i4) >> 1;
        }
    }

    public static void f(int[] iArr) {
        e(iArr);
    }

    public static void f(int[] iArr, int i2) {
        int i3 = i2 / 6;
        int i4 = i2 % 6;
        int i5 = 682 << (i3 + 5);
        int i6 = i3 + 16;
        if (i2 < 4) {
            for (int i7 = 0; i7 < 4; i7++) {
                int i8 = iArr[i7] >> 31;
                iArr[i7] = (Math.min(((((iArr[i7] ^ i8) - i8) * f31649f[i4][0]) + i5) >> i6, 2063) ^ i8) - i8;
            }
            return;
        }
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = iArr[i9] >> 31;
            iArr[i9] = ((((((iArr[i9] ^ i10) - i10) * f31649f[i4][0]) + i5) >> i6) ^ i10) - i10;
        }
    }

    public static void g(int[] iArr) {
        a.a(iArr, 2, 4);
        a.a(iArr, 3, 5);
        a.a(iArr, 10, 12);
        a.a(iArr, 11, 13);
    }

    public static void g(int[] iArr, int i2) {
    }

    public static void h(int[] iArr) {
    }

    public static void h(int[] iArr, int i2) {
    }

    public static void i(int[] iArr) {
    }
}
