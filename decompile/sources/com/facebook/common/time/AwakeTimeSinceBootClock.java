package com.facebook.common.time;

import android.os.SystemClock;

public class AwakeTimeSinceBootClock {
    private static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

    private AwakeTimeSinceBootClock() {
    }

    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }

    public long now() {
        return SystemClock.uptimeMillis();
    }
}
