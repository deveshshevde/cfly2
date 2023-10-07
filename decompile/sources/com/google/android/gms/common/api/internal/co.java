package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.tasks.c;

public final class co extends ci<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final j.a<?> f17567b;

    public co(j.a<?> aVar, c<Boolean> cVar) {
        super(4, cVar);
        this.f17567b = aVar;
    }

    public final /* bridge */ /* synthetic */ void a(x xVar, boolean z2) {
    }

    public final boolean a(bh<?> bhVar) {
        bx bxVar = bhVar.e().get(this.f17567b);
        return bxVar != null && bxVar.f17524a.c();
    }

    public final Feature[] b(bh<?> bhVar) {
        bx bxVar = bhVar.e().get(this.f17567b);
        if (bxVar == null) {
            return null;
        }
        return bxVar.f17524a.b();
    }

    public final void c(bh<?> bhVar) throws RemoteException {
        bx remove = bhVar.e().remove(this.f17567b);
        if (remove != null) {
            remove.f17525b.a(bhVar.d(), this.f17549a);
            remove.f17524a.a();
            return;
        }
        this.f17549a.b(false);
    }
}
