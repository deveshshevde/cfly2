package il;

import android.text.TextUtils;
import android.util.Log;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f13593a = "";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f13594b = true;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f13595c = true;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f13596d = true;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f13597e = true;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f13598f = true;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f13599g = true;

    /* renamed from: h  reason: collision with root package name */
    public static a f13600h;

    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, Throwable th);

        void a(String str, Throwable th);

        void b(String str, String str2);
    }

    private static String a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        String format = String.format("%s.%s(L:%d)", new Object[]{className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())});
        if (TextUtils.isEmpty(f13593a)) {
            return format;
        }
        return String.valueOf(f13593a) + ":" + format;
    }

    public static void a(String str) {
        if (f13594b) {
            String a2 = a(d.a());
            a aVar = f13600h;
            if (aVar != null) {
                aVar.a(a2, str);
            } else {
                Log.d(a2, str);
            }
        }
    }

    public static void a(String str, Throwable th) {
        if (f13595c) {
            String a2 = a(d.a());
            a aVar = f13600h;
            if (aVar != null) {
                aVar.a(a2, str, th);
            } else {
                Log.e(a2, str, th);
            }
        }
    }

    public static void a(Throwable th) {
        if (f13598f) {
            String a2 = a(d.a());
            a aVar = f13600h;
            if (aVar != null) {
                aVar.a(a2, th);
            } else {
                Log.w(a2, th);
            }
        }
    }

    public static void b(String str) {
        if (f13595c) {
            String a2 = a(d.a());
            a aVar = f13600h;
            if (aVar != null) {
                aVar.b(a2, str);
            } else {
                Log.e(a2, str);
            }
        }
    }
}
