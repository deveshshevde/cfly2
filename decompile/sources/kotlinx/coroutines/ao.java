package kotlinx.coroutines;

import java.util.Objects;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.i;
import kotlin.l;
import kotlinx.coroutines.internal.aa;
import kotlinx.coroutines.internal.e;

public final class ao {
    private static final <T> void a(k<? super T> kVar) {
        at a2 = by.f30365a.a();
        if (a2.f()) {
            a2.a((an<?>) kVar);
            return;
        }
        an anVar = kVar;
        a2.a(true);
        try {
            a(kVar, kVar.b(), true);
            do {
            } while (a2.e());
        } catch (Throwable th) {
            a2.b(true);
            throw th;
        }
        a2.b(true);
    }

    public static final <T> void a(k<? super T> kVar, int i2) {
        boolean z2 = true;
        if (ag.a()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        c<? super T> a2 = kVar.b();
        if (i2 != 4) {
            z2 = false;
        }
        if (z2 || !(a2 instanceof e) || a(i2) != a(kVar.f30305a)) {
            a(kVar, a2, z2);
            return;
        }
        aa aaVar = ((e) a2).f30402d;
        f context = a2.getContext();
        if (aaVar.a(context)) {
            aaVar.a(context, kVar);
        } else {
            a(kVar);
        }
    }

    public static final <T> void a(k<? super T> kVar, c<? super T> cVar, boolean z2) {
        Object obj;
        Object f2 = kVar.f();
        Throwable b2 = kVar.b(f2);
        if (b2 != null) {
            Result.a aVar = Result.f30171a;
            obj = i.a(b2);
        } else {
            Result.a aVar2 = Result.f30171a;
            obj = kVar.a(f2);
        }
        Object e2 = Result.e(obj);
        if (z2) {
            Objects.requireNonNull(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
            e eVar = (e) cVar;
            f context = eVar.getContext();
            Object a2 = aa.a(context, eVar.f30401c);
            try {
                eVar.f30403e.resumeWith(e2);
                l lVar = l.f30254a;
            } finally {
                aa.b(context, a2);
            }
        } else {
            cVar.resumeWith(e2);
        }
    }

    public static final boolean a(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static final boolean b(int i2) {
        return i2 == 2;
    }
}
