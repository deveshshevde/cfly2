package com.transitionseverywhere.extra;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.transitionseverywhere.R;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.Visibility;
import com.transitionseverywhere.g;
import com.transitionseverywhere.h;

public class Scale extends Visibility {

    /* renamed from: a  reason: collision with root package name */
    private float f21919a = 0.0f;

    public Scale() {
    }

    public Scale(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Scale);
        a(obtainStyledAttributes.getFloat(R.styleable.Scale_disappearedScale, this.f21919a));
        obtainStyledAttributes.recycle();
    }

    private Animator a(final View view, float f2, float f3, h hVar) {
        final float scaleX = view.getScaleX();
        final float scaleY = view.getScaleY();
        float f4 = scaleX * f2;
        float f5 = scaleX * f3;
        float f6 = f2 * scaleY;
        float f7 = f3 * scaleY;
        if (hVar != null) {
            Float f8 = (Float) hVar.f21927b.get("scale:scaleX");
            Float f9 = (Float) hVar.f21927b.get("scale:scaleY");
            if (!(f8 == null || f8.floatValue() == scaleX)) {
                f4 = f8.floatValue();
            }
            if (!(f9 == null || f9.floatValue() == scaleY)) {
                f6 = f9.floatValue();
            }
        }
        view.setScaleX(f4);
        view.setScaleY(f6);
        Animator a2 = g.a(ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{f4, f5}), ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{f6, f7}));
        a((Transition.c) new Transition.d() {
            public void b(Transition transition) {
                view.setScaleX(scaleX);
                view.setScaleY(scaleY);
                transition.b((Transition.c) this);
            }
        });
        return a2;
    }

    public Animator a(ViewGroup viewGroup, View view, h hVar, h hVar2) {
        return a(view, this.f21919a, 1.0f, hVar);
    }

    public Scale a(float f2) {
        if (f2 >= 0.0f) {
            this.f21919a = f2;
            return this;
        }
        throw new IllegalArgumentException("disappearedScale cannot be negative!");
    }

    public void a(h hVar) {
        super.a(hVar);
        hVar.f21927b.put("scale:scaleX", Float.valueOf(hVar.f21926a.getScaleX()));
        hVar.f21927b.put("scale:scaleY", Float.valueOf(hVar.f21926a.getScaleY()));
    }

    public Animator b(ViewGroup viewGroup, View view, h hVar, h hVar2) {
        return a(view, 1.0f, this.f21919a, hVar);
    }
}
