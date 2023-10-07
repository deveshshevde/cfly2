package com.xeagle.android.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;

public class s {

    /* renamed from: a  reason: collision with root package name */
    public static int f24510a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f24511b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f24512c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static int f24513d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static float f24514e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public static float f24515f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public static float f24516g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public static float f24517h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    public static int f24518i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static int f24519j = 0;

    /* renamed from: k  reason: collision with root package name */
    public static int f24520k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static double f24521l = 0.85d;

    public static int a(float f2) {
        return (int) ((f2 * f24514e) + 0.5f);
    }

    public static int a(Context context) {
        if (f24510a == 0) {
            b(context);
        }
        return f24510a;
    }

    public static void b(Context context) {
        if (context != null) {
            DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
            f24510a = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            f24511b = i2;
            int i3 = f24510a;
            f24512c = i3 > i2 ? i2 : i3;
            if (i3 >= i2) {
                i2 = i3;
            }
            f24513d = i2;
            f24514e = displayMetrics.density;
            f24515f = displayMetrics.scaledDensity;
            f24516g = displayMetrics.xdpi;
            f24517h = displayMetrics.ydpi;
            f24518i = displayMetrics.densityDpi;
            f24519j = c(context);
            f24520k = d(context);
            Log.d("Demo.ScreenUtil", "screenWidth=" + f24510a + " screenHeight=" + f24511b + " density=" + f24514e);
        }
    }

    public static int c(Context context) {
        if (f24519j == 0) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                f24519j = context.getResources().getDimensionPixelSize(((Integer) cls.getField("status_bar_height").get(cls.newInstance())).intValue());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (f24519j == 0) {
            f24519j = a(25.0f);
        }
        return f24519j;
    }

    public static int d(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
