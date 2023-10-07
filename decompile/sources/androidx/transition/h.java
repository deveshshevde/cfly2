package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class h implements f {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f4833a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f4834b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f4835c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f4836d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f4837e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f4838f;

    /* renamed from: g  reason: collision with root package name */
    private final View f4839g;

    private h(View view) {
        this.f4839g = view;
    }

    static f a(View view, ViewGroup viewGroup, Matrix matrix) {
        b();
        Method method = f4835c;
        if (method != null) {
            try {
                return new h((View) method.invoke((Object) null, new Object[]{view, viewGroup, matrix}));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }

    private static void a() {
        if (!f4834b) {
            try {
                f4833a = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException e2) {
                Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e2);
            }
            f4834b = true;
        }
    }

    static void a(View view) {
        c();
        Method method = f4837e;
        if (method != null) {
            try {
                method.invoke((Object) null, new Object[]{view});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    private static void b() {
        if (!f4836d) {
            try {
                a();
                Method declaredMethod = f4833a.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});
                f4835c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e2);
            }
            f4836d = true;
        }
    }

    private static void c() {
        if (!f4838f) {
            try {
                a();
                Method declaredMethod = f4833a.getDeclaredMethod("removeGhost", new Class[]{View.class});
                f4837e = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e2);
            }
            f4838f = true;
        }
    }

    public void a(ViewGroup viewGroup, View view) {
    }

    public void setVisibility(int i2) {
        this.f4839g.setVisibility(i2);
    }
}
