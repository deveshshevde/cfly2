package com.google.android.gms.common.api.internal;

final class dg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f17595a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f17596b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ dh f17597c;

    dg(dh dhVar, LifecycleCallback lifecycleCallback, String str) {
        this.f17597c = dhVar;
        this.f17595a = lifecycleCallback;
        this.f17596b = str;
    }

    public final void run() {
        dh dhVar = this.f17597c;
        if (dhVar.f17600c > 0) {
            this.f17595a.a(dhVar.f17601d != null ? dhVar.f17601d.getBundle(this.f17596b) : null);
        }
        if (this.f17597c.f17600c >= 2) {
            this.f17595a.d();
        }
        if (this.f17597c.f17600c >= 3) {
            this.f17595a.c();
        }
        if (this.f17597c.f17600c >= 4) {
            this.f17595a.e();
        }
        if (this.f17597c.f17600c >= 5) {
            this.f17595a.b();
        }
    }
}
