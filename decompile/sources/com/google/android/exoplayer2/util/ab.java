package com.google.android.exoplayer2.util;

import android.os.Trace;

public final class ab {
    public static void a() {
        if (ad.f11755a >= 18) {
            b();
        }
    }

    public static void a(String str) {
        if (ad.f11755a >= 18) {
            b(str);
        }
    }

    private static void b() {
        Trace.endSection();
    }

    private static void b(String str) {
        Trace.beginSection(str);
    }
}
