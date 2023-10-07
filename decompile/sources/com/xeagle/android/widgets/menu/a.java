package com.xeagle.android.widgets.menu;

import android.view.View;
import ir.c;
import ir.i;

public class a {
    public static i a(View view) {
        return i.a(view, "rotationY", 0.0f, -90.0f);
    }

    public static i a(View view, float f2) {
        return i.a(view, "translationX", 0.0f, f2);
    }

    public static i b(View view) {
        return i.a(view, "rotationY", -90.0f, 0.0f);
    }

    public static i b(View view, float f2) {
        return i.a(view, "translationX", f2, 0.0f);
    }

    public static c c(View view, float f2) {
        c cVar = new c();
        cVar.a(e(view), a(view, f2));
        return cVar;
    }

    public static i c(View view) {
        return i.a(view, "rotationX", 0.0f, -90.0f);
    }

    public static i d(View view) {
        return i.a(view, "rotationX", -90.0f, 0.0f);
    }

    public static i e(View view) {
        return i.a(view, "alpha", 1.0f, 0.0f);
    }

    public static i f(View view) {
        return i.a(view, "alpha", 0.0f, 1.0f);
    }
}
