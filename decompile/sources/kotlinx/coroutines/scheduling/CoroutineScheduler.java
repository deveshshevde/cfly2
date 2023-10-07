package kotlinx.coroutines.scheduling;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.bz;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.internal.w;
import mp.c;
import mr.d;

public final class CoroutineScheduler implements Closeable, Executor {

    /* renamed from: d  reason: collision with root package name */
    static final AtomicLongFieldUpdater f30452d;

    /* renamed from: i  reason: collision with root package name */
    public static final w f30453i = new w("NOT_IN_STACK");

    /* renamed from: j  reason: collision with root package name */
    public static final a f30454j = new a((f) null);

    /* renamed from: k  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f30455k;

    /* renamed from: l  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f30456l;
    private volatile int _isTerminated;

    /* renamed from: a  reason: collision with root package name */
    public final d f30457a;

    /* renamed from: b  reason: collision with root package name */
    public final d f30458b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReferenceArray<b> f30459c;
    volatile long controlState;

    /* renamed from: e  reason: collision with root package name */
    public final int f30460e;

    /* renamed from: f  reason: collision with root package name */
    public final int f30461f;

    /* renamed from: g  reason: collision with root package name */
    public final long f30462g;

    /* renamed from: h  reason: collision with root package name */
    public final String f30463h;
    private volatile long parkedWorkersStack;

    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final class b extends Thread {

        /* renamed from: c  reason: collision with root package name */
        static final AtomicIntegerFieldUpdater f30470c = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");

        /* renamed from: a  reason: collision with root package name */
        public final m f30471a;

        /* renamed from: b  reason: collision with root package name */
        public WorkerState f30472b;

        /* renamed from: d  reason: collision with root package name */
        public boolean f30473d;

        /* renamed from: f  reason: collision with root package name */
        private long f30475f;

        /* renamed from: g  reason: collision with root package name */
        private long f30476g;

        /* renamed from: h  reason: collision with root package name */
        private int f30477h;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile int workerCtl;

        private b() {
            setDaemon(true);
            this.f30471a = new m();
            this.f30472b = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.f30453i;
            this.f30477h = c.f31274a.b();
        }

        public b(CoroutineScheduler coroutineScheduler, int i2) {
            this();
            a(i2);
        }

        private final void a(h hVar) {
            int b2 = hVar.f30496g.b();
            e(b2);
            c(b2);
            CoroutineScheduler.this.a(hVar);
            d(b2);
        }

        private final h b(boolean z2) {
            h i2;
            h i3;
            if (z2) {
                boolean z3 = b(CoroutineScheduler.this.f30460e * 2) == 0;
                if (z3 && (i3 = i()) != null) {
                    return i3;
                }
                h c2 = this.f30471a.c();
                if (c2 != null) {
                    return c2;
                }
                if (!z3 && (i2 = i()) != null) {
                    return i2;
                }
            } else {
                h i4 = i();
                if (i4 != null) {
                    return i4;
                }
            }
            return c(false);
        }

        private final h c(boolean z2) {
            if (ag.a()) {
                if (!(this.f30471a.b() == 0)) {
                    throw new AssertionError();
                }
            }
            int a2 = CoroutineScheduler.this.d();
            if (a2 < 2) {
                return null;
            }
            int b2 = b(a2);
            long j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < a2; i2++) {
                b2++;
                if (b2 > a2) {
                    b2 = 1;
                }
                b bVar = CoroutineScheduler.this.f30459c.get(b2);
                if (!(bVar == null || bVar == this)) {
                    if (ag.a()) {
                        if (!(this.f30471a.b() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    m mVar = this.f30471a;
                    m mVar2 = bVar.f30471a;
                    long b3 = z2 ? mVar.b(mVar2) : mVar.a(mVar2);
                    if (b3 == -1) {
                        return this.f30471a.c();
                    }
                    if (b3 > 0) {
                        j2 = Math.min(j2, b3);
                    }
                }
            }
            if (j2 == Long.MAX_VALUE) {
                j2 = 0;
            }
            this.f30476g = j2;
            return null;
        }

        private final void c(int i2) {
            if (i2 != 0 && a(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.b();
            }
        }

        private final boolean c() {
            boolean z2;
            if (this.f30472b != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j2 = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j2) >> 42)) != 0) {
                        if (CoroutineScheduler.f30452d.compareAndSet(coroutineScheduler, j2, j2 - 4398046511104L)) {
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
                if (!z2) {
                    return false;
                }
                this.f30472b = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        private final void d() {
            loop0:
            while (true) {
                boolean z2 = false;
                while (!CoroutineScheduler.this.a() && this.f30472b != WorkerState.TERMINATED) {
                    h a2 = a(this.f30473d);
                    if (a2 != null) {
                        this.f30476g = 0;
                        a(a2);
                    } else {
                        this.f30473d = false;
                        if (this.f30476g == 0) {
                            e();
                        } else if (!z2) {
                            z2 = true;
                        } else {
                            a(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f30476g);
                            this.f30476g = 0;
                        }
                    }
                }
            }
            a(WorkerState.TERMINATED);
        }

        private final void d(int i2) {
            if (i2 != 0) {
                CoroutineScheduler.f30452d.addAndGet(CoroutineScheduler.this, -2097152);
                WorkerState workerState = this.f30472b;
                if (workerState != WorkerState.TERMINATED) {
                    if (ag.a()) {
                        if (!(workerState == WorkerState.BLOCKING)) {
                            throw new AssertionError();
                        }
                    }
                    this.f30472b = WorkerState.DORMANT;
                }
            }
        }

        private final void e() {
            if (!f()) {
                CoroutineScheduler.this.a(this);
                return;
            }
            if (ag.a()) {
                if (!(this.f30471a.b() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (f() && this.workerCtl == -1 && !CoroutineScheduler.this.a() && this.f30472b != WorkerState.TERMINATED) {
                a(WorkerState.PARKING);
                Thread.interrupted();
                g();
            }
        }

        private final void e(int i2) {
            this.f30475f = 0;
            if (this.f30472b == WorkerState.PARKING) {
                if (ag.a()) {
                    boolean z2 = true;
                    if (i2 != 1) {
                        z2 = false;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
                this.f30472b = WorkerState.BLOCKING;
            }
        }

        private final boolean f() {
            return this.nextParkedWorker != CoroutineScheduler.f30453i;
        }

        private final void g() {
            if (this.f30475f == 0) {
                this.f30475f = System.nanoTime() + CoroutineScheduler.this.f30462g;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f30462g);
            if (System.nanoTime() - this.f30475f >= 0) {
                this.f30475f = 0;
                h();
            }
        }

        private final void h() {
            synchronized (CoroutineScheduler.this.f30459c) {
                if (!CoroutineScheduler.this.a()) {
                    if (CoroutineScheduler.this.d() > CoroutineScheduler.this.f30460e) {
                        if (f30470c.compareAndSet(this, -1, 1)) {
                            int i2 = this.indexInArray;
                            a(0);
                            CoroutineScheduler.this.a(this, i2, 0);
                            int andDecrement = (int) (CoroutineScheduler.f30452d.getAndDecrement(CoroutineScheduler.this) & 2097151);
                            if (andDecrement != i2) {
                                b bVar = CoroutineScheduler.this.f30459c.get(andDecrement);
                                h.a((Object) bVar);
                                b bVar2 = bVar;
                                CoroutineScheduler.this.f30459c.set(i2, bVar2);
                                bVar2.a(i2);
                                CoroutineScheduler.this.a(bVar2, andDecrement, i2);
                            }
                            CoroutineScheduler.this.f30459c.set(andDecrement, (Object) null);
                            l lVar = l.f30254a;
                            this.f30472b = WorkerState.TERMINATED;
                        }
                    }
                }
            }
        }

        private final h i() {
            d dVar;
            if (b(2) == 0) {
                h hVar = (h) CoroutineScheduler.this.f30457a.c();
                if (hVar != null) {
                    return hVar;
                }
                dVar = CoroutineScheduler.this.f30458b;
            } else {
                h hVar2 = (h) CoroutineScheduler.this.f30458b.c();
                if (hVar2 != null) {
                    return hVar2;
                }
                dVar = CoroutineScheduler.this.f30457a;
            }
            return (h) dVar.c();
        }

        public final int a() {
            return this.indexInArray;
        }

        public final h a(boolean z2) {
            h hVar;
            if (c()) {
                return b(z2);
            }
            if (!z2 || (hVar = this.f30471a.c()) == null) {
                hVar = (h) CoroutineScheduler.this.f30458b.c();
            }
            return hVar != null ? hVar : c(true);
        }

        public final void a(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f30463h);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void a(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean a(WorkerState workerState) {
            WorkerState workerState2 = this.f30472b;
            boolean z2 = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z2) {
                CoroutineScheduler.f30452d.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f30472b = workerState;
            }
            return z2;
        }

        public final int b(int i2) {
            int i3 = this.f30477h;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.f30477h = i6;
            int i7 = i2 - 1;
            return (i7 & i2) == 0 ? i6 & i7 : (i6 & SubsamplingScaleImageView.TILE_SIZE_AUTO) % i2;
        }

        public final Object b() {
            return this.nextParkedWorker;
        }

        public void run() {
            d();
        }
    }

    static {
        Class<CoroutineScheduler> cls = CoroutineScheduler.class;
        f30455k = AtomicLongFieldUpdater.newUpdater(cls, "parkedWorkersStack");
        f30452d = AtomicLongFieldUpdater.newUpdater(cls, "controlState");
        f30456l = AtomicIntegerFieldUpdater.newUpdater(cls, "_isTerminated");
    }

    public CoroutineScheduler(int i2, int i3, long j2, String str) {
        this.f30460e = i2;
        this.f30461f = i3;
        this.f30462g = j2;
        this.f30463h = str;
        if (i2 >= 1) {
            if (i3 >= i2) {
                if (i3 <= 2097150) {
                    if (j2 > 0) {
                        this.f30457a = new d();
                        this.f30458b = new d();
                        this.parkedWorkersStack = 0;
                        this.f30459c = new AtomicReferenceArray<>(i3 + 1);
                        this.controlState = ((long) i2) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
    }

    private final h a(b bVar, h hVar, boolean z2) {
        if (bVar == null || bVar.f30472b == WorkerState.TERMINATED) {
            return hVar;
        }
        if (hVar.f30496g.b() == 0 && bVar.f30472b == WorkerState.BLOCKING) {
            return hVar;
        }
        bVar.f30473d = true;
        return bVar.f30471a.a(hVar, z2);
    }

    public static /* synthetic */ void a(CoroutineScheduler coroutineScheduler, Runnable runnable, i iVar, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            iVar = g.f30493a;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        coroutineScheduler.a(runnable, iVar, z2);
    }

    private final void a(boolean z2) {
        long addAndGet = f30452d.addAndGet(this, 2097152);
        if (!z2 && !e() && !b(addAndGet)) {
            e();
        }
    }

    static /* synthetic */ boolean a(CoroutineScheduler coroutineScheduler, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.b(j2);
    }

    private final int b(b bVar) {
        int a2;
        do {
            Object b2 = bVar.b();
            if (b2 == f30453i) {
                return -1;
            }
            if (b2 == null) {
                return 0;
            }
            bVar = (b) b2;
            a2 = bVar.a();
        } while (a2 == 0);
        return a2;
    }

    private final boolean b(long j2) {
        if (d.c(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.f30460e) {
            int f2 = f();
            if (f2 == 1 && this.f30460e > 1) {
                f();
            }
            if (f2 > 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean b(h hVar) {
        boolean z2 = true;
        if (hVar.f30496g.b() != 1) {
            z2 = false;
        }
        return (z2 ? this.f30458b : this.f30457a).a(hVar);
    }

    private final b c() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            b bVar = this.f30459c.get((int) (2097151 & j2));
            if (bVar == null) {
                return null;
            }
            long j3 = (2097152 + j2) & -2097152;
            int b2 = b(bVar);
            if (b2 >= 0) {
                if (f30455k.compareAndSet(this, j2, ((long) b2) | j3)) {
                    bVar.a((Object) f30453i);
                    return bVar;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final int d() {
        return (int) (this.controlState & 2097151);
    }

    private final boolean e() {
        b c2;
        do {
            c2 = c();
            if (c2 == null) {
                return false;
            }
        } while (!b.f30470c.compareAndSet(c2, -1, 0));
        LockSupport.unpark(c2);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int f() {
        /*
            r10 = this;
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r0 = r10.f30459c
            monitor-enter(r0)
            boolean r1 = r10.a()     // Catch:{ all -> 0x007e }
            if (r1 == 0) goto L_0x000c
            r1 = -1
        L_0x000a:
            monitor-exit(r0)
            return r1
        L_0x000c:
            long r1 = r10.controlState     // Catch:{ all -> 0x007e }
            r3 = 2097151(0x1fffff, double:1.0361303E-317)
            long r5 = r1 & r3
            int r6 = (int) r5     // Catch:{ all -> 0x007e }
            r7 = 4398044413952(0x3ffffe00000, double:2.1729226538177E-311)
            long r1 = r1 & r7
            r5 = 21
            long r1 = r1 >> r5
            int r2 = (int) r1     // Catch:{ all -> 0x007e }
            int r1 = r6 - r2
            r2 = 0
            int r1 = mr.d.c(r1, r2)     // Catch:{ all -> 0x007e }
            int r5 = r10.f30460e     // Catch:{ all -> 0x007e }
            if (r1 < r5) goto L_0x002b
            monitor-exit(r0)
            return r2
        L_0x002b:
            int r5 = r10.f30461f     // Catch:{ all -> 0x007e }
            if (r6 < r5) goto L_0x0031
            monitor-exit(r0)
            return r2
        L_0x0031:
            long r5 = r10.controlState     // Catch:{ all -> 0x007e }
            long r5 = r5 & r3
            int r6 = (int) r5     // Catch:{ all -> 0x007e }
            r5 = 1
            int r6 = r6 + r5
            if (r6 <= 0) goto L_0x0043
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r7 = r10.f30459c     // Catch:{ all -> 0x007e }
            java.lang.Object r7 = r7.get(r6)     // Catch:{ all -> 0x007e }
            if (r7 != 0) goto L_0x0043
            r7 = 1
            goto L_0x0044
        L_0x0043:
            r7 = 0
        L_0x0044:
            if (r7 == 0) goto L_0x0070
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r7 = new kotlinx.coroutines.scheduling.CoroutineScheduler$b     // Catch:{ all -> 0x007e }
            r7.<init>(r10, r6)     // Catch:{ all -> 0x007e }
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r8 = r10.f30459c     // Catch:{ all -> 0x007e }
            r8.set(r6, r7)     // Catch:{ all -> 0x007e }
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = f30452d     // Catch:{ all -> 0x007e }
            long r8 = r8.incrementAndGet(r10)     // Catch:{ all -> 0x007e }
            long r3 = r3 & r8
            int r4 = (int) r3     // Catch:{ all -> 0x007e }
            if (r6 != r4) goto L_0x005b
            r2 = 1
        L_0x005b:
            if (r2 == 0) goto L_0x0062
            r7.start()     // Catch:{ all -> 0x007e }
            int r1 = r1 + r5
            goto L_0x000a
        L_0x0062:
            java.lang.String r1 = "Failed requirement."
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x007e }
            r2.<init>(r1)     // Catch:{ all -> 0x007e }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x007e }
            throw r2     // Catch:{ all -> 0x007e }
        L_0x0070:
            java.lang.String r1 = "Failed requirement."
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x007e }
            r2.<init>(r1)     // Catch:{ all -> 0x007e }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x007e }
            throw r2     // Catch:{ all -> 0x007e }
        L_0x007e:
            r1 = move-exception
            monitor-exit(r0)
            goto L_0x0082
        L_0x0081:
            throw r1
        L_0x0082:
            goto L_0x0081
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.f():int");
    }

    private final b g() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof b)) {
            currentThread = null;
        }
        b bVar = (b) currentThread;
        if (bVar == null || !h.a((Object) CoroutineScheduler.this, (Object) this)) {
            return null;
        }
        return bVar;
    }

    public final h a(Runnable runnable, i iVar) {
        long a2 = k.f30503f.a();
        if (!(runnable instanceof h)) {
            return new j(runnable, a2, iVar);
        }
        h hVar = (h) runnable;
        hVar.f30495f = a2;
        hVar.f30496g = iVar;
        return hVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0070, code lost:
        if (r9 != null) goto L_0x007b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(long r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f30456l
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r0 = r8.g()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r3 = r8.f30459c
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch:{ all -> 0x00bc }
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r3)
            if (r2 > r5) goto L_0x0060
            r3 = 1
        L_0x001d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r4 = r8.f30459c
            java.lang.Object r4 = r4.get(r3)
            kotlin.jvm.internal.h.a((java.lang.Object) r4)
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r4 = (kotlinx.coroutines.scheduling.CoroutineScheduler.b) r4
            if (r4 == r0) goto L_0x005b
        L_0x002a:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L_0x003a
            r6 = r4
            java.lang.Thread r6 = (java.lang.Thread) r6
            java.util.concurrent.locks.LockSupport.unpark(r6)
            r4.join(r9)
            goto L_0x002a
        L_0x003a:
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r6 = r4.f30472b
            boolean r7 = kotlinx.coroutines.ag.a()
            if (r7 == 0) goto L_0x0054
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r7 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            if (r6 != r7) goto L_0x0048
            r6 = 1
            goto L_0x0049
        L_0x0048:
            r6 = 0
        L_0x0049:
            if (r6 == 0) goto L_0x004c
            goto L_0x0054
        L_0x004c:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        L_0x0054:
            kotlinx.coroutines.scheduling.m r4 = r4.f30471a
            kotlinx.coroutines.scheduling.d r6 = r8.f30458b
            r4.a((kotlinx.coroutines.scheduling.d) r6)
        L_0x005b:
            if (r3 == r5) goto L_0x0060
            int r3 = r3 + 1
            goto L_0x001d
        L_0x0060:
            kotlinx.coroutines.scheduling.d r9 = r8.f30458b
            r9.b()
            kotlinx.coroutines.scheduling.d r9 = r8.f30457a
            r9.b()
        L_0x006a:
            if (r0 == 0) goto L_0x0073
            kotlinx.coroutines.scheduling.h r9 = r0.a((boolean) r2)
            if (r9 == 0) goto L_0x0073
            goto L_0x007b
        L_0x0073:
            kotlinx.coroutines.scheduling.d r9 = r8.f30457a
            java.lang.Object r9 = r9.c()
            kotlinx.coroutines.scheduling.h r9 = (kotlinx.coroutines.scheduling.h) r9
        L_0x007b:
            if (r9 == 0) goto L_0x007e
            goto L_0x0086
        L_0x007e:
            kotlinx.coroutines.scheduling.d r9 = r8.f30458b
            java.lang.Object r9 = r9.c()
            kotlinx.coroutines.scheduling.h r9 = (kotlinx.coroutines.scheduling.h) r9
        L_0x0086:
            if (r9 == 0) goto L_0x008c
            r8.a((kotlinx.coroutines.scheduling.h) r9)
            goto L_0x006a
        L_0x008c:
            if (r0 == 0) goto L_0x0093
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r9 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.a((kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState) r9)
        L_0x0093:
            boolean r9 = kotlinx.coroutines.ag.a()
            if (r9 == 0) goto L_0x00b5
            long r9 = r8.controlState
            r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r3
            r0 = 42
            long r9 = r9 >> r0
            int r10 = (int) r9
            int r9 = r8.f30460e
            if (r10 != r9) goto L_0x00aa
            r1 = 1
        L_0x00aa:
            if (r1 == 0) goto L_0x00ad
            goto L_0x00b5
        L_0x00ad:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        L_0x00b5:
            r9 = 0
            r8.parkedWorkersStack = r9
            r8.controlState = r9
            return
        L_0x00bc:
            r9 = move-exception
            monitor-exit(r3)
            goto L_0x00c0
        L_0x00bf:
            throw r9
        L_0x00c0:
            goto L_0x00bf
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.a(long):void");
    }

    public final void a(Runnable runnable, i iVar, boolean z2) {
        bz a2 = ca.a();
        if (a2 != null) {
            a2.b();
        }
        h a3 = a(runnable, iVar);
        b g2 = g();
        h a4 = a(g2, a3, z2);
        if (a4 == null || b(a4)) {
            boolean z3 = z2 && g2 != null;
            if (a3.f30496g.b() != 0) {
                a(z3);
            } else if (!z3) {
                b();
            }
        } else {
            throw new RejectedExecutionException(this.f30463h + " was terminated");
        }
    }

    public final void a(b bVar, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & -2097152;
            if (i4 == i2) {
                i4 = i3 == 0 ? b(bVar) : i3;
            }
            if (i4 >= 0) {
                if (f30455k.compareAndSet(this, j2, j3 | ((long) i4))) {
                    return;
                }
            }
        }
    }

    public final void a(h hVar) {
        bz a2;
        try {
            hVar.run();
            a2 = ca.a();
            if (a2 == null) {
                return;
            }
        } catch (Throwable th) {
            bz a3 = ca.a();
            if (a3 != null) {
                a3.c();
            }
            throw th;
        }
        a2.c();
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._isTerminated;
    }

    public final boolean a(b bVar) {
        long j2;
        long j3;
        int a2;
        if (bVar.b() != f30453i) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            int i2 = (int) (2097151 & j2);
            j3 = (2097152 + j2) & -2097152;
            a2 = bVar.a();
            if (ag.a()) {
                if (!(a2 != 0)) {
                    throw new AssertionError();
                }
            }
            bVar.a((Object) this.f30459c.get(i2));
        } while (!f30455k.compareAndSet(this, j2, ((long) a2) | j3));
        return true;
    }

    public final void b() {
        if (!e() && !a(this, 0, 1, (Object) null)) {
            e();
        }
    }

    public void close() {
        a(10000);
    }

    public void execute(Runnable runnable) {
        a(this, runnable, (i) null, false, 6, (Object) null);
    }

    public String toString() {
        StringBuilder sb;
        String str;
        Collection collection;
        ArrayList arrayList = new ArrayList();
        int length = this.f30459c.length();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < length; i7++) {
            b bVar = this.f30459c.get(i7);
            if (bVar != null) {
                int b2 = bVar.f30471a.b();
                int i8 = a.f30478a[bVar.f30472b.ordinal()];
                if (i8 != 1) {
                    if (i8 == 2) {
                        i3++;
                        collection = arrayList;
                        sb = new StringBuilder();
                        sb.append(String.valueOf(b2));
                        str = "b";
                    } else if (i8 == 3) {
                        i2++;
                        collection = arrayList;
                        sb = new StringBuilder();
                        sb.append(String.valueOf(b2));
                        str = "c";
                    } else if (i8 == 4) {
                        i5++;
                        if (b2 > 0) {
                            collection = arrayList;
                            sb = new StringBuilder();
                            sb.append(String.valueOf(b2));
                            str = "d";
                        }
                    } else if (i8 == 5) {
                        i6++;
                    }
                    sb.append(str);
                    collection.add(sb.toString());
                } else {
                    i4++;
                }
            }
        }
        long j2 = this.controlState;
        return this.f30463h + '@' + ah.a((Object) this) + '[' + "Pool Size {" + "core = " + this.f30460e + ", " + "max = " + this.f30461f + "}, " + "Worker States {" + "CPU = " + i2 + ", " + "blocking = " + i3 + ", " + "parked = " + i4 + ", " + "dormant = " + i5 + ", " + "terminated = " + i6 + "}, " + "running workers queues = " + arrayList + ", " + "global CPU queue size = " + this.f30457a.a() + ", " + "global blocking queue size = " + this.f30458b.a() + ", " + "Control State {" + "created workers= " + ((int) (2097151 & j2)) + ", " + "blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", " + "CPUs acquired = " + (this.f30460e - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }
}
