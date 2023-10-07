package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.i;
import kotlin.l;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.an;
import kotlinx.coroutines.at;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.by;
import kotlinx.coroutines.x;
import mm.b;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final w f30405a = new w("REUSABLE_CLAIMED");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final w f30406b = new w("UNDEFINED");

    public static final <T> void a(c<? super T> cVar, Object obj, b<? super Throwable, l> bVar) {
        boolean z2;
        kotlin.coroutines.f context;
        Object a2;
        if (cVar instanceof e) {
            e eVar = (e) cVar;
            Object a3 = x.a(obj, bVar);
            if (eVar.f30402d.a(eVar.getContext())) {
                eVar.f30400b = a3;
                eVar.f30305a = 1;
                eVar.f30402d.a(eVar.getContext(), eVar);
                return;
            }
            boolean a4 = ag.a();
            at a5 = by.f30365a.a();
            if (a5.f()) {
                eVar.f30400b = a3;
                eVar.f30305a = 1;
                a5.a((an<?>) eVar);
                return;
            }
            an anVar = eVar;
            a5.a(true);
            try {
                bg bgVar = (bg) eVar.getContext().get(bg.f30343b);
                if (bgVar == null || bgVar.a()) {
                    z2 = false;
                } else {
                    CancellationException i2 = bgVar.i();
                    eVar.a(a3, i2);
                    Result.a aVar = Result.f30171a;
                    eVar.resumeWith(Result.e(i.a((Throwable) i2)));
                    z2 = true;
                }
                if (!z2) {
                    context = eVar.getContext();
                    a2 = aa.a(context, eVar.f30401c);
                    eVar.f30403e.resumeWith(obj);
                    l lVar = l.f30254a;
                    aa.b(context, a2);
                }
                do {
                } while (a5.e());
            } catch (Throwable th) {
                try {
                    anVar.a(th, (Throwable) null);
                } catch (Throwable th2) {
                    a5.b(true);
                    throw th2;
                }
            }
            a5.b(true);
            return;
        }
        cVar.resumeWith(obj);
    }

    public static /* synthetic */ void a(c cVar, Object obj, b bVar, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            bVar = null;
        }
        a(cVar, obj, bVar);
    }
}
