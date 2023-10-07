package com.google.android.gms.tasks;

final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f18367a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f f18368b;

    e(f fVar, b bVar) {
        this.f18368b = fVar;
        this.f18367a = bVar;
    }

    public final void run() {
        synchronized (this.f18368b.f18370b) {
            f fVar = this.f18368b;
            if (fVar.f18371c != null) {
                fVar.f18371c.a(this.f18367a);
            }
        }
    }
}
