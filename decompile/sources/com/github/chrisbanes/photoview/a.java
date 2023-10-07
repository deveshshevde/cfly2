package com.github.chrisbanes.photoview;

import android.os.Build;
import android.view.View;

class a {
    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            b(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    private static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
