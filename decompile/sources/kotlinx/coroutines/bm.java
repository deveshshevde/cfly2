package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.f;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.internal.d;
import kotlinx.coroutines.internal.k;
import kotlinx.coroutines.internal.l;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.internal.v;
import mm.m;

public class bm implements bg, bt, q {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f30347a = AtomicReferenceFieldUpdater.newUpdater(bm.class, Object.class, "_state");
    private volatile Object _parentHandle;
    private volatile Object _state;

    private static final class a extends bl<bg> {

        /* renamed from: a  reason: collision with root package name */
        private final bm f30348a;

        /* renamed from: e  reason: collision with root package name */
        private final b f30349e;

        /* renamed from: f  reason: collision with root package name */
        private final p f30350f;

        /* renamed from: g  reason: collision with root package name */
        private final Object f30351g;

        public a(bm bmVar, b bVar, p pVar, Object obj) {
            super(pVar.f30446a);
            this.f30348a = bmVar;
            this.f30349e = bVar;
            this.f30350f = pVar;
            this.f30351g = obj;
        }

        public void a(Throwable th) {
            this.f30348a.b(this.f30349e, this.f30350f, this.f30351g);
        }

        public /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return l.f30254a;
        }
    }

    private static final class b implements bb {
        private volatile Object _exceptionsHolder = null;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* renamed from: a  reason: collision with root package name */
        private final bq f30352a;

        public b(bq bqVar, boolean z2, Throwable th) {
            this.f30352a = bqVar;
            this._isCompleting = z2 ? 1 : 0;
            this._rootCause = th;
        }

        private final void a(Object obj) {
            this._exceptionsHolder = obj;
        }

        private final Object g() {
            return this._exceptionsHolder;
        }

        private final ArrayList<Throwable> h() {
            return new ArrayList<>(4);
        }

        public final void a(Throwable th) {
            this._rootCause = th;
        }

        public final void a(boolean z2) {
            this._isCompleting = z2 ? 1 : 0;
        }

        public final List<Throwable> b(Throwable th) {
            ArrayList<Throwable> arrayList;
            Object g2 = g();
            if (g2 == null) {
                arrayList = h();
            } else if (g2 instanceof Throwable) {
                ArrayList<Throwable> h2 = h();
                h2.add(g2);
                l lVar = l.f30254a;
                arrayList = h2;
            } else if (g2 instanceof ArrayList) {
                arrayList = (ArrayList) g2;
            } else {
                throw new IllegalStateException(("State is " + g2).toString());
            }
            Throwable d2 = d();
            if (d2 != null) {
                arrayList.add(0, d2);
            }
            if (th != null && (!h.a((Object) th, (Object) d2))) {
                arrayList.add(th);
            }
            a((Object) bn.f30360e);
            return arrayList;
        }

        public boolean b() {
            return d() == null;
        }

        public final void c(Throwable th) {
            Throwable d2 = d();
            if (d2 == null) {
                a(th);
            } else if (th != d2) {
                Object g2 = g();
                if (g2 == null) {
                    a((Object) th);
                } else if (g2 instanceof Throwable) {
                    if (th != g2) {
                        ArrayList<Throwable> h2 = h();
                        h2.add(g2);
                        h2.add(th);
                        l lVar = l.f30254a;
                        a((Object) h2);
                    }
                } else if (g2 instanceof ArrayList) {
                    ((ArrayList) g2).add(th);
                } else {
                    throw new IllegalStateException(("State is " + g2).toString());
                }
            }
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
        public final boolean c() {
            return this._isCompleting;
        }

        public final Throwable d() {
            return (Throwable) this._rootCause;
        }

        public final boolean e() {
            return g() == bn.f30360e;
        }

        public final boolean f() {
            return d() != null;
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + c() + ", rootCause=" + d() + ", exceptions=" + g() + ", list=" + z_() + ']';
        }

        public bq z_() {
            return this.f30352a;
        }
    }

    public static final class c extends l.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.internal.l f30353a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ bm f30354b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f30355c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(kotlinx.coroutines.internal.l lVar, kotlinx.coroutines.internal.l lVar2, bm bmVar, Object obj) {
            super(lVar2);
            this.f30353a = lVar;
            this.f30354b = bmVar;
            this.f30355c = obj;
        }

        public Object a(kotlinx.coroutines.internal.l lVar) {
            if (this.f30354b.l() == this.f30355c) {
                return null;
            }
            return k.a();
        }
    }

    public bm(boolean z2) {
        this._state = z2 ? bn.f30362g : bn.f30361f;
        this._parentHandle = null;
    }

    private final int a(Object obj) {
        if (obj instanceof as) {
            if (((as) obj).b()) {
                return 0;
            }
            if (!f30347a.compareAndSet(this, obj, bn.f30362g)) {
                return -1;
            }
            e();
            return 1;
        } else if (!(obj instanceof ba)) {
            return 0;
        } else {
            if (!f30347a.compareAndSet(this, obj, ((ba) obj).z_())) {
                return -1;
            }
            e();
            return 1;
        }
    }

    private final Object a(Object obj, Object obj2) {
        return !(obj instanceof bb) ? bn.f30357b : (((obj instanceof as) || (obj instanceof bl)) && !(obj instanceof p) && !(obj2 instanceof u)) ? a((bb) obj, obj2) ? obj2 : bn.f30358c : c((bb) obj, obj2);
    }

    private final Object a(b bVar, Object obj) {
        boolean f2;
        Throwable a2;
        boolean z2 = true;
        if (ag.a()) {
            if (!(l() == bVar)) {
                throw new AssertionError();
            }
        }
        if (ag.a() && !(!bVar.e())) {
            throw new AssertionError();
        } else if (!ag.a() || bVar.c()) {
            u uVar = (u) (!(obj instanceof u) ? null : obj);
            Throwable th = uVar != null ? uVar.f30513a : null;
            synchronized (bVar) {
                f2 = bVar.f();
                List<Throwable> b2 = bVar.b(th);
                a2 = a(bVar, (List<? extends Throwable>) b2);
                if (a2 != null) {
                    a(a2, (List<? extends Throwable>) b2);
                }
            }
            if (!(a2 == null || a2 == th)) {
                obj = new u(a2, false, 2, (f) null);
            }
            if (a2 != null) {
                if (!f(a2) && !e(a2)) {
                    z2 = false;
                }
                if (z2) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                    ((u) obj).c();
                }
            }
            if (!f2) {
                d(a2);
            }
            b(obj);
            boolean compareAndSet = f30347a.compareAndSet(this, bVar, bn.a(obj));
            if (!ag.a() || compareAndSet) {
                b((bb) bVar, obj);
                return obj;
            }
            throw new AssertionError();
        } else {
            throw new AssertionError();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Throwable a(kotlinx.coroutines.bm.b r6, java.util.List<? extends java.lang.Throwable> r7) {
        /*
            r5 = this;
            boolean r0 = r7.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r6 = r6.f()
            if (r6 == 0) goto L_0x0021
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            kotlinx.coroutines.JobCancellationException r6 = new kotlinx.coroutines.JobCancellationException
            java.lang.String r7 = r5.f()
            r0 = r5
            kotlinx.coroutines.bg r0 = (kotlinx.coroutines.bg) r0
            r6.<init>(r7, r1, r0)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            return r6
        L_0x0021:
            return r1
        L_0x0022:
            r6 = r7
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r0 = r6.iterator()
        L_0x0029:
            boolean r2 = r0.hasNext()
            r3 = 1
            if (r2 == 0) goto L_0x003d
            java.lang.Object r2 = r0.next()
            r4 = r2
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r4 = r4 instanceof java.util.concurrent.CancellationException
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x0029
            goto L_0x003e
        L_0x003d:
            r2 = r1
        L_0x003e:
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            if (r2 == 0) goto L_0x0043
            return r2
        L_0x0043:
            r0 = 0
            java.lang.Object r7 = r7.get(r0)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            boolean r2 = r7 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r2 == 0) goto L_0x0070
            java.util.Iterator r6 = r6.iterator()
        L_0x0052:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x006b
            java.lang.Object r2 = r6.next()
            r4 = r2
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            if (r4 == r7) goto L_0x0067
            boolean r4 = r4 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r4 == 0) goto L_0x0067
            r4 = 1
            goto L_0x0068
        L_0x0067:
            r4 = 0
        L_0x0068:
            if (r4 == 0) goto L_0x0052
            r1 = r2
        L_0x006b:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            if (r1 == 0) goto L_0x0070
            return r1
        L_0x0070:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.bm.a(kotlinx.coroutines.bm$b, java.util.List):java.lang.Throwable");
    }

    public static /* synthetic */ CancellationException a(bm bmVar, Throwable th, String str, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            return bmVar.a(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        if (r2 != null) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlinx.coroutines.bl<?> a(mm.b<? super java.lang.Throwable, kotlin.l> r5, boolean r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            if (r6 == 0) goto L_0x003a
            boolean r6 = r5 instanceof kotlinx.coroutines.bh
            if (r6 != 0) goto L_0x000a
            goto L_0x000b
        L_0x000a:
            r2 = r5
        L_0x000b:
            kotlinx.coroutines.bh r2 = (kotlinx.coroutines.bh) r2
            if (r2 == 0) goto L_0x002c
            boolean r6 = kotlinx.coroutines.ag.a()
            if (r6 == 0) goto L_0x0029
            kotlinx.coroutines.bg r6 = r2.f30346b
            r3 = r4
            kotlinx.coroutines.bm r3 = (kotlinx.coroutines.bm) r3
            if (r6 != r3) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 == 0) goto L_0x0021
            goto L_0x0029
        L_0x0021:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            throw r5
        L_0x0029:
            if (r2 == 0) goto L_0x002c
            goto L_0x0037
        L_0x002c:
            kotlinx.coroutines.be r6 = new kotlinx.coroutines.be
            r0 = r4
            kotlinx.coroutines.bg r0 = (kotlinx.coroutines.bg) r0
            r6.<init>(r0, r5)
            r2 = r6
            kotlinx.coroutines.bh r2 = (kotlinx.coroutines.bh) r2
        L_0x0037:
            kotlinx.coroutines.bl r2 = (kotlinx.coroutines.bl) r2
            goto L_0x0070
        L_0x003a:
            boolean r6 = r5 instanceof kotlinx.coroutines.bl
            if (r6 != 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r2 = r5
        L_0x0040:
            kotlinx.coroutines.bl r2 = (kotlinx.coroutines.bl) r2
            if (r2 == 0) goto L_0x0065
            boolean r6 = kotlinx.coroutines.ag.a()
            if (r6 == 0) goto L_0x0062
            J r6 = r2.f30346b
            r3 = r4
            kotlinx.coroutines.bm r3 = (kotlinx.coroutines.bm) r3
            if (r6 != r3) goto L_0x0056
            boolean r6 = r2 instanceof kotlinx.coroutines.bh
            if (r6 != 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r0 = 0
        L_0x0057:
            if (r0 == 0) goto L_0x005a
            goto L_0x0062
        L_0x005a:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            throw r5
        L_0x0062:
            if (r2 == 0) goto L_0x0065
            goto L_0x0070
        L_0x0065:
            kotlinx.coroutines.bf r6 = new kotlinx.coroutines.bf
            r0 = r4
            kotlinx.coroutines.bg r0 = (kotlinx.coroutines.bg) r0
            r6.<init>(r0, r5)
            r2 = r6
            kotlinx.coroutines.bl r2 = (kotlinx.coroutines.bl) r2
        L_0x0070:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.bm.a(mm.b, boolean):kotlinx.coroutines.bl");
    }

    private final bq a(bb bbVar) {
        bq z_ = bbVar.z_();
        if (z_ != null) {
            return z_;
        }
        if (bbVar instanceof as) {
            return new bq();
        }
        if (bbVar instanceof bl) {
            b((bl<?>) (bl) bbVar);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + bbVar).toString());
    }

    private final p a(kotlinx.coroutines.internal.l lVar) {
        while (lVar.d()) {
            lVar = lVar.g();
        }
        while (true) {
            lVar = lVar.f();
            if (!lVar.d()) {
                if (lVar instanceof p) {
                    return (p) lVar;
                }
                if (lVar instanceof bq) {
                    return null;
                }
            }
        }
    }

    private final void a(Throwable th, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set a2 = d.a(list.size());
            Throwable a3 = !ag.c() ? th : v.a(th);
            for (Throwable th2 : list) {
                if (ag.c()) {
                    th2 = v.a(th2);
                }
                if (th2 != th && th2 != a3 && !(th2 instanceof CancellationException) && a2.add(th2)) {
                    kotlin.a.a(th, th2);
                }
            }
        }
    }

    private final void a(as asVar) {
        bq bqVar = new bq();
        f30347a.compareAndSet(this, asVar, asVar.b() ? bqVar : new ba(bqVar));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r1 != null) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(kotlinx.coroutines.bq r9, java.lang.Throwable r10) {
        /*
            r8 = this;
            r8.d((java.lang.Throwable) r10)
            r0 = 0
            r1 = r0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            kotlinx.coroutines.internal.j r9 = (kotlinx.coroutines.internal.j) r9
            java.lang.Object r2 = r9.e()
            kotlinx.coroutines.internal.l r2 = (kotlinx.coroutines.internal.l) r2
        L_0x000f:
            boolean r3 = kotlin.jvm.internal.h.a((java.lang.Object) r2, (java.lang.Object) r9)
            r3 = r3 ^ 1
            if (r3 == 0) goto L_0x0060
            if (r2 == 0) goto L_0x0060
            boolean r3 = r2 instanceof kotlinx.coroutines.bh
            if (r3 == 0) goto L_0x0053
            r3 = r2
            kotlinx.coroutines.bl r3 = (kotlinx.coroutines.bl) r3
            r3.a(r10)     // Catch:{ all -> 0x0024 }
            goto L_0x0053
        L_0x0024:
            r4 = move-exception
            if (r1 == 0) goto L_0x002d
            kotlin.a.a(r1, r4)
            if (r1 == 0) goto L_0x002d
            goto L_0x0053
        L_0x002d:
            r1 = r8
            kotlinx.coroutines.bm r1 = (kotlinx.coroutines.bm) r1
            kotlinx.coroutines.CompletionHandlerException r5 = new kotlinx.coroutines.CompletionHandlerException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Exception in completion handler "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = " for "
            r6.append(r3)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            r5.<init>(r1, r4)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            kotlin.l r1 = kotlin.l.f30254a
            r1 = r5
        L_0x0053:
            java.lang.Object r2 = r2.e()
            if (r2 == 0) goto L_0x005e
            kotlinx.coroutines.internal.l r2 = kotlinx.coroutines.internal.k.a(r2)
            goto L_0x000f
        L_0x005e:
            r2 = r0
            goto L_0x000f
        L_0x0060:
            if (r1 == 0) goto L_0x0065
            r8.a((java.lang.Throwable) r1)
        L_0x0065:
            r8.f((java.lang.Throwable) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.bm.a(kotlinx.coroutines.bq, java.lang.Throwable):void");
    }

    private final boolean a(Object obj, bq bqVar, bl<?> blVar) {
        int a2;
        kotlinx.coroutines.internal.l lVar = bqVar;
        kotlinx.coroutines.internal.l lVar2 = blVar;
        l.a cVar = new c(lVar2, lVar2, this, obj);
        do {
            kotlinx.coroutines.internal.l h2 = lVar.h();
            if (h2 == null) {
                break;
            }
            a2 = h2.a(lVar2, lVar, cVar);
            if (a2 == 1) {
                return true;
            }
        } while (a2 != 2);
        return false;
    }

    private final boolean a(bb bbVar, Object obj) {
        if (ag.a()) {
            if (!((bbVar instanceof as) || (bbVar instanceof bl))) {
                throw new AssertionError();
            }
        }
        if (ag.a() && !(!(obj instanceof u))) {
            throw new AssertionError();
        } else if (!f30347a.compareAndSet(this, bbVar, bn.a(obj))) {
            return false;
        } else {
            d((Throwable) null);
            b(obj);
            b(bbVar, obj);
            return true;
        }
    }

    private final boolean a(bb bbVar, Throwable th) {
        if (ag.a() && !(!(bbVar instanceof b))) {
            throw new AssertionError();
        } else if (!ag.a() || bbVar.b()) {
            bq a2 = a(bbVar);
            if (a2 == null) {
                return false;
            }
            if (!f30347a.compareAndSet(this, bbVar, new b(a2, false, th))) {
                return false;
            }
            a(a2, th);
            return true;
        } else {
            throw new AssertionError();
        }
    }

    private final boolean a(b bVar, p pVar, Object obj) {
        while (bg.a.a(pVar.f30446a, false, false, new a(this, bVar, pVar, obj), 1, (Object) null) == br.f30364a) {
            pVar = a((kotlinx.coroutines.internal.l) pVar);
            if (pVar == null) {
                return false;
            }
        }
        return true;
    }

    private final p b(bb bbVar) {
        p pVar = (p) (!(bbVar instanceof p) ? null : bbVar);
        if (pVar != null) {
            return pVar;
        }
        bq z_ = bbVar.z_();
        if (z_ != null) {
            return a((kotlinx.coroutines.internal.l) z_);
        }
        return null;
    }

    private final void b(bb bbVar, Object obj) {
        o k2 = k();
        if (k2 != null) {
            k2.a();
            a((o) br.f30364a);
        }
        Throwable th = null;
        if (!(obj instanceof u)) {
            obj = null;
        }
        u uVar = (u) obj;
        if (uVar != null) {
            th = uVar.f30513a;
        }
        if (bbVar instanceof bl) {
            try {
                ((bl) bbVar).a(th);
            } catch (Throwable th2) {
                a((Throwable) new CompletionHandlerException("Exception in completion handler " + bbVar + " for " + this, th2));
            }
        } else {
            bq z_ = bbVar.z_();
            if (z_ != null) {
                b(z_, th);
            }
        }
    }

    private final void b(bl<?> blVar) {
        blVar.a((kotlinx.coroutines.internal.l) new bq());
        f30347a.compareAndSet(this, blVar, blVar.f());
    }

    /* access modifiers changed from: private */
    public final void b(b bVar, p pVar, Object obj) {
        if (ag.a()) {
            if (!(l() == bVar)) {
                throw new AssertionError();
            }
        }
        p a2 = a((kotlinx.coroutines.internal.l) pVar);
        if (a2 == null || !a(bVar, a2, obj)) {
            d(a(bVar, obj));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r1 != null) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(kotlinx.coroutines.bq r9, java.lang.Throwable r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = r0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            kotlinx.coroutines.internal.j r9 = (kotlinx.coroutines.internal.j) r9
            java.lang.Object r2 = r9.e()
            kotlinx.coroutines.internal.l r2 = (kotlinx.coroutines.internal.l) r2
        L_0x000c:
            boolean r3 = kotlin.jvm.internal.h.a((java.lang.Object) r2, (java.lang.Object) r9)
            r3 = r3 ^ 1
            if (r3 == 0) goto L_0x005d
            if (r2 == 0) goto L_0x005d
            boolean r3 = r2 instanceof kotlinx.coroutines.bl
            if (r3 == 0) goto L_0x0050
            r3 = r2
            kotlinx.coroutines.bl r3 = (kotlinx.coroutines.bl) r3
            r3.a(r10)     // Catch:{ all -> 0x0021 }
            goto L_0x0050
        L_0x0021:
            r4 = move-exception
            if (r1 == 0) goto L_0x002a
            kotlin.a.a(r1, r4)
            if (r1 == 0) goto L_0x002a
            goto L_0x0050
        L_0x002a:
            r1 = r8
            kotlinx.coroutines.bm r1 = (kotlinx.coroutines.bm) r1
            kotlinx.coroutines.CompletionHandlerException r5 = new kotlinx.coroutines.CompletionHandlerException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Exception in completion handler "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = " for "
            r6.append(r3)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            r5.<init>(r1, r4)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            kotlin.l r1 = kotlin.l.f30254a
            r1 = r5
        L_0x0050:
            java.lang.Object r2 = r2.e()
            if (r2 == 0) goto L_0x005b
            kotlinx.coroutines.internal.l r2 = kotlinx.coroutines.internal.k.a(r2)
            goto L_0x000c
        L_0x005b:
            r2 = r0
            goto L_0x000c
        L_0x005d:
            if (r1 == 0) goto L_0x0062
            r8.a((java.lang.Throwable) r1)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.bm.b(kotlinx.coroutines.bq, java.lang.Throwable):void");
    }

    private final Object c(Object obj) {
        Object a2;
        do {
            Object l2 = l();
            if (!(l2 instanceof bb) || ((l2 instanceof b) && ((b) l2).c())) {
                return bn.f30357b;
            }
            a2 = a(l2, (Object) new u(g(obj), false, 2, (f) null));
        } while (a2 == bn.f30358c);
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0072, code lost:
        if (r2 == null) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0074, code lost:
        a(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0077, code lost:
        r7 = b(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x007b, code lost:
        if (r7 == null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0081, code lost:
        if (a(r1, r7, r8) == false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0085, code lost:
        return kotlinx.coroutines.bn.f30356a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x008a, code lost:
        return a(r1, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object c(kotlinx.coroutines.bb r7, java.lang.Object r8) {
        /*
            r6 = this;
            kotlinx.coroutines.bq r0 = r6.a((kotlinx.coroutines.bb) r7)
            if (r0 == 0) goto L_0x008e
            boolean r1 = r7 instanceof kotlinx.coroutines.bm.b
            r2 = 0
            if (r1 != 0) goto L_0x000d
            r1 = r2
            goto L_0x000e
        L_0x000d:
            r1 = r7
        L_0x000e:
            kotlinx.coroutines.bm$b r1 = (kotlinx.coroutines.bm.b) r1
            if (r1 == 0) goto L_0x0013
            goto L_0x0019
        L_0x0013:
            kotlinx.coroutines.bm$b r1 = new kotlinx.coroutines.bm$b
            r3 = 0
            r1.<init>(r0, r3, r2)
        L_0x0019:
            r3 = r2
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            monitor-enter(r1)
            boolean r3 = r1.c()     // Catch:{ all -> 0x008b }
            if (r3 == 0) goto L_0x0029
            kotlinx.coroutines.internal.w r7 = kotlinx.coroutines.bn.f30357b     // Catch:{ all -> 0x008b }
            monitor-exit(r1)
            return r7
        L_0x0029:
            r3 = 1
            r1.a((boolean) r3)     // Catch:{ all -> 0x008b }
            if (r1 == r7) goto L_0x003d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f30347a     // Catch:{ all -> 0x008b }
            boolean r4 = r4.compareAndSet(r6, r7, r1)     // Catch:{ all -> 0x008b }
            if (r4 != 0) goto L_0x003d
            kotlinx.coroutines.internal.w r7 = kotlinx.coroutines.bn.f30358c     // Catch:{ all -> 0x008b }
            monitor-exit(r1)
            return r7
        L_0x003d:
            boolean r4 = kotlinx.coroutines.ag.a()     // Catch:{ all -> 0x008b }
            if (r4 == 0) goto L_0x0053
            boolean r4 = r1.e()     // Catch:{ all -> 0x008b }
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x004b
            goto L_0x0053
        L_0x004b:
            java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch:{ all -> 0x008b }
            r7.<init>()     // Catch:{ all -> 0x008b }
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x008b }
            throw r7     // Catch:{ all -> 0x008b }
        L_0x0053:
            boolean r4 = r1.f()     // Catch:{ all -> 0x008b }
            boolean r5 = r8 instanceof kotlinx.coroutines.u     // Catch:{ all -> 0x008b }
            if (r5 != 0) goto L_0x005d
            r5 = r2
            goto L_0x005e
        L_0x005d:
            r5 = r8
        L_0x005e:
            kotlinx.coroutines.u r5 = (kotlinx.coroutines.u) r5     // Catch:{ all -> 0x008b }
            if (r5 == 0) goto L_0x0067
            java.lang.Throwable r5 = r5.f30513a     // Catch:{ all -> 0x008b }
            r1.c(r5)     // Catch:{ all -> 0x008b }
        L_0x0067:
            java.lang.Throwable r5 = r1.d()     // Catch:{ all -> 0x008b }
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x006f
            r2 = r5
        L_0x006f:
            kotlin.l r3 = kotlin.l.f30254a     // Catch:{ all -> 0x008b }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x0077
            r6.a((kotlinx.coroutines.bq) r0, (java.lang.Throwable) r2)
        L_0x0077:
            kotlinx.coroutines.p r7 = r6.b((kotlinx.coroutines.bb) r7)
            if (r7 == 0) goto L_0x0086
            boolean r7 = r6.a((kotlinx.coroutines.bm.b) r1, (kotlinx.coroutines.p) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x0086
            kotlinx.coroutines.internal.w r7 = kotlinx.coroutines.bn.f30356a
            return r7
        L_0x0086:
            java.lang.Object r7 = r6.a((kotlinx.coroutines.bm.b) r1, (java.lang.Object) r8)
            return r7
        L_0x008b:
            r7 = move-exception
            monitor-exit(r1)
            throw r7
        L_0x008e:
            kotlinx.coroutines.internal.w r7 = kotlinx.coroutines.bn.f30358c
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.bm.c(kotlinx.coroutines.bb, java.lang.Object):java.lang.Object");
    }

    private final boolean f(Throwable th) {
        if (o()) {
            return true;
        }
        boolean z2 = th instanceof CancellationException;
        o k2 = k();
        return (k2 == null || k2 == br.f30364a) ? z2 : k2.b(th) || z2;
    }

    private final Throwable g(Object obj) {
        if (!(obj != null ? obj instanceof Throwable : true)) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
            obj = ((bt) obj).n();
        } else if (obj == null) {
            String str = null;
            return new JobCancellationException(f(), (Throwable) null, this);
        }
        return (Throwable) obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        if (r0 == null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        a(((kotlinx.coroutines.bm.b) r2).z_(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0050, code lost:
        return kotlinx.coroutines.bn.c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object h(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
        L_0x0004:
            java.lang.Object r2 = r6.l()
            boolean r3 = r2 instanceof kotlinx.coroutines.bm.b
            if (r3 == 0) goto L_0x0054
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.bm$b r3 = (kotlinx.coroutines.bm.b) r3     // Catch:{ all -> 0x0051 }
            boolean r3 = r3.e()     // Catch:{ all -> 0x0051 }
            if (r3 == 0) goto L_0x001c
            kotlinx.coroutines.internal.w r7 = kotlinx.coroutines.bn.f30359d     // Catch:{ all -> 0x0051 }
            monitor-exit(r2)
            return r7
        L_0x001c:
            r3 = r2
            kotlinx.coroutines.bm$b r3 = (kotlinx.coroutines.bm.b) r3     // Catch:{ all -> 0x0051 }
            boolean r3 = r3.f()     // Catch:{ all -> 0x0051 }
            if (r7 != 0) goto L_0x0027
            if (r3 != 0) goto L_0x0034
        L_0x0027:
            if (r1 == 0) goto L_0x002a
            goto L_0x002e
        L_0x002a:
            java.lang.Throwable r1 = r6.g(r7)     // Catch:{ all -> 0x0051 }
        L_0x002e:
            r7 = r2
            kotlinx.coroutines.bm$b r7 = (kotlinx.coroutines.bm.b) r7     // Catch:{ all -> 0x0051 }
            r7.c(r1)     // Catch:{ all -> 0x0051 }
        L_0x0034:
            r7 = r2
            kotlinx.coroutines.bm$b r7 = (kotlinx.coroutines.bm.b) r7     // Catch:{ all -> 0x0051 }
            java.lang.Throwable r7 = r7.d()     // Catch:{ all -> 0x0051 }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x0040
            r0 = r7
        L_0x0040:
            monitor-exit(r2)
            if (r0 == 0) goto L_0x004c
            kotlinx.coroutines.bm$b r2 = (kotlinx.coroutines.bm.b) r2
            kotlinx.coroutines.bq r7 = r2.z_()
            r6.a((kotlinx.coroutines.bq) r7, (java.lang.Throwable) r0)
        L_0x004c:
            kotlinx.coroutines.internal.w r7 = kotlinx.coroutines.bn.f30357b
            return r7
        L_0x0051:
            r7 = move-exception
            monitor-exit(r2)
            throw r7
        L_0x0054:
            boolean r3 = r2 instanceof kotlinx.coroutines.bb
            if (r3 == 0) goto L_0x00aa
            if (r1 == 0) goto L_0x005b
            goto L_0x005f
        L_0x005b:
            java.lang.Throwable r1 = r6.g(r7)
        L_0x005f:
            r3 = r2
            kotlinx.coroutines.bb r3 = (kotlinx.coroutines.bb) r3
            boolean r4 = r3.b()
            if (r4 == 0) goto L_0x0073
            boolean r2 = r6.a((kotlinx.coroutines.bb) r3, (java.lang.Throwable) r1)
            if (r2 == 0) goto L_0x0004
            kotlinx.coroutines.internal.w r7 = kotlinx.coroutines.bn.f30357b
            return r7
        L_0x0073:
            kotlinx.coroutines.u r3 = new kotlinx.coroutines.u
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.a((java.lang.Object) r2, (java.lang.Object) r3)
            kotlinx.coroutines.internal.w r4 = kotlinx.coroutines.bn.f30357b
            if (r3 == r4) goto L_0x008d
            kotlinx.coroutines.internal.w r2 = kotlinx.coroutines.bn.f30358c
            if (r3 != r2) goto L_0x008c
            goto L_0x0004
        L_0x008c:
            return r3
        L_0x008d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Cannot happen in "
            r7.append(r0)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x00aa:
            kotlinx.coroutines.internal.w r7 = kotlinx.coroutines.bn.f30359d
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.bm.h(java.lang.Object):java.lang.Object");
    }

    private final Throwable i(Object obj) {
        if (!(obj instanceof u)) {
            obj = null;
        }
        u uVar = (u) obj;
        if (uVar != null) {
            return uVar.f30513a;
        }
        return null;
    }

    private final String j(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof bb ? ((bb) obj).b() ? "Active" : "New" : obj instanceof u ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.f() ? "Cancelling" : bVar.c() ? "Completing" : "Active";
    }

    /* access modifiers changed from: protected */
    public final CancellationException a(Throwable th, String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException != null) {
            return cancellationException;
        }
        if (str == null) {
            str = f();
        }
        return new JobCancellationException(str, th, this);
    }

    public final aq a(boolean z2, boolean z3, mm.b<? super Throwable, kotlin.l> bVar) {
        Throwable th = null;
        bl<?> blVar = null;
        while (true) {
            Object l2 = l();
            if (l2 instanceof as) {
                as asVar = (as) l2;
                if (asVar.b()) {
                    if (blVar == null) {
                        blVar = a(bVar, z2);
                    }
                    if (f30347a.compareAndSet(this, l2, blVar)) {
                        return blVar;
                    }
                } else {
                    a(asVar);
                }
            } else if (l2 instanceof bb) {
                bq z_ = ((bb) l2).z_();
                if (z_ == null) {
                    Objects.requireNonNull(l2, "null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                    b((bl<?>) (bl) l2);
                } else {
                    Throwable th2 = null;
                    aq aqVar = br.f30364a;
                    if (z2 && (l2 instanceof b)) {
                        synchronized (l2) {
                            th2 = ((b) l2).d();
                            if (th2 == null || ((bVar instanceof p) && !((b) l2).c())) {
                                if (blVar == null) {
                                    blVar = a(bVar, z2);
                                }
                                if (a(l2, z_, blVar)) {
                                    if (th2 == null) {
                                        aq aqVar2 = blVar;
                                        return aqVar2;
                                    }
                                    aqVar = blVar;
                                }
                            }
                            kotlin.l lVar = kotlin.l.f30254a;
                        }
                    }
                    if (th2 != null) {
                        if (z3) {
                            bVar.invoke(th2);
                        }
                        return aqVar;
                    }
                    if (blVar == null) {
                        blVar = a(bVar, z2);
                    }
                    if (a(l2, z_, blVar)) {
                        return blVar;
                    }
                }
            } else {
                if (z3) {
                    if (!(l2 instanceof u)) {
                        l2 = null;
                    }
                    u uVar = (u) l2;
                    if (uVar != null) {
                        th = uVar.f30513a;
                    }
                    bVar.invoke(th);
                }
                return br.f30364a;
            }
        }
    }

    public final o a(q qVar) {
        aq a2 = bg.a.a(this, true, false, new p(this, qVar), 2, (Object) null);
        Objects.requireNonNull(a2, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (o) a2;
    }

    public void a(Throwable th) {
        throw th;
    }

    public void a(CancellationException cancellationException) {
        if (cancellationException == null) {
            String str = null;
            cancellationException = new JobCancellationException(f(), (Throwable) null, this);
        }
        b((Throwable) cancellationException);
    }

    public final void a(bg bgVar) {
        if (ag.a()) {
            if (!(k() == null)) {
                throw new AssertionError();
            }
        }
        if (bgVar == null) {
            a((o) br.f30364a);
            return;
        }
        bgVar.j();
        o a2 = bgVar.a((q) this);
        a(a2);
        if (m()) {
            a2.a();
            a((o) br.f30364a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(kotlinx.coroutines.bl<?> r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.l()
            boolean r1 = r0 instanceof kotlinx.coroutines.bl
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f30347a
            kotlinx.coroutines.as r2 = kotlinx.coroutines.bn.f30362g
            boolean r0 = r1.compareAndSet(r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            boolean r1 = r0 instanceof kotlinx.coroutines.bb
            if (r1 == 0) goto L_0x0027
            kotlinx.coroutines.bb r0 = (kotlinx.coroutines.bb) r0
            kotlinx.coroutines.bq r0 = r0.z_()
            if (r0 == 0) goto L_0x0027
            r4.c()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.bm.a(kotlinx.coroutines.bl):void");
    }

    public final void a(bt btVar) {
        e((Object) btVar);
    }

    public final void a(o oVar) {
        this._parentHandle = oVar;
    }

    public boolean a() {
        Object l2 = l();
        return (l2 instanceof bb) && ((bb) l2).b();
    }

    /* access modifiers changed from: protected */
    public void b(Object obj) {
    }

    public void b(Throwable th) {
        e((Object) th);
    }

    public boolean b() {
        return true;
    }

    public boolean c(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return e((Object) th) && b();
    }

    /* access modifiers changed from: protected */
    public void d(Object obj) {
    }

    /* access modifiers changed from: protected */
    public void d(Throwable th) {
    }

    public void e() {
    }

    public final boolean e(Object obj) {
        Object c2 = bn.f30357b;
        if (y_() && (c2 = c(obj)) == bn.f30356a) {
            return true;
        }
        if (c2 == bn.f30357b) {
            c2 = h(obj);
        }
        if (c2 == bn.f30357b || c2 == bn.f30356a) {
            return true;
        }
        if (c2 == bn.f30359d) {
            return false;
        }
        d(c2);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean e(Throwable th) {
        return false;
    }

    public final Object f(Object obj) {
        Object a2;
        do {
            a2 = a(l(), obj);
            if (a2 == bn.f30357b) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, " + "but is being completed with " + obj, i(obj));
            }
        } while (a2 == bn.f30358c);
        return a2;
    }

    /* access modifiers changed from: protected */
    public String f() {
        return "Job was cancelled";
    }

    public <R> R fold(R r2, m<? super R, ? super f.b, ? extends R> mVar) {
        return bg.a.a(this, r2, mVar);
    }

    public String g() {
        return ah.b(this);
    }

    public <E extends f.b> E get(f.c<E> cVar) {
        return bg.a.a((bg) this, cVar);
    }

    public final f.c<?> getKey() {
        return bg.f30343b;
    }

    public final CancellationException i() {
        Object l2 = l();
        if (l2 instanceof b) {
            Throwable d2 = ((b) l2).d();
            if (d2 != null) {
                CancellationException a2 = a(d2, ah.b(this) + " is cancelling");
                if (a2 != null) {
                    return a2;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (l2 instanceof bb) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (l2 instanceof u) {
            return a(this, ((u) l2).f30513a, (String) null, 1, (Object) null);
        } else {
            return new JobCancellationException(ah.b(this) + " has completed normally", (Throwable) null, this);
        }
    }

    public final boolean j() {
        int a2;
        do {
            a2 = a(l());
            if (a2 == 0) {
                return false;
            }
        } while (a2 != 1);
        return true;
    }

    public final o k() {
        return (o) this._parentHandle;
    }

    public final Object l() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof r)) {
                return obj;
            }
            ((r) obj).c(this);
        }
    }

    public final boolean m() {
        return !(l() instanceof bb);
    }

    public f minusKey(f.c<?> cVar) {
        return bg.a.b(this, cVar);
    }

    public CancellationException n() {
        Throwable th;
        Object l2 = l();
        CancellationException cancellationException = null;
        if (l2 instanceof b) {
            th = ((b) l2).d();
        } else if (l2 instanceof u) {
            th = ((u) l2).f30513a;
        } else if (!(l2 instanceof bb)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + l2).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = th;
        }
        CancellationException cancellationException2 = cancellationException;
        if (cancellationException2 != null) {
            return cancellationException2;
        }
        return new JobCancellationException("Parent job is " + j(l2), th, this);
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return false;
    }

    public final String p() {
        return g() + '{' + j(l()) + '}';
    }

    public f plus(f fVar) {
        return bg.a.a((bg) this, fVar);
    }

    public String toString() {
        return p() + '@' + ah.a((Object) this);
    }

    public boolean y_() {
        return false;
    }
}
