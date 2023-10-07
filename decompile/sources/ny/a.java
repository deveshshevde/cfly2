package ny;

import od.b;
import od.c;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.d;
import org.jcodec.codecs.h264.io.model.i;
import org.jcodec.common.model.ColorSpace;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int[] f31650a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    /* renamed from: b  reason: collision with root package name */
    private ColorSpace f31651b;

    /* renamed from: c  reason: collision with root package name */
    private c f31652c = b();

    /* renamed from: d  reason: collision with root package name */
    private int[] f31653d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f31654e;

    /* renamed from: f  reason: collision with root package name */
    private int f31655f;

    /* renamed from: g  reason: collision with root package name */
    private int f31656g;

    public a(i iVar, d dVar, int i2, int i3) {
        this.f31651b = iVar.f33052f;
        int i4 = iVar.f33056j + 1;
        this.f31655f = i4;
        this.f31656g = (1 << i3) - 1;
        this.f31653d = new int[4];
        this.f31654e = new int[(i4 << i2)];
    }

    public static final int a(int i2) {
        return i2 >> 4;
    }

    public static final int a(int i2, int i3) {
        return (i2 << 4) | i3;
    }

    private int a(b bVar, int[] iArr, c[] cVarArr, int i2, int i3, int[] iArr2, c cVar) {
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = iArr[iArr2[i7 + i2]];
            if (i8 == 0) {
                iArr3[i5] = iArr3[i5] + 1;
                i6++;
            } else {
                iArr4[i5] = i8;
                i5++;
            }
        }
        if (i5 < i3) {
            i6 -= iArr3[i5];
        }
        while (i4 < i5 && i4 < 3 && Math.abs(iArr4[(i5 - i4) - 1]) == 1) {
            i4++;
        }
        int a2 = a(i5, i4);
        cVar.a(bVar, a2);
        if (i5 > 0) {
            a(bVar, iArr4, i5, i4);
            b(bVar, iArr4, i5, i4);
            if (i5 < i3) {
                cVarArr[i5 - 1].a(bVar, i6);
                c(bVar, iArr3, i5, i6);
            }
        }
        return a2;
    }

    private void a(b bVar, int[] iArr, int i2, int i3) {
        for (int i4 = i2 - 1; i4 >= i2 - i3; i4--) {
            bVar.a(iArr[i4] >>> 31);
        }
    }

    private final int b(int i2) {
        int i3 = i2 >> 31;
        return ((((i2 ^ i3) - i3) << 1) + (i2 >>> 31)) - 2;
    }

    private void b(b bVar, int[] iArr, int i2, int i3) {
        int i4;
        int i5 = (i2 <= 10 || i3 >= 3) ? 0 : 1;
        int i6 = (i2 - i3) - 1;
        for (int i7 = i6; i7 >= 0; i7--) {
            int b2 = b(iArr[i7]);
            if (i7 == i6 && i3 < 3) {
                b2 -= 2;
            }
            int i8 = b2 >> i5;
            if ((i5 == 0 && i8 < 14) || (i5 > 0 && i8 < 15)) {
                bVar.a(1, i8 + 1);
                bVar.a(b2, i5);
            } else if (i5 != 0 || b2 >= 30) {
                if (i5 == 0) {
                    b2 -= 15;
                }
                int i9 = 12;
                while (true) {
                    int i10 = 1 << i9;
                    i4 = ((b2 - ((i9 + 3) << i5)) - i10) + 4096;
                    if (i4 < i10) {
                        break;
                    }
                    i9++;
                }
                bVar.a(1, i9 + 4);
                bVar.a(i4, i9);
            } else {
                bVar.a(1, 15);
                bVar.a(b2 - 14, 4);
            }
            if (i5 == 0) {
                i5 = 1;
            }
            if (org.jcodec.common.tools.b.a(iArr[i7]) > (3 << (i5 - 1)) && i5 < 6) {
                i5++;
            }
        }
    }

    private void c(b bVar, int[] iArr, int i2, int i3) {
        for (int i4 = i2 - 1; i4 > 0 && i3 > 0; i4--) {
            H264Const.f32897d[Math.min(6, i3 - 1)].a(bVar, iArr[i4]);
            i3 -= iArr[i4];
        }
    }

    public c a() {
        return this.f31652c;
    }

    public c a(boolean z2, MBType mBType, int i2, boolean z3, MBType mBType2, int i3) {
        return H264Const.f32894a[Math.min(b(z2, mBType, i2, z3, mBType2, i3), 8)];
    }

    public void a(b bVar, int i2, int i3, MBType mBType, MBType mBType2, int[] iArr, c[] cVarArr, int i4, int i5, int[] iArr2) {
        int a2 = a(bVar, iArr, cVarArr, i4, i5, iArr2, a(i2 != 0, mBType, this.f31653d[this.f31656g & i3], i3 != 0, mBType2, this.f31654e[i2]));
        this.f31653d[this.f31656g & i3] = a2;
        this.f31654e[i2] = a2;
    }

    public void a(b bVar, int[] iArr, c[] cVarArr, int i2, int i3, int[] iArr2) {
        a(bVar, iArr, cVarArr, i2, i3, iArr2, a());
    }

    /* access modifiers changed from: protected */
    public int b(boolean z2, MBType mBType, int i2, boolean z3, MBType mBType2, int i3) {
        int a2 = mBType == null ? 0 : a(i2);
        int a3 = mBType2 == null ? 0 : a(i3);
        if (z2 && z3) {
            return ((a2 + a3) + 1) >> 1;
        }
        if (z2) {
            return a2;
        }
        if (z3) {
            return a3;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public c b() {
        if (this.f31651b == ColorSpace.YUV420) {
            return H264Const.f32895b;
        }
        if (this.f31651b == ColorSpace.YUV422) {
            return H264Const.f32896c;
        }
        if (this.f31651b == ColorSpace.YUV444) {
            return H264Const.f32894a[0];
        }
        return null;
    }

    public void b(b bVar, int i2, int i3, MBType mBType, MBType mBType2, int[] iArr, c[] cVarArr, int i4, int i5, int[] iArr2) {
        a(bVar, iArr, cVarArr, i4, i5, iArr2, a(i2 != 0, mBType, this.f31653d[this.f31656g & i3], i3 != 0, mBType2, this.f31654e[i2]));
    }
}
