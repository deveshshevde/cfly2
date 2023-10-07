package com.flypro.photoview_library;

import android.os.Build;
import android.view.View;

public class a {
    public static int a(int i2) {
        return Build.VERSION.SDK_INT >= 11 ? c(i2) : b(i2);
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            b(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    private static int b(int i2) {
        return (i2 & 65280) >> 8;
    }

    private static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    private static int c(int i2) {
        return (i2 & 65280) >> 8;
    }
}
