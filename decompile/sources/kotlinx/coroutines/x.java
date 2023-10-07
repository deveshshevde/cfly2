package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.i;
import kotlin.l;
import kotlinx.coroutines.internal.v;
import mm.b;

public final class x {
    public static final <T> Object a(Object obj, c<? super T> cVar) {
        if (obj instanceof u) {
            Result.a aVar = Result.f30171a;
            Throwable th = ((u) obj).f30513a;
            if (ag.c() && (cVar instanceof kotlin.coroutines.jvm.internal.c)) {
                th = v.b(th, (kotlin.coroutines.jvm.internal.c) cVar);
            }
            obj = i.a(th);
        } else {
            Result.a aVar2 = Result.f30171a;
        }
        return Result.e(obj);
    }

    public static final <T> Object a(Object obj, j<?> jVar) {
        Throwable c2 = Result.c(obj);
        if (c2 != null) {
            c cVar = jVar;
            if (ag.c() && (cVar instanceof kotlin.coroutines.jvm.internal.c)) {
                c2 = v.b(c2, (kotlin.coroutines.jvm.internal.c) cVar);
            }
            obj = new u(c2, false, 2, (f) null);
        }
        return obj;
    }

    public static final <T> Object a(Object obj, b<? super Throwable, l> bVar) {
        Throwable c2 = Result.c(obj);
        return c2 == null ? bVar != null ? new v(obj, bVar) : obj : new u(c2, false, 2, (f) null);
    }

    public static /* synthetic */ Object a(Object obj, b bVar, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            bVar = null;
        }
        return a(obj, (b<? super Throwable, l>) bVar);
    }
}
