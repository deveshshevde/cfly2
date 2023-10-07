package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.constant.MemoryConstants;

public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    public static class C0088a {

        /* renamed from: a  reason: collision with root package name */
        public int f11307a;

        /* renamed from: b  reason: collision with root package name */
        public int f11308b;
    }

    public static void a(C0088a aVar, float f2, ViewGroup.LayoutParams layoutParams, int i2, int i3) {
        if (f2 > 0.0f && layoutParams != null) {
            if (a(layoutParams.height)) {
                aVar.f11308b = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (View.MeasureSpec.getSize(aVar.f11307a) - i2)) / f2) + ((float) i3)), aVar.f11308b), MemoryConstants.GB);
            } else if (a(layoutParams.width)) {
                aVar.f11307a = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (View.MeasureSpec.getSize(aVar.f11308b) - i3)) * f2) + ((float) i2)), aVar.f11307a), MemoryConstants.GB);
            }
        }
    }

    private static boolean a(int i2) {
        return i2 == 0 || i2 == -2;
    }
}
