package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.base.zap;
import gh.b;
import java.util.concurrent.ExecutorService;

public final class ba {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f17489a = zap.zaa().zac(2, new b("GAC_Executor"), 2);

    public static ExecutorService a() {
        return f17489a;
    }
}
