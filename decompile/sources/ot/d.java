package ot;

import java.util.concurrent.atomic.AtomicReference;
import ok.i;

public final class d implements i {

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<a> f34101a = new AtomicReference<>(new a(false, e.a()));

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        final boolean f34102a;

        /* renamed from: b  reason: collision with root package name */
        final i f34103b;

        a(boolean z2, i iVar) {
            this.f34102a = z2;
            this.f34103b = iVar;
        }

        /* access modifiers changed from: package-private */
        public a a() {
            return new a(true, this.f34103b);
        }

        /* access modifiers changed from: package-private */
        public a a(i iVar) {
            return new a(this.f34102a, iVar);
        }
    }

    public void a(i iVar) {
        a aVar;
        if (iVar != null) {
            AtomicReference<a> atomicReference = this.f34101a;
            do {
                aVar = atomicReference.get();
                if (aVar.f34102a) {
                    iVar.unsubscribe();
                    return;
                }
            } while (!atomicReference.compareAndSet(aVar, aVar.a(iVar)));
            aVar.f34103b.unsubscribe();
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    public boolean isUnsubscribed() {
        return this.f34101a.get().f34102a;
    }

    public void unsubscribe() {
        a aVar;
        AtomicReference<a> atomicReference = this.f34101a;
        do {
            aVar = atomicReference.get();
            if (aVar.f34102a) {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.a()));
        aVar.f34103b.unsubscribe();
    }
}
