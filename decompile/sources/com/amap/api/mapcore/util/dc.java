package com.amap.api.mapcore.util;

import android.graphics.Bitmap;

public final class dc {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f8236a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f8237b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f8238c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8239d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f8240e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f8241f = 20;

    public static void a(boolean z2) {
        f8236a = z2;
    }

    public static boolean a() {
        return f8236a;
    }

    public static void b(boolean z2) {
        f8237b = z2;
    }

    public static boolean b() {
        return f8237b;
    }

    public static void c(boolean z2) {
        f8238c = z2;
    }

    public static boolean c() {
        return f8238c;
    }

    public static void g() {
        fz.c(new Exception("BlackScreen"), "PureScreenCheckTool", "uploadInfo");
    }

    public final boolean a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i2 = -1;
                for (int i3 = (int) (((float) width) / 4.0f); ((float) i3) < ((float) (width * 3)) / 4.0f; i3++) {
                    int i4 = (int) (((float) height) / 4.0f);
                    while (((float) i4) < ((float) (height * 3)) / 4.0f) {
                        int pixel = bitmap.getPixel(i3, i4);
                        if (i2 == -1) {
                            i2 = pixel;
                        }
                        if (pixel != i2) {
                            this.f8239d = true;
                            return false;
                        } else if (pixel != -16777216) {
                            this.f8239d = true;
                            return false;
                        } else {
                            i4++;
                        }
                    }
                }
            } catch (Throwable th) {
                this.f8239d = true;
                throw th;
            }
        }
        this.f8239d = true;
        return true;
    }

    public final boolean d() {
        return this.f8239d;
    }

    public final void e() {
        this.f8240e++;
    }

    public final boolean f() {
        return this.f8240e >= this.f8241f;
    }
}
