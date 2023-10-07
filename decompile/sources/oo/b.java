package oo;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class b<E> extends a<E> {

    /* renamed from: g  reason: collision with root package name */
    private static final Integer f32490g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: c  reason: collision with root package name */
    final AtomicLong f32491c = new AtomicLong();

    /* renamed from: d  reason: collision with root package name */
    protected long f32492d;

    /* renamed from: e  reason: collision with root package name */
    final AtomicLong f32493e = new AtomicLong();

    /* renamed from: f  reason: collision with root package name */
    final int f32494f;

    public b(int i2) {
        super(i2);
        this.f32494f = Math.min(i2 / 4, f32490g.intValue());
    }

    private long a() {
        return this.f32493e.get();
    }

    private long b() {
        return this.f32491c.get();
    }

    private void b(long j2) {
        this.f32491c.lazySet(j2);
    }

    private void c(long j2) {
        this.f32493e.lazySet(j2);
    }

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public boolean isEmpty() {
        return b() == a();
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public boolean offer(E e2) {
        Objects.requireNonNull(e2, "Null is not a valid element");
        AtomicReferenceArray atomicReferenceArray = this.f32488a;
        int i2 = this.f32489b;
        long j2 = this.f32491c.get();
        int a2 = a(j2, i2);
        if (j2 >= this.f32492d) {
            long j3 = ((long) this.f32494f) + j2;
            if (a(atomicReferenceArray, a(j3, i2)) == null) {
                this.f32492d = j3;
            } else if (a(atomicReferenceArray, a2) != null) {
                return false;
            }
        }
        b(j2 + 1);
        a(atomicReferenceArray, a2, e2);
        return true;
    }

    public E peek() {
        return a(a(this.f32493e.get()));
    }

    public E poll() {
        long j2 = this.f32493e.get();
        int a2 = a(j2);
        AtomicReferenceArray atomicReferenceArray = this.f32488a;
        E a3 = a(atomicReferenceArray, a2);
        if (a3 == null) {
            return null;
        }
        c(j2 + 1);
        a(atomicReferenceArray, a2, null);
        return a3;
    }

    public int size() {
        long a2 = a();
        while (true) {
            long b2 = b();
            long a3 = a();
            if (a2 == a3) {
                return (int) (b2 - a3);
            }
            a2 = a3;
        }
    }
}
