package rx.internal.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadFactory f34357a = new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            throw new AssertionError("No threads allowed.");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    final String f34358b;

    public RxThreadFactory(String str) {
        this.f34358b = str;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f34358b + incrementAndGet());
        thread.setDaemon(true);
        return thread;
    }
}
