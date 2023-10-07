package io.reactivex.internal.queue;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import lx.e;

public final class a<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    static final int f28801a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j  reason: collision with root package name */
    private static final Object f28802j = new Object();

    /* renamed from: b  reason: collision with root package name */
    final AtomicLong f28803b = new AtomicLong();

    /* renamed from: c  reason: collision with root package name */
    int f28804c;

    /* renamed from: d  reason: collision with root package name */
    long f28805d;

    /* renamed from: e  reason: collision with root package name */
    final int f28806e;

    /* renamed from: f  reason: collision with root package name */
    AtomicReferenceArray<Object> f28807f;

    /* renamed from: g  reason: collision with root package name */
    final int f28808g;

    /* renamed from: h  reason: collision with root package name */
    AtomicReferenceArray<Object> f28809h;

    /* renamed from: i  reason: collision with root package name */
    final AtomicLong f28810i = new AtomicLong();

    public a(int i2) {
        int a2 = io.reactivex.internal.util.e.a(Math.max(8, i2));
        int i3 = a2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a2 + 1);
        this.f28807f = atomicReferenceArray;
        this.f28806e = i3;
        a(a2);
        this.f28809h = atomicReferenceArray;
        this.f28808g = i3;
        this.f28805d = (long) (i3 - 1);
        a(0);
    }

    private static int a(long j2, int i2) {
        return b(((int) j2) & i2);
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.f28809h = atomicReferenceArray;
        int a2 = a(j2, i2);
        T b2 = b(atomicReferenceArray, a2);
        if (b2 != null) {
            a(atomicReferenceArray, a2, (Object) null);
            b(j2 + 1);
        }
        return b2;
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        int b2 = b(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, b2);
        a(atomicReferenceArray, b2, (Object) null);
        return atomicReferenceArray2;
    }

    private void a(int i2) {
        this.f28804c = Math.min(i2 / 4, f28801a);
    }

    private void a(long j2) {
        this.f28803b.lazySet(j2);
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t2, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f28807f = atomicReferenceArray2;
        this.f28805d = (j3 + j2) - 1;
        a(atomicReferenceArray2, i2, (Object) t2);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i2, f28802j);
        a(j2 + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, b(atomicReferenceArray.length() - 1), (Object) atomicReferenceArray2);
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t2, long j2, int i2) {
        a(atomicReferenceArray, i2, (Object) t2);
        a(j2 + 1);
        return true;
    }

    private static int b(int i2) {
        return i2;
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private void b(long j2) {
        this.f28810i.lazySet(j2);
    }

    private long d() {
        return this.f28803b.get();
    }

    private long e() {
        return this.f28810i.get();
    }

    private long f() {
        return this.f28803b.get();
    }

    private long g() {
        return this.f28810i.get();
    }

    public boolean a(T t2) {
        Objects.requireNonNull(t2, "Null is not a valid element");
        AtomicReferenceArray<Object> atomicReferenceArray = this.f28807f;
        long f2 = f();
        int i2 = this.f28806e;
        int a2 = a(f2, i2);
        if (f2 < this.f28805d) {
            return a(atomicReferenceArray, t2, f2, a2);
        }
        long j2 = ((long) this.f28804c) + f2;
        if (b(atomicReferenceArray, a(j2, i2)) == null) {
            this.f28805d = j2 - 1;
            return a(atomicReferenceArray, t2, f2, a2);
        } else if (b(atomicReferenceArray, a(1 + f2, i2)) == null) {
            return a(atomicReferenceArray, t2, f2, a2);
        } else {
            a(atomicReferenceArray, f2, a2, t2, (long) i2);
            return true;
        }
    }

    public boolean b() {
        return d() == e();
    }

    public void v_() {
        while (true) {
            if (w_() == null && b()) {
                return;
            }
        }
    }

    public T w_() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f28809h;
        long g2 = g();
        int i2 = this.f28808g;
        int a2 = a(g2, i2);
        T b2 = b(atomicReferenceArray, a2);
        boolean z2 = b2 == f28802j;
        if (b2 != null && !z2) {
            a(atomicReferenceArray, a2, (Object) null);
            b(g2 + 1);
            return b2;
        } else if (z2) {
            return a(a(atomicReferenceArray, i2 + 1), g2, i2);
        } else {
            return null;
        }
    }
}
