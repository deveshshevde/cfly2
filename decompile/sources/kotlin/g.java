package kotlin;

import kotlin.jvm.internal.h;
import mm.a;

class g {
    public static final <T> d<T> a(LazyThreadSafetyMode lazyThreadSafetyMode, a<? extends T> aVar) {
        d<T> dVar;
        h.d(lazyThreadSafetyMode, "mode");
        h.d(aVar, "initializer");
        int i2 = f.f30220a[lazyThreadSafetyMode.ordinal()];
        if (i2 == 1) {
            dVar = new SynchronizedLazyImpl<>(aVar, (Object) null, 2, (f) null);
        } else if (i2 == 2) {
            dVar = new SafePublicationLazyImpl<>(aVar);
        } else if (i2 == 3) {
            dVar = new UnsafeLazyImpl<>(aVar);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return dVar;
    }

    public static final <T> d<T> a(a<? extends T> aVar) {
        h.d(aVar, "initializer");
        return new SynchronizedLazyImpl<>(aVar, (Object) null, 2, (f) null);
    }
}
