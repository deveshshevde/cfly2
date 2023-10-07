package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.transitionseverywhere.Transition;

public class Fade extends Visibility {

    private static class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f21829a;

        /* renamed from: b  reason: collision with root package name */
        private float f21830b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f21831c = false;

        public a(View view, float f2) {
            this.f21829a = view;
            this.f21830b = f2;
        }

        public void onAnimationEnd(Animator animator) {
            this.f21829a.setAlpha(this.f21830b);
            if (this.f21831c) {
                this.f21829a.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (com.transitionseverywhere.utils.a.a(this.f21829a) && this.f21829a.getLayerType() == 0) {
                this.f21831c = true;
                this.f21829a.setLayerType(2, (Paint) null);
            }
        }
    }

    public Fade() {
    }

    public Fade(int i2) {
        b(i2);
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fade);
        int i2 = obtainStyledAttributes.getInt(R.styleable.Fade_fadingMode, b());
        obtainStyledAttributes.recycle();
        b(i2);
    }

    private Animator a(final View view, float f2, float f3, h hVar) {
        final float alpha = view.getAlpha();
        float f4 = f2 * alpha;
        float f5 = f3 * alpha;
        if (hVar != null && hVar.f21927b.containsKey("fade:alpha")) {
            float floatValue = ((Float) hVar.f21927b.get("fade:alpha")).floatValue();
            if (floatValue != alpha) {
                f4 = floatValue;
            }
        }
        view.setAlpha(f4);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{f5});
        ofFloat.addListener(new a(view, alpha));
        a((Transition.c) new Transition.d() {
            public void b(Transition transition) {
                view.setAlpha(alpha);
                transition.b((Transition.c) this);
            }
        });
        return ofFloat;
    }

    public Animator a(ViewGroup viewGroup, View view, h hVar, h hVar2) {
        return a(view, 0.0f, 1.0f, hVar);
    }

    public void a(h hVar) {
        super.a(hVar);
        hVar.f21927b.put("fade:alpha", Float.valueOf(hVar.f21926a.getAlpha()));
    }

    public Animator b(ViewGroup viewGroup, View view, h hVar, h hVar2) {
        return a(view, 1.0f, 0.0f, hVar);
    }
}
