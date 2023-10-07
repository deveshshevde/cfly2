package org.jcodec.codecs.h264;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import ny.a;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.codecs.h264.io.model.c;
import org.jcodec.codecs.h264.io.model.d;
import org.jcodec.codecs.h264.io.model.f;
import org.jcodec.codecs.h264.io.model.i;
import org.jcodec.codecs.h264.io.model.j;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.e;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private a[] f32929a;

    /* renamed from: b  reason: collision with root package name */
    private int[][] f32930b;

    /* renamed from: c  reason: collision with root package name */
    private int[][] f32931c;

    /* renamed from: d  reason: collision with root package name */
    private nx.b f32932d;

    public b() {
        this(new nx.a());
    }

    public b(nx.b bVar) {
        this.f32932d = bVar;
    }

    private int a(int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return 128;
        }
        return i3 == 0 ? (org.jcodec.common.a.a(this.f32930b[0]) + 8) >> 4 : i2 == 0 ? (org.jcodec.common.a.b(this.f32931c[0], i2, 16) + 8) >> 4 : ((org.jcodec.common.a.a(this.f32930b[0]) + org.jcodec.common.a.b(this.f32931c[0], i2, 16)) + 16) >> 5;
    }

    private int a(int i2, int i3, int i4) {
        int i5 = i4 & 7;
        if (i3 != 0 && i4 != 0) {
            return a(this.f32930b[i2], this.f32931c[i2], i5, i3);
        }
        if (i3 != 0) {
            return a(this.f32930b[i2], i5);
        }
        if (i4 != 0) {
            return a(this.f32931c[i2], i3);
        }
        return 128;
    }

    private final int a(int[] iArr, int i2) {
        return ((((iArr[i2] + iArr[i2 + 1]) + iArr[i2 + 2]) + iArr[i2 + 3]) + 2) >> 2;
    }

    private final int a(int[] iArr, int[] iArr2, int i2, int i3) {
        return ((((((((iArr[i2] + iArr[i2 + 1]) + iArr[i2 + 2]) + iArr[i2 + 3]) + iArr2[i3]) + iArr2[i3 + 1]) + iArr2[i3 + 2]) + iArr2[i3 + 3]) + 4) >> 3;
    }

    private void a(int i2, int i3, int i4, od.b bVar, int i5, int i6, int i7, int[] iArr) {
        int i8 = i5;
        int[] iArr2 = iArr;
        if (iArr2.length == 4) {
            nw.b.f(iArr2, i8);
            nw.b.f(iArr);
            this.f32929a[i2].a(bVar, iArr, H264Const.f32899f, 0, iArr2.length, new int[]{0, 1, 2, 3});
        } else if (iArr2.length == 8) {
            nw.b.g(iArr2, i8);
            nw.b.h(iArr);
            this.f32929a[i2].a(bVar, iArr, H264Const.f32900g, 0, iArr2.length, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        } else {
            nw.b.g(iArr);
            nw.b.d(iArr2, i8);
            nw.b.d(iArr);
            this.f32929a[i2].b(bVar, i6, i7, MBType.I_16x16, MBType.I_16x16, iArr, H264Const.f32898e, 0, 16, nw.b.f31644a);
        }
    }

    private void a(int i2, int i3, int i4, od.b bVar, int i5, int i6, int[][] iArr, int i7) {
        int[][] iArr2 = iArr;
        for (int i8 = 0; i8 < iArr2.length; i8++) {
            nw.b.b(iArr2[i8], i7);
            this.f32929a[i2].a(bVar, i5 + H264Const.f32908o[i8], i6 + H264Const.f32909p[i8], MBType.I_16x16, MBType.I_16x16, iArr2[i8], H264Const.f32898e, 1, 15, nw.b.f31644a);
        }
    }

    private void a(ByteBuffer byteBuffer, d dVar) {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        dVar.a(allocate);
        allocate.flip();
        c.a(allocate, byteBuffer);
    }

    private void a(ByteBuffer byteBuffer, i iVar) {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        iVar.b(allocate);
        allocate.flip();
        c.a(allocate, byteBuffer);
    }

    private void a(i iVar, d dVar, org.jcodec.common.model.b bVar, ByteBuffer byteBuffer, boolean z2, int i2) {
        od.b b2;
        int i3;
        int i4;
        i iVar2 = iVar;
        d dVar2 = dVar;
        ByteBuffer byteBuffer2 = byteBuffer;
        boolean z3 = z2;
        this.f32929a = new a[]{new a(iVar2, dVar2, 2, 2), new a(iVar2, dVar2, 1, 1), new a(iVar2, dVar2, 1, 1)};
        this.f32932d.c();
        int a2 = this.f32932d.a();
        byteBuffer2.putInt(1);
        new c(z3 ? NALUnitType.IDR_SLICE : NALUnitType.NON_IDR_SLICE, 2).b(byteBuffer2);
        j jVar = new j();
        jVar.f33082i = SliceType.I;
        if (z3) {
            jVar.f33077d = new f(false, false);
        }
        jVar.f33075b = dVar2;
        jVar.f33074a = iVar2;
        jVar.f33088o = i2 << 1;
        od.b bVar2 = new od.b(ByteBuffer.allocate(bVar.a() * bVar.b()));
        new nz.b().a(jVar, z3, 2, bVar2);
        org.jcodec.common.model.b a3 = org.jcodec.common.model.b.a(16, 16, ColorSpace.YUV420);
        int i5 = 0;
        while (i5 < iVar2.f33055i + 1) {
            int i6 = a2;
            od.b bVar3 = bVar2;
            int i7 = 0;
            while (i7 < iVar2.f33056j + 1) {
                nz.a.a(bVar3, 23);
                while (true) {
                    b2 = bVar3.b();
                    int b3 = this.f32932d.b();
                    i3 = i6 + b3;
                    i4 = i7;
                    od.b bVar4 = bVar3;
                    a(bVar, i7, i5, b2, a3, i3, b3);
                    if (this.f32932d.a(b2.c() - bVar4.c())) {
                        break;
                    }
                    i7 = i4;
                    bVar3 = bVar4;
                }
                a(a3, i4);
                i7 = i4 + 1;
                bVar3 = b2;
                i6 = i3;
            }
            i5++;
            a2 = i6;
            bVar2 = bVar3;
        }
        bVar2.a(1);
        bVar2.a();
        ByteBuffer d2 = bVar2.d();
        d2.flip();
        c.a(d2, byteBuffer2);
    }

    private void a(org.jcodec.common.model.b bVar, int i2) {
        System.arraycopy(bVar.a(0), GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, this.f32931c[0], i2 << 4, 16);
        int i3 = i2 << 3;
        System.arraycopy(bVar.a(1), 56, this.f32931c[1], i3, 8);
        System.arraycopy(bVar.a(2), 56, this.f32931c[2], i3, 8);
        a(bVar.a(0), 15, 16, this.f32930b[0]);
        a(bVar.a(1), 7, 8, this.f32930b[1]);
        a(bVar.a(2), 7, 8, this.f32930b[2]);
    }

    private void a(org.jcodec.common.model.b bVar, int i2, int i3, od.b bVar2, int i4, org.jcodec.common.model.b bVar3) {
        int i5 = i4;
        int i6 = bVar.c().f33208n[1];
        int i7 = bVar.c().f33209o[1];
        int i8 = i2 << (4 - i6);
        int i9 = i3 << (4 - i7);
        org.jcodec.common.model.b bVar4 = bVar;
        int i10 = i4;
        int i11 = i6;
        int i12 = i7;
        int i13 = i8;
        int i14 = i9;
        int[][] a2 = a(bVar4, 1, i10, i11, i12, i13, i14, bVar3);
        int[][] a3 = a(bVar4, 2, i10, i11, i12, i13, i14, bVar3);
        int[] a4 = a(a2);
        int i15 = i2 << 1;
        int i16 = i3 << 1;
        int i17 = i2;
        int i18 = i3;
        od.b bVar5 = bVar2;
        int i19 = i4;
        int i20 = i15;
        int[] a5 = a(a3);
        int i21 = i16;
        int[] iArr = a4;
        a(1, i17, i18, bVar5, i19, i20, i21, a4);
        a(2, i17, i18, bVar5, i19, i20, i21, a5);
        int i22 = i15;
        int i23 = i16;
        int i24 = i4;
        a(1, i17, i18, bVar5, i22, i23, a2, i24);
        a(2, i17, i18, bVar5, i22, i23, a3, i24);
        a(iArr, a2, i5);
        a(bVar3.d()[1], 1, i8, i9, a2);
        a(a5, a3, i5);
        a(bVar3.d()[2], 2, i8, i9, a3);
    }

    private void a(org.jcodec.common.model.b bVar, int i2, int i3, od.b bVar2, org.jcodec.common.model.b bVar3, int i4, int i5) {
        nz.a.a(bVar2, 0);
        nz.a.b(bVar2, i5);
        org.jcodec.common.model.b bVar4 = bVar;
        int i6 = i2;
        int i7 = i3;
        od.b bVar5 = bVar2;
        int i8 = i4;
        org.jcodec.common.model.b bVar6 = bVar3;
        b(bVar4, i6, i7, bVar5, i8, bVar6);
        a(bVar4, i6, i7, bVar5, i8, bVar6);
    }

    private final void a(int[] iArr, int i2, int i3, int i4, int i5, int[] iArr2, int i6) {
        if (i4 + 4 >= i2 || i5 + 4 >= i3) {
            c(iArr, i2, i3, i4, i5, iArr2, i6);
        } else {
            b(iArr, i2, i3, i4, i5, iArr2, i6);
        }
    }

    private void a(int[] iArr, int i2, int i3, int i4, int[][] iArr2) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        int[] iArr3 = iArr;
        a(iArr3, a(i2, i3, i4), iArr2[0], 3, 0, 0);
        a(iArr3, b(i2, i3, i4), iArr2[1], 3, 4, 0);
        a(iArr3, c(i2, i3, i4), iArr2[2], 3, 0, 4);
        a(iArr3, d(i2, i3, i4), iArr2[3], 3, 4, 4);
    }

    private void a(int[] iArr, int i2, int i3, int[] iArr2) {
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            iArr2[i4] = iArr[i2];
            i2 += i3;
        }
    }

    private void a(int[] iArr, int i2, int[] iArr2, int i3, int i4, int i5) {
        int i6 = 1 << i3;
        int i7 = (i5 << i3) + i4;
        int i8 = 0;
        for (int i9 = 0; i9 < 4; i9++) {
            iArr[i7] = org.jcodec.common.tools.b.a(iArr2[i8] + i2, 0, 255);
            iArr[i7 + 1] = org.jcodec.common.tools.b.a(iArr2[i8 + 1] + i2, 0, 255);
            iArr[i7 + 2] = org.jcodec.common.tools.b.a(iArr2[i8 + 2] + i2, 0, 255);
            iArr[i7 + 3] = org.jcodec.common.tools.b.a(iArr2[i8 + 3] + i2, 0, 255);
            i8 += 4;
            i7 += i6;
        }
    }

    private void a(int[] iArr, int i2, int[][] iArr2, int i3) {
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            a(iArr, i2, iArr2[i4], i3, H264Const.f32905l[i4], H264Const.f32906m[i4]);
        }
    }

    private void a(int[] iArr, int[][] iArr2, int i2) {
        if (iArr.length == 4) {
            nw.b.e(iArr);
            nw.b.e(iArr, i2);
        } else if (iArr.length == 8) {
            nw.b.i(iArr);
            nw.b.h(iArr, i2);
        } else {
            nw.b.c(iArr);
            nw.b.c(iArr, i2);
            nw.b.g(iArr);
        }
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            nw.b.a(iArr2[i3], i2);
            iArr2[i3][0] = iArr[i3];
            nw.b.a(iArr2[i3]);
        }
    }

    private int[] a(int[][] iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = iArr[i2][0];
            iArr[i2][0] = 0;
        }
        return iArr2;
    }

    private int[][] a(org.jcodec.common.model.b bVar, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i6;
        int i9 = i7;
        int a2 = a(i8, i9);
        int[] iArr = new int[2];
        iArr[1] = 16;
        iArr[0] = 16 >> (i4 + i5);
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        for (int i10 = 0; i10 < iArr2.length; i10++) {
            int[] iArr3 = iArr2[i10];
            a(bVar.a(i2), bVar.b(i2), bVar.c(i2), i8 + H264Const.f32905l[i10], i9 + H264Const.f32906m[i10], iArr3, a2);
            nw.b.b(iArr3);
        }
        return iArr2;
    }

    private int[][] a(org.jcodec.common.model.b bVar, int i2, int i3, int i4, int i5, int i6, int i7, org.jcodec.common.model.b bVar2) {
        int i8 = i2;
        int i9 = i6;
        int i10 = i7;
        int[] iArr = new int[2];
        iArr[1] = 16;
        iArr[0] = 16 >> (i4 + i5);
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        int i11 = i7;
        a(bVar.a(i2), bVar.b(i2), bVar.c(i2), i6, i11, iArr2[0], a(i8, i9, i10));
        nw.b.b(iArr2[0]);
        int i12 = i9 + 4;
        a(bVar.a(i2), bVar.b(i2), bVar.c(i2), i12, i11, iArr2[1], b(i8, i9, i10));
        nw.b.b(iArr2[1]);
        int i13 = i10 + 4;
        a(bVar.a(i2), bVar.b(i2), bVar.c(i2), i6, i13, iArr2[2], c(i8, i9, i10));
        nw.b.b(iArr2[2]);
        a(bVar.a(i2), bVar.b(i2), bVar.c(i2), i12, i13, iArr2[3], d(i8, i9, i10));
        nw.b.b(iArr2[3]);
        return iArr2;
    }

    private int b(int i2, int i3, int i4) {
        int i5 = i4 & 7;
        if (i4 != 0) {
            return a(this.f32931c[i2], i3 + 4);
        }
        if (i3 != 0) {
            return a(this.f32930b[i2], i5);
        }
        return 128;
    }

    private void b(org.jcodec.common.model.b bVar, int i2, int i3, od.b bVar2, int i4, org.jcodec.common.model.b bVar3) {
        int i5 = i2 << 4;
        int i6 = i3 << 4;
        int[][] a2 = a(bVar, 0, i4, 0, 0, i5, i6);
        int[] a3 = a(a2);
        int i7 = i2 << 2;
        int i8 = i3 << 2;
        int i9 = i2;
        int i10 = i3;
        od.b bVar4 = bVar2;
        a(0, i9, i10, bVar4, i4, i7, i8, a3);
        a(0, i9, i10, bVar4, i7, i8, a2, i4);
        a(a3, a2, i4);
        a(bVar3.a(0), a(i5, i6), a2, 4);
    }

    private final void b(int[] iArr, int i2, int i3, int i4, int i5, int[] iArr2, int i6) {
        int i7 = (i5 * i2) + i4;
        int i8 = 0;
        int i9 = 0;
        while (i8 < 4) {
            iArr2[i9] = iArr[i7] - i6;
            iArr2[i9 + 1] = iArr[i7 + 1] - i6;
            iArr2[i9 + 2] = iArr[i7 + 2] - i6;
            iArr2[i9 + 3] = iArr[i7 + 3] - i6;
            i8++;
            i7 += i2;
            i9 += 4;
        }
    }

    private int c(int i2, int i3, int i4) {
        int i5 = i4 & 7;
        if (i3 != 0) {
            return a(this.f32930b[i2], i5 + 4);
        }
        if (i4 != 0) {
            return a(this.f32931c[i2], i3);
        }
        return 128;
    }

    private final void c(int[] iArr, int i2, int i3, int i4, int i5, int[] iArr2, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        int i11 = i5;
        while (true) {
            i7 = i5 + 4;
            if (i11 >= Math.min(i7, i3)) {
                break;
            }
            int min = (i11 * i2) + Math.min(i4, i2);
            int i12 = i4;
            while (true) {
                i9 = i4 + 4;
                if (i12 >= Math.min(i9, i2)) {
                    break;
                }
                iArr2[i10] = iArr[min] - i6;
                i12++;
                i10++;
                min++;
            }
            int i13 = min - 1;
            while (i12 < i9) {
                iArr2[i10] = iArr[i13] - i6;
                i12++;
                i10++;
            }
            i11++;
        }
        while (i11 < i7) {
            int min2 = ((i3 * i2) - i2) + Math.min(i4, i2);
            int i14 = i4;
            while (true) {
                i8 = i4 + 4;
                if (i14 >= Math.min(i8, i2)) {
                    break;
                }
                iArr2[i10] = iArr[min2] - i6;
                i14++;
                i10++;
                min2++;
            }
            int i15 = min2 - 1;
            while (i14 < i8) {
                iArr2[i10] = iArr[i15] - i6;
                i14++;
                i10++;
            }
            i11++;
        }
    }

    private int d(int i2, int i3, int i4) {
        int i5 = i4 & 7;
        if (i3 != 0 && i4 != 0) {
            return a(this.f32930b[i2], this.f32931c[i2], i5 + 4, i3 + 4);
        }
        if (i3 != 0) {
            return a(this.f32930b[i2], i5 + 4);
        }
        if (i4 != 0) {
            return a(this.f32931c[i2], i3 + 4);
        }
        return 128;
    }

    public ByteBuffer a(org.jcodec.common.model.b bVar, ByteBuffer byteBuffer) {
        return a(bVar, byteBuffer, true, 0);
    }

    public ByteBuffer a(org.jcodec.common.model.b bVar, ByteBuffer byteBuffer, boolean z2, int i2) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        i a2 = a(new e(bVar.e(), bVar.f()));
        d a3 = a();
        if (z2) {
            duplicate.putInt(1);
            new c(NALUnitType.SPS, 3).b(duplicate);
            a(duplicate, a2);
            duplicate.putInt(1);
            new c(NALUnitType.PPS, 3).b(duplicate);
            a(duplicate, a3);
        }
        int i3 = a2.f33056j + 1;
        this.f32930b = new int[][]{new int[16], new int[8], new int[8]};
        int i4 = i3 << 3;
        this.f32931c = new int[][]{new int[(i3 << 4)], new int[i4], new int[i4]};
        a(a2, a3, bVar, duplicate, z2, i2);
        duplicate.flip();
        return duplicate;
    }

    public d a() {
        d dVar = new d();
        dVar.f33020k = this.f32932d.a() - 26;
        return dVar;
    }

    public i a(e eVar) {
        i iVar = new i();
        iVar.f33056j = ((eVar.a() + 15) >> 4) - 1;
        iVar.f33055i = ((eVar.b() + 15) >> 4) - 1;
        iVar.f33052f = ColorSpace.YUV420;
        iVar.f33060n = 66;
        iVar.f33065s = 40;
        iVar.f33072z = true;
        int i2 = (iVar.f33056j + 1) << 4;
        int i3 = (iVar.f33055i + 1) << 4;
        iVar.A = (i2 == eVar.a() && i3 == eVar.b()) ? false : true;
        iVar.C = ((i2 - eVar.a()) + 1) >> 1;
        iVar.E = ((i3 - eVar.b()) + 1) >> 1;
        return iVar;
    }

    public ColorSpace[] b() {
        return new ColorSpace[]{ColorSpace.YUV420J};
    }
}
