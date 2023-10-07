package com.google.android.gms.common.api.internal;

abstract class ap implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ aq f17434b;

    /* synthetic */ ap(aq aqVar, ao aoVar) {
        this.f17434b = aqVar;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public final void run() {
        this.f17434b.f17436b.lock();
        try {
            if (!Thread.interrupted()) {
                a();
            }
        } catch (RuntimeException e2) {
            this.f17434b.f17435a.a(e2);
        } catch (Throwable th) {
            this.f17434b.f17436b.unlock();
            throw th;
        }
        this.f17434b.f17436b.unlock();
    }
}
