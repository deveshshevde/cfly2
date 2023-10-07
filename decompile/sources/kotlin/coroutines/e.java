package kotlin.coroutines;

import kotlin.Result;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.m;

public final class e {
    public static final <R, T> void a(m<? super R, ? super c<? super T>, ? extends Object> mVar, R r2, c<? super T> cVar) {
        h.d(mVar, "$this$startCoroutine");
        h.d(cVar, "completion");
        c<l> a2 = a.a(a.a(mVar, r2, cVar));
        l lVar = l.f30254a;
        Result.a aVar = Result.f30171a;
        a2.resumeWith(Result.e(lVar));
    }
}
