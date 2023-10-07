package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ae {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4779a = true;

    /* renamed from: b  reason: collision with root package name */
    private static Method f4780b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4781c;

    static int a(ViewGroup viewGroup, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i2);
        }
        if (!f4781c) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("getChildDrawingOrder", new Class[]{Integer.TYPE, Integer.TYPE});
                f4780b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f4781c = true;
        }
        Method method = f4780b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, new Object[]{Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i2)})).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i2;
    }

    static ad a(ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new ac(viewGroup) : ab.a(viewGroup);
    }

    static void a(ViewGroup viewGroup, boolean z2) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z2);
        } else if (Build.VERSION.SDK_INT >= 18) {
            b(viewGroup, z2);
        } else {
            af.a(viewGroup, z2);
        }
    }

    private static void b(ViewGroup viewGroup, boolean z2) {
        if (f4779a) {
            try {
                viewGroup.suppressLayout(z2);
            } catch (NoSuchMethodError unused) {
                f4779a = false;
            }
        }
    }
}
