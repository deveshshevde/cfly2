package retrofit2;

import kotlin.jvm.internal.Lambda;
import kotlin.l;
import mm.b;

final class KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2 extends Lambda implements b<Throwable, l> {
    final /* synthetic */ Call $this_await$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(Call call) {
        super(1);
        this.$this_await$inlined = call;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return l.f30254a;
    }

    public final void invoke(Throwable th) {
        this.$this_await$inlined.cancel();
    }
}
