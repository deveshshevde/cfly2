package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;

public abstract class DownsampleStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DownsampleStrategy f10428a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final DownsampleStrategy f10429b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final DownsampleStrategy f10430c = new e();

    /* renamed from: d  reason: collision with root package name */
    public static final DownsampleStrategy f10431d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final DownsampleStrategy f10432e;

    /* renamed from: f  reason: collision with root package name */
    public static final DownsampleStrategy f10433f = new f();

    /* renamed from: g  reason: collision with root package name */
    public static final DownsampleStrategy f10434g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.bumptech.glide.load.e<DownsampleStrategy> f10435h;

    /* renamed from: i  reason: collision with root package name */
    static final boolean f10436i = (Build.VERSION.SDK_INT >= 19);

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    private static class a extends DownsampleStrategy {
        a() {
        }

        public float a(int i2, int i3, int i4, int i5) {
            int min = Math.min(i3 / i5, i2 / i4);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(min));
        }

        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }
    }

    private static class b extends DownsampleStrategy {
        b() {
        }

        public float a(int i2, int i3, int i4, int i5) {
            int ceil = (int) Math.ceil((double) Math.max(((float) i3) / ((float) i5), ((float) i2) / ((float) i4)));
            int i6 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i6 = 0;
            }
            return 1.0f / ((float) (max << i6));
        }

        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.MEMORY;
        }
    }

    private static class c extends DownsampleStrategy {
        c() {
        }

        public float a(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, f10430c.a(i2, i3, i4, i5));
        }

        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            return a(i2, i3, i4, i5) == 1.0f ? SampleSizeRounding.QUALITY : f10430c.b(i2, i3, i4, i5);
        }
    }

    private static class d extends DownsampleStrategy {
        d() {
        }

        public float a(int i2, int i3, int i4, int i5) {
            return Math.max(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
        }

        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }
    }

    private static class e extends DownsampleStrategy {
        e() {
        }

        public float a(int i2, int i3, int i4, int i5) {
            if (f10436i) {
                return Math.min(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
            }
            int max = Math.max(i3 / i5, i2 / i4);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(max));
        }

        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            return f10436i ? SampleSizeRounding.QUALITY : SampleSizeRounding.MEMORY;
        }
    }

    private static class f extends DownsampleStrategy {
        f() {
        }

        public float a(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }

        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }
    }

    static {
        d dVar = new d();
        f10432e = dVar;
        f10434g = dVar;
        f10435h = com.bumptech.glide.load.e.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
    }

    public abstract float a(int i2, int i3, int i4, int i5);

    public abstract SampleSizeRounding b(int i2, int i3, int i4, int i5);
}
