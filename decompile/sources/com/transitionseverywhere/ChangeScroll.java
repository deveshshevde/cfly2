package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {
    public ChangeScroll() {
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d(h hVar) {
        hVar.f21927b.put("android:changeScroll:x", Integer.valueOf(hVar.f21926a.getScrollX()));
        hVar.f21927b.put("android:changeScroll:y", Integer.valueOf(hVar.f21926a.getScrollY()));
    }

    public Animator a(ViewGroup viewGroup, h hVar, h hVar2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (hVar == null || hVar2 == null || Build.VERSION.SDK_INT < 14) {
            return null;
        }
        View view = hVar2.f21926a;
        int intValue = ((Integer) hVar.f21927b.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) hVar2.f21927b.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) hVar.f21927b.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) hVar2.f21927b.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", new int[]{intValue, intValue2});
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", new int[]{intValue3, intValue4});
        }
        return g.a(objectAnimator, objectAnimator2);
    }

    public void a(h hVar) {
        d(hVar);
    }

    public void b(h hVar) {
        d(hVar);
    }
}
