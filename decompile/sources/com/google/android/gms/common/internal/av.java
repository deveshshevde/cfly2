package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class av extends an {

    /* renamed from: a  reason: collision with root package name */
    private d f17792a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17793b;

    public av(d dVar, int i2) {
        this.f17792a = dVar;
        this.f17793b = i2;
    }

    public final void a(int i2, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public final void a(int i2, IBinder iBinder, Bundle bundle) {
        m.a(this.f17792a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
        this.f17792a.onPostInitHandler(i2, iBinder, bundle, this.f17793b);
        this.f17792a = null;
    }

    public final void a(int i2, IBinder iBinder, zzj zzj) {
        d dVar = this.f17792a;
        m.a(dVar, (Object) "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        m.a(zzj);
        d.zzj(dVar, zzj);
        a(i2, iBinder, zzj.f17880a);
    }
}
