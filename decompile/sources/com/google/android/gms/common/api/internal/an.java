package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.m;
import gk.f;

final class an implements d.b, d.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aq f17433a;

    /* synthetic */ an(aq aqVar, am amVar) {
        this.f17433a = aqVar;
    }

    public final void a(int i2) {
    }

    public final void a(Bundle bundle) {
        e eVar = (e) m.a(this.f17433a.f17452r);
        ((f) m.a(this.f17433a.f17445k)).a(new al(this.f17433a));
    }

    public final void a(ConnectionResult connectionResult) {
        this.f17433a.f17436b.lock();
        try {
            if (this.f17433a.b(connectionResult)) {
                this.f17433a.e();
                this.f17433a.g();
            } else {
                this.f17433a.a(connectionResult);
            }
        } finally {
            this.f17433a.f17436b.unlock();
        }
    }
}
