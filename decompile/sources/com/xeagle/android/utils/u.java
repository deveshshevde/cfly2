package com.xeagle.android.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.preference.PreferenceManager;
import androidx.core.content.b;
import com.cfly.uav_pro.R;
import kotlin.jvm.internal.h;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final u f24533a = new u();

    private u() {
    }

    public final int a(Context context) {
        h.d(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int c2 = b.c(context, R.color.colorPrimary);
        int i2 = defaultSharedPreferences.getInt("color", c2);
        return (i2 == 0 || Color.alpha(i2) == 255) ? i2 : c2;
    }

    public final ColorStateList b(Context context) {
        h.d(context, "context");
        int[] iArr = {a(context)};
        return new ColorStateList(new int[][]{new int[0]}, iArr);
    }
}
