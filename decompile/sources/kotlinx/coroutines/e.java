package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.l;
import mm.b;
import mm.m;

public final class e {
    public static final <T> Object a(f fVar, m<? super af, ? super c<? super T>, ? extends Object> mVar, c<? super T> cVar) {
        return g.a(fVar, mVar, cVar);
    }

    public static final bg a(af afVar, f fVar, CoroutineStart coroutineStart, m<? super af, ? super c<? super l>, ? extends Object> mVar) {
        return g.a(afVar, fVar, coroutineStart, mVar);
    }

    public static final <T, R> void a(CoroutineStart coroutineStart, R r2, c<? super T> cVar, b<? super Throwable, l> bVar, m<? super R, ? super c<? super T>, ? extends Object> mVar) {
        g.a(coroutineStart, r2, cVar, bVar, mVar);
    }
}
