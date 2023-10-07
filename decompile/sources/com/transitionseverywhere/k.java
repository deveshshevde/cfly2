package com.transitionseverywhere;

import android.view.View;

public abstract class k extends f {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f21943a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    private static int a(h hVar, int i2) {
        int[] iArr;
        if (hVar == null || (iArr = (int[]) hVar.f21927b.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i2];
    }

    public void a(h hVar) {
        View view = hVar.f21926a;
        Integer num = (Integer) hVar.f21927b.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        hVar.f21927b.put("android:visibilityPropagation:visibility", num);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        hVar.f21927b.put("android:visibilityPropagation:center", iArr);
    }

    public String[] a() {
        return f21943a;
    }

    public int b(h hVar) {
        Integer num;
        if (hVar == null || (num = (Integer) hVar.f21927b.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int c(h hVar) {
        return a(hVar, 0);
    }

    public int d(h hVar) {
        return a(hVar, 1);
    }
}
