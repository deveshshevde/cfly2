package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;
import kotlin.Result;
import kotlin.i;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final b f30314a;

    static {
        Object obj;
        b bVar = null;
        try {
            Result.a aVar = Result.f30171a;
            obj = Result.e(new a(a(Looper.getMainLooper(), true), (String) null, 2, (f) null));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f30171a;
            obj = Result.e(i.a(th));
        }
        if (!Result.b(obj)) {
            bVar = obj;
        }
        f30314a = bVar;
    }

    public static final Handler a(Looper looper, boolean z2) {
        if (!z2 || Build.VERSION.SDK_INT < 16) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke((Object) null, new Object[]{looper});
            Objects.requireNonNull(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) invoke;
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, true});
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
