package com.amap.api.mapcore.util;

import android.content.Context;

public final class ib extends ia {

    /* renamed from: a  reason: collision with root package name */
    private Context f9197a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9198b = false;

    public ib(Context context, boolean z2) {
        this.f9197a = context;
        this.f9198b = z2;
    }

    /* access modifiers changed from: protected */
    public final boolean c() {
        return ez.p(this.f9197a) == 1 || this.f9198b;
    }
}
