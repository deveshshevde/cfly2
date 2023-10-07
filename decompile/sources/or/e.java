package or;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import rx.internal.schedulers.a;
import rx.internal.schedulers.b;
import rx.internal.schedulers.d;
import rx.internal.util.RxThreadFactory;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final e f32523a = new e();

    protected e() {
    }

    public static ok.e a() {
        return a((ThreadFactory) new RxThreadFactory("RxComputationScheduler-"));
    }

    public static ok.e a(ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory == null");
        return new b(threadFactory);
    }

    public static ok.e b() {
        return b(new RxThreadFactory("RxIoScheduler-"));
    }

    public static ok.e b(ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory == null");
        return new a(threadFactory);
    }

    public static ok.e c() {
        return c(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static ok.e c(ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory == null");
        return new d(threadFactory);
    }

    public static e g() {
        return f32523a;
    }

    public on.a a(on.a aVar) {
        return aVar;
    }

    public ok.e d() {
        return null;
    }

    public ok.e e() {
        return null;
    }

    public ok.e f() {
        return null;
    }
}
