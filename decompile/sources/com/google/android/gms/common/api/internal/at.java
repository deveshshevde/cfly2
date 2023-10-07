package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zaq;

final class at extends zaq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ av f17457a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    at(av avVar, Looper looper) {
        super(looper);
        this.f17457a = avVar;
    }

    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            av.b(this.f17457a);
        } else if (i2 != 2) {
            int i3 = message.what;
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i3);
            Log.w("GoogleApiClientImpl", sb.toString());
        } else {
            av.a(this.f17457a);
        }
    }
}
