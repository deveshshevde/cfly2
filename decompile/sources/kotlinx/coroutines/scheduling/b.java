package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.aa;
import kotlinx.coroutines.internal.x;
import mr.d;

public final class b extends c {

    /* renamed from: b  reason: collision with root package name */
    public static final b f30479b;

    /* renamed from: e  reason: collision with root package name */
    private static final aa f30480e;

    static {
        b bVar = new b();
        f30479b = bVar;
        f30480e = new e(bVar, z.a("kotlinx.coroutines.io.parallelism", d.c(64, x.a()), 0, 0, 12, (Object) null), "Dispatchers.IO", 1);
    }

    private b() {
        super(0, 0, (String) null, 7, (f) null);
    }

    public final aa a() {
        return f30480e;
    }

    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public String toString() {
        return "Dispatchers.Default";
    }
}
