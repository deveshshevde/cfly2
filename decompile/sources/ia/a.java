package ia;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Method f13512a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f13513b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f13514c;

    /* renamed from: d  reason: collision with root package name */
    private static int f13515d;

    static {
        Class<Activity> cls = Activity.class;
        try {
            f13512a = cls.getMethod("setStatusBarDarkIcon", new Class[]{Integer.TYPE});
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
        Class<Activity> cls2 = Activity.class;
        try {
            f13513b = cls2.getMethod("setStatusBarDarkIcon", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        }
        try {
            f13514c = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
        try {
            f13515d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt((Object) null);
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
        }
    }

    public static void a(Activity activity, boolean z2) {
        a(activity, z2, true);
    }

    private static void a(Activity activity, boolean z2, boolean z3) {
        Method method = f13513b;
        if (method != null) {
            try {
                method.invoke(activity, new Object[]{Boolean.valueOf(z2)});
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        } else if (z3) {
            a(activity.getWindow(), z2);
        }
    }

    private static void a(View view, boolean z2) {
        int systemUiVisibility = view.getSystemUiVisibility();
        int i2 = z2 ? f13515d | systemUiVisibility : (f13515d ^ -1) & systemUiVisibility;
        if (i2 != systemUiVisibility) {
            view.setSystemUiVisibility(i2);
        }
    }

    private static void a(Window window, int i2) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = f13514c;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i2) {
                    f13514c.set(attributes, Integer.valueOf(i2));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Window window, boolean z2) {
        if (Build.VERSION.SDK_INT < 23) {
            a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z2);
            return;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            a(decorView, z2);
            a(window, 0);
        }
    }

    private static boolean a(WindowManager.LayoutParams layoutParams, String str, boolean z2) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i3 = declaredField2.getInt(layoutParams);
            int i4 = z2 ? i2 | i3 : (i2 ^ -1) & i3;
            if (i3 == i4) {
                return false;
            }
            declaredField2.setInt(layoutParams, i4);
            return true;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return false;
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
