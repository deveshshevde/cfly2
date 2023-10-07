package com.transitionseverywhere.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.transitionseverywhere.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final a f21978a;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Field f21979a = i.a(View.class, "mViewFlags");

        /* renamed from: b  reason: collision with root package name */
        private static final Field f21980b = i.a(View.class, "mLayoutParams");

        /* renamed from: c  reason: collision with root package name */
        private static final Method f21981c = i.b(View.class, "setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);

        a() {
        }

        public Rect a(View view) {
            return null;
        }

        public View a(View view, ViewGroup viewGroup, Matrix matrix) {
            return null;
        }

        public void a(View view, float f2) {
        }

        public void a(View view, int i2) {
            Field field = f21979a;
            i.a((Object) view, field, (Object) Integer.valueOf(i2 | (((Integer) i.a((Object) view, (Object) 0, field)).intValue() & -13)));
        }

        public void a(View view, int i2, int i3, int i4, int i5) {
            i.a(view, (Object) null, f21981c, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        }

        public void a(View view, Matrix matrix) {
        }

        public void a(View view, Rect rect) {
        }

        public void a(View view, ViewGroup.LayoutParams layoutParams) {
            i.a((Object) view, f21980b, (Object) layoutParams);
        }

        public boolean a(View view, boolean z2) {
            return z2;
        }

        public String b(View view) {
            return (String) view.getTag(R.id.transitionName);
        }

        public void b(View view, Matrix matrix) {
        }

        public void b(View view, boolean z2) {
        }

        public float c(View view) {
            return 0.0f;
        }

        public void c(View view, Matrix matrix) {
        }

        public void d(View view) {
        }

        public Object e(View view) {
            return view.getWindowToken();
        }

        public boolean f(View view) {
            return false;
        }
    }

    static class b extends a {
        b() {
        }

        public void b(View view, boolean z2) {
            view.setHasTransientState(z2);
        }
    }

    static class c extends b {
        c() {
        }

        public boolean f(View view) {
            return view.getLayoutDirection() == 1;
        }
    }

    static class d extends c {
        d() {
        }

        public Rect a(View view) {
            return view.getClipBounds();
        }

        public void a(View view, Rect rect) {
            view.setClipBounds(rect);
        }

        public Object e(View view) {
            return view.getWindowId();
        }
    }

    static class e extends d {
        e() {
        }

        public boolean a(View view, boolean z2) {
            return view.isLaidOut();
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f21978a = i2 >= 22 ? new o() : i2 >= 21 ? new n() : i2 >= 19 ? new e() : i2 >= 18 ? new d() : i2 >= 17 ? new c() : i2 >= 16 ? new b() : new a();
    }

    public static Rect a(View view) {
        return f21978a.a(view);
    }

    public static View a(View view, ViewGroup viewGroup, Matrix matrix) {
        return f21978a.a(view, viewGroup, matrix);
    }

    public static void a(View view, float f2) {
        f21978a.a(view, f2);
    }

    public static void a(View view, int i2) {
        f21978a.a(view, i2);
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        f21978a.a(view, i2, i3, i4, i5);
    }

    public static void a(View view, Matrix matrix) {
        f21978a.a(view, matrix);
    }

    public static void a(View view, Rect rect) {
        f21978a.a(view, rect);
    }

    public static void a(View view, ViewGroup.LayoutParams layoutParams) {
        f21978a.a(view, layoutParams);
    }

    public static boolean a(View view, boolean z2) {
        return f21978a.a(view, z2);
    }

    public static String b(View view) {
        return f21978a.b(view);
    }

    public static void b(View view, Matrix matrix) {
        f21978a.b(view, matrix);
    }

    public static void b(View view, boolean z2) {
        f21978a.b(view, z2);
    }

    public static float c(View view) {
        return f21978a.c(view);
    }

    public static void c(View view, Matrix matrix) {
        f21978a.c(view, matrix);
    }

    public static void d(View view) {
        f21978a.d(view);
    }

    public static Object e(View view) {
        return f21978a.e(view);
    }

    public static boolean f(View view) {
        return f21978a.f(view);
    }
}
