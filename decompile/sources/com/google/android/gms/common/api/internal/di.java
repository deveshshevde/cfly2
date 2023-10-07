package com.google.android.gms.common.api.internal;

final class di implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f17602a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f17603b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ dj f17604c;

    di(dj djVar, LifecycleCallback lifecycleCallback, String str) {
        this.f17604c = djVar;
        this.f17602a = lifecycleCallback;
        this.f17603b = str;
    }

    public final void run() {
        dj djVar = this.f17604c;
        if (djVar.f17607c > 0) {
            this.f17602a.a(djVar.f17608d != null ? djVar.f17608d.getBundle(this.f17603b) : null);
        }
        if (this.f17604c.f17607c >= 2) {
            this.f17602a.d();
        }
        if (this.f17604c.f17607c >= 3) {
            this.f17602a.c();
        }
        if (this.f17604c.f17607c >= 4) {
            this.f17602a.e();
        }
        if (this.f17604c.f17607c >= 5) {
            this.f17602a.b();
        }
    }
}
