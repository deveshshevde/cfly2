package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class p implements TypeEvaluator<Rect> {

    /* renamed from: a  reason: collision with root package name */
    private Rect f4857a;

    p() {
    }

    p(Rect rect) {
        this.f4857a = rect;
    }

    /* renamed from: a */
    public Rect evaluate(float f2, Rect rect, Rect rect2) {
        int i2 = rect.left + ((int) (((float) (rect2.left - rect.left)) * f2));
        int i3 = rect.top + ((int) (((float) (rect2.top - rect.top)) * f2));
        int i4 = rect.right + ((int) (((float) (rect2.right - rect.right)) * f2));
        int i5 = rect.bottom + ((int) (((float) (rect2.bottom - rect.bottom)) * f2));
        Rect rect3 = this.f4857a;
        if (rect3 == null) {
            return new Rect(i2, i3, i4, i5);
        }
        rect3.set(i2, i3, i4, i5);
        return this.f4857a;
    }
}
