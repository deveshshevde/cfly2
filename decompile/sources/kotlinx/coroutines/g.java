package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.e;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlinx.coroutines.internal.aa;
import kotlinx.coroutines.internal.t;
import mm.m;
import mu.b;

final /* synthetic */ class g {
    /* JADX INFO: finally extract failed */
    public static final <T> Object a(f fVar, m<? super af, ? super c<? super T>, ? extends Object> mVar, c<? super T> cVar) {
        Object obj;
        f context = cVar.getContext();
        f plus = context.plus(fVar);
        ce.a(plus);
        if (plus == context) {
            t tVar = new t(plus, cVar);
            obj = b.a(tVar, tVar, mVar);
        } else if (h.a((Object) (d) plus.get(d.f30197a), (Object) (d) context.get(d.f30197a))) {
            cc ccVar = new cc(plus, cVar);
            Object a2 = aa.a(plus, (Object) null);
            try {
                Object a3 = b.a(ccVar, ccVar, mVar);
                aa.b(plus, a2);
                obj = a3;
            } catch (Throwable th) {
                aa.b(plus, a2);
                throw th;
            }
        } else {
            am amVar = new am(plus, cVar);
            amVar.a(CoroutineStart.DEFAULT, amVar, mVar);
            obj = amVar.h();
        }
        if (obj == a.a()) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return obj;
    }

    public static final bg a(af afVar, f fVar, CoroutineStart coroutineStart, m<? super af, ? super c<? super l>, ? extends Object> mVar) {
        f a2 = z.a(afVar, fVar);
        bu boVar = coroutineStart.a() ? new bo(a2, mVar) : new bu(a2, true);
        boVar.a(coroutineStart, boVar, mVar);
        return boVar;
    }

    public static /* synthetic */ bg a(af afVar, f fVar, CoroutineStart coroutineStart, m mVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fVar = EmptyCoroutineContext.f30194a;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return e.a(afVar, fVar, coroutineStart, mVar);
    }

    public static final <T, R> void a(CoroutineStart coroutineStart, R r2, c<? super T> cVar, mm.b<? super Throwable, l> bVar, m<? super R, ? super c<? super T>, ? extends Object> mVar) {
        int i2 = f.f30372a[coroutineStart.ordinal()];
        if (i2 == 1) {
            mu.a.a(mVar, r2, cVar, bVar);
        } else if (i2 == 2) {
            e.a(mVar, r2, cVar);
        } else if (i2 == 3) {
            b.a(mVar, r2, cVar);
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
