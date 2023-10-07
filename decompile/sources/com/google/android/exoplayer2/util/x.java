package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public class x implements b {
    protected x() {
    }

    public long a() {
        return SystemClock.elapsedRealtime();
    }

    public j a(Looper looper, Handler.Callback callback) {
        return new y(new Handler(looper, callback));
    }

    public long b() {
        return SystemClock.uptimeMillis();
    }
}
