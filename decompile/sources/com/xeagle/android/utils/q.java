package com.xeagle.android.utils;

import android.os.Build;
import java.util.Locale;

public class q {
    public static String a() {
        return Locale.getDefault().getLanguage();
    }

    public static String b() {
        return Build.VERSION.RELEASE;
    }

    public static String c() {
        return Build.MODEL;
    }

    public static String d() {
        return Build.BRAND;
    }
}
