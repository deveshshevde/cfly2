package retrofit2;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.i;

final class KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 implements Runnable {
    final /* synthetic */ c $continuation;
    final /* synthetic */ Exception $this_suspendAndThrow$inlined;

    KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1(c cVar, Exception exc) {
        this.$continuation = cVar;
        this.$this_suspendAndThrow$inlined = exc;
    }

    public final void run() {
        c a2 = a.a(this.$continuation);
        Result.a aVar = Result.f30171a;
        a2.resumeWith(Result.e(i.a((Throwable) this.$this_suspendAndThrow$inlined)));
    }
}
