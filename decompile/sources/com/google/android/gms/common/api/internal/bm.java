package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.d;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class bm<O extends a.d> extends aa {
    @NotOnlyInitialized

    /* renamed from: a  reason: collision with root package name */
    private final c<O> f11810a;

    public bm(c<O> cVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f11810a = cVar;
    }

    public final Looper a() {
        return this.f11810a.a();
    }

    public final <A extends a.b, R extends g, T extends d.a<R, A>> T a(T t2) {
        return this.f11810a.a(t2);
    }

    public final void a(cj cjVar) {
    }

    public final <A extends a.b, T extends d.a<? extends g, A>> T b(T t2) {
        return this.f11810a.b(t2);
    }

    public final void b(cj cjVar) {
    }
}
