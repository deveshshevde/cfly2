package com.google.android.gms.analytics;

import android.os.Process;

final class zzq extends Thread {
    zzq(Runnable runnable, String str) {
        super(runnable, str);
    }

    public final void run() {
        Process.setThreadPriority(10);
        super.run();
    }
}
