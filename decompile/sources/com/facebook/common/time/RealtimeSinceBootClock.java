package com.facebook.common.time;

import android.os.SystemClock;

public class RealtimeSinceBootClock {

    /* renamed from: a  reason: collision with root package name */
    private static final RealtimeSinceBootClock f11098a = new RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    public static RealtimeSinceBootClock get() {
        return f11098a;
    }

    public long a() {
        return SystemClock.elapsedRealtime();
    }
}
