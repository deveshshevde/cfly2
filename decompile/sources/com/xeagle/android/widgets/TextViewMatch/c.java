package com.xeagle.android.widgets.TextViewMatch;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f25673a;

    /* renamed from: b  reason: collision with root package name */
    public static int f25674b;

    /* renamed from: c  reason: collision with root package name */
    public static float f25675c;

    /* renamed from: d  reason: collision with root package name */
    public static int f25676d;

    /* renamed from: e  reason: collision with root package name */
    public static int f25677e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f25678f;

    public static int a(float f2) {
        return (int) ((f2 * f25675c) + 0.5f);
    }

    public static void a(Context context) {
        if (!f25678f && context != null) {
            f25678f = true;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            f25673a = displayMetrics.widthPixels;
            f25674b = displayMetrics.heightPixels;
            f25675c = displayMetrics.density;
            f25676d = (int) (((float) f25673a) / displayMetrics.density);
            f25677e = (int) (((float) f25674b) / displayMetrics.density);
        }
    }
}
