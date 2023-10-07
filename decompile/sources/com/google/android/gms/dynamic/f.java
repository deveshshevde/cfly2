package com.google.android.gms.dynamic;

import java.util.Iterator;

final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f17993a;

    f(a aVar) {
        this.f17993a = aVar;
    }

    public final void a(c cVar) {
        this.f17993a.f17988a = cVar;
        Iterator it2 = this.f17993a.f17990c.iterator();
        while (it2.hasNext()) {
            ((m) it2.next()).a(this.f17993a.f17988a);
        }
        this.f17993a.f17990c.clear();
        this.f17993a.f17989b = null;
    }
}
