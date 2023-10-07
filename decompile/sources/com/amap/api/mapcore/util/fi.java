package com.amap.api.mapcore.util;

import android.content.Context;

public class fi {

    /* renamed from: a  reason: collision with root package name */
    private static fi f8767a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f8768b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8769c = fp.a(fg.c("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private fi(Context context) {
        this.f8768b = context.getApplicationContext();
    }

    public static fi a(Context context) {
        if (f8767a == null) {
            synchronized (fi.class) {
                if (f8767a == null) {
                    f8767a = new fi(context);
                }
            }
        }
        return f8767a;
    }

    public final synchronized void a() {
        try {
            if (ez.c() == null) {
                ez.a(fm.a());
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(String str) {
        fj.a(this.f8768b).a(this.f8769c);
        fj.a(this.f8768b).b(str);
    }
}
