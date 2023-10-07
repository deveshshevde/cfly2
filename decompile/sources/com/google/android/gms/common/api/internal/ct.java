package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.m;

final class ct {

    /* renamed from: a  reason: collision with root package name */
    private final int f17579a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionResult f17580b;

    ct(ConnectionResult connectionResult, int i2) {
        m.a(connectionResult);
        this.f17580b = connectionResult;
        this.f17579a = i2;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f17579a;
    }

    /* access modifiers changed from: package-private */
    public final ConnectionResult b() {
        return this.f17580b;
    }
}
