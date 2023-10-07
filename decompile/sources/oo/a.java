package oo;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import op.i;

abstract class a<E> extends AbstractQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    protected final AtomicReferenceArray<E> f32488a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f32489b;

    public a(int i2) {
        int a2 = i.a(i2);
        this.f32489b = a2 - 1;
        this.f32488a = new AtomicReferenceArray<>(a2);
    }

    /* access modifiers changed from: protected */
    public final int a(long j2) {
        return this.f32489b & ((int) j2);
    }

    /* access modifiers changed from: protected */
    public final int a(long j2, int i2) {
        return ((int) j2) & i2;
    }

    /* access modifiers changed from: protected */
    public final E a(int i2) {
        return a(this.f32488a, i2);
    }

    /* access modifiers changed from: protected */
    public final E a(AtomicReferenceArray<E> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    /* access modifiers changed from: protected */
    public final void a(AtomicReferenceArray<E> atomicReferenceArray, int i2, E e2) {
        atomicReferenceArray.lazySet(i2, e2);
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
