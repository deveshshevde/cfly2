package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import gl.a;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    private int f18525a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f18526b = 2;

    /* renamed from: c  reason: collision with root package name */
    private int f18527c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ViewPropertyAnimator f18528d;

    public HideBottomViewOnScrollBehavior() {
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(V v2, int i2, long j2, TimeInterpolator timeInterpolator) {
        this.f18528d = v2.animate().translationY((float) i2).setInterpolator(timeInterpolator).setDuration(j2).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ViewPropertyAnimator unused = HideBottomViewOnScrollBehavior.this.f18528d = null;
            }
        });
    }

    public void a(V v2) {
        if (this.f18526b != 2) {
            ViewPropertyAnimator viewPropertyAnimator = this.f18528d;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v2.clearAnimation();
            }
            this.f18526b = 2;
            a(v2, 0, 225, a.f28538d);
        }
    }

    public void a(V v2, int i2) {
        this.f18527c = i2;
        if (this.f18526b == 1) {
            v2.setTranslationY((float) (this.f18525a + i2));
        }
    }

    public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (i3 > 0) {
            b(v2);
        } else if (i3 < 0) {
            a(v2);
        }
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        this.f18525a = v2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v2.getLayoutParams()).bottomMargin;
        return super.a(coordinatorLayout, v2, i2);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
        return i2 == 2;
    }

    public void b(V v2) {
        if (this.f18526b != 1) {
            ViewPropertyAnimator viewPropertyAnimator = this.f18528d;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v2.clearAnimation();
            }
            this.f18526b = 1;
            a(v2, this.f18525a + this.f18527c, 175, a.f28537c);
        }
    }
}
