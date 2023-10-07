package com.transitionseverywhere.utils;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ViewGroup;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final a f21977a = (Build.VERSION.SDK_INT >= 18 ? new b() : new a());

    static class a {
        a() {
        }

        public void a(ViewGroup viewGroup, Drawable drawable) {
            ViewOverlayPreJellybean.a(viewGroup).a(drawable);
        }

        public void b(ViewGroup viewGroup, Drawable drawable) {
            ViewOverlayPreJellybean.a(viewGroup).b(drawable);
        }
    }

    static class b extends a {
        b() {
        }

        public void a(ViewGroup viewGroup, Drawable drawable) {
            viewGroup.getOverlay().add(drawable);
        }

        public void b(ViewGroup viewGroup, Drawable drawable) {
            viewGroup.getOverlay().remove(drawable);
        }
    }

    public static void a(ViewGroup viewGroup, Drawable drawable) {
        f21977a.a(viewGroup, drawable);
    }

    public static void b(ViewGroup viewGroup, Drawable drawable) {
        f21977a.b(viewGroup, drawable);
    }
}
