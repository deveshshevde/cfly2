package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

public class e extends Handler implements k {

    /* renamed from: a  reason: collision with root package name */
    private final j f14041a = new j();

    /* renamed from: b  reason: collision with root package name */
    private final int f14042b;

    /* renamed from: c  reason: collision with root package name */
    private final c f14043c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14044d;

    protected e(c cVar, Looper looper, int i2) {
        super(looper);
        this.f14043c = cVar;
        this.f14042b = i2;
    }

    public void a(p pVar, Object obj) {
        i a2 = i.a(pVar, obj);
        synchronized (this) {
            this.f14041a.a(a2);
            if (!this.f14044d) {
                this.f14044d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                i a2 = this.f14041a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f14041a.a();
                        if (a2 == null) {
                            this.f14044d = false;
                            this.f14044d = false;
                            return;
                        }
                    }
                }
                this.f14043c.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f14042b));
            if (sendMessage(obtainMessage())) {
                this.f14044d = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } catch (Throwable th) {
            this.f14044d = false;
            throw th;
        }
    }
}
