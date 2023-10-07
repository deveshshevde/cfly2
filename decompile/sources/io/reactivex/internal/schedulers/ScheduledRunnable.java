package io.reactivex.internal.schedulers;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements b, Runnable, Callable<Object> {

    /* renamed from: b  reason: collision with root package name */
    static final Object f28818b = new Object();

    /* renamed from: c  reason: collision with root package name */
    static final Object f28819c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final Object f28820d = new Object();

    /* renamed from: e  reason: collision with root package name */
    static final Object f28821e = new Object();
    private static final long serialVersionUID = -6120223772001106981L;

    /* renamed from: a  reason: collision with root package name */
    final Runnable f28822a;

    public ScheduledRunnable(Runnable runnable, a aVar) {
        super(3);
        this.f28822a = runnable;
        lazySet(0, aVar);
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != f28821e) {
                if (obj == f28819c) {
                    future.cancel(false);
                    return;
                } else if (obj == f28820d) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    public Object call() {
        run();
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispose() {
        /*
            r7 = this;
        L_0x0000:
            r0 = 1
            java.lang.Object r1 = r7.get(r0)
            java.lang.Object r2 = f28821e
            r3 = 0
            if (r1 == r2) goto L_0x0031
            java.lang.Object r2 = f28819c
            if (r1 == r2) goto L_0x0031
            java.lang.Object r4 = f28820d
            if (r1 != r4) goto L_0x0013
            goto L_0x0031
        L_0x0013:
            r5 = 2
            java.lang.Object r5 = r7.get(r5)
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            if (r5 == r6) goto L_0x0020
            r5 = 1
            goto L_0x0021
        L_0x0020:
            r5 = 0
        L_0x0021:
            if (r5 == 0) goto L_0x0024
            r2 = r4
        L_0x0024:
            boolean r0 = r7.compareAndSet(r0, r1, r2)
            if (r0 == 0) goto L_0x0000
            if (r1 == 0) goto L_0x0031
            java.util.concurrent.Future r1 = (java.util.concurrent.Future) r1
            r1.cancel(r5)
        L_0x0031:
            java.lang.Object r0 = r7.get(r3)
            java.lang.Object r1 = f28821e
            if (r0 == r1) goto L_0x004b
            java.lang.Object r1 = f28818b
            if (r0 == r1) goto L_0x004b
            if (r0 != 0) goto L_0x0040
            goto L_0x004b
        L_0x0040:
            boolean r1 = r7.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L_0x0031
            io.reactivex.internal.disposables.a r0 = (io.reactivex.internal.disposables.a) r0
            r0.c(r7)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ScheduledRunnable.dispose():void");
    }

    public boolean isDisposed() {
        Object obj = get(0);
        return obj == f28818b || obj == f28821e;
    }

    public void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.f28822a.run();
        } catch (Throwable th) {
            lazySet(2, (Object) null);
            Object obj3 = get(0);
            if (!(obj3 == f28818b || !compareAndSet(0, obj3, f28821e) || obj3 == null)) {
                ((a) obj3).c(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == f28819c || obj2 == f28820d || compareAndSet(1, obj2, f28821e)) {
                    throw th;
                }
                obj2 = get(1);
                break;
            } while (compareAndSet(1, obj2, f28821e));
            throw th;
        }
        lazySet(2, (Object) null);
        Object obj4 = get(0);
        if (!(obj4 == f28818b || !compareAndSet(0, obj4, f28821e) || obj4 == null)) {
            ((a) obj4).c(this);
        }
        do {
            obj = get(1);
            if (obj == f28819c || obj == f28820d || compareAndSet(1, obj, f28821e)) {
            }
            obj = get(1);
            return;
        } while (compareAndSet(1, obj, f28821e));
    }
}
