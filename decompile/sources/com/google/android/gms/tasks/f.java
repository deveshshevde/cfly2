package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class f<TResult> implements g<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f18369a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f18370b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a<TResult> f18371c;

    public f(Executor executor, a<TResult> aVar) {
        this.f18369a = executor;
        this.f18371c = aVar;
    }

    public final void a(b<TResult> bVar) {
        synchronized (this.f18370b) {
            if (this.f18371c != null) {
                this.f18369a.execute(new e(this, bVar));
            }
        }
    }
}
