package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class v {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10411a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f10412b = new Handler(Looper.getMainLooper(), new a());

    private static final class a implements Handler.Callback {
        a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((s) message.obj).f();
            return true;
        }
    }

    v() {
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(s<?> sVar, boolean z2) {
        if (!this.f10411a) {
            if (!z2) {
                this.f10411a = true;
                sVar.f();
                this.f10411a = false;
            }
        }
        this.f10412b.obtainMessage(1, sVar).sendToTarget();
    }
}
