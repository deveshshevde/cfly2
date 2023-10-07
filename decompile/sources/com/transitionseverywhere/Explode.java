package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import fg.i;

public class Explode extends Visibility {

    /* renamed from: a  reason: collision with root package name */
    private static final TimeInterpolator f21823a = new DecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private static final TimeInterpolator f21824b = new AccelerateInterpolator();

    /* renamed from: c  reason: collision with root package name */
    private int[] f21825c = new int[2];

    public Explode() {
        a((f) new a());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a((f) new a());
    }

    private static double a(View view, int i2, int i3) {
        return Math.hypot((double) Math.max(i2, view.getWidth() - i2), (double) Math.max(i3, view.getHeight() - i3));
    }

    private void a(View view, Rect rect, int[] iArr) {
        int i2;
        int i3;
        View view2 = view;
        view2.getLocationOnScreen(this.f21825c);
        int[] iArr2 = this.f21825c;
        int i4 = iArr2[0];
        int i5 = iArr2[1];
        Rect j2 = j();
        if (j2 == null) {
            i3 = (view.getWidth() / 2) + i4 + Math.round(view.getTranslationX());
            i2 = (view.getHeight() / 2) + i5 + Math.round(view.getTranslationY());
        } else {
            int centerX = j2.centerX();
            i2 = j2.centerY();
            i3 = centerX;
        }
        double centerX2 = (double) (rect.centerX() - i3);
        double centerY = (double) (rect.centerY() - i2);
        if (centerX2 == i.f27244a && centerY == i.f27244a) {
            double random = (Math.random() * 2.0d) - 1.0d;
            centerY = (Math.random() * 2.0d) - 1.0d;
            centerX2 = random;
        }
        double hypot = Math.hypot(centerX2, centerY);
        double a2 = a(view2, i3 - i4, i2 - i5);
        iArr[0] = (int) Math.round((centerX2 / hypot) * a2);
        iArr[1] = (int) Math.round(a2 * (centerY / hypot));
    }

    private void d(h hVar) {
        View view = hVar.f21926a;
        view.getLocationOnScreen(this.f21825c);
        int[] iArr = this.f21825c;
        int i2 = iArr[0];
        int i3 = iArr[1];
        hVar.f21927b.put("android:explode:screenBounds", new Rect(i2, i3, view.getWidth() + i2, view.getHeight() + i3));
    }

    public Animator a(ViewGroup viewGroup, View view, h hVar, h hVar2) {
        if (hVar2 == null) {
            return null;
        }
        Rect rect = (Rect) hVar2.f21927b.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        a((View) viewGroup, rect, this.f21825c);
        int[] iArr = this.f21825c;
        return j.a(view, hVar2, rect.left, rect.top, translationX + ((float) iArr[0]), translationY + ((float) iArr[1]), translationX, translationY, f21823a, this);
    }

    public void a(h hVar) {
        super.a(hVar);
        d(hVar);
    }

    public Animator b(ViewGroup viewGroup, View view, h hVar, h hVar2) {
        float f2;
        float f3;
        if (hVar == null) {
            return null;
        }
        Rect rect = (Rect) hVar.f21927b.get("android:explode:screenBounds");
        int i2 = rect.left;
        int i3 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) hVar.f21926a.getTag(R.id.transitionPosition);
        if (iArr != null) {
            f3 = ((float) (iArr[0] - rect.left)) + translationX;
            f2 = ((float) (iArr[1] - rect.top)) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f3 = translationX;
            f2 = translationY;
        }
        a((View) viewGroup, rect, this.f21825c);
        int[] iArr2 = this.f21825c;
        return j.a(view, hVar, i2, i3, translationX, translationY, f3 + ((float) iArr2[0]), f2 + ((float) iArr2[1]), f21824b, this);
    }

    public void b(h hVar) {
        super.b(hVar);
        d(hVar);
    }
}
