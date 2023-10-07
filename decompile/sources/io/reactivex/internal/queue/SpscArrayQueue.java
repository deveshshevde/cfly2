package io.reactivex.internal.queue;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import lx.e;

public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements e<E> {

    /* renamed from: f  reason: collision with root package name */
    private static final Integer f28795f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;

    /* renamed from: a  reason: collision with root package name */
    final int f28796a = (length() - 1);

    /* renamed from: b  reason: collision with root package name */
    final AtomicLong f28797b = new AtomicLong();

    /* renamed from: c  reason: collision with root package name */
    long f28798c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicLong f28799d = new AtomicLong();

    /* renamed from: e  reason: collision with root package name */
    final int f28800e;

    public SpscArrayQueue(int i2) {
        super(io.reactivex.internal.util.e.a(i2));
        this.f28800e = Math.min(i2 / 4, f28795f.intValue());
    }

    /* access modifiers changed from: package-private */
    public int a(long j2, int i2) {
        return ((int) j2) & i2;
    }

    /* access modifiers changed from: package-private */
    public E a(int i2) {
        return get(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, E e2) {
        lazySet(i2, e2);
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        this.f28797b.lazySet(j2);
    }

    public boolean a(E e2) {
        Objects.requireNonNull(e2, "Null is not a valid element");
        int i2 = this.f28796a;
        long j2 = this.f28797b.get();
        int a2 = a(j2, i2);
        if (j2 >= this.f28798c) {
            long j3 = ((long) this.f28800e) + j2;
            if (a(a(j3, i2)) == null) {
                this.f28798c = j3;
            } else if (a(a2) != null) {
                return false;
            }
        }
        a(a2, e2);
        a(j2 + 1);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b(long j2) {
        this.f28799d.lazySet(j2);
    }

    public boolean b() {
        return this.f28797b.get() == this.f28799d.get();
    }

    /* access modifiers changed from: package-private */
    public int c(long j2) {
        return this.f28796a & ((int) j2);
    }

    public void v_() {
        while (true) {
            if (w_() == null && b()) {
                return;
            }
        }
    }

    public E w_() {
        long j2 = this.f28799d.get();
        int c2 = c(j2);
        E a2 = a(c2);
        if (a2 == null) {
            return null;
        }
        b(j2 + 1);
        a(c2, (Object) null);
        return a2;
    }
}
