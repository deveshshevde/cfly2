package com.xeagle.android.utils;

import android.content.Context;
import android.content.res.Resources;
import com.xeagle.android.XEagleApp;

public class z {
    public static int a(int i2) {
        return (int) ((((float) i2) * b().getDisplayMetrics().density) + 0.5f);
    }

    public static Context a() {
        return XEagleApp.f12203a;
    }

    public static Resources b() {
        return a().getResources();
    }
}
