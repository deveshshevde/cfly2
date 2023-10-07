package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;

    /* renamed from: a  reason: collision with root package name */
    final String f28815a;

    /* renamed from: b  reason: collision with root package name */
    final int f28816b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f28817c;

    static final class a extends Thread {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    public RxThreadFactory(String str, int i2) {
        this(str, i2, false);
    }

    public RxThreadFactory(String str, int i2, boolean z2) {
        this.f28815a = str;
        this.f28816b = i2;
        this.f28817c = z2;
    }

    public Thread newThread(Runnable runnable) {
        String str = this.f28815a + '-' + incrementAndGet();
        Thread aVar = this.f28817c ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.f28816b);
        aVar.setDaemon(true);
        return aVar;
    }

    public String toString() {
        return "RxThreadFactory[" + this.f28815a + "]";
    }
}
