package fj;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class q {

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f27387h = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f27388i = {44100, 48000, 32000};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f27389j = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f27390k = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f27391l = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f27392m = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f27393n = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    /* renamed from: a  reason: collision with root package name */
    public int f27394a;

    /* renamed from: b  reason: collision with root package name */
    public String f27395b;

    /* renamed from: c  reason: collision with root package name */
    public int f27396c;

    /* renamed from: d  reason: collision with root package name */
    public int f27397d;

    /* renamed from: e  reason: collision with root package name */
    public int f27398e;

    /* renamed from: f  reason: collision with root package name */
    public int f27399f;

    /* renamed from: g  reason: collision with root package name */
    public int f27400g;

    public static int a(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (!c(i2) || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i7 = f27388i[i6];
        if (i3 == 2) {
            i7 /= 2;
        } else if (i3 == 0) {
            i7 /= 4;
        }
        int i8 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            return ((((i3 == 3 ? f27389j[i5 - 1] : f27390k[i5 - 1]) * 12) / i7) + i8) * 4;
        }
        int i9 = i3 == 3 ? i4 == 2 ? f27391l[i5 - 1] : f27392m[i5 - 1] : f27393n[i5 - 1];
        int i10 = IjkMediaMeta.FF_PROFILE_H264_HIGH_444;
        if (i3 == 3) {
            return ((i9 * IjkMediaMeta.FF_PROFILE_H264_HIGH_444) / i7) + i8;
        }
        if (i4 == 1) {
            i10 = 72;
        }
        return ((i10 * i9) / i7) + i8;
    }

    private static int a(int i2, int i3) {
        if (i3 == 1) {
            return i2 == 3 ? 1152 : 576;
        }
        if (i3 == 2) {
            return 1152;
        }
        if (i3 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }

    private void a(int i2, String str, int i3, int i4, int i5, int i6, int i7) {
        this.f27394a = i2;
        this.f27395b = str;
        this.f27396c = i3;
        this.f27397d = i4;
        this.f27398e = i5;
        this.f27399f = i6;
        this.f27400g = i7;
    }

    public static boolean a(int i2, q qVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (!c(i2) || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return false;
        }
        int i11 = f27388i[i6];
        if (i3 == 2) {
            i11 /= 2;
        } else if (i3 == 0) {
            i11 /= 4;
        }
        int i12 = i11;
        int i13 = (i2 >>> 9) & 1;
        int a2 = a(i3, i4);
        if (i4 == 3) {
            i8 = i3 == 3 ? f27389j[i5 - 1] : f27390k[i5 - 1];
            i9 = (((i8 * 12) / i12) + i13) * 4;
        } else {
            if (i3 == 3) {
                i10 = i4 == 2 ? f27391l[i5 - 1] : f27392m[i5 - 1];
                i7 = i10 * IjkMediaMeta.FF_PROFILE_H264_HIGH_444;
            } else {
                i10 = f27393n[i5 - 1];
                i7 = (i4 == 1 ? 72 : IjkMediaMeta.FF_PROFILE_H264_HIGH_444) * i10;
            }
            i9 = (i7 / i12) + i13;
        }
        qVar.a(i3, f27387h[3 - i4], i9, i12, ((i2 >> 6) & 3) == 3 ? 1 : 2, i8, a2);
        return true;
    }

    public static int b(int i2) {
        int i3;
        int i4;
        if (!c(i2) || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0) {
            return -1;
        }
        int i5 = (i2 >>> 12) & 15;
        int i6 = (i2 >>> 10) & 3;
        if (i5 == 0 || i5 == 15 || i6 == 3) {
            return -1;
        }
        return a(i3, i4);
    }

    private static boolean c(int i2) {
        return (i2 & -2097152) == -2097152;
    }
}
