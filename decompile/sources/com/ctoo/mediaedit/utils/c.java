package com.ctoo.mediaedit.utils;

import com.ctoo.mediaedit.filter.Rotation;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f10957a = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f10958b = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f10959c = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f10960d = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: e  reason: collision with root package name */
    public static final float[] f10961e = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: f  reason: collision with root package name */
    private static int f10962f = 1080;

    /* renamed from: com.ctoo.mediaedit.utils.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10963a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.ctoo.mediaedit.filter.Rotation[] r0 = com.ctoo.mediaedit.filter.Rotation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10963a = r0
                com.ctoo.mediaedit.filter.Rotation r1 = com.ctoo.mediaedit.filter.Rotation.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10963a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ctoo.mediaedit.filter.Rotation r1 = com.ctoo.mediaedit.filter.Rotation.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10963a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ctoo.mediaedit.filter.Rotation r1 = com.ctoo.mediaedit.filter.Rotation.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10963a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.ctoo.mediaedit.filter.Rotation r1 = com.ctoo.mediaedit.filter.Rotation.NORMAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ctoo.mediaedit.utils.c.AnonymousClass1.<clinit>():void");
        }
    }

    private static float a(float f2) {
        return f2 == 0.0f ? 1.0f : 0.0f;
    }

    public static float[] a(Rotation rotation, boolean z2, boolean z3) {
        int i2 = AnonymousClass1.f10963a[rotation.ordinal()];
        float[] fArr = i2 != 1 ? i2 != 2 ? i2 != 3 ? f10957a : f10960d : f10959c : f10958b;
        if (z2) {
            fArr = new float[]{a(fArr[0]), fArr[1], a(fArr[2]), fArr[3], a(fArr[4]), fArr[5], a(fArr[6]), fArr[7]};
        }
        if (!z3) {
            return fArr;
        }
        return new float[]{fArr[0], a(fArr[1]), fArr[2], a(fArr[3]), fArr[4], a(fArr[5]), fArr[6], a(fArr[7])};
    }
}
