package com.cloudbufferfly.uicorelib.utils;

import android.content.Context;
import android.content.res.Resources;
import kotlin.jvm.internal.h;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f10757a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f10758b = {"i700v", "A862W", "V8526"};

    private b() {
    }

    public final float a(Context context) {
        h.c(context, "context");
        Resources resources = context.getResources();
        h.a((Object) resources, "context.resources");
        return resources.getDisplayMetrics().density;
    }

    public final int a(Context context, float f2) {
        h.c(context, "context");
        return (int) ((f2 * a(context)) + 0.5f);
    }
}
