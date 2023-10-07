package com.xeagle.android.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.xeagle.android.XEagleApp;
import java.util.Objects;
import kotlin.jvm.internal.h;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f24395a = new e();

    private e() {
    }

    public static final int a(Context context) {
        h.d(context, "context");
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static final int b(Context context) {
        h.d(context, "context");
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public final float a(float f2) {
        Context context = XEagleApp.f12203a;
        h.b(context, "XEagleApp.context");
        Resources resources = context.getResources();
        h.b(resources, "XEagleApp.context.resources");
        return (f2 * resources.getDisplayMetrics().density) + 0.5f;
    }
}
