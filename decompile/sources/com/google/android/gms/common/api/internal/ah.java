package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.d;

final class ah extends ax {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.c f17425a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ah(ai aiVar, aw awVar, d.c cVar) {
        super(awVar);
        this.f17425a = cVar;
    }

    public final void a() {
        this.f17425a.a(new ConnectionResult(16, (PendingIntent) null));
    }
}
