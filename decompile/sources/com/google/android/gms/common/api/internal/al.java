package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.c;
import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

final class al extends c {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<aq> f17432a;

    al(aq aqVar) {
        this.f17432a = new WeakReference<>(aqVar);
    }

    public final void a(zak zak) {
        aq aqVar = (aq) this.f17432a.get();
        if (aqVar != null) {
            aqVar.f17435a.a((ax) new ak(this, aqVar, aqVar, zak));
        }
    }
}
