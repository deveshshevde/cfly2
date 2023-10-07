package com.transitionseverywhere.utils;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

public class h implements TypeEvaluator<Rect> {

    /* renamed from: a  reason: collision with root package name */
    private Rect f21963a;

    public h() {
    }

    public h(Rect rect) {
        this.f21963a = rect;
    }

    /* renamed from: a */
    public Rect evaluate(float f2, Rect rect, Rect rect2) {
        int i2 = rect.left + ((int) (((float) (rect2.left - rect.left)) * f2));
        int i3 = rect.top + ((int) (((float) (rect2.top - rect.top)) * f2));
        int i4 = rect.right + ((int) (((float) (rect2.right - rect.right)) * f2));
        int i5 = rect.bottom + ((int) (((float) (rect2.bottom - rect.bottom)) * f2));
        Rect rect3 = this.f21963a;
        if (rect3 == null) {
            return new Rect(i2, i3, i4, i5);
        }
        rect3.set(i2, i3, i4, i5);
        return this.f21963a;
    }
}
