package androidx.work.impl;

import androidx.lifecycle.s;
import androidx.work.impl.utils.futures.b;
import androidx.work.l;

public class c implements l {

    /* renamed from: c  reason: collision with root package name */
    private final s<l.a> f5224c = new s<>();

    /* renamed from: d  reason: collision with root package name */
    private final b<l.a.c> f5225d = b.d();

    public c() {
        a(l.f5451b);
    }

    public void a(l.a aVar) {
        this.f5224c.a(aVar);
        if (aVar instanceof l.a.c) {
            this.f5225d.a((l.a.c) aVar);
        } else if (aVar instanceof l.a.C0046a) {
            this.f5225d.a(((l.a.C0046a) aVar).a());
        }
    }
}
