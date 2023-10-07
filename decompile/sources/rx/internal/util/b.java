package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f34383a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f34384b;

    static {
        int d2 = d();
        f34383a = d2;
        f34384b = d2 != 0;
    }

    public static boolean a() {
        return f34384b;
    }

    public static int b() {
        return f34383a;
    }

    static ClassLoader c() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() {
            /* renamed from: a */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    private static int d() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, c()).getField("SDK_INT").get((Object) null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
