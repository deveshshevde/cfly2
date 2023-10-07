package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import t.ac;

class aj {

    /* renamed from: a  reason: collision with root package name */
    static final Property<View, Float> f4795a = new Property<View, Float>(Float.class, "translationAlpha") {
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(aj.c(view));
        }

        /* renamed from: a */
        public void set(View view, Float f2) {
            aj.a(view, f2.floatValue());
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static final Property<View, Rect> f4796b = new Property<View, Rect>(Rect.class, "clipBounds") {
        /* renamed from: a */
        public Rect get(View view) {
            return ac.I(view);
        }

        /* renamed from: a */
        public void set(View view, Rect rect) {
            ac.a(view, rect);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final ap f4797c = (Build.VERSION.SDK_INT >= 29 ? new ao() : Build.VERSION.SDK_INT >= 23 ? new an() : Build.VERSION.SDK_INT >= 22 ? new am() : Build.VERSION.SDK_INT >= 21 ? new al() : Build.VERSION.SDK_INT >= 19 ? new ak() : new ap());

    static ai a(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new ah(view) : ag.d(view);
    }

    static void a(View view, float f2) {
        f4797c.a(view, f2);
    }

    static void a(View view, int i2) {
        f4797c.a(view, i2);
    }

    static void a(View view, int i2, int i3, int i4, int i5) {
        f4797c.a(view, i2, i3, i4, i5);
    }

    static void a(View view, Matrix matrix) {
        f4797c.a(view, matrix);
    }

    static at b(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new as(view) : new ar(view.getWindowToken());
    }

    static void b(View view, Matrix matrix) {
        f4797c.b(view, matrix);
    }

    static float c(View view) {
        return f4797c.a(view);
    }

    static void c(View view, Matrix matrix) {
        f4797c.c(view, matrix);
    }

    static void d(View view) {
        f4797c.b(view);
    }

    static void e(View view) {
        f4797c.c(view);
    }
}
