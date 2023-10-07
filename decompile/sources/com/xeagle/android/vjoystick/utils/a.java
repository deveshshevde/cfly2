package com.xeagle.android.vjoystick.utils;

import android.content.Context;

public class a {
    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
