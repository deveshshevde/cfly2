package androidx.lifecycle;

import kotlin.jvm.internal.h;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bw;

public final class l {
    public static final i a(Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        h.c(lifecycle, "$this$coroutineScope");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.f3552a.get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, bw.a((bg) null, 1, (Object) null).plus(ap.b().a()));
        } while (!lifecycle.f3552a.compareAndSet((Object) null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.a();
        return lifecycleCoroutineScopeImpl;
    }
}
