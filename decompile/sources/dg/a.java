package dg;

import java.util.Locale;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static c f26701a = b.a();

    private static String a(Class<?> cls) {
        return cls.getSimpleName();
    }

    private static String a(String str, Object... objArr) {
        return String.format((Locale) null, str, objArr);
    }

    public static void a(Class<?> cls, String str) {
        if (f26701a.a(2)) {
            f26701a.a(a(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (f26701a.a(2)) {
            f26701a.a(a(cls), a(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (a(2)) {
            a(cls, a(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (f26701a.a(2)) {
            f26701a.a(a(cls), a(str, obj, obj2, obj3, obj4));
        }
    }

    public static void a(Class<?> cls, String str, Object... objArr) {
        if (f26701a.a(2)) {
            f26701a.a(a(cls), a(str, objArr));
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        if (f26701a.a(5)) {
            f26701a.b(str, a(str2, objArr));
        }
    }

    public static boolean a(int i2) {
        return f26701a.a(i2);
    }

    public static void b(Class<?> cls, String str, Object... objArr) {
        if (f26701a.a(5)) {
            f26701a.b(a(cls), a(str, objArr));
        }
    }
}
