package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f17954a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f17955b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f17956c;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f17957d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f17957d == null) {
            boolean z2 = false;
            if (l.f() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z2 = true;
            }
            f17957d = Boolean.valueOf(z2);
        }
        return f17957d.booleanValue();
    }

    public static boolean b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f17954a == null) {
            boolean z2 = false;
            if (l.c() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z2 = true;
            }
            f17954a = Boolean.valueOf(z2);
        }
        return f17954a.booleanValue();
    }

    public static boolean c(Context context) {
        if (b(context)) {
            if (l.e()) {
                return d(context) && !l.f();
            }
            return true;
        }
    }

    public static boolean d(Context context) {
        if (f17955b == null) {
            boolean z2 = false;
            if (l.d() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z2 = true;
            }
            f17955b = Boolean.valueOf(z2);
        }
        return f17955b.booleanValue();
    }

    public static boolean e(Context context) {
        if (f17956c == null) {
            boolean z2 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z2 = false;
            }
            f17956c = Boolean.valueOf(z2);
        }
        return f17956c.booleanValue();
    }
}
