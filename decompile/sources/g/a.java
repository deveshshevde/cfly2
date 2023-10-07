package g;

import java.util.concurrent.Executor;

public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f28347a;

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f28348d = new Executor() {
        public void execute(Runnable runnable) {
            a.a().b(runnable);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f28349e = new Executor() {
        public void execute(Runnable runnable) {
            a.a().a(runnable);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private c f28350b;

    /* renamed from: c  reason: collision with root package name */
    private c f28351c;

    private a() {
        b bVar = new b();
        this.f28351c = bVar;
        this.f28350b = bVar;
    }

    public static a a() {
        if (f28347a != null) {
            return f28347a;
        }
        synchronized (a.class) {
            if (f28347a == null) {
                f28347a = new a();
            }
        }
        return f28347a;
    }

    public static Executor b() {
        return f28349e;
    }

    public void a(Runnable runnable) {
        this.f28350b.a(runnable);
    }

    public void b(Runnable runnable) {
        this.f28350b.b(runnable);
    }

    public boolean c() {
        return this.f28350b.c();
    }
}
