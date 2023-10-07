package com.google.android.gms.common.api.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class bb implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f17490a;

    public /* synthetic */ bb(Handler handler) {
        this.f17490a = handler;
    }

    public final void execute(Runnable runnable) {
        this.f17490a.post(runnable);
    }
}
