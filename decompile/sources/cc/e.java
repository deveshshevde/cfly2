package cc;

import java.util.concurrent.Executor;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f6179a = new Executor() {
        public void execute(Runnable runnable) {
            l.a(runnable);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f6180b = new Executor() {
        public void execute(Runnable runnable) {
            runnable.run();
        }
    };

    public static Executor a() {
        return f6179a;
    }

    public static Executor b() {
        return f6180b;
    }
}
