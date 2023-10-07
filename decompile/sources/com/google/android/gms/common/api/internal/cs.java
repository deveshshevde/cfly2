package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.c;
import j.a;
import java.util.Map;
import java.util.Set;

public final class cs {

    /* renamed from: a  reason: collision with root package name */
    private final a<b<?>, ConnectionResult> f17574a;

    /* renamed from: b  reason: collision with root package name */
    private final a<b<?>, String> f17575b;

    /* renamed from: c  reason: collision with root package name */
    private final c<Map<b<?>, String>> f17576c;

    /* renamed from: d  reason: collision with root package name */
    private int f17577d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17578e;

    public final Set<b<?>> a() {
        return this.f17574a.keySet();
    }

    public final void a(b<?> bVar, ConnectionResult connectionResult, String str) {
        this.f17574a.put(bVar, connectionResult);
        this.f17575b.put(bVar, str);
        this.f17577d--;
        if (!connectionResult.e()) {
            this.f17578e = true;
        }
        if (this.f17577d != 0) {
            return;
        }
        if (this.f17578e) {
            this.f17576c.a((Exception) new AvailabilityException(this.f17574a));
            return;
        }
        this.f17576c.a(this.f17575b);
    }
}
