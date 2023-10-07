package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.c;
import java.util.HashMap;
import java.util.Map;

final class p {

    /* renamed from: a  reason: collision with root package name */
    private final Map<c, j<?>> f10381a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<c, j<?>> f10382b = new HashMap();

    p() {
    }

    private Map<c, j<?>> a(boolean z2) {
        return z2 ? this.f10382b : this.f10381a;
    }

    /* access modifiers changed from: package-private */
    public j<?> a(c cVar, boolean z2) {
        return a(z2).get(cVar);
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar, j<?> jVar) {
        a(jVar.a()).put(cVar, jVar);
    }

    /* access modifiers changed from: package-private */
    public void b(c cVar, j<?> jVar) {
        Map<c, j<?>> a2 = a(jVar.a());
        if (jVar.equals(a2.get(cVar))) {
            a2.remove(cVar);
        }
    }
}
