package com.facebook.imagepipeline.memory;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f11358a = b();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f11359b = b.class;

    /* renamed from: c  reason: collision with root package name */
    private static int f11360c = 384;

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f11361d;

    public static a a() {
        if (f11361d == null) {
            synchronized (b.class) {
                if (f11361d == null) {
                    f11361d = new a(f11360c, f11358a);
                }
            }
        }
        return f11361d;
    }

    private static int b() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }
}
