package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.a;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class q {

    /* renamed from: a  reason: collision with root package name */
    private final int f15363a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15364b;

    /* renamed from: c  reason: collision with root package name */
    private final float f15365c;

    /* renamed from: d  reason: collision with root package name */
    private final float f15366d;

    /* renamed from: e  reason: collision with root package name */
    private final float f15367e;

    /* renamed from: f  reason: collision with root package name */
    private final int f15368f;

    /* renamed from: g  reason: collision with root package name */
    private final int f15369g;

    /* renamed from: h  reason: collision with root package name */
    private final int f15370h;

    /* renamed from: i  reason: collision with root package name */
    private final short[] f15371i;

    /* renamed from: j  reason: collision with root package name */
    private short[] f15372j;

    /* renamed from: k  reason: collision with root package name */
    private int f15373k;

    /* renamed from: l  reason: collision with root package name */
    private short[] f15374l;

    /* renamed from: m  reason: collision with root package name */
    private int f15375m;

    /* renamed from: n  reason: collision with root package name */
    private short[] f15376n;

    /* renamed from: o  reason: collision with root package name */
    private int f15377o;

    /* renamed from: p  reason: collision with root package name */
    private int f15378p;

    /* renamed from: q  reason: collision with root package name */
    private int f15379q;

    /* renamed from: r  reason: collision with root package name */
    private int f15380r;

    /* renamed from: s  reason: collision with root package name */
    private int f15381s;

    /* renamed from: t  reason: collision with root package name */
    private int f15382t;

    /* renamed from: u  reason: collision with root package name */
    private int f15383u;

    /* renamed from: v  reason: collision with root package name */
    private int f15384v;

    public q(int i2, int i3, float f2, float f3, int i4) {
        this.f15363a = i2;
        this.f15364b = i3;
        this.f15365c = f2;
        this.f15366d = f3;
        this.f15367e = ((float) i2) / ((float) i4);
        this.f15368f = i2 / 400;
        int i5 = i2 / 65;
        this.f15369g = i5;
        int i6 = i5 * 2;
        this.f15370h = i6;
        this.f15371i = new short[i6];
        this.f15372j = new short[(i6 * i3)];
        this.f15374l = new short[(i6 * i3)];
        this.f15376n = new short[(i6 * i3)];
    }

    private int a(short[] sArr, int i2) {
        int i3;
        int i4 = this.f15363a;
        int i5 = i4 > 4000 ? i4 / 4000 : 1;
        if (this.f15364b == 1 && i5 == 1) {
            i3 = a(sArr, i2, this.f15368f, this.f15369g);
        } else {
            c(sArr, i2, i5);
            int a2 = a(this.f15371i, 0, this.f15368f / i5, this.f15369g / i5);
            if (i5 != 1) {
                int i6 = a2 * i5;
                int i7 = i5 * 4;
                int i8 = i6 - i7;
                int i9 = i6 + i7;
                int i10 = this.f15368f;
                if (i8 < i10) {
                    i8 = i10;
                }
                int i11 = this.f15369g;
                if (i9 > i11) {
                    i9 = i11;
                }
                if (this.f15364b == 1) {
                    i3 = a(sArr, i2, i8, i9);
                } else {
                    c(sArr, i2, 1);
                    i3 = a(this.f15371i, 0, i8, i9);
                }
            } else {
                i3 = a2;
            }
        }
        int i12 = a(this.f15383u, this.f15384v) ? this.f15381s : i3;
        this.f15382t = this.f15383u;
        this.f15381s = i3;
        return i12;
    }

    private int a(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 >= 2.0f) {
            i4 = (int) (((float) i3) / (f2 - 1.0f));
        } else {
            this.f15380r = (int) ((((float) i3) * (2.0f - f2)) / (f2 - 1.0f));
            i4 = i3;
        }
        short[] a2 = a(this.f15374l, this.f15375m, i4);
        this.f15374l = a2;
        a(i4, this.f15364b, a2, this.f15375m, sArr, i2, sArr, i2 + i3);
        this.f15375m += i4;
        return i4;
    }

    private int a(short[] sArr, int i2, int i3, int i4) {
        int i5 = i2 * this.f15364b;
        int i6 = 1;
        int i7 = 255;
        int i8 = 0;
        int i9 = 0;
        while (i3 <= i4) {
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                i10 += Math.abs(sArr[i5 + i11] - sArr[(i5 + i3) + i11]);
            }
            if (i10 * i8 < i6 * i3) {
                i8 = i3;
                i6 = i10;
            }
            if (i10 * i7 > i9 * i3) {
                i7 = i3;
                i9 = i10;
            }
            i3++;
        }
        this.f15383u = i6 / i8;
        this.f15384v = i9 / i7;
        return i8;
    }

    private void a(float f2) {
        int a2;
        int i2 = this.f15373k;
        if (i2 >= this.f15370h) {
            int i3 = 0;
            do {
                if (this.f15380r > 0) {
                    a2 = b(i3);
                } else {
                    int a3 = a(this.f15372j, i3);
                    int i4 = (((double) f2) > 1.0d ? 1 : (((double) f2) == 1.0d ? 0 : -1));
                    short[] sArr = this.f15372j;
                    a2 = i4 > 0 ? a3 + a(sArr, i3, f2, a3) : b(sArr, i3, f2, a3);
                }
                i3 += a2;
            } while (this.f15370h + i3 <= i2);
            a(i3);
        }
    }

    private void a(float f2, int i2) {
        int i3;
        int i4;
        if (this.f15375m != i2) {
            int i5 = this.f15363a;
            int i6 = (int) (((float) i5) / f2);
            while (true) {
                if (i6 <= 16384 && i5 <= 16384) {
                    break;
                }
                i6 /= 2;
                i5 /= 2;
            }
            c(i2);
            int i7 = 0;
            while (true) {
                int i8 = this.f15377o;
                boolean z2 = true;
                if (i7 < i8 - 1) {
                    while (true) {
                        i3 = this.f15378p;
                        int i9 = (i3 + 1) * i6;
                        i4 = this.f15379q;
                        if (i9 <= i4 * i5) {
                            break;
                        }
                        this.f15374l = a(this.f15374l, this.f15375m, 1);
                        int i10 = 0;
                        while (true) {
                            int i11 = this.f15364b;
                            if (i10 >= i11) {
                                break;
                            }
                            this.f15374l[(this.f15375m * i11) + i10] = b(this.f15376n, (i11 * i7) + i10, i5, i6);
                            i10++;
                        }
                        this.f15379q++;
                        this.f15375m++;
                    }
                    int i12 = i3 + 1;
                    this.f15378p = i12;
                    if (i12 == i5) {
                        this.f15378p = 0;
                        if (i4 != i6) {
                            z2 = false;
                        }
                        a.b(z2);
                        this.f15379q = 0;
                    }
                    i7++;
                } else {
                    d(i8 - 1);
                    return;
                }
            }
        }
    }

    private void a(int i2) {
        int i3 = this.f15373k - i2;
        short[] sArr = this.f15372j;
        int i4 = this.f15364b;
        System.arraycopy(sArr, i2 * i4, sArr, 0, i4 * i3);
        this.f15373k = i3;
    }

    private static void a(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i4 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i5 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i8] = (short) (((sArr2[i10] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                i8 += i3;
                i10 += i3;
                i9 += i3;
            }
        }
    }

    private boolean a(int i2, int i3) {
        return i2 != 0 && this.f15381s != 0 && i3 <= i2 * 3 && i2 * 2 > this.f15382t * 3;
    }

    private short[] a(short[] sArr, int i2, int i3) {
        int length = sArr.length;
        int i4 = this.f15364b;
        int i5 = length / i4;
        return i2 + i3 <= i5 ? sArr : Arrays.copyOf(sArr, (((i5 * 3) / 2) + i3) * i4);
    }

    private int b(int i2) {
        int min = Math.min(this.f15370h, this.f15380r);
        b(this.f15372j, i2, min);
        this.f15380r -= min;
        return min;
    }

    private int b(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 < 0.5f) {
            i4 = (int) ((((float) i3) * f2) / (1.0f - f2));
        } else {
            this.f15380r = (int) ((((float) i3) * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
            i4 = i3;
        }
        int i5 = i3 + i4;
        short[] a2 = a(this.f15374l, this.f15375m, i5);
        this.f15374l = a2;
        int i6 = this.f15364b;
        System.arraycopy(sArr, i2 * i6, a2, this.f15375m * i6, i6 * i3);
        a(i4, this.f15364b, this.f15374l, this.f15375m + i3, sArr, i2 + i3, sArr, i2);
        this.f15375m += i5;
        return i4;
    }

    private short b(short[] sArr, int i2, int i3, int i4) {
        short s2 = sArr[i2];
        short s3 = sArr[i2 + this.f15364b];
        int i5 = this.f15379q * i3;
        int i6 = this.f15378p;
        int i7 = i6 * i4;
        int i8 = (i6 + 1) * i4;
        int i9 = i8 - i5;
        int i10 = i8 - i7;
        return (short) (((s2 * i9) + ((i10 - i9) * s3)) / i10);
    }

    private void b(short[] sArr, int i2, int i3) {
        short[] a2 = a(this.f15374l, this.f15375m, i3);
        this.f15374l = a2;
        int i4 = this.f15364b;
        System.arraycopy(sArr, i2 * i4, a2, this.f15375m * i4, i4 * i3);
        this.f15375m += i3;
    }

    private void c(int i2) {
        int i3 = this.f15375m - i2;
        short[] a2 = a(this.f15376n, this.f15377o, i3);
        this.f15376n = a2;
        short[] sArr = this.f15374l;
        int i4 = this.f15364b;
        System.arraycopy(sArr, i2 * i4, a2, this.f15377o * i4, i4 * i3);
        this.f15375m = i2;
        this.f15377o += i3;
    }

    private void c(short[] sArr, int i2, int i3) {
        int i4 = this.f15370h / i3;
        int i5 = this.f15364b;
        int i6 = i3 * i5;
        int i7 = i2 * i5;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 += sArr[(i8 * i6) + i7 + i10];
            }
            this.f15371i[i8] = (short) (i9 / i6);
        }
    }

    private void d() {
        int i2 = this.f15375m;
        float f2 = this.f15365c;
        float f3 = this.f15366d;
        float f4 = f2 / f3;
        float f5 = this.f15367e * f3;
        double d2 = (double) f4;
        if (d2 > 1.00001d || d2 < 0.99999d) {
            a(f4);
        } else {
            b(this.f15372j, 0, this.f15373k);
            this.f15373k = 0;
        }
        if (f5 != 1.0f) {
            a(f5, i2);
        }
    }

    private void d(int i2) {
        if (i2 != 0) {
            short[] sArr = this.f15376n;
            int i3 = this.f15364b;
            System.arraycopy(sArr, i2 * i3, sArr, 0, (this.f15377o - i2) * i3);
            this.f15377o -= i2;
        }
    }

    public void a() {
        int i2;
        int i3 = this.f15373k;
        float f2 = this.f15365c;
        float f3 = this.f15366d;
        int i4 = this.f15375m + ((int) ((((((float) i3) / (f2 / f3)) + ((float) this.f15377o)) / (this.f15367e * f3)) + 0.5f));
        this.f15372j = a(this.f15372j, i3, (this.f15370h * 2) + i3);
        int i5 = 0;
        while (true) {
            i2 = this.f15370h;
            int i6 = this.f15364b;
            if (i5 >= i2 * 2 * i6) {
                break;
            }
            this.f15372j[(i6 * i3) + i5] = 0;
            i5++;
        }
        this.f15373k += i2 * 2;
        d();
        if (this.f15375m > i4) {
            this.f15375m = i4;
        }
        this.f15373k = 0;
        this.f15380r = 0;
        this.f15377o = 0;
    }

    public void a(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i2 = this.f15364b;
        int i3 = remaining / i2;
        short[] a2 = a(this.f15372j, this.f15373k, i3);
        this.f15372j = a2;
        shortBuffer.get(a2, this.f15373k * this.f15364b, ((i2 * i3) * 2) / 2);
        this.f15373k += i3;
        d();
    }

    public void b() {
        this.f15373k = 0;
        this.f15375m = 0;
        this.f15377o = 0;
        this.f15378p = 0;
        this.f15379q = 0;
        this.f15380r = 0;
        this.f15381s = 0;
        this.f15382t = 0;
        this.f15383u = 0;
        this.f15384v = 0;
    }

    public void b(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f15364b, this.f15375m);
        shortBuffer.put(this.f15374l, 0, this.f15364b * min);
        int i2 = this.f15375m - min;
        this.f15375m = i2;
        short[] sArr = this.f15374l;
        int i3 = this.f15364b;
        System.arraycopy(sArr, min * i3, sArr, 0, i2 * i3);
    }

    public int c() {
        return this.f15375m * this.f15364b * 2;
    }
}
