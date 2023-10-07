package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.c;
import kotlin.l;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.internal.e;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.internal.v;
import mm.b;

public class k<T> extends an<T> implements c, j<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f30440d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f30441e;
    private volatile int _decision;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.coroutines.c<T> f30442b;

    /* renamed from: c  reason: collision with root package name */
    private final f f30443c;

    static {
        Class<k> cls = k.class;
        f30440d = AtomicIntegerFieldUpdater.newUpdater(cls, "_decision");
        f30441e = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_state");
    }

    public k(kotlin.coroutines.c<? super T> cVar, int i2) {
        super(i2);
        if (ag.a()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        this.f30442b = cVar;
        this.f30443c = cVar.getContext();
        this._decision = 0;
        this._state = b.f30336a;
        this._parentHandle = null;
    }

    private final Object a(bs bsVar, Object obj, int i2, b<? super Throwable, l> bVar, Object obj2) {
        if (obj instanceof u) {
            boolean z2 = true;
            if (ag.a()) {
                if (!(obj2 == null)) {
                    throw new AssertionError();
                }
            }
            if (!ag.a()) {
                return obj;
            }
            if (bVar != null) {
                z2 = false;
            }
            if (z2) {
                return obj;
            }
            throw new AssertionError();
        } else if (!ao.a(i2) && obj2 == null) {
            return obj;
        } else {
            if (bVar == null && ((!(bsVar instanceof h) || (bsVar instanceof c)) && obj2 == null)) {
                return obj;
            }
            if (!(bsVar instanceof h)) {
                bsVar = null;
            }
            return new t(obj, (h) bsVar, bVar, obj2, (Throwable) null, 16, (f) null);
        }
    }

    private final void a(int i2) {
        if (!o()) {
            ao.a(this, i2);
        }
    }

    private final void a(Object obj, int i2, b<? super Throwable, l> bVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof bs) {
            } else {
                if (obj2 instanceof m) {
                    m mVar = (m) obj2;
                    if (mVar.a()) {
                        if (bVar != null) {
                            a(bVar, mVar.f30513a);
                            return;
                        }
                        return;
                    }
                }
                c(obj);
                throw new KotlinNothingValueException();
            }
        } while (!f30441e.compareAndSet(this, obj2, a((bs) obj2, obj, i2, bVar, (Object) null)));
        p();
        a(i2);
    }

    private final void a(aq aqVar) {
        this._parentHandle = aqVar;
    }

    static /* synthetic */ void a(k kVar, Object obj, int i2, b bVar, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 4) != 0) {
                bVar = null;
            }
            kVar.a(obj, i2, bVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final void a(b<? super Throwable, l> bVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + bVar + ", already has " + obj).toString());
    }

    private final h b(b<? super Throwable, l> bVar) {
        return bVar instanceof h ? (h) bVar : new bd(bVar);
    }

    private final void b(b<? super Throwable, l> bVar, Throwable th) {
        try {
            bVar.invoke(th);
        } catch (Throwable th2) {
            f context = getContext();
            ac.a(context, (Throwable) new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final boolean b(Throwable th) {
        if (!ao.b(this.f30305a)) {
            return false;
        }
        kotlin.coroutines.c<T> cVar = this.f30442b;
        if (!(cVar instanceof e)) {
            cVar = null;
        }
        e eVar = (e) cVar;
        if (eVar != null) {
            return eVar.a(th);
        }
        return false;
    }

    private final Void c(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final aq j() {
        return (aq) this._parentHandle;
    }

    private final boolean k() {
        kotlin.coroutines.c<T> cVar = this.f30442b;
        return (cVar instanceof e) && ((e) cVar).a((k<?>) this);
    }

    private final void l() {
        bg bgVar;
        if (!m() && j() == null && (bgVar = (bg) this.f30442b.getContext().get(bg.f30343b)) != null) {
            aq a2 = bg.a.a(bgVar, true, false, new n(bgVar, this), 2, (Object) null);
            a(a2);
            if (d() && !k()) {
                a2.a();
                a((aq) br.f30364a);
            }
        }
    }

    private final boolean m() {
        Throwable a2;
        boolean d2 = d();
        if (!ao.b(this.f30305a)) {
            return d2;
        }
        kotlin.coroutines.c<T> cVar = this.f30442b;
        if (!(cVar instanceof e)) {
            cVar = null;
        }
        e eVar = (e) cVar;
        if (eVar == null || (a2 = eVar.a((j<?>) this)) == null) {
            return d2;
        }
        if (!d2) {
            a(a2);
        }
        return true;
    }

    private final boolean n() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f30440d.compareAndSet(this, 0, 1));
        return true;
    }

    private final boolean o() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f30440d.compareAndSet(this, 0, 2));
        return true;
    }

    private final void p() {
        if (!k()) {
            h();
        }
    }

    public <T> T a(Object obj) {
        if (!(obj instanceof t)) {
            return obj;
        }
        t tVar = (t) obj;
        tVar.d();
        return tVar.f30509a;
    }

    /* renamed from: a */
    public final kotlin.coroutines.c<T> b() {
        return this.f30442b;
    }

    public void a(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof bs) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof u)) {
                if (obj2 instanceof t) {
                    t tVar = (t) obj2;
                    if (!tVar.c()) {
                        if (f30441e.compareAndSet(this, obj2, t.a(tVar, (Object) null, (h) null, (b) null, (Object) null, th, 15, (Object) null))) {
                            tVar.a(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (f30441e.compareAndSet(this, obj2, new t(obj2, (h) null, (b) null, (Object) null, th, 14, (f) null))) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void a(aa aaVar, T t2) {
        kotlin.coroutines.c<T> a2 = u.a(this.f30442b);
        aa aaVar2 = null;
        if (!(a2 instanceof e)) {
            a2 = null;
        }
        e eVar = (e) a2;
        if (eVar != null) {
            aaVar2 = eVar.f30402d;
        }
        a(this, t2, aaVar2 == aaVar ? 4 : this.f30305a, (b) null, 4, (Object) null);
    }

    public final void a(bg bgVar) {
        Throwable b2 = b(bgVar);
        if (!b(b2)) {
            a(b2);
            p();
        }
    }

    public final void a(h hVar, Throwable th) {
        try {
            hVar.a(th);
        } catch (Throwable th2) {
            f context = getContext();
            ac.a(context, (Throwable) new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public void a(b<? super Throwable, l> bVar) {
        h b2 = b(bVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof b) {
                if (f30441e.compareAndSet(this, obj, b2)) {
                    return;
                }
            } else if (obj instanceof h) {
                a(bVar, obj);
            } else {
                boolean z2 = obj instanceof u;
                if (z2) {
                    if (!((u) obj).c()) {
                        a(bVar, obj);
                    }
                    if (obj instanceof m) {
                        Throwable th = null;
                        if (!z2) {
                            obj = null;
                        }
                        u uVar = (u) obj;
                        if (uVar != null) {
                            th = uVar.f30513a;
                        }
                        b(bVar, th);
                        return;
                    }
                    return;
                } else if (obj instanceof t) {
                    t tVar = (t) obj;
                    if (tVar.a() != null) {
                        a(bVar, obj);
                    }
                    if (!(b2 instanceof c)) {
                        if (tVar.c()) {
                            b(bVar, tVar.f30511c);
                            return;
                        }
                        if (f30441e.compareAndSet(this, obj, t.a(tVar, (Object) null, b2, (b) null, (Object) null, (Throwable) null, 29, (Object) null))) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (!(b2 instanceof c)) {
                    if (f30441e.compareAndSet(this, obj, new t(obj, b2, (b) null, (Object) null, (Throwable) null, 28, (f) null))) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void a(b<? super Throwable, l> bVar, Throwable th) {
        try {
            bVar.invoke(th);
        } catch (Throwable th2) {
            f context = getContext();
            ac.a(context, (Throwable) new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public boolean a(Throwable th) {
        Object obj;
        boolean z2;
        do {
            obj = this._state;
            if (!(obj instanceof bs)) {
                return false;
            }
            z2 = obj instanceof h;
        } while (!f30441e.compareAndSet(this, obj, new m(this, th, z2)));
        if (!z2) {
            obj = null;
        }
        h hVar = (h) obj;
        if (hVar != null) {
            a(hVar, th);
        }
        p();
        a(this.f30305a);
        return true;
    }

    public Throwable b(Object obj) {
        Throwable b2 = super.b(obj);
        if (b2 == null) {
            return null;
        }
        kotlin.coroutines.c<T> cVar = this.f30442b;
        return (!ag.c() || !(cVar instanceof c)) ? b2 : v.b(b2, (c) cVar);
    }

    public Throwable b(bg bgVar) {
        return bgVar.i();
    }

    public final Object c() {
        return this._state;
    }

    public boolean d() {
        return !(c() instanceof bs);
    }

    public void e() {
        l();
    }

    public Object f() {
        return c();
    }

    public final Object g() {
        bg bgVar;
        l();
        if (n()) {
            return a.a();
        }
        Object c2 = c();
        if (c2 instanceof u) {
            Throwable th = ((u) c2).f30513a;
            kotlin.coroutines.c cVar = this;
            if (ag.c() && (cVar instanceof c)) {
                th = v.b(th, (c) cVar);
            }
            throw th;
        } else if (!ao.a(this.f30305a) || (bgVar = (bg) getContext().get(bg.f30343b)) == null || bgVar.a()) {
            return a(c2);
        } else {
            Throwable i2 = bgVar.i();
            a(c2, i2);
            kotlin.coroutines.c cVar2 = this;
            if (ag.c() && (cVar2 instanceof c)) {
                i2 = v.b(i2, (c) cVar2);
            }
            throw i2;
        }
    }

    public c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f30442b;
        if (!(cVar instanceof c)) {
            cVar = null;
        }
        return (c) cVar;
    }

    public f getContext() {
        return this.f30443c;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final void h() {
        aq j2 = j();
        if (j2 != null) {
            j2.a();
        }
        a((aq) br.f30364a);
    }

    /* access modifiers changed from: protected */
    public String i() {
        return "CancellableContinuation";
    }

    public void resumeWith(Object obj) {
        a(this, x.a(obj, (j<?>) this), this.f30305a, (b) null, 4, (Object) null);
    }

    public String toString() {
        return i() + '(' + ah.a((kotlin.coroutines.c<?>) this.f30442b) + "){" + c() + "}@" + ah.a((Object) this);
    }
}
