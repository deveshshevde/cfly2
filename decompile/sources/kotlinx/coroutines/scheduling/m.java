package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.ag;

public final class m {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f30504b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f30505c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f30506d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f30507e;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReferenceArray<h> f30508a = new AtomicReferenceArray<>(128);
    private volatile int blockingTasksInBuffer = 0;
    private volatile int consumerIndex = 0;
    private volatile Object lastScheduledTask = null;
    private volatile int producerIndex = 0;

    static {
        Class<m> cls = m.class;
        f30504b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        f30505c = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        f30506d = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        f30507e = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    private final long a(m mVar, boolean z2) {
        h hVar;
        do {
            hVar = (h) mVar.lastScheduledTask;
            if (hVar == null) {
                return -2;
            }
            if (z2) {
                boolean z3 = true;
                if (hVar.f30496g.b() != 1) {
                    z3 = false;
                }
                if (!z3) {
                    return -2;
                }
            }
            long a2 = k.f30503f.a() - hVar.f30495f;
            if (a2 < k.f30498a) {
                return k.f30498a - a2;
            }
        } while (!f30504b.compareAndSet(mVar, hVar, (Object) null));
        a(this, hVar, false, 2, (Object) null);
        return -1;
    }

    private final h a(h hVar) {
        boolean z2 = true;
        if (hVar.f30496g.b() != 1) {
            z2 = false;
        }
        if (z2) {
            f30507e.incrementAndGet(this);
        }
        if (a() == 127) {
            return hVar;
        }
        int i2 = this.producerIndex & 127;
        while (this.f30508a.get(i2) != null) {
            Thread.yield();
        }
        this.f30508a.lazySet(i2, hVar);
        f30505c.incrementAndGet(this);
        return null;
    }

    public static /* synthetic */ h a(m mVar, h hVar, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return mVar.a(hVar, z2);
    }

    private final void b(h hVar) {
        if (hVar != null) {
            boolean z2 = false;
            if (hVar.f30496g.b() == 1) {
                int decrementAndGet = f30507e.decrementAndGet(this);
                if (ag.a()) {
                    if (decrementAndGet >= 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    private final boolean b(d dVar) {
        h d2 = d();
        if (d2 == null) {
            return false;
        }
        dVar.a(d2);
        return true;
    }

    private final h d() {
        h andSet;
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (f30506d.compareAndSet(this, i2, i2 + 1) && (andSet = this.f30508a.getAndSet(i3, (Object) null)) != null) {
                b(andSet);
                return andSet;
            }
        }
    }

    public final int a() {
        return this.producerIndex - this.consumerIndex;
    }

    public final long a(m mVar) {
        boolean z2 = true;
        if (ag.a()) {
            if (!(a() == 0)) {
                throw new AssertionError();
            }
        }
        h d2 = mVar.d();
        if (d2 == null) {
            return a(mVar, false);
        }
        h a2 = a(this, d2, false, 2, (Object) null);
        if (!ag.a()) {
            return -1;
        }
        if (a2 != null) {
            z2 = false;
        }
        if (z2) {
            return -1;
        }
        throw new AssertionError();
    }

    public final h a(h hVar, boolean z2) {
        if (z2) {
            return a(hVar);
        }
        h hVar2 = (h) f30504b.getAndSet(this, hVar);
        if (hVar2 != null) {
            return a(hVar2);
        }
        return null;
    }

    public final void a(d dVar) {
        h hVar = (h) f30504b.getAndSet(this, (Object) null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        do {
        } while (b(dVar));
    }

    public final int b() {
        return this.lastScheduledTask != null ? a() + 1 : a();
    }

    public final long b(m mVar) {
        if (ag.a()) {
            if (!(a() == 0)) {
                throw new AssertionError();
            }
        }
        int i2 = mVar.producerIndex;
        AtomicReferenceArray<h> atomicReferenceArray = mVar.f30508a;
        for (int i3 = mVar.consumerIndex; i3 != i2; i3++) {
            int i4 = i3 & 127;
            if (mVar.blockingTasksInBuffer == 0) {
                break;
            }
            h hVar = atomicReferenceArray.get(i4);
            if (hVar != null) {
                if ((hVar.f30496g.b() == 1) && atomicReferenceArray.compareAndSet(i4, hVar, (Object) null)) {
                    f30507e.decrementAndGet(mVar);
                    a(this, hVar, false, 2, (Object) null);
                    return -1;
                }
            }
        }
        return a(mVar, true);
    }

    public final h c() {
        h hVar = (h) f30504b.getAndSet(this, (Object) null);
        return hVar != null ? hVar : d();
    }
}
