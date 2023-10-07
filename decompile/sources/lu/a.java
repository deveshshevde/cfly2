package lu;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.i;
import java.util.concurrent.Callable;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final i f30999a = lt.a.a((Callable<i>) new Callable<i>() {
        /* renamed from: a */
        public i call() throws Exception {
            return C0220a.f31000a;
        }
    });

    /* renamed from: lu.a$a  reason: collision with other inner class name */
    private static final class C0220a {

        /* renamed from: a  reason: collision with root package name */
        static final i f31000a = new b(new Handler(Looper.getMainLooper()), false);
    }

    public static i a() {
        return lt.a.a(f30999a);
    }
}
