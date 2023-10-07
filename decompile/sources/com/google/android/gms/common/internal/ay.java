package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

public final class ay extends am {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ d f17798e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ay(d dVar, int i2, Bundle bundle) {
        super(dVar, i2, (Bundle) null);
        this.f17798e = dVar;
    }

    /* access modifiers changed from: protected */
    public final void a(ConnectionResult connectionResult) {
        if (!this.f17798e.enableLocalFallback() || !d.zzo(this.f17798e)) {
            this.f17798e.zzc.a(connectionResult);
            this.f17798e.onConnectionFailed(connectionResult);
            return;
        }
        d.zzk(this.f17798e, 16);
    }

    /* access modifiers changed from: protected */
    public final boolean b() {
        this.f17798e.zzc.a(ConnectionResult.f17353a);
        return true;
    }
}
