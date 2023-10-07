package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.m;

public final class da implements d.b, d.c {

    /* renamed from: a  reason: collision with root package name */
    public final a<?> f17590a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17591b;

    /* renamed from: c  reason: collision with root package name */
    private db f17592c;

    public da(a<?> aVar, boolean z2) {
        this.f17590a = aVar;
        this.f17591b = z2;
    }

    private final db a() {
        m.a(this.f17592c, (Object) "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.f17592c;
    }

    public final void a(int i2) {
        a().a(i2);
    }

    public final void a(Bundle bundle) {
        a().a(bundle);
    }

    public final void a(ConnectionResult connectionResult) {
        a().a(connectionResult, this.f17590a, this.f17591b);
    }

    public final void a(db dbVar) {
        this.f17592c = dbVar;
    }
}
