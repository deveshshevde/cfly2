package mh;

import jp.co.cyberagent.android.gpuimage.Rotation;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f31202a = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f31203b = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f31204c = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f31205d = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: mh.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31206a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                jp.co.cyberagent.android.gpuimage.Rotation[] r0 = jp.co.cyberagent.android.gpuimage.Rotation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31206a = r0
                jp.co.cyberagent.android.gpuimage.Rotation r1 = jp.co.cyberagent.android.gpuimage.Rotation.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31206a     // Catch:{ NoSuchFieldError -> 0x001d }
                jp.co.cyberagent.android.gpuimage.Rotation r1 = jp.co.cyberagent.android.gpuimage.Rotation.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31206a     // Catch:{ NoSuchFieldError -> 0x0028 }
                jp.co.cyberagent.android.gpuimage.Rotation r1 = jp.co.cyberagent.android.gpuimage.Rotation.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31206a     // Catch:{ NoSuchFieldError -> 0x0033 }
                jp.co.cyberagent.android.gpuimage.Rotation r1 = jp.co.cyberagent.android.gpuimage.Rotation.NORMAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: mh.a.AnonymousClass1.<clinit>():void");
        }
    }

    private static float a(float f2) {
        return f2 == 0.0f ? 1.0f : 0.0f;
    }

    public static float[] a(Rotation rotation, boolean z2, boolean z3) {
        int i2 = AnonymousClass1.f31206a[rotation.ordinal()];
        float[] fArr = i2 != 1 ? i2 != 2 ? i2 != 3 ? f31202a : f31205d : f31204c : f31203b;
        if (z2) {
            fArr = new float[]{a(fArr[0]), fArr[1], a(fArr[2]), fArr[3], a(fArr[4]), fArr[5], a(fArr[6]), fArr[7]};
        }
        if (!z3) {
            return fArr;
        }
        return new float[]{fArr[0], a(fArr[1]), fArr[2], a(fArr[3]), fArr[4], a(fArr[5]), fArr[6], a(fArr[7])};
    }
}
