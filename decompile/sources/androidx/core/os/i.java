package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

@Deprecated
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static long f2999a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f3000b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f3001c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f3002d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f3003e;

    static {
        if (Build.VERSION.SDK_INT >= 18 && Build.VERSION.SDK_INT < 29) {
            try {
                f2999a = Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                f3000b = Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});
                f3001c = Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});
                f3002d = Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});
                f3003e = Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});
            } catch (Exception e2) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e2);
            }
        }
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }
}
