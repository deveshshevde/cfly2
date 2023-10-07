package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import ok.e;

public final class d extends e {

    /* renamed from: b  reason: collision with root package name */
    private final ThreadFactory f34334b;

    public d(ThreadFactory threadFactory) {
        this.f34334b = threadFactory;
    }

    public e.a a() {
        return new e(this.f34334b);
    }
}
