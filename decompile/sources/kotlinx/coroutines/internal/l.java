package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.ah;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f30414a;

    /* renamed from: c  reason: collision with root package name */
    static final AtomicReferenceFieldUpdater f30415c;

    /* renamed from: d  reason: collision with root package name */
    static final AtomicReferenceFieldUpdater f30416d;
    volatile Object _next = this;
    volatile Object _prev = this;
    private volatile Object _removedRef = null;

    public static abstract class a extends c<l> {
        private volatile Object _oldNext = null;

        /* renamed from: d  reason: collision with root package name */
        public final l f30417d;

        public a(l lVar) {
            this.f30417d = lVar;
        }

        public void a(l lVar, Object obj) {
            boolean z2 = obj == null;
            l c2 = z2 ? this.f30417d : c();
            if (c2 != null && l.f30415c.compareAndSet(lVar, this, c2) && z2) {
                l lVar2 = this.f30417d;
                l c3 = c();
                h.a((Object) c3);
                lVar2.c(c3);
            }
        }

        public final void b(l lVar) {
            this._oldNext = lVar;
        }

        public final l c() {
            return (l) this._oldNext;
        }
    }

    static {
        Class<l> cls = l.class;
        f30415c = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        f30416d = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_prev");
        f30414a = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_removedRef");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0054, code lost:
        if (f30415c.compareAndSet(r4, r3, ((kotlinx.coroutines.internal.s) r5).a()) != false) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlinx.coroutines.internal.l a(kotlinx.coroutines.internal.r r8) {
        /*
            r7 = this;
        L_0x0000:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.l r0 = (kotlinx.coroutines.internal.l) r0
            r1 = 0
            if (r0 == 0) goto L_0x006b
            r2 = r1
            kotlinx.coroutines.internal.l r2 = (kotlinx.coroutines.internal.l) r2
            r3 = r0
        L_0x000b:
            r4 = r2
        L_0x000c:
            java.lang.Object r5 = r3._next
            if (r5 == 0) goto L_0x006b
            r6 = r7
            kotlinx.coroutines.internal.l r6 = (kotlinx.coroutines.internal.l) r6
            if (r5 != r6) goto L_0x0022
            if (r0 != r3) goto L_0x0018
            return r3
        L_0x0018:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f30416d
            boolean r0 = r1.compareAndSet(r7, r0, r3)
            if (r0 != 0) goto L_0x0021
            goto L_0x0000
        L_0x0021:
            return r3
        L_0x0022:
            boolean r6 = r7.d()
            if (r6 == 0) goto L_0x0029
            return r1
        L_0x0029:
            if (r5 != r8) goto L_0x002c
            return r3
        L_0x002c:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.r
            if (r6 == 0) goto L_0x0042
            if (r8 == 0) goto L_0x003c
            r0 = r5
            kotlinx.coroutines.internal.r r0 = (kotlinx.coroutines.internal.r) r0
            boolean r0 = r8.a(r0)
            if (r0 == 0) goto L_0x003c
            return r1
        L_0x003c:
            kotlinx.coroutines.internal.r r5 = (kotlinx.coroutines.internal.r) r5
            r5.c(r3)
            goto L_0x0000
        L_0x0042:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.s
            if (r6 == 0) goto L_0x0061
            if (r4 == 0) goto L_0x0059
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = f30415c
            kotlinx.coroutines.internal.s r5 = (kotlinx.coroutines.internal.s) r5
            kotlinx.coroutines.internal.l r5 = r5.a()
            boolean r3 = r6.compareAndSet(r4, r3, r5)
            if (r3 != 0) goto L_0x0057
            goto L_0x0000
        L_0x0057:
            r3 = r4
            goto L_0x000b
        L_0x0059:
            java.lang.Object r3 = r3._prev
            kotlinx.coroutines.internal.l r3 = (kotlinx.coroutines.internal.l) r3
            if (r3 == 0) goto L_0x0060
            goto L_0x000c
        L_0x0060:
            return r1
        L_0x0061:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            java.util.Objects.requireNonNull(r5, r4)
            kotlinx.coroutines.internal.l r5 = (kotlinx.coroutines.internal.l) r5
            r4 = r3
            r3 = r5
            goto L_0x000c
        L_0x006b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.l.a(kotlinx.coroutines.internal.r):kotlinx.coroutines.internal.l");
    }

    private final l b(l lVar) {
        while (lVar.d()) {
            lVar = (l) lVar._prev;
            if (lVar == null) {
                return null;
            }
        }
        return lVar;
    }

    /* access modifiers changed from: private */
    public final void c(l lVar) {
        l lVar2;
        do {
            lVar2 = (l) lVar._prev;
            if (e() != lVar) {
                return;
            }
        } while (!f30416d.compareAndSet(lVar, lVar2, this));
        if (d()) {
            lVar.a((r) null);
        }
    }

    private final s j() {
        s sVar = (s) this._removedRef;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this);
        f30414a.lazySet(this, sVar2);
        return sVar2;
    }

    public final int a(l lVar, l lVar2, a aVar) {
        f30416d.lazySet(lVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30415c;
        atomicReferenceFieldUpdater.lazySet(lVar, lVar2);
        aVar.b(lVar2);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, lVar2, aVar)) {
            return 0;
        }
        return aVar.c(this) == null ? 1 : 2;
    }

    public final boolean a(l lVar) {
        f30416d.lazySet(lVar, this);
        f30415c.lazySet(lVar, this);
        while (e() == this) {
            if (f30415c.compareAndSet(this, this, lVar)) {
                lVar.c(this);
                return true;
            }
        }
        return false;
    }

    public boolean c() {
        return i() == null;
    }

    public boolean d() {
        return e() instanceof s;
    }

    public final Object e() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof r)) {
                return obj;
            }
            ((r) obj).c(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = kotlinx.coroutines.internal.k.a(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.internal.l f() {
        /*
            r1 = this;
            java.lang.Object r0 = r1.e()
            if (r0 == 0) goto L_0x000d
            kotlinx.coroutines.internal.l r0 = kotlinx.coroutines.internal.k.a(r0)
            if (r0 == 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r0 = r1
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.l.f():kotlinx.coroutines.internal.l");
    }

    public final l g() {
        l h2 = h();
        return h2 != null ? h2 : this;
    }

    public final l h() {
        l a2 = a((r) null);
        if (a2 != null) {
            return a2;
        }
        l lVar = (l) this._prev;
        if (lVar != null) {
            return b(lVar);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.internal.l i() {
        /*
            r5 = this;
        L_0x0000:
            java.lang.Object r0 = r5.e()
            r1 = 0
            if (r0 == 0) goto L_0x0033
            boolean r2 = r0 instanceof kotlinx.coroutines.internal.s
            if (r2 == 0) goto L_0x0012
            kotlinx.coroutines.internal.s r0 = (kotlinx.coroutines.internal.s) r0
            kotlinx.coroutines.internal.l r0 = r0.a()
            return r0
        L_0x0012:
            r2 = r5
            kotlinx.coroutines.internal.l r2 = (kotlinx.coroutines.internal.l) r2
            if (r0 != r2) goto L_0x001c
            r5._prev = r1
            kotlinx.coroutines.internal.l r0 = (kotlinx.coroutines.internal.l) r0
            return r0
        L_0x001c:
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            java.util.Objects.requireNonNull(r0, r2)
            r2 = r0
            kotlinx.coroutines.internal.l r2 = (kotlinx.coroutines.internal.l) r2
            kotlinx.coroutines.internal.s r3 = r2.j()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f30415c
            boolean r0 = r4.compareAndSet(r5, r0, r3)
            if (r0 == 0) goto L_0x0000
            r2.a((kotlinx.coroutines.internal.r) r1)
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.l.i():kotlinx.coroutines.internal.l");
    }

    public String toString() {
        return ah.b(this) + '@' + ah.a((Object) this);
    }
}
