package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.base.zap;
import gh.b;
import java.util.concurrent.ExecutorService;

public final class by {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f17527a = zap.zaa().zaa(new b("GAC_Transform"), 1);

    public static ExecutorService a() {
        return f17527a;
    }
}
