package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.base.zaq;

final class ch extends zaq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cj f17548a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ch(cj cjVar, Looper looper) {
        super(looper);
        this.f17548a = cjVar;
    }

    public final void handleMessage(Message message) {
        Status a2;
        int i2 = message.what;
        if (i2 == 0) {
            e eVar = (e) message.obj;
            synchronized (this.f17548a.f17554e) {
                cj cjVar = (cj) m.a(this.f17548a.f17551b);
                if (eVar == null) {
                    a2 = new Status(13, "Transform returned null");
                } else if (eVar instanceof bz) {
                    a2 = ((bz) eVar).a();
                } else {
                    cjVar.a((e<?>) eVar);
                }
                cjVar.a(a2);
            }
        } else if (i2 != 1) {
            int i3 = message.what;
            StringBuilder sb = new StringBuilder(70);
            sb.append("TransformationResultHandler received unknown message type: ");
            sb.append(i3);
            Log.e("TransformedResultImpl", sb.toString());
        } else {
            RuntimeException runtimeException = (RuntimeException) message.obj;
            String valueOf = String.valueOf(runtimeException.getMessage());
            Log.e("TransformedResultImpl", valueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(valueOf) : new String("Runtime exception on the transformation worker thread: "));
            throw runtimeException;
        }
    }
}
