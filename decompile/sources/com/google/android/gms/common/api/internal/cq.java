package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;

final class cq implements d.c {

    /* renamed from: a  reason: collision with root package name */
    public final int f17569a;

    /* renamed from: b  reason: collision with root package name */
    public final d f17570b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c f17571c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ cr f17572d;

    public cq(cr crVar, int i2, d dVar, d.c cVar) {
        this.f17572d = crVar;
        this.f17569a = i2;
        this.f17570b = dVar;
        this.f17571c = cVar;
    }

    public final void a(ConnectionResult connectionResult) {
        String valueOf = String.valueOf(connectionResult);
        String.valueOf(valueOf).length();
        Log.d("AutoManageHelper", "beginFailureResolution for ".concat(String.valueOf(valueOf)));
        this.f17572d.b(connectionResult, this.f17569a);
    }
}
