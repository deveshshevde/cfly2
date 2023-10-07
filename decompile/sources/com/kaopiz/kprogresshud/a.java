package com.kaopiz.kprogresshud;

import android.content.Context;

class a {

    /* renamed from: a  reason: collision with root package name */
    private static float f20999a;

    public static int a(float f2, Context context) {
        if (f20999a == 0.0f) {
            f20999a = context.getResources().getDisplayMetrics().density;
        }
        return (int) (f2 * f20999a);
    }
}
