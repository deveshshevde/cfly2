package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

class o implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f4475a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<Runnable> f4476b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private Runnable f4477c;

    o(Executor executor) {
        this.f4475a = executor;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        Runnable poll = this.f4476b.poll();
        this.f4477c = poll;
        if (poll != null) {
            this.f4475a.execute(poll);
        }
    }

    public synchronized void execute(final Runnable runnable) {
        this.f4476b.offer(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } finally {
                    o.this.a();
                }
            }
        });
        if (this.f4477c == null) {
            a();
        }
    }
}
