package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicInteger;
import ly.a;
import oj.b;

public final class c {
    public static <T> void a(b<? super T> bVar, T t2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            bVar.onNext(t2);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable a2 = atomicThrowable.a();
                if (a2 != null) {
                    bVar.onError(a2);
                } else {
                    bVar.onComplete();
                }
            }
        }
    }

    public static void a(b<?> bVar, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.a(th)) {
            a.a(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            bVar.onError(atomicThrowable.a());
        }
    }

    public static void a(b<?> bVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable a2 = atomicThrowable.a();
            if (a2 != null) {
                bVar.onError(a2);
            } else {
                bVar.onComplete();
            }
        }
    }
}
