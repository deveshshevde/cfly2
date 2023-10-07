package kotlinx.coroutines;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.f;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlinx.coroutines.internal.ab;
import kotlinx.coroutines.internal.ac;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.u;
import mr.d;

public abstract class au extends av implements ak {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f30324b;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f30325d;
    private volatile Object _delayed = null;
    private volatile int _isCompleted = 0;
    private volatile Object _queue = null;

    private static final class a extends b {

        /* renamed from: b  reason: collision with root package name */
        private final j<l> f30326b;

        /* renamed from: c  reason: collision with root package name */
        private final aa f30327c;

        public a(long j2, j<? super l> jVar, aa aaVar) {
            super(j2);
            this.f30326b = jVar;
            this.f30327c = aaVar;
        }

        public void run() {
            u.a((Object) this);
            this.f30326b.a(this.f30327c, l.f30254a);
        }
    }

    public static abstract class b implements Comparable<b>, Runnable, aq, ac {

        /* renamed from: a  reason: collision with root package name */
        public long f30328a;

        /* renamed from: b  reason: collision with root package name */
        private Object f30329b;

        /* renamed from: c  reason: collision with root package name */
        private int f30330c = -1;

        public b(long j2) {
            this.f30328a = j2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:36:0x004e, code lost:
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
            return r10;
         */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0046  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized int a(long r10, kotlinx.coroutines.au.c r12, kotlinx.coroutines.au r13) {
            /*
                r9 = this;
                monitor-enter(r9)
                java.lang.Object r0 = r9.f30329b     // Catch:{ all -> 0x0053 }
                kotlinx.coroutines.internal.w r1 = kotlinx.coroutines.ax.f30332a     // Catch:{ all -> 0x0053 }
                if (r0 != r1) goto L_0x000c
                r10 = 2
            L_0x000a:
                monitor-exit(r9)
                return r10
            L_0x000c:
                r0 = r12
                kotlinx.coroutines.internal.ab r0 = (kotlinx.coroutines.internal.ab) r0     // Catch:{ all -> 0x0053 }
                r1 = r9
                kotlinx.coroutines.internal.ac r1 = (kotlinx.coroutines.internal.ac) r1     // Catch:{ all -> 0x0053 }
                monitor-enter(r0)     // Catch:{ all -> 0x0053 }
                kotlinx.coroutines.internal.ac r2 = r0.e()     // Catch:{ all -> 0x0050 }
                kotlinx.coroutines.au$b r2 = (kotlinx.coroutines.au.b) r2     // Catch:{ all -> 0x0050 }
                boolean r13 = r13.k()     // Catch:{ all -> 0x0050 }
                if (r13 == 0) goto L_0x0023
                r10 = 1
                monitor-exit(r0)     // Catch:{ all -> 0x0053 }
                monitor-exit(r9)
                return r10
            L_0x0023:
                r3 = 0
                if (r2 != 0) goto L_0x002a
            L_0x0027:
                r12.f30331a = r10     // Catch:{ all -> 0x0050 }
                goto L_0x003d
            L_0x002a:
                long r5 = r2.f30328a     // Catch:{ all -> 0x0050 }
                long r7 = r5 - r10
                int r13 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                if (r13 < 0) goto L_0x0033
                goto L_0x0034
            L_0x0033:
                r10 = r5
            L_0x0034:
                long r5 = r12.f30331a     // Catch:{ all -> 0x0050 }
                long r5 = r10 - r5
                int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r13 <= 0) goto L_0x003d
                goto L_0x0027
            L_0x003d:
                long r10 = r9.f30328a     // Catch:{ all -> 0x0050 }
                long r5 = r12.f30331a     // Catch:{ all -> 0x0050 }
                long r10 = r10 - r5
                int r13 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r13 >= 0) goto L_0x004a
                long r10 = r12.f30331a     // Catch:{ all -> 0x0050 }
                r9.f30328a = r10     // Catch:{ all -> 0x0050 }
            L_0x004a:
                r0.b(r1)     // Catch:{ all -> 0x0050 }
                monitor-exit(r0)     // Catch:{ all -> 0x0053 }
                r10 = 0
                goto L_0x000a
            L_0x0050:
                r10 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0053 }
                throw r10     // Catch:{ all -> 0x0053 }
            L_0x0053:
                r10 = move-exception
                monitor-exit(r9)
                goto L_0x0057
            L_0x0056:
                throw r10
            L_0x0057:
                goto L_0x0056
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.au.b.a(long, kotlinx.coroutines.au$c, kotlinx.coroutines.au):int");
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            long j2 = this.f30328a - bVar.f30328a;
            if (j2 > 0) {
                return 1;
            }
            return j2 < 0 ? -1 : 0;
        }

        public final synchronized void a() {
            Object obj = this.f30329b;
            if (obj != ax.f30332a) {
                if (!(obj instanceof c)) {
                    obj = null;
                }
                c cVar = (c) obj;
                if (cVar != null) {
                    cVar.a(this);
                }
                this.f30329b = ax.f30332a;
                u.a((Object) this);
            }
        }

        public void a(int i2) {
            this.f30330c = i2;
        }

        public void a(ab<?> abVar) {
            if (this.f30329b != ax.f30332a) {
                this.f30329b = abVar;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public final boolean a(long j2) {
            return j2 - this.f30328a >= 0;
        }

        public ab<?> b() {
            Object obj = this.f30329b;
            if (!(obj instanceof ab)) {
                obj = null;
            }
            return (ab) obj;
        }

        public int c() {
            return this.f30330c;
        }

        public String toString() {
            return "Delayed@" + ah.a((Object) this) + "[nanos=" + this.f30328a + ']';
        }
    }

    public static final class c extends ab<b> {

        /* renamed from: a  reason: collision with root package name */
        public long f30331a;

        public c(long j2) {
            this.f30331a = j2;
        }
    }

    static {
        Class<au> cls = au.class;
        f30324b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_queue");
        f30325d = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_delayed");
    }

    private final boolean a(b bVar) {
        c cVar = (c) this._delayed;
        return (cVar != null ? (b) cVar.c() : null) == bVar;
    }

    private final boolean b(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (k()) {
                return false;
            }
            if (obj == null) {
                if (f30324b.compareAndSet(this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof n) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                n nVar = (n) obj;
                int a2 = nVar.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    f30324b.compareAndSet(this, obj, nVar.e());
                } else if (a2 == 2) {
                    return false;
                }
            } else if (obj == ax.f30333b) {
                return false;
            } else {
                n nVar2 = new n(8, true);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                nVar2.a((Runnable) obj);
                nVar2.a(runnable);
                if (f30324b.compareAndSet(this, obj, nVar2)) {
                    return true;
                }
            }
        }
    }

    private final int c(long j2, b bVar) {
        if (k()) {
            return 1;
        }
        c cVar = (c) this._delayed;
        if (cVar == null) {
            au auVar = this;
            f30325d.compareAndSet(auVar, (Object) null, new c(j2));
            Object obj = auVar._delayed;
            h.a(obj);
            cVar = (c) obj;
        }
        return bVar.a(j2, cVar, this);
    }

    private final void c(boolean z2) {
        this._isCompleted = z2 ? 1 : 0;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
    /* access modifiers changed from: private */
    public final boolean k() {
        return this._isCompleted;
    }

    private final Runnable l() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof n) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                n nVar = (n) obj;
                Object d2 = nVar.d();
                if (d2 != n.f30419a) {
                    return (Runnable) d2;
                }
                f30324b.compareAndSet(this, obj, nVar.e());
            } else if (obj == ax.f30333b) {
                return null;
            } else {
                if (f30324b.compareAndSet(this, obj, (Object) null)) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final void m() {
        if (!ag.a() || k()) {
            while (true) {
                Object obj = this._queue;
                if (obj == null) {
                    if (f30324b.compareAndSet(this, (Object) null, ax.f30333b)) {
                        return;
                    }
                } else if (obj instanceof n) {
                    ((n) obj).c();
                    return;
                } else if (obj != ax.f30333b) {
                    n nVar = new n(8, true);
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                    nVar.a((Runnable) obj);
                    if (f30324b.compareAndSet(this, obj, nVar)) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    private final void n() {
        b bVar;
        bz a2 = ca.a();
        long a3 = a2 != null ? a2.a() : System.nanoTime();
        while (true) {
            c cVar = (c) this._delayed;
            if (cVar != null && (bVar = (b) cVar.d()) != null) {
                b(a3, bVar);
            } else {
                return;
            }
        }
    }

    public final void a(long j2, b bVar) {
        int c2 = c(j2, bVar);
        if (c2 != 0) {
            if (c2 == 1) {
                b(j2, bVar);
            } else if (c2 != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (a(bVar)) {
            j();
        }
    }

    public void a(long j2, j<? super l> jVar) {
        long a2 = ax.a(j2);
        if (a2 < 4611686018427387903L) {
            bz a3 = ca.a();
            long a4 = a3 != null ? a3.a() : System.nanoTime();
            a aVar = new a(a2 + a4, jVar, this);
            l.a(jVar, u.b(aVar));
            a(a4, (b) aVar);
        }
    }

    public final void a(Runnable runnable) {
        if (b(runnable)) {
            j();
        } else {
            ai.f30301b.a(runnable);
        }
    }

    public final void a(f fVar, Runnable runnable) {
        a(runnable);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long b() {
        /*
            r10 = this;
            boolean r0 = r10.e()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.Object r0 = r10._delayed
            kotlinx.coroutines.au$c r0 = (kotlinx.coroutines.au.c) r0
            if (r0 == 0) goto L_0x0050
            boolean r3 = r0.b()
            if (r3 != 0) goto L_0x0050
            kotlinx.coroutines.bz r3 = kotlinx.coroutines.ca.a()
            if (r3 == 0) goto L_0x0020
            long r3 = r3.a()
            goto L_0x0024
        L_0x0020:
            long r3 = java.lang.System.nanoTime()
        L_0x0024:
            r5 = r0
            kotlinx.coroutines.internal.ab r5 = (kotlinx.coroutines.internal.ab) r5
            monitor-enter(r5)
            kotlinx.coroutines.internal.ac r6 = r5.e()     // Catch:{ all -> 0x004d }
            r7 = 0
            if (r6 == 0) goto L_0x0047
            kotlinx.coroutines.au$b r6 = (kotlinx.coroutines.au.b) r6     // Catch:{ all -> 0x004d }
            boolean r8 = r6.a((long) r3)     // Catch:{ all -> 0x004d }
            r9 = 0
            if (r8 == 0) goto L_0x003f
            java.lang.Runnable r6 = (java.lang.Runnable) r6     // Catch:{ all -> 0x004d }
            boolean r6 = r10.b(r6)     // Catch:{ all -> 0x004d }
            goto L_0x0040
        L_0x003f:
            r6 = 0
        L_0x0040:
            if (r6 == 0) goto L_0x0047
            kotlinx.coroutines.internal.ac r6 = r5.a((int) r9)     // Catch:{ all -> 0x004d }
            r7 = r6
        L_0x0047:
            monitor-exit(r5)
            kotlinx.coroutines.au$b r7 = (kotlinx.coroutines.au.b) r7
            if (r7 == 0) goto L_0x0050
            goto L_0x0024
        L_0x004d:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x0050:
            java.lang.Runnable r0 = r10.l()
            if (r0 == 0) goto L_0x005a
            r0.run()
            return r1
        L_0x005a:
            long r0 = r10.d()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.au.b():long");
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        if (!g()) {
            return false;
        }
        c cVar = (c) this._delayed;
        if (cVar != null && !cVar.b()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            return obj instanceof n ? ((n) obj).a() : obj == ax.f30333b;
        }
    }

    /* access modifiers changed from: protected */
    public long d() {
        b bVar;
        if (super.d() == 0) {
            return 0;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof n)) {
                return obj == ax.f30333b ? Long.MAX_VALUE : 0;
            }
            if (!((n) obj).a()) {
                return 0;
            }
        }
        c cVar = (c) this._delayed;
        if (cVar == null || (bVar = (b) cVar.c()) == null) {
            return Long.MAX_VALUE;
        }
        long j2 = bVar.f30328a;
        bz a2 = ca.a();
        return d.a(j2 - (a2 != null ? a2.a() : System.nanoTime()), 0);
    }

    /* access modifiers changed from: protected */
    public void h() {
        by.f30365a.b();
        c(true);
        m();
        do {
        } while (b() <= 0);
        n();
    }

    /* access modifiers changed from: protected */
    public final void i() {
        this._queue = null;
        this._delayed = null;
    }
}
