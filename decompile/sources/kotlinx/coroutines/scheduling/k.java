package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.x;
import mr.d;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final long f30498a = z.a("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, (Object) null);

    /* renamed from: b  reason: collision with root package name */
    public static final int f30499b = z.a("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);

    /* renamed from: c  reason: collision with root package name */
    public static final int f30500c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f30501d;

    /* renamed from: e  reason: collision with root package name */
    public static final long f30502e = TimeUnit.SECONDS.toNanos(z.a("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, (Object) null));

    /* renamed from: f  reason: collision with root package name */
    public static l f30503f = f.f30492a;

    static {
        int a2 = z.a("kotlinx.coroutines.scheduler.core.pool.size", d.c(x.a(), 2), 1, 0, 8, (Object) null);
        f30500c = a2;
        f30501d = z.a("kotlinx.coroutines.scheduler.max.pool.size", d.a(x.a() * 128, a2, 2097150), 0, 2097150, 4, (Object) null);
    }
}
