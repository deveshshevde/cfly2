package ot;

import java.util.concurrent.atomic.AtomicReference;
import ok.i;

public final class a implements i {

    /* renamed from: b  reason: collision with root package name */
    static final on.a f34094b = new on.a() {
        public void call() {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<on.a> f34095a;

    public a() {
        this.f34095a = new AtomicReference<>();
    }

    private a(on.a aVar) {
        this.f34095a = new AtomicReference<>(aVar);
    }

    public static a a() {
        return new a();
    }

    public static a a(on.a aVar) {
        return new a(aVar);
    }

    public boolean isUnsubscribed() {
        return this.f34095a.get() == f34094b;
    }

    public final void unsubscribe() {
        on.a andSet;
        on.a aVar = this.f34095a.get();
        on.a aVar2 = f34094b;
        if (aVar != aVar2 && (andSet = this.f34095a.getAndSet(aVar2)) != null && andSet != aVar2) {
            andSet.call();
        }
    }
}
