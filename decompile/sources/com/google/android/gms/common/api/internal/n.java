package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.tasks.c;

public abstract class n<A extends a.b, L> {

    /* renamed from: a  reason: collision with root package name */
    private final j<L> f17628a;

    /* renamed from: b  reason: collision with root package name */
    private final Feature[] f17629b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17630c;

    public void a() {
        this.f17628a.b();
    }

    /* access modifiers changed from: protected */
    public abstract void a(A a2, c<Void> cVar) throws RemoteException;

    public Feature[] b() {
        return this.f17629b;
    }

    public final boolean c() {
        return this.f17630c;
    }
}
