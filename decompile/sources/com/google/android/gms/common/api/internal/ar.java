package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.d;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class ar implements aw {
    @NotOnlyInitialized

    /* renamed from: a  reason: collision with root package name */
    private final az f11781a;

    public ar(az azVar) {
        this.f11781a = azVar;
    }

    public final <A extends a.b, R extends g, T extends d.a<R, A>> T a(T t2) {
        this.f11781a.f11788g.f17459a.add(t2);
        return t2;
    }

    public final void a() {
        for (a.f disconnect : this.f11781a.f11782a.values()) {
            disconnect.disconnect();
        }
        this.f11781a.f11788g.f17462d = Collections.emptySet();
    }

    public final void a(int i2) {
    }

    public final void a(Bundle bundle) {
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, boolean z2) {
    }

    public final <A extends a.b, T extends d.a<? extends g, A>> T b(T t2) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void b() {
        this.f11781a.g();
    }

    public final boolean d() {
        return true;
    }
}
