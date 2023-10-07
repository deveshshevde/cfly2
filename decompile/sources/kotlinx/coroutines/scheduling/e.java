package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.f;
import kotlinx.coroutines.ay;

final class e extends ay implements Executor, i {

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f30486e = AtomicIntegerFieldUpdater.newUpdater(e.class, "inFlightTasks");

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentLinkedQueue<Runnable> f30487b = new ConcurrentLinkedQueue<>();

    /* renamed from: f  reason: collision with root package name */
    private final c f30488f;

    /* renamed from: g  reason: collision with root package name */
    private final int f30489g;

    /* renamed from: h  reason: collision with root package name */
    private final String f30490h;

    /* renamed from: i  reason: collision with root package name */
    private final int f30491i;
    private volatile int inFlightTasks = 0;

    public e(c cVar, int i2, String str, int i3) {
        this.f30488f = cVar;
        this.f30489g = i2;
        this.f30490h = str;
        this.f30491i = i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK, PHI: r4 
      PHI: (r4v1 java.lang.Runnable) = (r4v0 java.lang.Runnable), (r4v5 java.lang.Runnable) binds: [B:0:0x0000, B:8:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(java.lang.Runnable r4, boolean r5) {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f30486e
            int r1 = r0.incrementAndGet(r3)
            int r2 = r3.f30489g
            if (r1 > r2) goto L_0x0013
            kotlinx.coroutines.scheduling.c r0 = r3.f30488f
            r1 = r3
            kotlinx.coroutines.scheduling.i r1 = (kotlinx.coroutines.scheduling.i) r1
            r0.a(r4, r1, r5)
            return
        L_0x0013:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r1 = r3.f30487b
            r1.add(r4)
            int r4 = r0.decrementAndGet(r3)
            int r0 = r3.f30489g
            if (r4 < r0) goto L_0x0021
            return
        L_0x0021:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r4 = r3.f30487b
            java.lang.Object r4 = r4.poll()
            java.lang.Runnable r4 = (java.lang.Runnable) r4
            if (r4 == 0) goto L_0x002c
            goto L_0x0000
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.e.a(java.lang.Runnable, boolean):void");
    }

    public void a() {
        Runnable poll = this.f30487b.poll();
        if (poll != null) {
            this.f30488f.a(poll, this, true);
            return;
        }
        f30486e.decrementAndGet(this);
        Runnable poll2 = this.f30487b.poll();
        if (poll2 != null) {
            a(poll2, true);
        }
    }

    public void a(f fVar, Runnable runnable) {
        a(runnable, false);
    }

    public int b() {
        return this.f30491i;
    }

    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    public void execute(Runnable runnable) {
        a(runnable, false);
    }

    public String toString() {
        String str = this.f30490h;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f30488f + ']';
    }
}
