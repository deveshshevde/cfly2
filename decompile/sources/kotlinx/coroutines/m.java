package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class m extends u {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f30444b = AtomicIntegerFieldUpdater.newUpdater(m.class, "_resumed");
    private volatile int _resumed;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public m(kotlin.coroutines.c<?> r3, java.lang.Throwable r4, boolean r5) {
        /*
            r2 = this;
            if (r4 == 0) goto L_0x0003
            goto L_0x0020
        L_0x0003:
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Continuation "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = " was cancelled normally"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
        L_0x0020:
            r2.<init>(r4, r5)
            r3 = 0
            r2._resumed = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.m.<init>(kotlin.coroutines.c, java.lang.Throwable, boolean):void");
    }

    public final boolean a() {
        return f30444b.compareAndSet(this, 0, 1);
    }
}
