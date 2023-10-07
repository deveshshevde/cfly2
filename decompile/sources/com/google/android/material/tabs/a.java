package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

class a extends b {
    a() {
    }

    private static float a(float f2) {
        double d2 = (double) f2;
        Double.isNaN(d2);
        return (float) Math.sin((d2 * 3.141592653589793d) / 2.0d);
    }

    private static float b(float f2) {
        double d2 = (double) f2;
        Double.isNaN(d2);
        return (float) (1.0d - Math.cos((d2 * 3.141592653589793d) / 2.0d));
    }

    /* access modifiers changed from: package-private */
    public void a(TabLayout tabLayout, View view, View view2, float f2, Drawable drawable) {
        float f3;
        float f4;
        RectF a2 = a(tabLayout, view);
        RectF a3 = a(tabLayout, view2);
        if (a2.left < a3.left) {
            f4 = b(f2);
            f3 = a(f2);
        } else {
            f4 = a(f2);
            f3 = b(f2);
        }
        drawable.setBounds(gl.a.a((int) a2.left, (int) a3.left, f4), drawable.getBounds().top, gl.a.a((int) a2.right, (int) a3.right, f3), drawable.getBounds().bottom);
    }
}
