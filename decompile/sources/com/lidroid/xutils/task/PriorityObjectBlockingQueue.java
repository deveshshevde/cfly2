package com.lidroid.xutils.task;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PriorityObjectBlockingQueue<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {
    private static final long serialVersionUID = -6903933977591709194L;

    /* renamed from: a  reason: collision with root package name */
    transient a<E> f21126a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21127b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f21128c;

    /* renamed from: d  reason: collision with root package name */
    private transient a<E> f21129d;

    /* renamed from: e  reason: collision with root package name */
    private final ReentrantLock f21130e;

    /* renamed from: f  reason: collision with root package name */
    private final Condition f21131f;

    /* renamed from: g  reason: collision with root package name */
    private final ReentrantLock f21132g;

    /* renamed from: h  reason: collision with root package name */
    private final Condition f21133h;

    private class a implements Iterator<E> {

        /* renamed from: b  reason: collision with root package name */
        private a<E> f21135b;

        /* renamed from: c  reason: collision with root package name */
        private a<E> f21136c;

        /* renamed from: d  reason: collision with root package name */
        private E f21137d;

        a() {
            PriorityObjectBlockingQueue.this.a();
            try {
                a aVar = PriorityObjectBlockingQueue.this.f21126a.f21138a;
                this.f21135b = aVar;
                if (aVar != null) {
                    this.f21137d = aVar.b();
                }
            } finally {
                PriorityObjectBlockingQueue.this.b();
            }
        }

        private a<E> a(a<E> aVar) {
            a<T> aVar2;
            while (true) {
                aVar2 = aVar.f21138a;
                if (aVar2 == aVar) {
                    return PriorityObjectBlockingQueue.this.f21126a.f21138a;
                }
                if (aVar2 == null || aVar2.b() != null) {
                    return aVar2;
                }
                aVar = aVar2;
            }
            return aVar2;
        }

        public boolean hasNext() {
            return this.f21135b != null;
        }

        public E next() {
            PriorityObjectBlockingQueue.this.a();
            try {
                a<E> aVar = this.f21135b;
                if (aVar != null) {
                    E e2 = this.f21137d;
                    this.f21136c = aVar;
                    a<E> a2 = a(aVar);
                    this.f21135b = a2;
                    this.f21137d = a2 == null ? null : a2.b();
                    return e2;
                }
                throw new NoSuchElementException();
            } finally {
                PriorityObjectBlockingQueue.this.b();
            }
        }

        public void remove() {
            if (this.f21136c != null) {
                PriorityObjectBlockingQueue.this.a();
                try {
                    a<E> aVar = this.f21136c;
                    this.f21136c = null;
                    a<E> aVar2 = PriorityObjectBlockingQueue.this.f21126a;
                    while (true) {
                        a<E> aVar3 = aVar2;
                        aVar2 = aVar2.f21138a;
                        if (aVar2 != null) {
                            if (aVar2 == aVar) {
                                PriorityObjectBlockingQueue.this.a(aVar2, aVar3);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } finally {
                    PriorityObjectBlockingQueue.this.b();
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public PriorityObjectBlockingQueue() {
        this(SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public PriorityObjectBlockingQueue(int i2) {
        this.f21128c = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f21130e = reentrantLock;
        this.f21131f = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.f21132g = reentrantLock2;
        this.f21133h = reentrantLock2.newCondition();
        if (i2 > 0) {
            this.f21127b = i2;
            a<E> aVar = new a<>(null);
            this.f21126a = aVar;
            this.f21129d = aVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    private synchronized E a(a<E> aVar) {
        if (aVar == null) {
            return e();
        }
        b(aVar);
        return null;
    }

    private void b(a<E> aVar) {
        boolean z2;
        a aVar2 = this.f21126a;
        while (true) {
            if (aVar2.f21138a == null) {
                z2 = false;
                break;
            }
            a<T> aVar3 = aVar2.f21138a;
            if (aVar3.a().ordinal() > aVar.a().ordinal()) {
                aVar2.f21138a = aVar;
                aVar.f21138a = aVar3;
                z2 = true;
                break;
            }
            aVar2 = aVar2.f21138a;
        }
        if (!z2) {
            this.f21129d.f21138a = aVar;
            this.f21129d = aVar;
        }
    }

    private void c() {
        ReentrantLock reentrantLock = this.f21130e;
        reentrantLock.lock();
        try {
            this.f21131f.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void d() {
        ReentrantLock reentrantLock = this.f21132g;
        reentrantLock.lock();
        try {
            this.f21133h.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private E e() {
        a<E> aVar = this.f21126a;
        a aVar2 = aVar.f21138a;
        aVar.f21138a = aVar;
        this.f21126a = aVar2;
        E b2 = aVar2.b();
        aVar2.a(null);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21132g.lock();
        this.f21130e.lock();
    }

    /* access modifiers changed from: package-private */
    public void a(a<E> aVar, a<E> aVar2) {
        aVar.a(null);
        aVar2.f21138a = aVar.f21138a;
        if (this.f21129d == aVar) {
            this.f21129d = aVar2;
        }
        if (this.f21128c.getAndDecrement() == this.f21127b) {
            this.f21133h.signal();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f21130e.unlock();
        this.f21132g.unlock();
    }

    public void clear() {
        a();
        try {
            a<E> aVar = this.f21126a;
            while (true) {
                a<T> aVar2 = aVar.f21138a;
                if (aVar2 == null) {
                    break;
                }
                aVar.f21138a = aVar;
                aVar2.a(null);
                aVar = aVar2;
            }
            this.f21126a = this.f21129d;
            if (this.f21128c.getAndSet(0) == this.f21127b) {
                this.f21133h.signal();
            }
        } finally {
            b();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        a();
        try {
            a aVar = this.f21126a;
            do {
                aVar = aVar.f21138a;
                if (aVar == null) {
                    b();
                    return false;
                }
            } while (!obj.equals(aVar.b()));
            b();
            return true;
        } catch (Throwable th) {
            b();
            throw th;
        }
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public int drainTo(Collection<? super E> collection, int i2) {
        a<E> aVar;
        int i3;
        Objects.requireNonNull(collection);
        if (collection != this) {
            boolean z2 = false;
            if (i2 <= 0) {
                return 0;
            }
            ReentrantLock reentrantLock = this.f21130e;
            reentrantLock.lock();
            try {
                int min = Math.min(i2, this.f21128c.get());
                aVar = this.f21126a;
                i3 = 0;
                while (i3 < min) {
                    a<T> aVar2 = aVar.f21138a;
                    collection.add(aVar2.b());
                    aVar2.a(null);
                    aVar.f21138a = aVar;
                    i3++;
                    aVar = aVar2;
                }
                if (i3 > 0) {
                    this.f21126a = aVar;
                    if (this.f21128c.getAndAdd(-i3) == this.f21127b) {
                        z2 = true;
                    }
                }
                reentrantLock.unlock();
                if (z2) {
                    d();
                }
                return min;
            } catch (Throwable th) {
                reentrantLock.unlock();
                if (0 != 0) {
                    d();
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Iterator<E> iterator() {
        return new a();
    }

    public boolean offer(E e2) {
        Objects.requireNonNull(e2);
        AtomicInteger atomicInteger = this.f21128c;
        if (atomicInteger.get() == this.f21127b) {
            return false;
        }
        int i2 = -1;
        a aVar = new a(e2);
        ReentrantLock reentrantLock = this.f21132g;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() < this.f21127b) {
                a(aVar);
                i2 = atomicInteger.getAndIncrement();
                if (i2 + 1 < this.f21127b) {
                    this.f21133h.signal();
                }
            }
            if (i2 == 0) {
                c();
            }
            return i2 >= 0;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean offer(E e2, long j2, TimeUnit timeUnit) throws InterruptedException {
        Objects.requireNonNull(e2);
        long nanos = timeUnit.toNanos(j2);
        ReentrantLock reentrantLock = this.f21132g;
        AtomicInteger atomicInteger = this.f21128c;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.f21127b) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.f21133h.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        a(new a(e2));
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.f21127b) {
            this.f21133h.signal();
        }
        reentrantLock.unlock();
        if (andIncrement != 0) {
            return true;
        }
        c();
        return true;
    }

    public E peek() {
        if (this.f21128c.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.f21130e;
        reentrantLock.lock();
        try {
            a aVar = this.f21126a.f21138a;
            if (aVar == null) {
                return null;
            }
            E b2 = aVar.b();
            reentrantLock.unlock();
            return b2;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public E poll() {
        AtomicInteger atomicInteger = this.f21128c;
        E e2 = null;
        if (atomicInteger.get() == 0) {
            return null;
        }
        int i2 = -1;
        ReentrantLock reentrantLock = this.f21130e;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() > 0) {
                e2 = a((a) null);
                i2 = atomicInteger.getAndDecrement();
                if (i2 > 1) {
                    this.f21131f.signal();
                }
            }
            reentrantLock.unlock();
            if (i2 == this.f21127b) {
                d();
            }
            return e2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public E poll(long j2, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j2);
        AtomicInteger atomicInteger = this.f21128c;
        ReentrantLock reentrantLock = this.f21130e;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.f21131f.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        E a2 = a((a) null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.f21131f.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.f21127b) {
            d();
        }
        return a2;
    }

    public void put(E e2) throws InterruptedException {
        Objects.requireNonNull(e2);
        a aVar = new a(e2);
        ReentrantLock reentrantLock = this.f21132g;
        AtomicInteger atomicInteger = this.f21128c;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.f21127b) {
            try {
                this.f21133h.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        a(aVar);
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.f21127b) {
            this.f21133h.signal();
        }
        if (andIncrement == 0) {
            c();
        }
    }

    public int remainingCapacity() {
        return this.f21127b - this.f21128c.get();
    }

    /* JADX INFO: finally extract failed */
    public boolean remove(Object obj) {
        a<E> aVar;
        if (obj == null) {
            return false;
        }
        a();
        try {
            a<E> aVar2 = this.f21126a;
            do {
                aVar = aVar2;
                aVar2 = aVar2.f21138a;
                if (aVar2 == null) {
                    b();
                    return false;
                }
            } while (!obj.equals(aVar2.b()));
            a(aVar2, aVar);
            b();
            return true;
        } catch (Throwable th) {
            b();
            throw th;
        }
    }

    public int size() {
        return this.f21128c.get();
    }

    /* JADX INFO: finally extract failed */
    public E take() throws InterruptedException {
        AtomicInteger atomicInteger = this.f21128c;
        ReentrantLock reentrantLock = this.f21130e;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.f21131f.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E a2 = a((a) null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.f21131f.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.f21127b) {
            d();
        }
        return a2;
    }

    public Object[] toArray() {
        a();
        try {
            Object[] objArr = new Object[this.f21128c.get()];
            int i2 = 0;
            a<T> aVar = this.f21126a.f21138a;
            while (aVar != null) {
                int i3 = i2 + 1;
                objArr[i2] = aVar.b();
                aVar = aVar.f21138a;
                i2 = i3;
            }
            return objArr;
        } finally {
            b();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        a();
        try {
            int i2 = this.f21128c.get();
            if (tArr.length < i2) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2);
            }
            int i3 = 0;
            a<T> aVar = this.f21126a.f21138a;
            while (aVar != null) {
                int i4 = i3 + 1;
                tArr[i3] = aVar.b();
                aVar = aVar.f21138a;
                i3 = i4;
            }
            if (tArr.length > i3) {
                tArr[i3] = null;
            }
            return tArr;
        } finally {
            b();
        }
    }
}
