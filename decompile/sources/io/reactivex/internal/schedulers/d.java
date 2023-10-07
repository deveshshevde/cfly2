package io.reactivex.internal.schedulers;

import io.reactivex.i;
import java.util.concurrent.ThreadFactory;

public final class d extends i {

    /* renamed from: c  reason: collision with root package name */
    private static final RxThreadFactory f28862c = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f28863b;

    public d() {
        this(f28862c);
    }

    public d(ThreadFactory threadFactory) {
        this.f28863b = threadFactory;
    }

    public i.c a() {
        return new e(this.f28863b);
    }
}
