package com.google.android.gms.common;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zaq;

final class i extends zaq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f17705a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f17706b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(c cVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f17705a = cVar;
        this.f17706b = context.getApplicationContext();
    }

    public final void handleMessage(Message message) {
        if (message.what != 1) {
            int i2 = message.what;
            StringBuilder sb = new StringBuilder(50);
            sb.append("Don't know how to handle this message: ");
            sb.append(i2);
            Log.w("GoogleApiAvailability", sb.toString());
            return;
        }
        int a2 = this.f17705a.a(this.f17706b);
        if (this.f17705a.b(a2)) {
            this.f17705a.b(this.f17706b, a2);
        }
    }
}
