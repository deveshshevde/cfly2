package com.google.android.gms.common.api.internal;

abstract class ax {

    /* renamed from: a  reason: collision with root package name */
    private final aw f17483a;

    protected ax(aw awVar) {
        this.f17483a = awVar;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public final void a(az azVar) {
        azVar.f11790i.lock();
        try {
            if (azVar.f11795n == this.f17483a) {
                a();
            }
        } finally {
            azVar.f11790i.unlock();
        }
    }
}
