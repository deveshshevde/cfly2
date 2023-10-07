package com.google.android.gms.common.internal;

import android.util.Log;

public abstract class au<TListener> {

    /* renamed from: a  reason: collision with root package name */
    private TListener f17789a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17790b = false;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ d f17791d;

    public au(d dVar, TListener tlistener) {
        this.f17791d = dVar;
        this.f17789a = tlistener;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract void a(TListener tlistener);

    public final void c() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.f17789a;
            if (this.f17790b) {
                String obj = toString();
                StringBuilder sb = new StringBuilder(obj.length() + 47);
                sb.append("Callback proxy ");
                sb.append(obj);
                sb.append(" being reused. This is not safe.");
                Log.w("GmsClient", sb.toString());
            }
        }
        if (tlistener != null) {
            try {
                a(tlistener);
            } catch (RuntimeException e2) {
                throw e2;
            }
        }
        synchronized (this) {
            this.f17790b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f17789a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f17791d.zzt) {
            this.f17791d.zzt.remove(this);
        }
    }
}
