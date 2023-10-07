package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlinx.coroutines.aa;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.an;
import kotlinx.coroutines.at;
import kotlinx.coroutines.by;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k;
import kotlinx.coroutines.v;
import kotlinx.coroutines.x;
import mm.b;

public final class e<T> extends an<T> implements c<T>, kotlin.coroutines.jvm.internal.c {

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f30399i = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: b  reason: collision with root package name */
    public Object f30400b = f.f30406b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f30401c;

    /* renamed from: d  reason: collision with root package name */
    public final aa f30402d;

    /* renamed from: e  reason: collision with root package name */
    public final c<T> f30403e;

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.coroutines.jvm.internal.c f30404h;

    public e(aa aaVar, c<? super T> cVar) {
        super(-1);
        this.f30402d = aaVar;
        this.f30403e = cVar;
        this.f30404h = (kotlin.coroutines.jvm.internal.c) (!(cVar instanceof kotlin.coroutines.jvm.internal.c) ? null : cVar);
        this.f30401c = aa.a(getContext());
        this._reusableCancellableContinuation = null;
    }

    public final Throwable a(j<?> jVar) {
        do {
            Object obj = this._reusableCancellableContinuation;
            if (obj != f.f30405a) {
                if (obj == null) {
                    return null;
                }
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                } else if (f30399i.compareAndSet(this, obj, (Object) null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!f30399i.compareAndSet(this, f.f30405a, jVar));
        return null;
    }

    public final k<?> a() {
        Object obj = this._reusableCancellableContinuation;
        if (!(obj instanceof k)) {
            obj = null;
        }
        return (k) obj;
    }

    public void a(Object obj, Throwable th) {
        if (obj instanceof v) {
            ((v) obj).f30515b.invoke(th);
        }
    }

    public final boolean a(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (h.a(obj, (Object) f.f30405a)) {
                if (f30399i.compareAndSet(this, f.f30405a, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (f30399i.compareAndSet(this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    public final boolean a(k<?> kVar) {
        Object obj = this._reusableCancellableContinuation;
        if (obj != null) {
            return !(obj instanceof k) || obj == kVar;
        }
        return false;
    }

    public c<T> b() {
        return this;
    }

    public Object f() {
        Object obj = this.f30400b;
        if (ag.a()) {
            if (!(obj != f.f30406b)) {
                throw new AssertionError();
            }
        }
        this.f30400b = f.f30406b;
        return obj;
    }

    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        return this.f30404h;
    }

    public f getContext() {
        return this.f30403e.getContext();
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public void resumeWith(Object obj) {
        f context;
        Object a2;
        f context2 = this.f30403e.getContext();
        Object a3 = x.a(obj, (b) null, 1, (Object) null);
        if (this.f30402d.a(context2)) {
            this.f30400b = a3;
            this.f30305a = 0;
            this.f30402d.a(context2, this);
            return;
        }
        boolean a4 = ag.a();
        at a5 = by.f30365a.a();
        if (a5.f()) {
            this.f30400b = a3;
            this.f30305a = 0;
            a5.a((an<?>) this);
            return;
        }
        an anVar = this;
        a5.a(true);
        try {
            context = getContext();
            a2 = aa.a(context, this.f30401c);
            this.f30403e.resumeWith(obj);
            l lVar = l.f30254a;
            aa.b(context, a2);
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
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f30402d + ", " + ah.a((c<?>) this.f30403e) + ']';
    }
}
