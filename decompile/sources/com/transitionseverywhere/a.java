package com.transitionseverywhere;

import android.graphics.Rect;
import android.view.ViewGroup;

public class a extends k {

    /* renamed from: a  reason: collision with root package name */
    private float f21902a = 3.0f;

    private static double a(float f2, float f3, float f4, float f5) {
        return Math.hypot((double) (f4 - f2), (double) (f5 - f3));
    }

    public long a(ViewGroup viewGroup, Transition transition, h hVar, h hVar2) {
        int i2;
        int i3;
        int i4;
        if (hVar == null && hVar2 == null) {
            return 0;
        }
        if (hVar2 == null || b(hVar) == 0) {
            i2 = -1;
        } else {
            hVar = hVar2;
            i2 = 1;
        }
        int c2 = c(hVar);
        int d2 = d(hVar);
        Rect j2 = transition.j();
        if (j2 != null) {
            i4 = j2.centerX();
            i3 = j2.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round = Math.round(((float) (iArr[0] + (viewGroup.getWidth() / 2))) + viewGroup.getTranslationX());
            i3 = Math.round(((float) (iArr[1] + (viewGroup.getHeight() / 2))) + viewGroup.getTranslationY());
            i4 = round;
        }
        double a2 = a((float) c2, (float) d2, (float) i4, (float) i3) / a(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
        long c3 = transition.c();
        if (c3 < 0) {
            c3 = 300;
        }
        double d3 = (double) (((float) (c3 * ((long) i2))) / this.f21902a);
        Double.isNaN(d3);
        return Math.round(d3 * a2);
    }
}
