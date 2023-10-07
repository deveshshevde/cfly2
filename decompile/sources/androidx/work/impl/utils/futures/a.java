package androidx.work.impl.utils.futures;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class a<V> implements gz.a<V> {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f5362a = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: b  reason: collision with root package name */
    static final C0045a f5363b;

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f5364f;

    /* renamed from: g  reason: collision with root package name */
    private static final Object f5365g = new Object();

    /* renamed from: c  reason: collision with root package name */
    volatile Object f5366c;

    /* renamed from: d  reason: collision with root package name */
    volatile d f5367d;

    /* renamed from: e  reason: collision with root package name */
    volatile h f5368e;

    /* renamed from: androidx.work.impl.utils.futures.a$a  reason: collision with other inner class name */
    private static abstract class C0045a {
        private C0045a() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a(h hVar, h hVar2);

        /* access modifiers changed from: package-private */
        public abstract void a(h hVar, Thread thread);

        /* access modifiers changed from: package-private */
        public abstract boolean a(a<?> aVar, d dVar, d dVar2);

        /* access modifiers changed from: package-private */
        public abstract boolean a(a<?> aVar, h hVar, h hVar2);

        /* access modifiers changed from: package-private */
        public abstract boolean a(a<?> aVar, Object obj, Object obj2);
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final b f5369a;

        /* renamed from: b  reason: collision with root package name */
        static final b f5370b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f5371c;

        /* renamed from: d  reason: collision with root package name */
        final Throwable f5372d;

        static {
            if (a.f5362a) {
                f5370b = null;
                f5369a = null;
                return;
            }
            f5370b = new b(false, (Throwable) null);
            f5369a = new b(true, (Throwable) null);
        }

        b(boolean z2, Throwable th) {
            this.f5371c = z2;
            this.f5372d = th;
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final c f5373a = new c(new AbstractFuture$Failure$1("Failure occurred while trying to finish a future."));

        /* renamed from: b  reason: collision with root package name */
        final Throwable f5374b;

        c(Throwable th) {
            this.f5374b = (Throwable) a.b(th);
        }
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        static final d f5375a = new d((Runnable) null, (Executor) null);

        /* renamed from: b  reason: collision with root package name */
        final Runnable f5376b;

        /* renamed from: c  reason: collision with root package name */
        final Executor f5377c;

        /* renamed from: d  reason: collision with root package name */
        d f5378d;

        d(Runnable runnable, Executor executor) {
            this.f5376b = runnable;
            this.f5377c = executor;
        }
    }

    private static final class e extends C0045a {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<h, Thread> f5379a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<h, h> f5380b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, h> f5381c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, d> f5382d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f5383e;

        e(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f5379a = atomicReferenceFieldUpdater;
            this.f5380b = atomicReferenceFieldUpdater2;
            this.f5381c = atomicReferenceFieldUpdater3;
            this.f5382d = atomicReferenceFieldUpdater4;
            this.f5383e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar, h hVar2) {
            this.f5380b.lazySet(hVar, hVar2);
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar, Thread thread) {
            this.f5379a.lazySet(hVar, thread);
        }

        /* access modifiers changed from: package-private */
        public boolean a(a<?> aVar, d dVar, d dVar2) {
            return this.f5382d.compareAndSet(aVar, dVar, dVar2);
        }

        /* access modifiers changed from: package-private */
        public boolean a(a<?> aVar, h hVar, h hVar2) {
            return this.f5381c.compareAndSet(aVar, hVar, hVar2);
        }

        /* access modifiers changed from: package-private */
        public boolean a(a<?> aVar, Object obj, Object obj2) {
            return this.f5383e.compareAndSet(aVar, obj, obj2);
        }
    }

    private static final class f<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final a<V> f5384a;

        /* renamed from: b  reason: collision with root package name */
        final gz.a<? extends V> f5385b;

        f(a<V> aVar, gz.a<? extends V> aVar2) {
            this.f5384a = aVar;
            this.f5385b = aVar2;
        }

        public void run() {
            if (this.f5384a.f5366c == this) {
                if (a.f5363b.a((a<?>) this.f5384a, (Object) this, a.b((gz.a<?>) this.f5385b))) {
                    a.a((a<?>) this.f5384a);
                }
            }
        }
    }

    private static final class g extends C0045a {
        g() {
            super();
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar, h hVar2) {
            hVar.f5388c = hVar2;
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar, Thread thread) {
            hVar.f5387b = thread;
        }

        /* access modifiers changed from: package-private */
        public boolean a(a<?> aVar, d dVar, d dVar2) {
            synchronized (aVar) {
                if (aVar.f5367d != dVar) {
                    return false;
                }
                aVar.f5367d = dVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(a<?> aVar, h hVar, h hVar2) {
            synchronized (aVar) {
                if (aVar.f5368e != hVar) {
                    return false;
                }
                aVar.f5368e = hVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f5366c != obj) {
                    return false;
                }
                aVar.f5366c = obj2;
                return true;
            }
        }
    }

    private static final class h {

        /* renamed from: a  reason: collision with root package name */
        static final h f5386a = new h(false);

        /* renamed from: b  reason: collision with root package name */
        volatile Thread f5387b;

        /* renamed from: c  reason: collision with root package name */
        volatile h f5388c;

        h() {
            a.f5363b.a(this, Thread.currentThread());
        }

        h(boolean z2) {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            Thread thread = this.f5387b;
            if (thread != null) {
                this.f5387b = null;
                LockSupport.unpark(thread);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar) {
            a.f5363b.a(this, hVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: androidx.work.impl.utils.futures.a$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: androidx.work.impl.utils.futures.a$g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: androidx.work.impl.utils.futures.a$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: androidx.work.impl.utils.futures.a$e} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.String r0 = "c"
            java.lang.Class<androidx.work.impl.utils.futures.a> r1 = androidx.work.impl.utils.futures.a.class
            java.lang.String r2 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r3 = "false"
            java.lang.String r2 = java.lang.System.getProperty(r2, r3)
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            f5362a = r2
            java.lang.String r2 = r1.getName()
            java.util.logging.Logger r2 = java.util.logging.Logger.getLogger(r2)
            f5364f = r2
            androidx.work.impl.utils.futures.a$e r2 = new androidx.work.impl.utils.futures.a$e     // Catch:{ all -> 0x004c }
            java.lang.Class<androidx.work.impl.utils.futures.a$h> r3 = androidx.work.impl.utils.futures.a.h.class
            java.lang.Class<java.lang.Thread> r4 = java.lang.Thread.class
            java.lang.String r5 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r3, r4, r5)     // Catch:{ all -> 0x004c }
            java.lang.Class<androidx.work.impl.utils.futures.a$h> r3 = androidx.work.impl.utils.futures.a.h.class
            java.lang.Class<androidx.work.impl.utils.futures.a$h> r5 = androidx.work.impl.utils.futures.a.h.class
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r3, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Class<androidx.work.impl.utils.futures.a$h> r3 = androidx.work.impl.utils.futures.a.h.class
            java.lang.String r6 = "e"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r3, r6)     // Catch:{ all -> 0x004c }
            java.lang.Class<androidx.work.impl.utils.futures.a$d> r3 = androidx.work.impl.utils.futures.a.d.class
            java.lang.String r7 = "d"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r3, r7)     // Catch:{ all -> 0x004c }
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r3, r0)     // Catch:{ all -> 0x004c }
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x004c }
            r0 = 0
            goto L_0x0052
        L_0x004c:
            r0 = move-exception
            androidx.work.impl.utils.futures.a$g r2 = new androidx.work.impl.utils.futures.a$g
            r2.<init>()
        L_0x0052:
            f5363b = r2
            java.lang.Class<java.util.concurrent.locks.LockSupport> r1 = java.util.concurrent.locks.LockSupport.class
            if (r0 == 0) goto L_0x0061
            java.util.logging.Logger r1 = f5364f
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x0061:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            f5365g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.a.<clinit>():void");
    }

    protected a() {
    }

    private d a(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f5367d;
        } while (!f5363b.a((a<?>) this, dVar2, d.f5375a));
        d dVar3 = dVar2;
        d dVar4 = dVar;
        d dVar5 = dVar3;
        while (dVar5 != null) {
            d dVar6 = dVar5.f5378d;
            dVar5.f5378d = dVar4;
            dVar4 = dVar5;
            dVar5 = dVar6;
        }
        return dVar4;
    }

    private static <V> V a(Future<V> future) throws ExecutionException {
        V v2;
        boolean z2 = false;
        while (true) {
            try {
                v2 = future.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return v2;
    }

    private static CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private void a(h hVar) {
        hVar.f5387b = null;
        while (true) {
            h hVar2 = this.f5368e;
            if (hVar2 != h.f5386a) {
                h hVar3 = null;
                while (hVar2 != null) {
                    h hVar4 = hVar2.f5388c;
                    if (hVar2.f5387b != null) {
                        hVar3 = hVar2;
                    } else if (hVar3 != null) {
                        hVar3.f5388c = hVar4;
                        if (hVar3.f5387b == null) {
                        }
                    } else if (!f5363b.a((a<?>) this, hVar2, hVar4)) {
                    }
                    hVar2 = hVar4;
                }
                return;
            }
            return;
        }
    }

    static void a(a<?> aVar) {
        d dVar = null;
        a<V> aVar2 = aVar;
        while (true) {
            aVar2.d();
            aVar2.b();
            d a2 = aVar2.a(dVar);
            while (true) {
                if (a2 != null) {
                    dVar = a2.f5378d;
                    Runnable runnable = a2.f5376b;
                    if (runnable instanceof f) {
                        f fVar = (f) runnable;
                        a<V> aVar3 = fVar.f5384a;
                        if (aVar3.f5366c == fVar) {
                            if (f5363b.a((a<?>) aVar3, (Object) fVar, b((gz.a<?>) fVar.f5385b))) {
                                aVar2 = aVar3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        b(runnable, a2.f5377c);
                    }
                    a2 = dVar;
                } else {
                    return;
                }
            }
        }
    }

    private void a(StringBuilder sb) {
        String str = "]";
        try {
            Object a2 = a(this);
            sb.append("SUCCESS, result=[");
            sb.append(d(a2));
            sb.append(str);
            return;
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
        } catch (CancellationException unused) {
            str = "CANCELLED";
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            str = " thrown from get()]";
        }
        sb.append(str);
    }

    static Object b(gz.a<?> aVar) {
        if (aVar instanceof a) {
            Object obj = ((a) aVar).f5366c;
            if (!(obj instanceof b)) {
                return obj;
            }
            b bVar = (b) obj;
            return bVar.f5371c ? bVar.f5372d != null ? new b(false, bVar.f5372d) : b.f5370b : obj;
        }
        boolean isCancelled = aVar.isCancelled();
        if ((!f5362a) && isCancelled) {
            return b.f5370b;
        }
        try {
            Object a2 = a(aVar);
            return a2 == null ? f5365g : a2;
        } catch (ExecutionException e2) {
            return new c(e2.getCause());
        } catch (CancellationException e3) {
            if (isCancelled) {
                return new b(false, e3);
            }
            return new c(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + aVar, e3));
        } catch (Throwable th) {
            return new c(th);
        }
    }

    static <T> T b(T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    private static void b(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f5364f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e2);
        }
    }

    private V c(Object obj) throws ExecutionException {
        if (obj instanceof b) {
            throw a("Task was cancelled.", ((b) obj).f5372d);
        } else if (obj instanceof c) {
            throw new ExecutionException(((c) obj).f5374b);
        } else if (obj == f5365g) {
            return null;
        } else {
            return obj;
        }
    }

    private String d(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    private void d() {
        h hVar;
        do {
            hVar = this.f5368e;
        } while (!f5363b.a((a<?>) this, hVar, h.f5386a));
        while (hVar != null) {
            hVar.a();
            hVar = hVar.f5388c;
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    public final void a(Runnable runnable, Executor executor) {
        b(runnable);
        b(executor);
        d dVar = this.f5367d;
        if (dVar != d.f5375a) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f5378d = dVar;
                if (!f5363b.a((a<?>) this, dVar, dVar2)) {
                    dVar = this.f5367d;
                } else {
                    return;
                }
            } while (dVar != d.f5375a);
        }
        b(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public boolean a(gz.a<? extends V> aVar) {
        f fVar;
        c cVar;
        b(aVar);
        Object obj = this.f5366c;
        if (obj == null) {
            if (aVar.isDone()) {
                if (!f5363b.a((a<?>) this, (Object) null, b((gz.a<?>) aVar))) {
                    return false;
                }
                a((a<?>) this);
                return true;
            }
            fVar = new f(this, aVar);
            if (f5363b.a((a<?>) this, (Object) null, (Object) fVar)) {
                try {
                    aVar.a(fVar, DirectExecutor.INSTANCE);
                } catch (Throwable unused) {
                    cVar = c.f5373a;
                }
                return true;
            }
            obj = this.f5366c;
        }
        if (obj instanceof b) {
            aVar.cancel(((b) obj).f5371c);
        }
        return false;
        f5363b.a((a<?>) this, (Object) fVar, (Object) cVar);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean a(V v2) {
        if (v2 == null) {
            v2 = f5365g;
        }
        if (!f5363b.a((a<?>) this, (Object) null, (Object) v2)) {
            return false;
        }
        a((a<?>) this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean a(Throwable th) {
        if (!f5363b.a((a<?>) this, (Object) null, (Object) new c((Throwable) b(th)))) {
            return false;
        }
        a((a<?>) this);
        return true;
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public String c() {
        Object obj = this.f5366c;
        if (obj instanceof f) {
            return "setFuture=[" + d(((f) obj).f5385b) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [gz.a<? extends V>, gz.a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f5366c
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.a.f
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = f5362a
            if (r3 == 0) goto L_0x001f
            androidx.work.impl.utils.futures.a$b r3 = new androidx.work.impl.utils.futures.a$b
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.work.impl.utils.futures.a$b r3 = androidx.work.impl.utils.futures.a.b.f5369a
            goto L_0x0026
        L_0x0024:
            androidx.work.impl.utils.futures.a$b r3 = androidx.work.impl.utils.futures.a.b.f5370b
        L_0x0026:
            r5 = 0
            r4 = r7
        L_0x0028:
            androidx.work.impl.utils.futures.a$a r6 = f5363b
            boolean r6 = r6.a((androidx.work.impl.utils.futures.a<?>) r4, (java.lang.Object) r0, (java.lang.Object) r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.a()
        L_0x0035:
            a((androidx.work.impl.utils.futures.a<?>) r4)
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.a.f
            if (r4 == 0) goto L_0x0062
            androidx.work.impl.utils.futures.a$f r0 = (androidx.work.impl.utils.futures.a.f) r0
            gz.a<? extends V> r0 = r0.f5385b
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.a
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.work.impl.utils.futures.a r4 = (androidx.work.impl.utils.futures.a) r4
            java.lang.Object r0 = r4.f5366c
            if (r0 != 0) goto L_0x004d
            r5 = 1
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.a.f
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = 1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.f5366c
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.a.f
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = 0
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.a.cancel(boolean):boolean");
    }

    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f5366c;
            if ((obj2 != null) && (!(obj2 instanceof f))) {
                return c(obj2);
            }
            h hVar = this.f5368e;
            if (hVar != h.f5386a) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f5363b.a((a<?>) this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f5366c;
                            } else {
                                a(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return c(obj);
                    }
                    hVar = this.f5368e;
                } while (hVar != h.f5386a);
            }
            return c(this.f5366c);
        }
        throw new InterruptedException();
    }

    public final V get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j3 = j2;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j3);
        if (!Thread.interrupted()) {
            Object obj = this.f5366c;
            if ((obj != null) && (!(obj instanceof f))) {
                return c(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                h hVar = this.f5368e;
                if (hVar != h.f5386a) {
                    h hVar2 = new h();
                    do {
                        hVar2.a(hVar);
                        if (f5363b.a((a<?>) this, hVar, hVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f5366c;
                                    if ((obj2 != null) && (!(obj2 instanceof f))) {
                                        return c(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    a(hVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            a(hVar2);
                        } else {
                            hVar = this.f5368e;
                        }
                    } while (hVar != h.f5386a);
                }
                return c(this.f5366c);
            }
            while (nanos > 0) {
                Object obj3 = this.f5366c;
                if ((obj3 != null) && (!(obj3 instanceof f))) {
                    return c(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String aVar = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j3 + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j4 = -nanos;
                long convert = timeUnit2.convert(j4, TimeUnit.NANOSECONDS);
                long nanos2 = j4 - timeUnit2.toNanos(convert);
                boolean z2 = convert == 0 || nanos2 > 1000;
                if (convert > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z2) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z2) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + aVar);
        }
        throw new InterruptedException();
    }

    public final boolean isCancelled() {
        return this.f5366c instanceof b;
    }

    public final boolean isDone() {
        Object obj = this.f5366c;
        return (!(obj instanceof f)) & (obj != null);
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            str2 = "CANCELLED";
        } else {
            if (!isDone()) {
                try {
                    str = c();
                } catch (RuntimeException e2) {
                    str = "Exception thrown from implementation: " + e2.getClass();
                }
                if (str != null && !str.isEmpty()) {
                    sb.append("PENDING, info=[");
                    sb.append(str);
                    sb.append("]");
                    sb.append("]");
                    return sb.toString();
                } else if (!isDone()) {
                    str2 = "PENDING";
                }
            }
            a(sb);
            sb.append("]");
            return sb.toString();
        }
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }
}
