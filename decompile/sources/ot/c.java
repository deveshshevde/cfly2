package ot;

import java.util.concurrent.atomic.AtomicReference;
import ok.i;

public final class c implements i {

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<a> f34098a = new AtomicReference<>(new a(false, e.a()));

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        final boolean f34099a;

        /* renamed from: b  reason: collision with root package name */
        final i f34100b;

        a(boolean z2, i iVar) {
            this.f34099a = z2;
            this.f34100b = iVar;
        }

        /* access modifiers changed from: package-private */
        public a a() {
            return new a(true, this.f34100b);
        }

        /* access modifiers changed from: package-private */
        public a a(i iVar) {
            return new a(this.f34099a, iVar);
        }
    }

    public void a(i iVar) {
        a aVar;
        if (iVar != null) {
            AtomicReference<a> atomicReference = this.f34098a;
            do {
                aVar = atomicReference.get();
                if (aVar.f34099a) {
                    iVar.unsubscribe();
                    return;
                }
            } while (!atomicReference.compareAndSet(aVar, aVar.a(iVar)));
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    public boolean isUnsubscribed() {
        return this.f34098a.get().f34099a;
    }

    public void unsubscribe() {
        a aVar;
        AtomicReference<a> atomicReference = this.f34098a;
        do {
            aVar = atomicReference.get();
            if (aVar.f34099a) {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.a()));
        aVar.f34100b.unsubscribe();
    }
}
