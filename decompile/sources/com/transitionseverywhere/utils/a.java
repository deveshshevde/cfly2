package com.transitionseverywhere.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.os.Build;
import android.view.View;
import com.transitionseverywhere.PathMotion;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final C0144a f21946a;

    /* renamed from: com.transitionseverywhere.utils.a$a  reason: collision with other inner class name */
    static class C0144a {
        C0144a() {
        }

        public <T> Animator a(T t2, g<T> gVar, float f2, float f3, float f4, float f5) {
            return null;
        }

        public <T> Animator a(T t2, g<T> gVar, Path path) {
            return null;
        }

        public void a(Animator animator) {
        }

        public void a(Animator animator, Animator.AnimatorPauseListener animatorPauseListener) {
        }

        public boolean a(View view) {
            return true;
        }

        public void b(Animator animator) {
        }

        public boolean c(Animator animator) {
            return false;
        }
    }

    static class b extends C0144a {
        b() {
        }

        public <T> Animator a(T t2, g<T> gVar, float f2, float f3, float f4, float f5) {
            return f.a(t2, gVar, f2, f3, f4, f5);
        }

        public <T> Animator a(T t2, g<T> gVar, Path path) {
            return e.a(t2, gVar, path);
        }

        public void a(Animator animator) {
            animator.cancel();
        }

        public boolean c(Animator animator) {
            return animator.isStarted();
        }
    }

    static class c extends b {
        c() {
        }

        public boolean a(View view) {
            return view.hasOverlappingRendering();
        }
    }

    static class d extends c {
        d() {
        }

        public void a(Animator animator) {
            animator.pause();
        }

        public void a(Animator animator, Animator.AnimatorPauseListener animatorPauseListener) {
            animator.addPauseListener(animatorPauseListener);
        }

        public void b(Animator animator) {
            animator.resume();
        }
    }

    static class e extends d {
        e() {
        }

        public <T> Animator a(T t2, g<T> gVar, Path path) {
            return ObjectAnimator.ofObject(t2, gVar, (TypeConverter) null, path);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f21946a = i2 >= 21 ? new e() : i2 >= 19 ? new d() : i2 >= 16 ? new c() : i2 >= 14 ? new b() : new C0144a();
    }

    public static <T> Animator a(T t2, g<T> gVar, float f2, float f3, float f4, float f5) {
        return f21946a.a(t2, gVar, f2, f3, f4, f5);
    }

    public static <T> Animator a(T t2, g<T> gVar, Path path) {
        if (path != null) {
            return f21946a.a(t2, gVar, path);
        }
        return null;
    }

    public static <T> Animator a(T t2, g<T> gVar, PathMotion pathMotion, float f2, float f3, float f4, float f5) {
        if (f2 == f4 && f3 == f5) {
            return null;
        }
        return (pathMotion == null || pathMotion.equals(PathMotion.f21832a)) ? a(t2, gVar, f2, f3, f4, f5) : a(t2, gVar, pathMotion.a(f2, f3, f4, f5));
    }

    public static void a(Animator animator) {
        f21946a.a(animator);
    }

    public static void a(Animator animator, Animator.AnimatorPauseListener animatorPauseListener) {
        f21946a.a(animator, animatorPauseListener);
    }

    public static boolean a(View view) {
        return f21946a.a(view);
    }

    public static void b(Animator animator) {
        f21946a.b(animator);
    }

    public static boolean c(Animator animator) {
        return f21946a.c(animator);
    }
}
