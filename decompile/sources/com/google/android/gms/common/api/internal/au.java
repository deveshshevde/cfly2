package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class au extends bn {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<av> f17458a;

    au(av avVar) {
        this.f17458a = new WeakReference<>(avVar);
    }

    public final void a() {
        av avVar = (av) this.f17458a.get();
        if (avVar != null) {
            av.a(avVar);
        }
    }
}
