package mu;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.i;
import kotlin.l;
import kotlinx.coroutines.internal.f;
import mm.b;
import mm.m;

public final class a {
    public static final void a(c<? super l> cVar, c<?> cVar2) {
        try {
            c<? super l> a2 = kotlin.coroutines.intrinsics.a.a(cVar);
            Result.a aVar = Result.f30171a;
            f.a(a2, Result.e(l.f30254a), (b) null, 2, (Object) null);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f30171a;
            cVar2.resumeWith(Result.e(i.a(th)));
        }
    }

    public static final <R, T> void a(m<? super R, ? super c<? super T>, ? extends Object> mVar, R r2, c<? super T> cVar, b<? super Throwable, l> bVar) {
        try {
            c<l> a2 = kotlin.coroutines.intrinsics.a.a(kotlin.coroutines.intrinsics.a.a(mVar, r2, cVar));
            Result.a aVar = Result.f30171a;
            f.a(a2, Result.e(l.f30254a), bVar);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f30171a;
            cVar.resumeWith(Result.e(i.a(th)));
        }
    }
}
