package ai;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static long f122a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f123b;

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a(str);
        }
    }

    private static void a(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean a() {
        try {
            if (f123b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return c();
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a();
        }
    }

    private static boolean c() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f123b == null) {
                    f122a = Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                    f123b = Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});
                }
                return ((Boolean) f123b.invoke((Object) null, new Object[]{Long.valueOf(f122a)})).booleanValue();
            } catch (Exception e2) {
                a("isTagEnabled", e2);
            }
        }
        return false;
    }
}
