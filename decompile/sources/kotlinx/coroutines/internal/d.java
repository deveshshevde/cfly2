package kotlinx.coroutines.internal;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Method f30398a;

    static {
        Method method;
        Class<ScheduledThreadPoolExecutor> cls = ScheduledThreadPoolExecutor.class;
        try {
            method = cls.getMethod("setRemoveOnCancelPolicy", new Class[]{Boolean.TYPE});
        } catch (Throwable unused) {
            method = null;
        }
        f30398a = method;
    }

    public static final <E> Set<E> a(int i2) {
        return Collections.newSetFromMap(new IdentityHashMap(i2));
    }
}
