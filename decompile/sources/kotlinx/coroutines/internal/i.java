package kotlinx.coroutines.internal;

import kotlin.Result;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f30411a;

    static {
        Object obj;
        try {
            Result.a aVar = Result.f30171a;
            obj = Result.e(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f30171a;
            obj = Result.e(kotlin.i.a(th));
        }
        f30411a = Result.a(obj);
    }

    public static final boolean a() {
        return f30411a;
    }
}
