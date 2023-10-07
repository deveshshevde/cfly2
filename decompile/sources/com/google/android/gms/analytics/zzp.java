package com.google.android.gms.analytics;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzp implements ThreadFactory {
    private static final AtomicInteger zza = new AtomicInteger();

    private zzp() {
    }

    /* synthetic */ zzp(zzo zzo) {
    }

    public final Thread newThread(Runnable runnable) {
        int incrementAndGet = zza.incrementAndGet();
        StringBuilder sb = new StringBuilder(23);
        sb.append("measurement-");
        sb.append(incrementAndGet);
        return new zzq(runnable, sb.toString());
    }
}
