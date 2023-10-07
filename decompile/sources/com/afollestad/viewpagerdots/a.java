package com.afollestad.viewpagerdots;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.h;

public final class a {
    public static final Drawable a(Drawable drawable, int i2) {
        h.c(drawable, "$receiver");
        Drawable g2 = androidx.core.graphics.drawable.a.g(drawable);
        androidx.core.graphics.drawable.a.a(g2, i2);
        h.a((Object) g2, "wrapped");
        return g2;
    }
}
