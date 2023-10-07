package iq;

import android.util.Log;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29057a = false;

    private static String a(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("FileDownloader.");
        sb.append((obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName());
        return sb.toString();
    }

    private static void a(int i2, Object obj, String str, Object... objArr) {
        a(i2, obj, (Throwable) null, str, objArr);
    }

    private static void a(int i2, Object obj, Throwable th, String str, Object... objArr) {
        if ((i2 >= 5) || f29057a) {
            Log.println(i2, a(obj), f.a(str, objArr));
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Object obj, String str, Object... objArr) {
        a(6, obj, str, objArr);
    }

    public static void a(Object obj, Throwable th, String str, Object... objArr) {
        a(6, obj, th, str, objArr);
    }

    public static void b(Object obj, String str, Object... objArr) {
        a(4, obj, str, objArr);
    }

    public static void c(Object obj, String str, Object... objArr) {
        a(3, obj, str, objArr);
    }

    public static void d(Object obj, String str, Object... objArr) {
        a(5, obj, str, objArr);
    }

    public static void e(Object obj, String str, Object... objArr) {
        a(2, obj, str, objArr);
    }
}
