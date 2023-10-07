package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

public class h {
    private h() {
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public static String a(String str, Object obj) {
        return str + obj;
    }

    private static <T extends Throwable> T a(T t2) {
        return a(t2, h.class.getName());
    }

    static <T extends Throwable> T a(T t2, String str) {
        StackTraceElement[] stackTrace = t2.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t2.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t2;
    }

    public static void a() {
        throw ((KotlinNullPointerException) a(new KotlinNullPointerException()));
    }

    public static void a(int i2, String str) {
        c();
    }

    public static void a(Object obj) {
        if (obj == null) {
            b();
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) a(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void a(String str) {
        throw ((UninitializedPropertyAccessException) a(new UninitializedPropertyAccessException(str)));
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b() {
        throw ((NullPointerException) a(new NullPointerException()));
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) a(new NullPointerException(str + " must not be null")));
        }
    }

    public static void b(String str) {
        a("lateinit property " + str + " has not been initialized");
    }

    public static void c() {
        c("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            d(str);
        }
    }

    public static void c(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            e(str);
        }
    }

    private static void d(String str) {
        throw ((IllegalArgumentException) a(new IllegalArgumentException(f(str))));
    }

    private static void e(String str) {
        throw ((NullPointerException) a(new NullPointerException(f(str))));
    }

    private static String f(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }
}
