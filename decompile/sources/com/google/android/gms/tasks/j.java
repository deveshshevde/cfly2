package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.tasks.zza;
import java.util.concurrent.Executor;

final class j implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f18375a = new zza(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        this.f18375a.post(runnable);
    }
}
