package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.a;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.l;
import kotlinx.coroutines.internal.aa;
import kotlinx.coroutines.internal.e;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.scheduling.h;
import kotlinx.coroutines.scheduling.i;

public abstract class an<T> extends h {

    /* renamed from: a  reason: collision with root package name */
    public int f30305a;

    public an(int i2) {
        this.f30305a = i2;
    }

    public <T> T a(Object obj) {
        return obj;
    }

    public void a(Object obj, Throwable th) {
    }

    public final void a(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                a.a(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            kotlin.jvm.internal.h.a((Object) th);
            ac.a(b().getContext(), (Throwable) new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". " + "Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    public Throwable b(Object obj) {
        if (!(obj instanceof u)) {
            obj = null;
        }
        u uVar = (u) obj;
        if (uVar != null) {
            return uVar.f30513a;
        }
        return null;
    }

    public abstract c<T> b();

    public abstract Object f();

    public final void run() {
        Object obj;
        f context;
        Object a2;
        Object e2;
        Object obj2;
        Throwable th;
        if (ag.a()) {
            if (!(this.f30305a != -1)) {
                throw new AssertionError();
            }
        }
        i iVar = this.f30496g;
        bg bgVar = null;
        Throwable th2 = null;
        try {
            c b2 = b();
            if (b2 != null) {
                e eVar = (e) b2;
                c<T> cVar = eVar.f30403e;
                context = cVar.getContext();
                Object f2 = f();
                a2 = aa.a(context, eVar.f30401c);
                Throwable b3 = b(f2);
                if (b3 == null && ao.a(this.f30305a)) {
                    bgVar = (bg) context.get(bg.f30343b);
                }
                if (bgVar != null && !bgVar.a()) {
                    CancellationException i2 = bgVar.i();
                    a(f2, (Throwable) i2);
                    Result.a aVar = Result.f30171a;
                    if (ag.c()) {
                        if (cVar instanceof kotlin.coroutines.jvm.internal.c) {
                            th = v.b(i2, (kotlin.coroutines.jvm.internal.c) cVar);
                            e2 = Result.e(kotlin.i.a(th));
                        }
                    }
                    th = i2;
                    e2 = Result.e(kotlin.i.a(th));
                } else if (b3 != null) {
                    Result.a aVar2 = Result.f30171a;
                    e2 = Result.e(kotlin.i.a(b3));
                } else {
                    Object a3 = a(f2);
                    Result.a aVar3 = Result.f30171a;
                    e2 = Result.e(a3);
                }
                cVar.resumeWith(e2);
                l lVar = l.f30254a;
                aa.b(context, a2);
                try {
                    Result.a aVar4 = Result.f30171a;
                    an anVar = this;
                    iVar.a();
                    obj2 = Result.e(l.f30254a);
                } catch (Throwable th3) {
                    Result.a aVar5 = Result.f30171a;
                    obj2 = Result.e(kotlin.i.a(th3));
                }
                a(th2, Result.c(obj2));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
        } catch (Throwable th4) {
            try {
                Result.a aVar6 = Result.f30171a;
                an anVar2 = this;
                iVar.a();
                obj = Result.e(l.f30254a);
            } catch (Throwable th5) {
                Result.a aVar7 = Result.f30171a;
                obj = Result.e(kotlin.i.a(th5));
            }
            a(th4, Result.c(obj));
        }
    }
}
