package op;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final Unsafe f32512a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f32513b = (System.getProperty("rx.unsafe-disable") != null);

    static {
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get((Object) null);
        } catch (Throwable unused) {
        }
        f32512a = unsafe;
    }

    public static long a(Class<?> cls, String str) {
        try {
            return f32512a.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e2) {
            InternalError internalError = new InternalError();
            internalError.initCause(e2);
            throw internalError;
        }
    }

    public static boolean a() {
        return f32512a != null && !f32513b;
    }
}
