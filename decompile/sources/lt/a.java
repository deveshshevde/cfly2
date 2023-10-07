package lt;

import io.reactivex.i;
import java.util.Objects;
import java.util.concurrent.Callable;
import lv.e;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e<Callable<i>, i> f30997a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile e<i, i> f30998b;

    public static i a(i iVar) {
        Objects.requireNonNull(iVar, "scheduler == null");
        e eVar = f30998b;
        return eVar == null ? iVar : (i) a(eVar, iVar);
    }

    public static i a(Callable<i> callable) {
        Objects.requireNonNull(callable, "scheduler == null");
        e<Callable<i>, i> eVar = f30997a;
        return eVar == null ? b(callable) : a(eVar, callable);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [lv.e, lv.e<java.util.concurrent.Callable<io.reactivex.i>, io.reactivex.i>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static io.reactivex.i a(lv.e<java.util.concurrent.Callable<io.reactivex.i>, io.reactivex.i> r0, java.util.concurrent.Callable<io.reactivex.i> r1) {
        /*
            java.lang.Object r0 = a(r0, r1)
            io.reactivex.i r0 = (io.reactivex.i) r0
            java.lang.String r1 = "Scheduler Callable returned null"
            java.util.Objects.requireNonNull(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lt.a.a(lv.e, java.util.concurrent.Callable):io.reactivex.i");
    }

    static <T, R> R a(e<T, R> eVar, T t2) {
        try {
            return eVar.a(t2);
        } catch (Throwable th) {
            throw io.reactivex.exceptions.a.a(th);
        }
    }

    static i b(Callable<i> callable) {
        try {
            i call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw io.reactivex.exceptions.a.a(th);
        }
    }
}
