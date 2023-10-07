package ka;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f29952a = Runtime.getRuntime().availableProcessors();

    /* renamed from: e  reason: collision with root package name */
    private static a f29953e;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadPoolExecutor f29954b;

    /* renamed from: c  reason: collision with root package name */
    private final ThreadPoolExecutor f29955c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f29956d = new b();

    private a() {
        c cVar = new c(10);
        int i2 = f29952a;
        c cVar2 = cVar;
        this.f29954b = new ThreadPoolExecutor(i2 * 2, i2 * 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), cVar2);
        this.f29955c = new ThreadPoolExecutor(i2 * 2, i2 * 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), cVar2);
    }

    public static a a() {
        if (f29953e == null) {
            synchronized (a.class) {
                f29953e = new a();
            }
        }
        return f29953e;
    }

    public ThreadPoolExecutor b() {
        return this.f29954b;
    }

    public ThreadPoolExecutor c() {
        return this.f29955c;
    }
}
