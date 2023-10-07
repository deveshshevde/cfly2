package com.transitionseverywhere.utils;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import com.transitionseverywhere.utils.m;
import java.lang.reflect.Method;

class n extends m.e {

    /* renamed from: a  reason: collision with root package name */
    private static final Class f21982a;

    /* renamed from: b  reason: collision with root package name */
    private static final Method f21983b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f21984c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f21985d = i.a((Class<?>) View.class, "transformMatrixToGlobal", (Class<?>[]) new Class[]{Matrix.class});

    /* renamed from: e  reason: collision with root package name */
    private static final Method f21986e = i.a((Class<?>) View.class, "transformMatrixToLocal", (Class<?>[]) new Class[]{Matrix.class});

    /* renamed from: f  reason: collision with root package name */
    private static final Method f21987f = i.a((Class<?>) View.class, "setAnimationMatrix", (Class<?>[]) new Class[]{Matrix.class});

    static {
        Class<?> a2 = i.a("android.view.GhostView");
        f21982a = a2;
        f21983b = i.a(a2, "addGhost", (Class<?>[]) new Class[]{View.class, ViewGroup.class, Matrix.class});
        f21984c = i.a(a2, "removeGhost", (Class<?>[]) new Class[]{View.class});
    }

    n() {
    }

    public View a(View view, ViewGroup viewGroup, Matrix matrix) {
        return (View) i.a((Object) null, (Object) null, f21983b, view, viewGroup, matrix);
    }

    public void a(View view, float f2) {
        view.setTranslationZ(f2);
    }

    public void a(View view, Matrix matrix) {
        i.a((Object) view, (Object) null, f21985d, (Object) matrix);
    }

    public String b(View view) {
        return view.getTransitionName();
    }

    public void b(View view, Matrix matrix) {
        i.a((Object) view, (Object) null, f21986e, (Object) matrix);
    }

    public float c(View view) {
        return view.getTranslationZ();
    }

    public void c(View view, Matrix matrix) {
        i.a((Object) view, (Object) null, f21987f, (Object) matrix);
    }

    public void d(View view) {
        i.a((Object) view, (Object) null, f21984c, (Object) view);
    }
}
