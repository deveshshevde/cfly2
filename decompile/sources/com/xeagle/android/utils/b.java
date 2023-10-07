package com.xeagle.android.utils;

import android.util.Log;

public class b implements en.b {

    /* renamed from: a  reason: collision with root package name */
    private static en.b f24377a = new b();

    private b() {
    }

    public static en.b a() {
        return f24377a;
    }

    public void a(String str, Exception exc) {
        if (exc != null) {
            Log.e(str, exc.getMessage(), exc);
        }
    }

    public void a(String str, String str2) {
        if (str2 != null) {
            Log.v(str, str2);
        }
    }

    public void b(String str, String str2) {
        if (str2 != null) {
            Log.e(str, str2);
        }
    }
}
