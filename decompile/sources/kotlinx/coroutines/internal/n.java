package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.ag;

public final class n<E> {

    /* renamed from: a  reason: collision with root package name */
    public static final w f30419a = new w("REMOVE_FROZEN");

    /* renamed from: b  reason: collision with root package name */
    public static final a f30420b = new a((f) null);

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f30421d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f30422e;
    private volatile Object _next = null;
    private volatile long _state = 0;

    /* renamed from: c  reason: collision with root package name */
    private final int f30423c;

    /* renamed from: f  reason: collision with root package name */
    private AtomicReferenceArray f30424f;

    /* renamed from: g  reason: collision with root package name */
    private final int f30425g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f30426h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final int a(long j2) {
            return (j2 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long a(long j2, int i2) {
            return a(j2, 1073741823) | (((long) i2) << 0);
        }

        public final long a(long j2, long j3) {
            return j2 & (j3 ^ -1);
        }

        public final long b(long j2, int i2) {
            return a(j2, 1152921503533105152L) | (((long) i2) << 30);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f30427a;

        public b(int i2) {
            this.f30427a = i2;
        }
    }

    static {
        Class<n> cls = n.class;
        f30421d = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        f30422e = AtomicLongFieldUpdater.newUpdater(cls, "_state");
    }

    public n(int i2, boolean z2) {
        this.f30425g = i2;
        this.f30426h = z2;
        int i3 = i2 - 1;
        this.f30423c = i3;
        this.f30424f = new AtomicReferenceArray(i2);
        boolean z3 = false;
        if (i3 <= 1073741823) {
            if (!((i2 & i3) == 0 ? true : z3)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final n<E> a(int i2, int i3) {
        long j2;
        a aVar;
        int i4;
        do {
            j2 = this._state;
            aVar = f30420b;
            boolean z2 = false;
            i4 = (int) ((1073741823 & j2) >> 0);
            if (ag.a()) {
                if (i4 == i2) {
                    z2 = true;
                }
                if (!z2) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j2) != 0) {
                return e();
            }
        } while (!f30422e.compareAndSet(this, j2, aVar.a(j2, i3)));
        this.f30424f.set(this.f30423c & i4, (Object) null);
        return null;
    }

    private final n<E> a(int i2, E e2) {
        Object obj = this.f30424f.get(this.f30423c & i2);
        if (!(obj instanceof b) || ((b) obj).f30427a != i2) {
            return null;
        }
        this.f30424f.set(i2 & this.f30423c, e2);
        return this;
    }

    private final n<E> a(long j2) {
        while (true) {
            n<E> nVar = (n) this._next;
            if (nVar != null) {
                return nVar;
            }
            f30421d.compareAndSet(this, (Object) null, b(j2));
        }
    }

    private final n<E> b(long j2) {
        n<E> nVar = new n<>(this.f30425g * 2, this.f30426h);
        int i2 = (int) ((1073741823 & j2) >> 0);
        int i3 = (int) ((1152921503533105152L & j2) >> 30);
        while (true) {
            int i4 = this.f30423c;
            if ((i2 & i4) != (i3 & i4)) {
                Object obj = this.f30424f.get(i4 & i2);
                if (obj == null) {
                    obj = new b(i2);
                }
                nVar.f30424f.set(nVar.f30423c & i2, obj);
                i2++;
            } else {
                nVar._state = f30420b.a(j2, 1152921504606846976L);
                return nVar;
            }
        }
    }

    private final long f() {
        long j2;
        long j3;
        do {
            j2 = this._state;
            if ((j2 & 1152921504606846976L) != 0) {
                return j2;
            }
            j3 = j2 | 1152921504606846976L;
        } while (!f30422e.compareAndSet(this, j2, j3));
        return j3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b A[LOOP:1: B:19:0x006b->B:22:0x007d, LOOP_START, PHI: r0 
      PHI: (r0v8 kotlinx.coroutines.internal.n) = (r0v7 kotlinx.coroutines.internal.n), (r0v10 kotlinx.coroutines.internal.n) binds: [B:18:0x0061, B:22:0x007d] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(E r14) {
        /*
            r13 = this;
        L_0x0000:
            long r2 = r13._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x0012
            kotlinx.coroutines.internal.n$a r14 = f30420b
            int r14 = r14.a(r2)
            return r14
        L_0x0012:
            kotlinx.coroutines.internal.n$a r0 = f30420b
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            r8 = 0
            long r4 = r4 >> r8
            int r1 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r9 = 30
            long r4 = r4 >> r9
            int r9 = (int) r4
            int r10 = r13.f30423c
            int r4 = r9 + 2
            r4 = r4 & r10
            r5 = r1 & r10
            r11 = 1
            if (r4 != r5) goto L_0x0030
            return r11
        L_0x0030:
            boolean r4 = r13.f30426h
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r4 != 0) goto L_0x004f
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r13.f30424f
            r12 = r9 & r10
            java.lang.Object r4 = r4.get(r12)
            if (r4 == 0) goto L_0x004f
            int r0 = r13.f30425g
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L_0x004e
            int r9 = r9 - r1
            r1 = r9 & r5
            int r0 = r0 >> 1
            if (r1 <= r0) goto L_0x0000
        L_0x004e:
            return r11
        L_0x004f:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = f30422e
            long r11 = r0.b(r2, r1)
            r0 = r4
            r1 = r13
            r4 = r11
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L_0x0000
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.f30424f
            r1 = r9 & r10
            r0.set(r1, r14)
            r0 = r13
            kotlinx.coroutines.internal.n r0 = (kotlinx.coroutines.internal.n) r0
        L_0x006b:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0075
            goto L_0x0080
        L_0x0075:
            kotlinx.coroutines.internal.n r0 = r0.e()
            kotlinx.coroutines.internal.n r0 = r0.a((int) r9, r14)
            if (r0 == 0) goto L_0x0080
            goto L_0x006b
        L_0x0080:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.n.a(java.lang.Object):int");
    }

    public final boolean a() {
        long j2 = this._state;
        return ((int) ((1073741823 & j2) >> 0)) == ((int) ((j2 & 1152921503533105152L) >> 30));
    }

    public final int b() {
        long j2 = this._state;
        return 1073741823 & (((int) ((j2 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j2) >> 0)));
    }

    public final boolean c() {
        long j2;
        do {
            j2 = this._state;
            if ((j2 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j2) != 0) {
                return false;
            }
        } while (!f30422e.compareAndSet(this, j2, j2 | 2305843009213693952L));
        return true;
    }

    public final Object d() {
        while (true) {
            long j2 = this._state;
            if ((1152921504606846976L & j2) != 0) {
                return f30419a;
            }
            a aVar = f30420b;
            int i2 = (int) ((1073741823 & j2) >> 0);
            int i3 = (int) ((1152921503533105152L & j2) >> 30);
            int i4 = this.f30423c;
            if ((i3 & i4) == (i2 & i4)) {
                return null;
            }
            Object obj = this.f30424f.get(i4 & i2);
            if (obj == null) {
                if (this.f30426h) {
                    return null;
                }
            } else if (obj instanceof b) {
                return null;
            } else {
                int i5 = (i2 + 1) & 1073741823;
                if (f30422e.compareAndSet(this, j2, aVar.a(j2, i5))) {
                    this.f30424f.set(this.f30423c & i2, (Object) null);
                    return obj;
                } else if (this.f30426h) {
                    n nVar = this;
                    do {
                        nVar = nVar.a(i2, i5);
                    } while (nVar != null);
                    return obj;
                }
            }
        }
    }

    public final n<E> e() {
        return a(f());
    }
}
