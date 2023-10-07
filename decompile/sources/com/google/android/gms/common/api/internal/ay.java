package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zaq;

final class ay extends zaq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ az f17484a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ay(az azVar, Looper looper) {
        super(looper);
        this.f17484a = azVar;
    }

    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            ((ax) message.obj).a(this.f17484a);
        } else if (i2 != 2) {
            int i3 = message.what;
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i3);
            Log.w("GACStateManager", sb.toString());
        } else {
            throw ((RuntimeException) message.obj);
        }
    }
}
