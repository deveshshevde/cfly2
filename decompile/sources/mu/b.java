package mu;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.a;
import kotlin.i;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.internal.aa;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.u;
import mm.m;

public final class b {
    public static final <T, R> Object a(t<? super T> tVar, R r2, m<? super R, ? super c<? super T>, ? extends Object> mVar) {
        Object obj;
        Object f2;
        tVar.x_();
        try {
            c cVar = tVar;
            if (mVar != null) {
                obj = ((m) kotlin.jvm.internal.m.b(mVar, 2)).a(r2, cVar);
                if (obj == a.a() || (f2 = tVar.f(obj)) == bn.f30356a) {
                    return a.a();
                }
                if (!(f2 instanceof u)) {
                    return bn.b(f2);
                }
                u uVar = (u) f2;
                Throwable th = uVar.f30513a;
                Throwable th2 = uVar.f30513a;
                c<T> cVar2 = tVar.f30435c;
                if (ag.c() && (cVar2 instanceof kotlin.coroutines.jvm.internal.c)) {
                    th2 = v.b(th2, (kotlin.coroutines.jvm.internal.c) cVar2);
                }
                throw th2;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th3) {
            obj = new u(th3, false, 2, (f) null);
        }
    }

    public static final <R, T> void a(m<? super R, ? super c<? super T>, ? extends Object> mVar, R r2, c<? super T> cVar) {
        Object obj;
        f context;
        Object a2;
        c<? super T> a3 = kotlin.coroutines.jvm.internal.f.a(cVar);
        try {
            context = cVar.getContext();
            a2 = aa.a(context, (Object) null);
            if (mVar != null) {
                obj = ((m) kotlin.jvm.internal.m.b(mVar, 2)).a(r2, a3);
                aa.b(context, a2);
                if (obj != a.a()) {
                    Result.a aVar = Result.f30171a;
                    a3.resumeWith(Result.e(obj));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.f30171a;
            obj = i.a(th);
        }
    }
}
