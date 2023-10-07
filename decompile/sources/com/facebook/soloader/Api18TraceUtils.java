package com.facebook.soloader;

import android.os.Trace;

class Api18TraceUtils {
    Api18TraceUtils() {
    }

    public static void a() {
        Trace.endSection();
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }
}
