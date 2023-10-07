package com.transitionseverywhere.utils;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final a f21970a = (Build.VERSION.SDK_INT >= 18 ? new b() : new a());

    static class a {
        a() {
        }

        public void a(ViewGroup viewGroup) {
            ViewOverlayPreJellybean.a(viewGroup);
        }

        public void a(ViewGroup viewGroup, View view) {
            ViewOverlayPreJellybean.a(viewGroup).removeView(view);
        }

        public void a(ViewGroup viewGroup, View view, int i2, int i3) {
            ViewOverlayPreJellybean.a(viewGroup).addView(view, i2, i3);
        }

        public void b(ViewGroup viewGroup, View view, int i2, int i3) {
            ViewOverlayPreJellybean.a(viewGroup).a(view, i2, i3);
        }
    }

    static class b extends a {
        b() {
        }

        public void a(ViewGroup viewGroup) {
        }

        public void a(ViewGroup viewGroup, View view) {
            viewGroup.getOverlay().remove(view);
        }

        public void a(ViewGroup viewGroup, View view, int i2, int i3) {
            b(viewGroup, view, i2, i3);
            viewGroup.getOverlay().add(view);
        }

        public void b(ViewGroup viewGroup, View view, int i2, int i3) {
            if (i2 != 0 || i3 != 0) {
                int[] iArr = new int[2];
                viewGroup.getLocationOnScreen(iArr);
                view.offsetLeftAndRight((i2 - iArr[0]) - view.getLeft());
                view.offsetTopAndBottom((i3 - iArr[1]) - view.getTop());
            }
        }
    }

    public static void a(ViewGroup viewGroup) {
        f21970a.a(viewGroup);
    }

    public static void a(ViewGroup viewGroup, View view) {
        if (view != null) {
            f21970a.a(viewGroup, view);
        }
    }

    public static void a(ViewGroup viewGroup, View view, int i2, int i3) {
        if (view != null) {
            f21970a.a(viewGroup, view, i2, i3);
        }
    }
}
