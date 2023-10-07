package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zabx extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    Context f17663a;

    /* renamed from: b  reason: collision with root package name */
    private final bn f17664b;

    public zabx(bn bnVar) {
        this.f17664b = bnVar;
    }

    public final synchronized void a() {
        Context context = this.f17663a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.f17663a = null;
    }

    public final void a(Context context) {
        this.f17663a = context;
    }

    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f17664b.a();
            a();
        }
    }
}
