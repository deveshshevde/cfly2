package com.google.android.gms.common.util;

import android.os.SystemClock;

public class f implements d {

    /* renamed from: a  reason: collision with root package name */
    private static final f f17953a = new f();

    private f() {
    }

    public static d c() {
        return f17953a;
    }

    public final long a() {
        return System.currentTimeMillis();
    }

    public final long b() {
        return SystemClock.elapsedRealtime();
    }
}
